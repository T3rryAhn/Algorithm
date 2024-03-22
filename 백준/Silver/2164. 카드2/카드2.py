class Que:
    def __init__(self, n):
        self.que = list(range(1, n + 1))
        self.front = 0
        self.rear = n

    def size(self):
        return self.rear - self.front

    def pop(self):
        result = self.que[self.front]
        self.front += 1
        return result

    def shuffle(self):
        self.que.append(self.pop())
        self.rear += 1
    def get_front(self):
        return self.que[self.front]

    def dump(self):
        return self.que[self.front:self.rear + 1]


n = int(input())

que = Que(n)
while que.size() > 1:
    que.pop()
    que.shuffle()

print(que.pop())

