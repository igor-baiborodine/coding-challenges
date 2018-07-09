"""DataStructuresJava1DArrayPart2 for the PermCheck task.

Task:   ../PERM_CHECK_README.md
Author: Igor Baiborodine

"""

import time


def solution(a):
    sum_a = sum(a)
    set_a = set(a)
    max_int = max(set_a)

    return int((len(a) == len(set_a)
                and sum_a == (max_int * (max_int + 1)) // 2))


start = time.clock()
assert solution([1]) == 1
assert solution([1, 2]) == 1
assert solution([1, 1]) == 0
assert solution([1, 3]) == 0
assert solution([2]) == 0
assert solution([2, 3]) == 0
assert solution([1, 4, 1]) == 0
assert solution(range(1, 100000)) == 1
end = time.clock()
print("%.2gs" % (end - start))
