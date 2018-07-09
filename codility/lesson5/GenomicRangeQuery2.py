"""DataStructuresJava1DArrayPart2 for the GenomicRangeQuery task.

Task:   ../GENOMIC_RANGE_QUERY_README.md
Author: Igor Baiborodine

"""


def solution(s, p, q):
    prefix_sums = [
        [0] * (len(s) + 1),
        [0] * (len(s) + 1),
        [0] * (len(s) + 1)
    ]

    for i, nucleotide in enumerate(s):
        if nucleotide == 'A':
            prefix_sums[0][i + 1] = prefix_sums[0][i] + 1
        elif nucleotide == 'C':
            prefix_sums[1][i + 1] = prefix_sums[1][i] + 1
        elif nucleotide == 'G':
            prefix_sums[2][i + 1] = prefix_sums[2][i] + 1

    factors = [1] * len(p)
    for i in range(0, len(p)):
        from_ind = p[i]
        to_ind = q[i] + 1

        if prefix_sums[0][to_ind] - prefix_sums[0][from_ind] > 0:
            factors[i] = 1
        elif prefix_sums[1][to_ind] - prefix_sums[1][from_ind] > 0:
            factors[i] = 2
        elif prefix_sums[2][to_ind] - prefix_sums[2][from_ind] > 0:
            factors[i] = 3
        else:
            factors[i] = 4

    return factors


assert solution(['A'], [0], [0]) == [1]
assert solution(['A', 'C'], [0], [0]) == [1]
assert solution(['A', 'C'], [1], [1]) == [2]
assert solution(
    ['C', 'A', 'G', 'C', 'C', 'T', 'A'], [2, 5, 0], [4, 5, 6]) == [2, 4, 1]
assert solution(['A'] * 1000000, [0] * 50000, [1] * 50000) == [1] * 50000
