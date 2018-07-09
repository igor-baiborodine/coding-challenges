"""Solution for the FrogRiverOne task.

Task:   ../FROG_RIVER_ONE_README.md
Author: Igor Baiborodine

"""


def solution(x, a):
    min_sec = -1
    counts = {}
    for sec, pos in enumerate(a):
        # if pos in counts:
        #     counts[pos] += 1
        # else:
        #     counts[pos] = 1
        counted = counts.get(pos, False)
        if not counted:
            counts[pos] = True

        if len(counts) == x:
            min_sec = sec
            break

    return min_sec


assert solution(1, [1]) == 0
assert solution(1, [1, 1]) == 0
assert solution(2, [1, 2]) == 1
assert solution(2, [2, 1]) == 1
assert solution(2, [2, 2, 1]) == 2
assert solution(2, [1, 2, 1]) == 1
assert solution(3, [1, 2, 2, 1, 3, 1]) == 4
assert solution(5, [1, 3, 1, 4, 2, 3, 5, 4]) == 6
assert solution(5, [1, 3, 1, 4, 2, 3, 3, 4]) == -1


