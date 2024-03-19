import sys

heights = []
to_delete = []
for _ in range(9):
    heights.append(int(sys.stdin.readline().strip()))

two_hobbits_height_sum = sum(heights) - 100

for i in range(len(heights) - 1):
    target = two_hobbits_height_sum - heights[i]
    for height in heights[i + 1:]:
        if target == height:
            to_delete.append([heights[i], height])

heights.remove(to_delete[0][0])
heights.remove(to_delete[0][1])

heights.sort()

for i in heights:
    print(i)
