#!/bin/python3

import sys
from datetime import datetime, timedelta

def time_delta(t1, t2):
    t1_tokens, t2_tokens = (t1.split(), t2.split())
    datetime1, datetime2 = (datetime.strptime(' '.join(t1_tokens[1:-1]), '%d %b %Y %H:%M:%S'),
                            datetime.strptime(' '.join(t2_tokens[1:-1]), '%d %b %Y %H:%M:%S'))
    t1_tmz_token = t1_tokens[-1:][0]
    t1_tmz = (t1_tmz_token[:1], t1_tmz_token[1:3].lstrip('0'), t1_tmz_token[3:].lstrip('0'))
    # print(datetime1, t1_tmz) 
    
    t2_tmz_token = t2_tokens[-1:][0]
    t2_tmz = (t2_tmz_token[:1], t2_tmz_token[1:3].lstrip('0'), t2_tmz_token[3:].lstrip('0'))
    # print(datetime2, t2_tmz) 
    
    datetime1 = apply_timezone(datetime1, t1_tmz)
    datetime2 = apply_timezone(datetime2, t2_tmz)
    # print(datetime1, datetime2)
    
    return int(abs(((datetime1 - datetime2).total_seconds())))


def apply_timezone(dt, tmz):
    if tmz[1]:
        hours_arg = -int(tmz[0] + tmz[1])
        # print("hours arg:", hours_arg)
        dt = dt + timedelta(hours=hours_arg)
        
    if tmz[2]:
        minutes_arg = -int(tmz[0] + tmz[2])
        # print("minutes arg:", minutes_arg)
        dt = dt + timedelta(minutes=minutes_arg)
        
    return dt
    
if __name__ == "__main__":
    t = int(input().strip())
    for a0 in range(t):
        t1 = input().strip()
        t2 = input().strip()
        delta = time_delta(t1, t2)
        print(delta)
