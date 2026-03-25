from wypp import *

# Ein Computer besteht aus:
# - Prozessor
# - Festplatten-Kapazität in Gigabyte
# - Hauptspeicher-Kapazität in Gigabyte
@record
class Computer:
    prozessor: str
    festplatte: int
    hauptspeicher: int

# Gesamtspeicher berechnen
# Eingabe: ein Computer
# Ergebnis: die Summe von Haupt- und Festplattenspeicher (int)
def totalMemory(c: Computer) -> int:
    return c.festplatte + c.hauptspeicher


check(totalMemory(Computer('Intel i9', 1000, 16)), 1016)
check(totalMemory(Computer('AMD', 250, 8)), 258)


# Ein Modell ist eins der folgenden:
# - Billigmodell
# - Gamer-Modell
# - Office-Modell
type Modell = Literal['billig', 'gamer', 'office']

# Computer für ein bestimmtes Modell zusammenstellen.
# Eingabe: ein Modell
# Ergebnis: ein Computer
def standardComputer(modell: Modell) -> Computer:
    if modell == 'billig':
        return Computer('Sempron', 2, 500)
    elif modell == 'gamer':
        return Computer('Quad', 16, 1000)
    elif modell == 'office':
        return Computer('Intel i7', 8, 750)


check(standardComputer('billig'), Computer('Sempron', 2, 500))
check(standardComputer('gamer'), Computer('Quad', 16, 1000))
check(standardComputer('office'), Computer('Intel i7', 8, 750))


# Aufgabe A
# Berechnet einen Preis für einen Computer.
def calcComputerPreis(c: Computer) -> float:
    summe = 0
    summe = summe + c.hauptspeicher * 3
    summe = summe + int(c.festplatte / 100) * 5

    summe = summe + 50
    if 'Intel' in c.prozessor:
        summe = summe - 10
    return c.festplatte  

