## Neue Funktionen

### Eigene Bewertung
Wenn eine eigene Bewertung für ein Bier existiert wird diese angezeigt statt der Rating-Sterne.

Um dies Umzusetzen wurden 2 neue Fragmente eingeführt, ein RatingAdd-Fragment und ein RatingDetail-Fragment. Diese werden programmatisch gesetzt/getauscht um entweder die Ratingfunktion oder die eigene vollständige Bewertung anzuzeigen.

### Beurteilung mit Zusatzinformationen
Beim abgeben einer Bewertung kann nun ein Ort angegeben werden auf welchen die Bewertung zutrifft. Zusätzlich können weitere Qualitäten wie die Bitterkeit des Biers, der Kopfweh-Faktor, und das Hauptaroma angegeben werden.

Beim Anzeigen von Bewertungen auf dem Nutzerprofil und in der Bierdetailansicht werden diese zusätzlichen Wertungen jeweils angezeigt.

## Bugfixes

- Beim Zurücknavigieren aus der CreateRatingActivity ist die App teils abgestürzt. Durch das Entfernen des NvaUtils.navigateUpFromSameTask(..) calls ist dieser Fehler behoben

## Useful Links

### Firestore

* [How to import data to Cloud Firestore](https://hackernoon.com/filling-cloud-firestore-with-data-3f67d26bd66e)
