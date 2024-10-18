def can_solve_in_limit(level, diffs, times, limit):
    total_time = 0

    for i in range(len(diffs)):
        diff = diffs[i]
        time_cur = times[i]
        time_prev = times[i - 1] # diffs[0] = 1

        if diff <= level:
            total_time += time_cur
        else:
            total_time += (diff - level) * (time_cur + time_prev) + time_cur

    if total_time > limit:
        return False
    else:
        return True
    
def solution(diffs, times, limit):
    left, right = 1, max(diffs)
    answer = right
    
    while left <= right:
        mid = (left + right) // 2
        
        if can_solve_in_limit(mid, diffs, times, limit):
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
            
    return answer
        