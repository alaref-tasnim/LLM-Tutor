- prompt wurde eingepasst, der sollte keine vorschlagslösugn geben und nur bewerten. 
- muster lösung ist vorhanden
- Studentlösung ist zu 20% richtig 

Ziel ist die tabelle zu erfertigen (sieht google sheet "musterlösung_&Lösung_20%")
# eingebaute Fehlern im Code 
computer aufgabe:
-  Grundpreis falsch gesetzt (Montage ignoriert)
-  Arbeitsspeicher: Mindestpreis vergessen und falsch multipliziert
-  Festplatte: falsche Formel, auf 100 statt 500 gerundet und falscher Preis
-  CPU: Intel wird billiger statt teurer
-  Rückgabe falsche Variable
-  keine checks vorhanden
-  keine datenanalyse 

schritt1: ja 
schritt2: nein
schritt3: Ja 
schritt4: Nein
schritt5: weglassen / ja
schritt6: Nein
-------------------------------------------------------------------------------------
pizza aufgabe:
- Fehler: Größe nicht mehr auf Literal eingeschränkt, sondern beliebiger String
- Fehler: Standardmäßig sind Oliven schon drauf (statt False)
- Grundpreis nur für große Pizzen, normale bleiben ohne Basispreis
- Oliven überschreiben den bisherigen Preis statt ihn zu erhöhen
- Käse komplett vergessen – wird nie berechnet
- 10% "Rabatt" statt Aufpreis für große Pizzen
- kein Extra-Grundpreis für normale Pizza, keine saubere Trennung

schritt1: ja 
schritt2: Nein
schritt3: Ja
schritt4: Ja 
schritt5: weglassen / ja
schritt6: nein
--------------------------------------------------------------------------------------
RemoveSlice:
- end wird ignoriert
- range bis len(l) statt bis end
- for i in range(start, len(l), step):  # nicht reversed → verschiebt Indizes
- if i < len(l):  # vermeidet Error, aber Logik falsch
- l.pop(i)  # entfernt falsche Elemente durch Indexverschiebung

schritt1: nein
schritt2: nein
schritt3: ja 
schritt4: nein 
schritt5: weglassen / ja
schritt6: nein



Ziel:
- Evaluierung der Agent system mit andere Aufgaben & unterschiedliche Modelle


aufbau:
- unterschiedliche aufgaben in python 
    - einfache aufgabe 
    - aufgabe mit Aufzählung
    - aufgabe mit zusammengesetzte Daten
- musterlösung als studenlösung eingeben
- Modelle: https://platform.openai.com/docs/pricing?utm_source=chatgpt.com
    - gpt-5: Das beste Modell für Codierungs- und agentische Aufgaben für diverse Branchen
    - gpt-5-mini: Eine schnellere, kostengünstigere Version von GPT-5 für klar definierte Aufgaben
    - gpt-4o 
    - gpt-4o-mini	
    - gemini 
    - gpt-4
    - gpt-4.1

Task:
- Übungsblatt 4 für pizza  aufgabe 3 komplett   (P04-mixed_blatt-04)
- Übungsblatt 8 für removeSlice aufgabe 4 komplett (P08-mutable_blatt-08)
- Übungsblatt 3 für computer aufgabe 1 a (P03-records_blatt-03)
