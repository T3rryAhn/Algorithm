numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
num_count_results = [0] * 10


def check_number(number: int) -> int:
    for i in numbers:
        if number == i:
            return numbers.index(i)
    return -1


def count_numbers(number: str):
    for i in range(len(number)):
        index = check_number(int(number[i]))
        num_count_results[index] += 1


a = int(input())
b = int(input())
c = int(input())
multi = a * b * c

count_numbers(str(multi))

for i in num_count_results:
    print(i)
