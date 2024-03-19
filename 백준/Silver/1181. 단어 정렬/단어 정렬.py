import sys


def sort_word(words: set):
    same_len_words = [[] for _ in range(max_len + 1)]
    for word in words:
        same_len_words[len(word)].append(word)

    for words in same_len_words:
        words.sort()

    result = []
    for words in same_len_words:
        for word in words:
            result.append(word)

    return result


# 입력

words = set()
max_len = 0

n = int(sys.stdin.readline())

for _ in range(n):
    input = sys.stdin.readline().strip()
    if max_len < len(input):
        max_len = len(input)
    words.add(input)

result = sort_word(words)

for word in result:
    print(word)
