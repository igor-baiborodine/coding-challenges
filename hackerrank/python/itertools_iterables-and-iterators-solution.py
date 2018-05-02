import itertools as itr
n = int(input())
letters = input().split(' ')
k = int(input())

cmb = list(itr.combinations(letters, k))
cmb_with_a = [e for e in cmb if 'a' in e]
print(len(cmb_with_a) / len(cmb))