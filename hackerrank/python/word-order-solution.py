from collections import Counter
from collections import OrderedDict

n = int(input())
words = [input() for i in range(0, n)]
word_counts = Counter(words)
distinct_words = list(OrderedDict.fromkeys(words))

print(len(distinct_words))
print(*[word_counts[w] for w in distinct_words], sep=' ')