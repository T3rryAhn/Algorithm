import sys


class Que:
    def __init__(self, capacity: int = 2000_000):
        self.start = 0
        self.rear = 0
        self.que = [None] * capacity

    def push(self, value):
        self.que[self.rear] = value
        self.rear += 1

    def pop(self):
        if self.empty() == 1:
            return -1
        value = self.que[self.start]
        self.start += 1
        return value

    def size(self):
        return self.rear - self.start

    def empty(self):
        if self.rear == self.start:
            return 1
        return 0

    def front(self):
        if self.empty():
            return -1
        return self.que[self.start]

    def back(self):
        if self.empty():
            return -1
        return self.que[self.rear - 1]


if __name__ == '__main__':
    que = Que()
    n = int(sys.stdin.readline())

    for _ in range(n):
        user_input = list(sys.stdin.readline().split())

        if user_input[0] == 'push':
            que.push(int(user_input[1]))
        elif user_input[0] == 'pop':
            print(que.pop())
        elif user_input[0] == 'size':
            print(que.size())
        elif user_input[0] == 'empty':
            print(que.empty())
        elif user_input[0] == 'front':
            print(que.front())
        elif user_input[0] == 'back':
            print(que.back())



