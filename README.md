**Europaschule Schulzentrum SII Utbremen**

*Protokoll*

**Programmier-Praktikum**

**  
Projekt 4: Routenplaner**

vorgelegt von...

<table>
<thead>
<tr class="header">
<th>Name:</th>
<th><p>Merlin Fuchs,</p>
<p>Jan Hendrik Müller,</p>
<p>Radosław Wardzinski</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Klasse:</td>
<td>DQI17 Q1</td>
</tr>
<tr class="even">
<td>Gruppe:</td>
<td>PP1</td>
</tr>
<tr class="odd">
<td>Datum:</td>
<td>06.06.2020</td>
</tr>
</tbody>
</table>

**Inhaltsverzeichnis**

# Inhalt

[Projektbeschreibung 3](#projektbeschreibung)

[Einzelaufgaben 3](#einzelaufgaben)

[Theoretische Überlegungen 3](#theoretische-überlegungen)

[Softwareentwurf 3](#softwareentwurf)

[Projektplanung 4](#projektplanung)

[Persönliche Zielsetzungen 4](#persönliche-zielsetzungen)

[Arbeitsaufteilung 4](#arbeitsaufteilung)

[Projektverlauf 4](#projektverlauf)

[Überblick 4](#überblick)

[Tests 4](#tests)

[Projektergebnisse 5](#projektergebnisse)

[Ergebnisse 5](#ergebnisse)

[Mängel 5](#mängel)

[Fazit 5](#fazit)

# Projektbeschreibung

Wir schreiben das Jahr 2004. Ein großer Internet Suchanbieter plant die
Bereitstellung einer Routenplanungssoftware auf Basis von frei
verfügbarem Kartenmaterial. Ihr werdet beauftragt, einen Prototypen für
das Autobahnnetz Deutschlands zu erstellen.

 

Euch werden Positionsdaten von Autobahnausfahrten und Verbindungen
dieser unter einander in Form einer .xml-Datei zu Verfügung gestellt.
Anhand dieser Daten soll die kürzeste Entfernung zwischen zwei Punkten
über die verfügbaren Routen erstellt werden. Hierzu wird euch außerdem
eine Karte von Deutschland zu Verfügung gestellt. Auf dieser soll die
Route visuell dargestellt werden.

## Einzelaufgaben

  - Erstellen der Software in Java und designen einer
    benutzerfreundlichen GUI welche die folgenden Anforderungen erfüllt:
    
      - Eingabe Startpunkt (Durch Benutzer)
    
      - Eingabe Endpunkt (Durch Benutzer)
    
      - Auswahl aus Liste von Möglichkeiten (z.B. Dropdown Menu) /
        Browniepoints: Suche mit dynamischer Anzeige von Suchergebnissen
    
      - Einbindung der Deutschlandkarte in die GUI
    
      - Fenster zur Ausgabe der Route in Textform
    
      - Schaltfläche für den Start des Routenplaners

  - Einlesen der XML Daten

  - Berechnen des kürzesten Weges zwischen Start und Ziel

  - Visuelle Darstellung der Route auf der Deutschlandkarte in der GUI
    durch rote Linienverbindungen zwischen einzelnen Knoten

  - Eine schriftliche Ausgabe der Zwischenknoten -\> im Fenster

  - Browniepoints: Export in eine Textdatei

# Theoretische Überlegungen

Durch die wenige Präsenz in der Schule haben wir und online als Gruppe
zusammengeschlossen. Nach dem Gruppen bilden, haben wir uns über Discord
abgesprochen wer was machen wollte. Hier haben wir das Projekt in die
Grundsätzlichen teile aufgeteilt und uns zu den einzelnen Teilen
Gedanken gemacht. Z.B. haben wir uns bei der GUI überlegt, wie wir die
Autobahnknoten auf die bereitgestellte Deutschland Karte bringen.

# Softwareentwurf

Wir haben uns dafür entschieden den Hauptteil des Programms und die
Methoden zum finden der besten Route zu trennen. Das hat den Vorteil,
dass man verschiedene Algorithmen an einem Ort findet und somit zum
Finden der besten Route verwenden kann. Zudem werden Hilfsklassen wie
Z.B. bei der Map verwendet. Hilfsklassen package-private Klassen, die in
der gleichen Datei verwendet werden.

Die mitgelieferten Dateien (data.xml und map.png) haben wir in einem
asset Ordner außerhalb des Source Codes gespeichert.

\-----------------------------------------------------------------------------------------------
Nur das Oberhalb ist aus diesem Projekt.

# Projektplanung

## Persönliche Zielsetzungen

**Jan:** Ich habe mir als Ziel gesetzt, den Algorithmus für die
Berechnung der besten Route zu implementieren  
**Merlin:**

**Fabian:** Ich habe mir als Zielsetzung gesetzt, dass ich einen
Einblick in das Projekt und den Code bekommen und das Protokoll zu
schreiben.

## Arbeitsaufteilung

Die Arbeitsaufteilung war relativ simpel:  
**Jan:** Algorithmus zum finden der besten Route (Dijkstra)

**Merlin:** Backend und GUI

**Fabian:** Protokoll & Hilfe im Programm

Die Arbeitsaufteilung lief ziemlich gut. Bei der Struktur haben wir dann
gemeinsam nochmal drüber gesehen und hier und da noch Verbesserungen
vorgenommen. Somit haben wir also in der Arbeitsteilung die Stärken von
uns genutzt und die Aufgaben effizient aufgeteilt sowie uns
untereinander geholfen.

# Projektverlauf

## Überblick

Da wir nur wenige PP Stunden hatten, aber in diesen die
Arbeitsverteilung schon gemacht hatten, konnte jeder erstmal an seiner
Aufgabe Arbeiten und wir konnten effizient vorrankommen. Zwischendurch
haben wir uns über Discord verständigt und die fertigen Arbeiten so wie
uns über unseren Arbeitsstand ausgetauscht. Dies lief sehr gut am Ende
haben wir dann nur noch alles zusammengetragen.

## Tests

# Projektergebnisse

## Ergebnisse

Allgemein haben wir das Programm fertigbekommen und alle
Mindestanforderungen sowie ein paar Erweiterungen erfüllt. Wir haben
ebenfalls eigene Ideen eingebracht (eigene Kaffee Spezialität). Außerdem
sind wir sehr mit der Benutzeroberfläche zufrieden. Auch in der Gruppe
gab es keine Konflikte und letztendlich haben wir alles erreicht, was
wir erreichen wollten.

## Mängel

## Fazit

**Jan:** Ich habe eigentlich alles gut hinbekommen bis auf die üblichen
kleinen Probleme. Durch die Tipps meiner Teamkollegen habe ich meine
Struktur noch verbessern können und konnte auch was für zukünftige
Projekte mitnehmen. Die Arbeit mit meinen Teamkollegen hat gutgeklappt
und hat mir Spaß gemacht.  
**Merlin:**

**Fabian:** Ich habe alles im zeitlichen Rahmen geschafft und mich mit
meinen Teamkollegen gut verstanden. Die Arbeit hat gut geklappt und ist
reibungslos abgelaufen.
