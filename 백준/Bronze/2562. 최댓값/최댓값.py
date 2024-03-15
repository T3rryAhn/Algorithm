nums = []

for i in range(9):
    nums.append(int(input()))

max_num = nums[0]
index = 0
for i in nums:
    if i > max_num:
        max_num = i
        index = nums.index(max_num)

print(max_num)
print(index + 1)

