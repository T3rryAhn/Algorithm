def factorial(n: int) -> int:
    if n > 0:
        return n * factorial(n - 1)
    return 1


if __name__ == '__main__':
    n = int(input())
    print(factorial(n))