Lim = 10


class Node:
    def __init__(self):
        self.data = [0] * 10
        self.pos = 0
        self.start = 0
        self.prev, self.next = None, None


def insertAfter(prev, node):
    node.next = prev.next
    if prev.next: prev.next.prev = node
    prev.next = node
    node.prev = prev


def remove(node):
    node.prev.next = node.next
    node.next.prev = node.prev


class Queue:
    def __init__(self):
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def isEmpty(self):
        return self.head.next == self.tail

    def push(self, val):
        if self.isEmpty():
            p = Node()
            insertAfter(self.head, p)
        cur = self.tail.prev
        if cur.pos == Lim:
            p = Node()
            insertAfter(cur, p)
            cur = p
        cur.data[cur.pos] = val
        cur.pos += 1

    def pop(self):
        if self.isEmpty(): return None
        cur = self.head.next
        res = cur.data[cur.start]
        cur.start += 1
        if cur.start == Lim or (cur == self.tail.prev and cur.start >= cur.pos):
            remove(cur)
        return res

def test(n):
    for i in range(n):
        yield i*i
for x in test(5): print(x)
print(dir(Queue()))
q = Queue()
q.push(2)
q.push(3)
print(q.pop())
