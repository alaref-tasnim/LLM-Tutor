from wypp import *

# Die Funktion entfernt Elemente aus einer Liste, die durch den Slice-Ausdruck selektiert werden.
# Eingaben: 
  # l (list) - die Liste, aus der Elemente entfernt werden, 
  # start (int) - der Startindex, 
  # end (int) - der Endindex, 
  # step (int) - die Schrittgröße
# Ergebnis: None, die Liste wird in-place modifiziert
def removeSlice(l: list, start: int, end: int, step: int) -> None:
    toRemove = range(start, end, step)
    for i in reversed(toRemove):
        l.pop(i)

myList = ['A', 'B', 'C', 'D', 'E', 'F', 'G']
removeSlice(myList, 1, 5, 2)
check(myList, ['A', 'C', 'E', 'F', 'G'])

myList = [1,2,3,1,2,3]
removeSlice(myList, 0, 3, 1)
check(myList, [1,2,3])

myList = [1,2,3,1,2,3]
removeSlice(myList, 0, len(myList), 1)
check(myList, [])

