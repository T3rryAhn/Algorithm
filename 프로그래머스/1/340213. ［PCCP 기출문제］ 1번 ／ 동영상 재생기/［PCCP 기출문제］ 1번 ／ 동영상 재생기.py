from datetime import datetime

def convert_to_seconds(time_str: str) -> int:
    time_format = "%M:%S"
    time_obj = datetime.strptime(time_str, time_format)
    
    return time_obj.minute * 60 + time_obj.second

def convert_to_mmss(seconds: int) -> str:
    minute = seconds // 60
    second = seconds % 60
    
    return f"{minute:02}:{second:02}"

def solution(video_len, pos, op_start, op_end, commands):  
    answer = ''
    video_len_sec = convert_to_seconds(video_len)
    pos_sec = convert_to_seconds(pos)
    op_start_sec = convert_to_seconds(op_start)
    op_end_sec = convert_to_seconds(op_end)
    
    for c in commands:
        if op_start_sec <= pos_sec <= op_end_sec:
            pos_sec = op_end_sec
        
        if c == "prev":
            pos_sec = max(0, pos_sec - 10)
        elif c == "next":
            pos_sec = min(video_len_sec, pos_sec + 10)
            
    if op_start_sec <= pos_sec <= op_end_sec:
        pos_sec = op_end_sec
            
    answer = convert_to_mmss(pos_sec)
    
    return answer