"""DataStructuresJava1DArrayPart2 for the MaxCounters task.

Task:   ../MAX_COUNTERS_README.md
Author: Igor Baiborodine

"""

import time


def solution(n, a):
    start = time.clock()
    counts = {}
    max_count = 0

    for num in a:
        if num == n + 1:
            if counts:
                max_count += max(counts.values())
            counts.clear()
        else:
            count = counts.get(num, 0)
            counts[num] = count + 1

    res = [0] * n
    for key in range(1, n + 1):
        count = counts.get(key, 0)
        res[key - 1] = count + max_count

    # print("res:", res)

    end = time.clock()
    print("time: %.2gs" % (end - start))
    return res


assert solution(1, [1]) == [1]
assert solution(2, [1]) == [1, 0]
assert solution(2, [2]) == [0, 1]
assert solution(3, [1]) == [1, 0, 0]
assert solution(1, [1, 2]) == [1]
assert solution(1, [2, 1]) == [1]
assert solution(2, [1, 2, 3]) == [1, 1]
assert solution(2, [1, 2, 2, 3]) == [2, 2]
assert solution(2, [1, 2, 2, 3, 2]) == [2, 3]
# single reset
assert solution(5, [3, 4, 4, 6, 1, 4, 4]) == [3, 2, 2, 4, 2]
# second reset at last integer
assert solution(5, [3, 4, 4, 6, 1, 4, 6]) == [3, 3, 3, 3, 3]
# second reset at not last integer
assert solution(5, [3, 4, 4, 6, 1, 4, 6, 1, 2]) == [4, 4, 3, 3, 3]
# max values
assert solution(100000, range(1, 100001)) == [1] * 100000
# all max_counter operations
assert solution(99999, [100000] * 100000) == [0] * 99999
