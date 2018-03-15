"""Solution for the Binary Gap exercise.

Exercise: BINARY_GAP_README.md
Author:   Igor Baiborodine

"""

def solution(N):
    max_bin_gap = 0
    cur_bin_gap = 0
    prev_rmnd = -1
    
    while (N != 0):
        cur_rmnd = N % 2
        
        if cur_rmnd == 0:
            if prev_rmnd == 1:
                cur_bin_gap = 1
            elif prev_rmnd == 0 and cur_bin_gap > 0:
                cur_bin_gap += 1
        else:
            if prev_rmnd == 0 and cur_bin_gap > max_bin_gap:
                max_bin_gap = cur_bin_gap
                cur_bin_gap = 0
          
        prev_rmnd = cur_rmnd
        N //= 2
    return max_bin_gap  
    
assert solution(5) == 1
assert solution(5728) == 2
assert solution(9) == 2
assert solution(529) == 4
assert solution(20) == 1
assert solution(15) == 0
assert solution(1041) == 5
