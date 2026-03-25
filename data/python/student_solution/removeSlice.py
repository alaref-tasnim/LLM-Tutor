from wypp import *

def removeSlice(l: list, start: int, end: int, step: int) -> None:
    if step <= 0:
        step = 1 
    
    for i in range(start, len(l), step): 
        if i < len(l):  
            l.pop(i)  
