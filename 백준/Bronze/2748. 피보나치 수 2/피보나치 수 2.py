from functools import lru_cache

n = int(input())


@lru_cache(maxsize=None)
def f(n):
    if n < 2:
        return n
    return f(n - 1) + f(n - 2)


print(f(n))
