"""Solution for the MissingInteger task.

Task:   ../MISSING_INTEGER_README.md
Author: Igor Baiborodine

"""


def solution(a):
	# extract positive min, max, and unique integers
	min_int = 0
	max_int = 0
	unique_ints = []

	for num in a:
		if num < 1:
			continue

		if num > max_int:
			max_int = num
		if num < min_int:
			min_int = num

		if num not in unique_ints:
			unique_ints.append(num)

	if max_int == 0:
		return 1
	if min_int == 0:
		min_int = 1

	# find missing smallest integer
	for num in range(min_int, max_int + 1):
		if num not in unique_ints:
			return num
	  
	return max_int + 1

  
assert solution([-1]) == 1
assert solution([0]) == 1
assert solution([1]) == 2
assert solution([2]) == 1

assert solution([0, 1]) == 2
assert solution([0, 2]) == 1
assert solution([1, 2]) == 3
assert solution([1, 3]) == 2

assert solution([-1, 0]) == 1
assert solution([-1, 1]) == 2
assert solution([-1, 2]) == 1
assert solution([-1, 0, 1]) == 2
assert solution([-1, -1]) == 1
assert solution([-1, -3]) == 1

assert solution([1, 3, 6, 4, 1, 2]) == 5