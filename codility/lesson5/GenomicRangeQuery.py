"""Solution for the GenomicRangeQuery task.

Task:   ../GENOMIC_RANGE_QUERY_README.md
Author: Igor Baiborodine

"""


def solution(s, p, q):
    impact_factors = {
        'A': 1,
        'C': 2,
        'G': 3,
        'T': 4
    }

    factors = [0] * len(p)
    for i in range(0, len(p)):
        query = s[p[i]:(q[i] + 1)]
        min_impact_factor = min(
            [impact_factors[nucl_type] for nucl_type in query])
        factors[i] = min_impact_factor

    return factors


assert solution(['A'], [0], [0]) == [1]
assert solution(['A', 'C'], [0], [0]) == [1]
assert solution(['A', 'C'], [1], [1]) == [2]
assert solution(
    ['C', 'A', 'G', 'C', 'C', 'T', 'A'], [2, 5, 0], [4, 5, 6]) == [2, 4, 1]
assert solution(['A'] * 1000000, [0] * 50000, [1] * 50000) == [1] * 50000
