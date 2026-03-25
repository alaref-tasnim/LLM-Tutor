Das Multi-Agent-System wird entlang sechs zentraler Qualitätsdimensionen bewertet: fachliche Korrektheit, Faithfulness, Vollständigkeit, Rollentreue, Nachvollziehbarkeit und Robustheit. Diese Dimensionen decken sowohl die inhaltliche Qualität der Bewertung als auch die strukturelle und funktionale Zuverlässigkeit des Systems ab. Entscheidend ist dabei, dass das System einerseits korrekt und vollständig arbeitet und andererseits die Rollen der einzelnen Agenten strikt einhält, um ein sauberes, transparentes und reproduzierbares Endergebnis zu gewährleisten.


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
| Kriterium                                    | Punkte |
| -------------------------------------------- | ------ |
| Schritte 1–6 korrekt bewertet                | 0–18   |
| Fehler vollständig und korrekt identifiziert | 0–15   |
| Keine falschen Fehler (False Positives)      | 0–2    |
| **Maximal**                                  | **35** |


2. faithfulness 
| Kriterium                                                 | Punkte |
| --------------------------------------------------------- | ------ |
| Kein Halluzinieren von Fehlern oder Aufgabenbestandteilen | 0–7    |
| Feedback stützt sich ausschließlich auf vorhandenen Code  | 0–5    |
| Keine zusätzlichen erfundenen Schritte                    | 0–3    |
| **Maximal**                                               | **15** |

3. vollständigkeit
| Kriterium                                | Punkte |
| ---------------------------------------- | ------ |
| Alle 6 Schritte wurden überprüft         | 0–12   |
| Alle tatsächlichen Fehler wurden erwähnt | 0–8   |
| **Maximal**                              | **20** |

4. Rollentreue 
| Agent            | Kriterien                                           | Punkte |
| ---------------- | --------------------------------------------------- | ------ |
| Assignment_Agent | extrahiert nur & verändert nichts                   | 0–4    |
| Retriever_Agent  | nur bewertung , gibt keinen Code                    | 0–4    |
| Muster_Agent     | vergleicht nur, keine eigene Lösung                 | 0–3    |
| Aggregator_Agent | fasst nur zusammen, tabelle richtig                 | 0–4    |
| **Maximal**      | —                                                   | **15** |

5. Nachvollziehbarkeit
| Kriterium                                                    | Punkte |
| ------------------------------------------------------------ | ------ |
| Begründungen für Schrittbewertung erkennbar                  | 0–6    |
| Musterfeedback ist logisch und klar bezogen auf Unterschiede | 0–4    |
| **Maximal**                                                  | **10** |

6. Robustheit
| Kriterium                                                    | Punkte |
| ------------------------------------------------------------ | ------ |
| Agente erkennen korrekt „Studentlösung nicht vorhanden“      | 0–4    |
| tabelle zurückgegeben, wobei alle als falsch markiert        | 0–1    |
| **Maximal**                                                  | **5**  |
