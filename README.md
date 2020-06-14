**Europaschule Schulzentrum SII Utbremen**

**Programmier-Praktikum**

![Ein Bild, das Text, Karte enthält. Automatisch generierte
Beschreibung](media/image1.png)**  
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

[Theoretische Überlegungen 4](#theoretische-überlegungen)

[Softwareentwurf 4](#softwareentwurf)

[Projektplanung 5](#projektplanung)

[Persönliche Zielsetzungen 5](#persönliche-zielsetzungen)

[Arbeitsaufteilung 5](#arbeitsaufteilung)

[Projektverlauf 6](#projektverlauf)

[Überblick 6](#überblick)

[Tests 6](#tests)

[Projektergebnisse 7](#_Toc43064779)

[Ergebnisse 7](#ergebnisse)

[Mängel 7](#mängel)

[Fazit 8](#fazit)

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

Durch die wenige Präsenz in der Schule haben wir uns online als Gruppe
zusammengeschlossen. Nach dem Gruppen bilden, haben wir uns über Discord
abgesprochen wer welchen Aufgabenteil übernehmen soll. Hier haben wir
das Projekt in die Grundsätzlichen teile aufgeteilt und uns zu den
einzelnen Teilen Gedanken gemacht. Z.B. haben wir uns bei der GUI
überlegt, wie wir die Autobahnknoten auf die bereitgestellte
Deutschland Karte bringen.

Für das gemeinsame Arbeiten an dem Programm haben wir für uns
Versionskontrollsystem GIT entschieden. Dies ermöglicht es uns
gleichzeitig an verschiedenen Stellen zu arbeiten und unsere Änderungen
später zusammenzuführen.

# Softwareentwurf

Wir haben uns dafür entschieden die Webgfindungs-Algorithmen von dem
Rest des Programms zu testen. Dies ermöglicht es uns verschiedene
Algorithmen zu implementieren und später zwischen diesen zu wechseln.
Letztendlich haben wir nur den Dijkstra-Algorithmus implementiert, aber
die Erweiterungsmöglichkeit bleibt.

![](media/image2.png)![](media/image3.png)Die mitgelieferten Dateien
(data.xml und map.png) haben wir in einem „asset„ Ordner außerhalb des
Source Codes gespeichert.

# Projektplanung

## Persönliche Zielsetzungen

### Jan

Ich habe mir als Ziel gesetzt, den Algorithmus für die Berechnung der
besten Route zu implementieren und mich so weiter mit den verschiedenen
Wegfindungsalgorithmen vertraut zu machen.  
**Merlin**

Mein Ziel für diese Projekt ist es, mich weiter mit der Entwicklung von
Benutzeroberflächen, mit besonderem Fokus auf JavaFX, auseinander zu
setzen. Außerdem möchte ich mich mit XML-Dateiformat vertraut machen und
lernen, dieses zu lesen.

### Radek

Mit diesem Projekt will ich mich im Bereich der Programmierung
verbessern. Ich habe festgestellt, dass im Vergleich zu meinen
Klassenkameraden mit der Zeit schlechter geworden bin.

## Arbeitsaufteilung

Dadurch, dass wir uns nur online absprechen konnten, haben wir uns am
Anfang einmal um die Arbeitsaufteilung gekümmert. Jeder hat dann einmal
mit den anderen besprochen, was jeder von uns machen möchte und was
deren Ziele sind. Daraus haben wir uns dann auf die Arbeitsaufteilung
geeinigt. Dies lief reibungs- und problemlos.

###   
Jan

Algorithmus zum Finden der besten Route (Dijkstra) und Protokoll

### Radek & Merlin

Backend und GUI (JavaFX)

# Projektverlauf

## Überblick

Da wir keine PP Stunden hatten, lief die ganze Organisation online über
Discord und WhatsApp ab. Nach der Arbeitsaufteilung haben wir an dem
Projekt gearbeitet, wenn gerade Zeit war. Da wir an meist
unterschiedlichen Zeiten dran gearbeitet haben, haben wir uns
zwischendurch auf den neusten Stand gebracht. Als wir dann fertig waren,
haben wir das Projekt zusammengefügt.

## Tests

Um den Routen Algorithmus zu Testen haben wir mehrmals 2 Punkte
ausgewählt und die berechnete Route mit der Route auf Google Maps
verglichen. Hier haben wir uns einfach zufällig ein paar Punkte
rausgesucht und diese verglichen. Daran konnten wir ungefähr absehen ob
unser Programm die richtige Route berechnet.

![](media/image4.png)

Beim Testen ist uns aufgefallen, dass die data.xml einige Fehler
aufweist. Es gibt mehrere Knoten, welche mit falschen Koordinaten
vermerkt sind. Dies ließ sich von unserer Seite nicht lösen, weswegen
wir es bei weiteren Tests ignoriert haben. Beim Anzeigen der gesamten
Karte ist das relativ leicht zu erkennen:

![Ein Bild, das Text, Karte enthält. Automatisch generierte
Beschreibung](media/image1.png)

# Projektergebnisse

## Ergebnisse

Das Programm ist ein voller Erfolg geworden. Es erfüllt alle geforderten
Punkte und die Browniepoints. Unserer Meinung nach, ist es genau das
Programm was gefordert wurde und deshalb sind wir sehr zufrieden mit dem
Ergebnis.

![Ein Bild, das Text, Karte enthält. Automatisch generierte
Beschreibung](media/image5.png)

## ![](media/image6.png)Mängel

Wie bei den Programmtests schon erwähnt, gibt es einige Punkte die in
dem Datensatz nicht richtig vermerkt sind. Dadurch kommt es bei
bestimmten Routen zu eigenartigen Routen. Dieses Problem lässt sich nur
durch Korrigierung des Datensatzes lösen.

Außerdem ist der Datensatz als XML-Datei formatiert. XML ist kein
besonders performantes Format, deswegen kommt es zu einer relativ langen
Ladezeit beim starten des Programms.

## Fazit

### Jan

Das Projekt war relativ spannend und durch die gute Arbeit meiner
Teamkollegen sehr gut in dem zeitlichen Rahmen zu Bewältigen. Es hat
Spaß gemacht den Algorithmus zu implementieren und dann am Ende zu
sehen, dass alles so funktioniert wie es soll.  
**Merlin**

Mir hat das Projekt gut gefallen. Besonders die Zusammenarbeit im Team
hat mir Spaß gemacht und ich konnte meine Kenntnisse mit JavaFx weiter
vertiefen. Die Übersetzung der vorgegebenen lat/lon Werte in x/y
Pixelwerte habe ich als am spannendsten empfunden.

### Radek

Dieses Projekt lief anfangs ziemlich schwer und ich hatte Probleme
manche Funktionen zu verstehen, aber nach einige Zeit, ging das viel
einfacher und ich könnte gut mit meinen Kollegen arbeiten. Ich konnte
mich bei diesem Projekt weiter mit der Programmierung mit JavaFx
auseinandersetzen und habe viel gelernt.
