from typing import Any
import sys

class Stack:
    def __init__(self, maxlen: int = 256):
        self.capacity = maxlen
        self.stk = [None] * maxlen
        self.ptr = 0

    def push(self, x: Any) -> None:
        self.stk[self.ptr] = x
        self.ptr += 1

    def pop(self):
        if self.is_empty():
            print(-1)
            return

        self.ptr -= 1
        print(self.stk[self.ptr])

    def size(self):
        print(self.ptr)

    def empty(self):
        if self.ptr > 0:
            print(0)
        else:
            print(1)

    def top(self):
        if self.is_empty():
            print(-1)
            return
        print(self.stk[self.ptr - 1])

    def is_empty(self):
        if self.ptr == 0:
            return True
        return False


if __name__ == "__main__":
    n = int(sys.stdin.readline())
    loop_count = 0
    stk = Stack(10_000)

    while loop_count < n:
        user_input = list(sys.stdin.readline().split())
        select = user_input[0]
        if select == 'push':
            stk.push(user_input[1])
        if select == 'top':
            stk.top()
        if select == 'size':
            stk.size()
        if select == 'empty':
            stk.empty()
        if select == 'pop':
            stk.pop()

        loop_count += 1
