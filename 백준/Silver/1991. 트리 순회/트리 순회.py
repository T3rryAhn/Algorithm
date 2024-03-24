import sys


def preorder(root):
    if root == '.':
        return ''
    return root + preorder(nodes[root][0]) + preorder(nodes[root][1])


def inorder(root):
    if root == '.':
        return ''
    return inorder(nodes[root][0]) + root + inorder(nodes[root][1])


def postorder(root):
    if root == '.':
        return ''
    return postorder(nodes[root][0]) + postorder(nodes[root][1]) + root


n = int(sys.stdin.readline())
nodes = {}
for i in range(n):
    root, left, right = sys.stdin.readline().strip().split()
    nodes[root] = (left, right)
print(preorder('A'))
print(inorder('A'))
print(postorder('A'))
