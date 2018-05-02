import itertools as itr
for key, group in itr.groupby(list(map(int, input()))):
    print((len(list(group)), key), end=" ")