"""Solution for the Cyclic Rotation exercise.

Exercise: CYCLIC_ROTATION_README.md
Author:   Igor Baiborodine

"""

def solution(A, K):
    if len(A) <= 1 or (K >= len(A) and K % len(A) == 0):
        return A
  
    if K > len(A):
        K = K % len(A)
  
    while (K > 0):
        last_elem = A[len(A) - 1]
        A.insert(0, last_elem)
        del A[len(A) - 1]
        K -= 1

    return A

assert solution([], 0) == []
assert solution([1], 0) == [1]
assert solution([1, 2, 3, 4, 5], 5) == [1, 2, 3, 4, 5]
assert solution([1, 2, 3, 4, 5], 10) == [1, 2, 3, 4, 5]
assert solution([1, 2, 3, 4], 2) == [3, 4, 1, 2]
assert solution([1, 2, 3, 4], 3) == [2, 3, 4, 1]
assert solution([1, 2, 3, 4], 6) == [3, 4, 1, 2]
assert solution([3, 8, 9, 7, 6], 3) == [9, 7, 6, 3, 8]
