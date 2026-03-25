from wypp import *


@record
class Pizza:
    größe: str = 'normal'
    oliven: bool = True
    pilze: bool = False
    salami: bool = False
    käse: bool = False


# Berechnet den Preis einer Pizza.
def calcPizzaPreis(pizza: Pizza) -> float:
    preis = 0
    if pizza.größe == 'groß':
        preis = 2.5
    if pizza.oliven:
        preis = 0.5
    if pizza.pilze:
        preis = preis + 0.4 
    if pizza.salami:
        preis = preis + 0.45 
    if pizza.größe == 'groß':
        preis = preis * 0.9
    return preis


check(calcPizzaPreis(Pizza('normal', True, True, True, True)), 3.9)
check(calcPizzaPreis(Pizza('groß')), 2.5)
