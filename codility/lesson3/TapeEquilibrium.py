"""Solution for the Tape Equilibrium exercise.
Exercise: ../TAPE_EQUILIBRIUM_README.md
Author:   Igor Baiborodine
"""


def solution(a):
  for i, num in enumerate(a, 1):
    a[i] = a[i-1] + a[i]
  min_diff = abs(a[0]*2 - a[len(a)-1])   
  # min_diff_index = 1
  
  for i, num in enumerate(a, 1):
    if i != len(a)-1:
      diff = abs(a[i]*2 - a[len(a)-1])
      if diff < min_diff:
        min_diff = diff
        # min_diff_index = i + 1
        
  return min_diff  
  

assert solution([0, 0]) == 0
assert solution([1, 0]) == 1
assert solution([-1, 0]) == 1
assert solution([1, -1]) == 2
assert solution([1, 1]) == 0

assert solution([1, 1, 1]) == 1
assert solution([1, -1, 1]) == 1
assert solution([1, 2, 3]) == 0

assert solution([3, 1, 2, 4, 3]) == 1
assert solution([1, 1, 10, 10, 1, 10]) == 9
assert solution([1, 1, 10, 10, 1, -10]) == 9
assert solution([1, 1, -10, 10, 1, -10]) == 9