
| Qualitätsdimension                            | Gewicht   | Punkte           |
| --------------------------------------------- | --------- | ---------------- |
| **1. Fachliche Korrektheit**                  | **35 %**  | 0–35             |
| **2. Faithfulness / Quellentreue**            | **15 %**  | 0–15             |
| **3. Vollständigkeit**                        | **20 %**  | 0–20             |
| **4. Rollentreue der Agenten**                | **15 %**  | 0–15             |
| **5. Nachvollziehbarkeit**                    | **10 %**  | 0–10             |
| **6. Robustheit (teilweise fehlende Lösung)** | **5 %**   | 0–5              |
| **Gesamt**                                    | **100 %** | **0–100 Punkte** |

Begründung der Gewichtung:
- Die fachliche Korrektheit ist Kern der Bewertung → höchste Gewichtung
- Vollständigkeit und Faithfulness sind essenziell → mittlere Gewichtung
- Rollentreue und Nachvollziehbarkeit beeinflussen Verständnis → leichte Gewichtung
- Robustheit ist wichtig, aber ein Sonderfall → geringere Gewichtung

1. Fachliche Korrektheit
| Kriterium                                          | Punkte |
| -------------------------------------------------- | ------ |
| Falsche oder irreführende Aussagen nicht vorhanden | 0–10   |
| Fehler werden mit korrekten Codezeilen angegeben   | 0–5    |
| Korrekt erklärt, warum die Lösung falsch ist       | 0–10   |
| Algorithmus wurde richtig bewertet                 | 0-5    |
| richtige Lösung erkannt, fals vorhanden            | 0-5    |
| **Maximal**                                        | **35** |




2. faithfulness 
| Kriterium                                                 | Punkte |
| --------------------------------------------------------- | ------ |
| Kein Halluzinieren von Fehlern oder Aufgabenbestandteilen | 0–7    |
| Feedback stützt sich ausschließlich auf vorhandenen Code  | 0–8    |
| **Maximal**                                               | **15** |

3. vollständigkeit
| Kriterium                                            | Punkte |
| ---------------------------------------------------- | ------ |
| Alle relevanten Fehler wurden identifiziert          | 0–10   |
| Alle Fehlern wurden aufgelistet und nicht wiederholt | 0–5    |
| Komplexe Lösung erkannt, fals vorhanden              | 0–5    |
| **Maximal**                                          | **20** |


4. Rollentreue 
| Agent            | Kriterien                                                                                | Punkte |
| ---------------- | ---------------------------------------------------------------------------------------- | ------ |
| Assignment_Agent | Kein Veränderung des Aufgabentextes & Lösung unverändert weitergegeben                   | 0–4    |
| Retriever_Agent  | Kein eigener Code, nur textuelles Feedback & Alle Fehlern erkannt                        | 0–4    |
| Muster_Agent     | Vergleich nur wenn erlaubt, Unterschiede klar und korrekt benannt                        | 0–3    |
| Aggregator_Agent | Zeilennummern vorhanden, Fehlern aufgelistet, Algo bewertung vorhanden & keine Doppelung | 0–4    |
| **Maximal**      | —                                                                                        | **15** |

5. Nachvollziehbarkeit
| Kriterium                                                    | Punkte |
| ------------------------------------------------------------ | ------ |
| Aussagen eindeutig und nicht missverständlich                | 0–6    |
| Musterfeedback ist logisch und klar bezogen auf Unterschiede | 0–4    |
| **Maximal**                                                  | **10** |

6. Robustheit
| Kriterium                                                                                            | Punkte |
| ---------------------------------------------------------------------------------------------------- | ------ |
| Agente erkennen korrekt „Studentlösung nicht vorhanden“                                              | 0–4    |
| Aggregator Agent deutet, dass die Funktionen nicht implementiert wurden, wenn lösung nicht vorhanden | 0–1    |
| **Maximal**                                                                                          | **5**  |
