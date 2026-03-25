Aufgaben:
linkedList blatt 3 aufgabe 1
InsertionSort blatt 4 aufgabe 2
searcchTree blatt 7 aufgabe 2
hashTableCahining blatt 10 aufgabe 2

--------------------------------------------------------------------
Fehler beim -linkedList 

* remove func
- Zeile 54: i == size wird erlaubt (sollte i >= size sein)
- Zeile 60: size wird erhöht statt verringert
- Zeile 68: statt .next.next > .next

* get func
- Zeile 74: (i >= size) statt (i > size)
- Zeile 78: i > 1 ist falsch es soll i > 0

* indexOf
- Zeile 91: Vergleich mit == statt equal
- Zeile 94: Es fehlt  index++; > du bekommst falsche Indizes bzw. immer den gleichen
- Zeile 97: retrun -1 befindet sich innerhalb der while-schleife
---------------------------------------------------------------------
Fehler beim InsertionSort 

- HIER sollte ich eine andere Algo implementieren, die den tests erfolgreich macht
aber nicht den gefragte algo entspricht
- Selectionsort statt insertionSort
-----------------------------------------------------------------------
Fehler beim SearchTree

* minimum()
- die Lösung ist richtig aber komplex gelöst
---------------------------------------------------------------------
Fehler beim HashTableChaninig:

* insert func
- der neuen liste wird nicht aktualisiert, diesen Teil fehlt
Zeile 27 -> this.array[h] = l;
- statt .equals wird == verwendet 
Zeile 30 -> if (e.getKey() == key)
- Es wird immer beim else den element auch am anfang angefügt. Es fehlt
Zeile 32 -> return;


* lookup func
- kein Null-Check für key
if (l == null) {
            return null;


* remove func
- statt h wird key gegeben
Zeile 65 -> this.array[h];
- kein return vorhanden, if läuft weiter 
Zeile 70 ->  return;


* size func
- statt alle listen zu addieren und ihre size einfügen, wurde nur für den ersten element geschasut 
Zeile 80 -> return l.size();

