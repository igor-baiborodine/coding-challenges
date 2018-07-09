"""DataStructuresJava1DArrayPart2 for the CountDiv task.

Task:   ../COUNT_DIV_README.md
Author: Igor Baiborodine

"""


def solution(a, b, k):
    count = 0

    if a % k > 0:
        a = (a // k + 1) * k

    count += 1

    if b % k > 0:
        b -= b % k

    count += (b - a) // k
    return count


assert solution(0, 0, 11) == 1
assert solution(1, 1, 11) == 0
assert solution(6, 11, 2) == 3
assert solution(11, 67, 17) == 3
assert solution(10, 12, 11) == 1
assert solution(10, 10, 5) == 1
assert solution(10, 10, 7) == 0
assert solution(10, 10, 20) == 0
assert solution(10, 40, 10) == 4
assert solution(9, 40, 10) == 4
assert solution(10, 41, 10) == 4
assert solution(100, 123000001, 2) == 61499951
assert solution(101, 123000001, 2) == 61499950

max_int = 2000000000000
assert solution(0, max_int, 1) == max_int + 1
assert solution(0, max_int, max_int) == 2
assert solution(1, 1, 1) == 1
assert solution(1, 1, max_int) == 0
assert solution(1, max_int, max_int) == 1
assert solution(max_int, max_int, max_int) == 1
assert solution(max_int, max_int, 1) == 1
assert solution(1, max_int, 1) == max_int
