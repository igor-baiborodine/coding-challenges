def solution(A, K):
    if len(A) <= 1 or (K >= len(A) and K % len(A) == 0):
        return A
  
    if K > len(A):
        K = K % len(A)
  
    while (K > 0):
        last_elem = A[len(A) - 1]
        A.insert(0, last_elem)
        del A[len(A) - 1]
        K -= 1

    return A
