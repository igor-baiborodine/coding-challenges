"""DataStructuresJava1DArrayPart2 for the Odd Occurences in Array task.

Task:   ../ODD_OCCURRENCES_IN_ARRAY_README.md
Author: Igor Baiborodine

"""


def solution(a):
    if len(a) % 2 == 0:
        return 0

    number_count = {}
    for number in a:
        count = number_count.get(number, 0)
        if count == 0:
            number_count[number] = 1
        elif count == 1:
            del number_count[number]

    return next(iter(number_count))


assert solution([]) == 0
assert solution([1, 1]) == 0
assert solution([1]) == 1

assert solution([1, 2, 1]) == 2
assert solution([2, 1, 1]) == 2
assert solution([1, 1, 2]) == 2

assert solution([1, 1, 2, 2, 3]) == 3
assert solution([3, 2, 2, 1, 1]) == 3
assert solution([1, 1, 3, 2, 2]) == 3

assert solution([1, 2, 1, 2, 3]) == 3
assert solution([3, 1, 2, 1, 2]) == 3
assert solution([1, 2, 3, 2, 1]) == 3

assert solution([4, 4, 5, 4, 4]) == 5
assert solution([9, 3, 9, 3, 9, 7, 9]) == 7
assert solution([1, 2, 2, 1, 3, 3, 4]) == 4
assert solution([1, 2, 3, 4, 1, 2, 3]) == 4
