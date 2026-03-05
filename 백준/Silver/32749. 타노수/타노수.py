import sys

def solve():
    input_data = sys.stdin.read().split()
    
    n = int(input_data[0])
    t = int(input_data[1])
    x = input_data[2]
   
    block_size = 1 << (n - t)

    max_val = ""
    
    for i in range(0, len(x), block_size):
        current_block = x[i : i + block_size]
        if current_block > max_val:
            max_val = current_block
            
    print(max_val)

if __name__ == "__main__":
    solve()