Agent system , GPT4o , Musterlösung, Dateien werden im Prompt von Rertriever Agent übergeben, input: HumanMessage only
| versuch | schritt_1 | schritt_2 | schritt_3 | schritt_4 | schritt_5 | schritt_6 | Erwartetes Gesamtergebnis | Tatsächliches Gesamtergebnise | korrekt erkannt? | Anmerkungen |
| 1       | ja        | ja        | ja        | ja        | ja        | ja        | Richtig                   | Richtig                       | Ja               |             |
| 2       | Nein      | ja        | ja        | ja        | ja        | ja        | falsch                    | kein fehler erkannt           | Nein             |             |
| 3       | ja        | Nein      | ja        | ja        | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 4       | ja        | ja        | Nein      | ja        | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 5       | ja        | ja        | ja        | Nein      | ja        | ja        | falsch                    | falsch                        | Ja               |             |
| 6       | ja        | ja        | ja        | ja        | Nein      | ja        | falsch                    | falsch                        | Ja               |             |
| 7       | ja        | ja        | ja        | ja        | ja        | Nein      | faslsch                   | faslch                        | Ja               |             |


Das sind die ergebnisse der Retriever agent (langsmith datasets Evaluation_Retriever_prompt_2)

Hauptfunktion ist in der Retriever Agent. Kompletter Input als Humanmessage
Ergebniss der Retreiver Agent:

ACHTUNG: Hier wurde die input pdf und datei vorher nicht bearbeitet, das heißt der Retriever Agent hat die human message bekommen und sie eingefügt mit dem prompt. Dann zusammen als human MEssage an der LLM gegeben. 
Ergebnisse der Assignment Agent wurde nicht geleitet, damit die Ergebnisse mit dem openai chat 
vergleichbar sind. 

alle richtig: richtig erkannt 
schritt_1: wurde nicht erkannt 
schritt_2: erkannt
schritt_3: erkannt
schritt_4: erkannt
schritt_6: erkannt

