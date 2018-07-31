"""Solution for Left Rotation task.

Task:   ../data-structures-left-rotation.pdf
Author: Igor Baiborodine

"""

if __name__ == '__main__':
    nd = input().split()
    n = int(nd[0])
    d = int(nd[1])
    a = list(map(int, input().rstrip().split()))

    if len(a) <= 1 or (d >= len(a) and d % len(a) == 0):
        print(" ".join(map(str, a)))

    if d > len(a):
        d = d % len(a)

    while d > 0:
        first_elem = a[0]
        a.insert(len(a), first_elem)
        del a[0]
        d -= 1

    print(" ".join(map(str, a)))

