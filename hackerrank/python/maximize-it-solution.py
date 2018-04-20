import itertools as itr

k, m = (map(int, input().split()))
elem_lists = []

for i in range(0, k):
    elem_lists.append(sorted(list(set(map(int, input().split(' ')[1:])))))
    
s_max = 0    
for comb in itr.product(*elem_lists): 
    s = sum([e**2 for e in comb]) % m
    if s > s_max:
        s_max = s
            
print(s_max)    