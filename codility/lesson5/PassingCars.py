"""Solution for the PassingCars task.

Task:   ../PASSING_CARS_README.md
Author: Igor Baiborodine

"""


def solution(a):
    count_pairs = 0
    count_0 = int(a[0] == 0)
    sum_count_0 = 0
    count_1 = 0

    for i in range(1, len(a)):
        if a[i - 1] == 1 and a[i] == 0:
            count_pairs += count_0 * count_1 + sum_count_0 * count_1
            if count_pairs > 1000000000:
                print("1 - max pairs count reached(incomplete pass):",
                      count_pairs)
                return -1
            sum_count_0 += count_0
            count_0 = 1
        elif a[i - 1] == 0 and a[i] == 0:
            count_0 += 1
        elif a[i - 1] == 0 and a[i] == 1:
            count_1 = 1
        else:  # 1 and 1
            count_1 += 1

    if a[len(a) - 1] == 1:
        count_pairs += count_0 * count_1 + sum_count_0 * count_1

    if count_pairs > 1000000000:
        print("2 - max pairs count reached(complete pass):", count_pairs)
        count_pairs = -1
    return count_pairs


assert solution([0, 1]) == 1
assert solution([1, 0]) == 0
assert solution([0, 0, 1]) == 2
assert solution([1, 0, 1]) == 1
assert solution([0, 1, 0, 1]) == 3
assert solution([1, 0, 1, 0]) == 1
assert solution([0, 1, 0, 0, 1]) == 4
assert solution([0, 1, 0, 1, 1]) == 5
assert solution([0, 1, 1, 1, 0]) == 3

# max length array
assert solution([0] + [1] * 99999) == 99999
# incomplete pass & max pairs reached
incompl_pass_arr = [0] * 89450
for i in range(1, len(incompl_pass_arr)):
    if (i - 1) % 2 == 0:
        incompl_pass_arr[i] = 1
assert solution(incompl_pass_arr) == -1
# complete pass & max pairs reached
assert solution([0] * 31623 + [1] * 31623) == -1
# exactly 1,000,000,000 pairs
assert solution([0] * 50000 + [1] * 20000) == 1000000000
