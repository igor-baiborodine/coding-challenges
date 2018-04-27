#!/bin/python3

import sys
from datetime import datetime, timedelta

def time_delta(t1, t2):
    t1_tokens, t2_tokens = (t1.split(), t2.split())
    datetime1, datetime2 = (datetime.strptime(' '.join(t1_tokens[1:-1]), '%d %b %Y %H:%M:%S'),
                            datetime.strptime(' '.join(t2_tokens[1:-1]), '%d %b %Y %H:%M:%S'))
    t1_tmz_token = t1_tokens[-1:][0]
    t1_tmz = (t1_tmz_token[:1], t1_tmz_token[1:3].lstrip('0'), t1_tmz_token[3:].lstrip('0'))
    # print(datetime1, datetime2, t1_tmz)
    
    if t1_tmz[1]:
        val = -int(t1_tmz[0] + t1_tmz[1])
        # print("hours:", val)
        datetime1 = datetime1 + timedelta(hours=val)
        
    if t1_tmz[2]:
        val = -int(t1_tmz[0] + t1_tmz[2])
        # print("minutes:", val)
        datetime1 = datetime1 + timedelta(minutes=val)
    # print(datetime1, datetime2)
    return int(abs(((datetime1 - datetime2).total_seconds())))
    
if __name__ == "__main__":
    t = int(input().strip())
    for a0 in range(t):
        t1 = input().strip()
        t2 = input().strip()
        delta = time_delta(t1, t2)
        print(delta)
