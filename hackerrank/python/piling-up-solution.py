from collections import deque

for i in range(0, int(input())):
    n = int(input())
    lengths = deque(map(int, input().split()))
    top = 0
    stackable = True
    
    while lengths:
        left = lengths.popleft()
        right = 0
        if lengths:
            right = lengths.pop()
        
        max_length = max([left, right])
        if top == 0:
            top = max_length
        elif max_length > top:
            # print("Cannot stack cube: top={}, next={}".format(top, max_length))
            stackable = False
            break
            
        if right > 0:
            if max_length == right:
                lengths.append(max_length)
            else:
                lengths.appendleft(max_length)
            
        # print("left:{}, right:{}, top:{}, lengths:{}".format(left, right, top, lengths))    
    
    print('Yes' if stackable else 'No')