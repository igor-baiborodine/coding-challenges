"""Solution for the Cyclic Rotation exercise.

Exercise: CYCLIC_ROTATION_README.md
Author:   Igor Baiborodine

"""


def solution(a, k):
    if len(a) <= 1 or (k >= len(a) and k % len(a) == 0):
        return a
  
    if k > len(a):
        k = k % len(a)
  
    while k > 0:
        last_elem = a[len(a) - 1]
        a.insert(0, last_elem)
        del a[len(a) - 1]
        k -= 1

    return a


assert solution([], 0) == []
assert solution([1], 0) == [1]
assert solution([1, 2, 3, 4, 5], 5) == [1, 2, 3, 4, 5]
assert solution([1, 2, 3, 4, 5], 10) == [1, 2, 3, 4, 5]
assert solution([1, 2, 3, 4], 2) == [3, 4, 1, 2]
assert solution([1, 2, 3, 4], 3) == [2, 3, 4, 1]
assert solution([1, 2, 3, 4], 6) == [3, 4, 1, 2]
assert solution([3, 8, 9, 7, 6], 3) == [9, 7, 6, 3, 8]
