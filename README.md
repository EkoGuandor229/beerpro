## Neue Funktionen

### Kühlschrank
Erlaubt es dem Benutzer seine Biere im Kühlschrank zu verwalten.

Mit Hilfe eines neuen Datenmodells und einer neuen Collection wurden die Daten in der DB gespeichert. Um diese auch anzuzeigen wurde eine neue Activity erstellt sowie das ViewModel. Mithilfe eines Listeners werden die Onclickevents für das hinzüfgen in den Kühlschrank bearbeitet. Ausserdem lässt sich die Menge der Biere anzupassen.

### Eigene Bewertung
Wenn eine eigene Bewertung für ein Bier existiert wird diese angezeigt statt der Rating-Sterne.

Um dies Umzusetzen wurden 2 neue Fragmente eingeführt, ein RatingAdd-Fragment und ein RatingDetail-Fragment. Diese werden programmatisch gesetzt/getauscht um entweder die Ratingfunktion oder die eigene vollständige Bewertung anzuzeigen.

### Beurteilung mit Zusatzinformationen
Beim abgeben einer Bewertung kann nun ein Ort angegeben werden auf welchen die Bewertung zutrifft. Zusätzlich können weitere Qualitäten wie die Bitterkeit des Biers, der Kopfweh-Faktor, und das Hauptaroma angegeben werden.

Beim Anzeigen von Bewertungen auf dem Nutzerprofil und in der Bierdetailansicht werden diese zusätzlichen Wertungen jeweils angezeigt.

## Bugfixes

- Beim Zurücknavigieren aus der CreateRatingActivity ist die App teils abgestürzt. Durch das Entfernen des NvaUtils.navigateUpFromSameTask(..) calls ist dieser Fehler behoben

- Beim Zurücknavigieren aus Mein Kühlschrank muss der Backbutton 2x betätigt werden.

## Useful Links

### Firestore

* [How to import data to Cloud Firestore](https://hackernoon.com/filling-cloud-firestore-with-data-3f67d26bd66e)
