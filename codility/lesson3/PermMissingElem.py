"""Solution for the Permutation Missing Element task.

Task:   ../PERM_MISSING_ELEM_README.md
Author: Igor Baiborodine

"""


def solution(a):
    perm_sum = 0
    for each in a:
        perm_sum += each

    full_perm_sum = ((len(a) + 1) * (len(a) + 2)) // 2
    return full_perm_sum - perm_sum


assert solution([]) == 1
assert solution([1]) == 2
assert solution([2]) == 1
assert solution([1, 2]) == 3
assert solution([3, 1]) == 2
assert solution([2, 3]) == 1
assert solution([2, 3, 1, 5]) == 4
