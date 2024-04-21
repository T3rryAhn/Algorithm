N = int(input())
nums = [int(input()) for _ in range(N)]
answer = 5
nums.sort()

for i in range(N):
    count1 = 4
    for j in range(i + 1, N):
        if nums[i] + 5 > nums[j]:
            count1 -= 1

    answer = min(answer, count1)
print(answer)
