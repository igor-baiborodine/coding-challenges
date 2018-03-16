"""Solution for the Cyclic Rotation exercise.

Exercise: ../FROG_JUMP_README.md
Author:   Igor Baiborodine

"""

import math


def solution(x, y, d):
    jump = y - x
    if jump == 0:
        return 0
    elif jump < d:
        return 1
    else:
        return math.ceil(jump/d)
		
		
assert solution(1, 1, 1) == 0
assert solution(1, 2, 1) == 1
assert solution(1, 2, 2) == 1
assert solution(1, 3, 1) == 2
assert solution(1, 6, 2) == 3
assert solution(10, 85, 30) == 3	
		
