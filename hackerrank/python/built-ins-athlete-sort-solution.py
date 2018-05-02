#!/bin/python3

import sys

if __name__ == "__main__":
    n, m = (map(int, input().strip().split()))
    elem_arrs = []
    
    for i in range(n):
        elem_arrs.append(list(map(int, input().strip().split())))
    
    k = int(input().strip())
    # print(n, m, elem_arrs, k)   
    
    elem_arrs.sort(key=lambda arr: arr[k])
    print(*[' '.join([str(e) for e in arr]) for arr in elem_arrs], sep='\n')