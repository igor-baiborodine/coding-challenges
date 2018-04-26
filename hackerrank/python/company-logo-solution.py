#!/bin/python3

import sys, operator
from collections import Counter

if __name__ == "__main__":
    s = input().strip()
    counts = Counter(s)
    most_common_3 = sorted(counts.items(), key=lambda x: (-x[1], x[0]))[:3]
    print(*[' '.join(map(str, pair)) for pair in most_common_3], sep='\n')