Agent system , GPT4o , Musterlösung, Dateien werden im Prompt von Rertriever Agent übergeben
| versuch | schritt_1 | schritt_2 | schritt_3 | schritt_4 | schritt_5 | schritt_6 | Erwartetes Gesamtergebnis | Tatsächliches Gesamtergebnise | korrekt erkannt? | Anmerkungen |
| 1       | ja        | ja        | ja        | ja        | ja        | ja        | Richtig                   | Richtig                       | Ja               |             |
| 2       | Nein      | ja        | ja        | ja        | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 3       | ja        | Nein      | ja        | ja        | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 4       | ja        | ja        | Nein      | ja        | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 5       | ja        | ja        | ja        | Nein      | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 6       | ja        | ja        | ja        | ja        | Nein      | ja        | falsch                    | falsch                        | Ja               |             |
| 7       | ja        | ja        | ja        | ja        | ja        | Nein      | faslsch                   | faslch                        | Ja               |             |


Das sind die ergebnisse der Retriever agent (langsmith datasets Evaluation_Retriever_prompt_2)

Hauptfunktion ist in der Retriever Agent: 
Ergebniss der Retreiver Agent:

- alle schritte sind richtig: alle als richtig identifiziert
- schritt 1: fehler erkannt, sehr gut 
- schritt 2:  fehler erkannt , korrekt , jeodch andere teile auch als falsch identifiziert
- schritt 3: erkannt
- schritt 4: erkannt, jedoch dabei schritt 1 auch als falsch identifiziert
- Schritt 6:  erkannt 

- sehr stark auf die Musterlösung eingegangen.
- manchmal wird erkannt, dass die schablone weg gelassen ist, manchmal nicht
- manchmal merkert er wegen die kurzbeschreibung obwohl sie richtig ist und hat verbesserungsvorschlag, manchmal ist er damit zufrieden
- manchmal selber erklären, was ein schablone ist "- Beide Implementierungen verwenden die Schablone von einer for-Schleife." 