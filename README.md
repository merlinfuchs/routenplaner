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

[Softwareentwurf 4](#softwareentwurf)

[Projektplanung 4](#projektplanung)

[Persönliche Zielsetzungen 4](#persönliche-zielsetzungen)

[Arbeitsaufteilung 4](#arbeitsaufteilung)

[Projektverlauf 4](#projektverlauf)

[Überblick 4](#überblick)

[Tests 5](#tests)

[Projektergebnisse 5](#projektergebnisse)

[Ergebnisse 5](#ergebnisse)

[Mängel 5](#mängel)

[Fazit 6](#fazit)

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
Letztendlich war von Anfang an klar, dass wir unser Projekt über Git
austauschen.

# Softwareentwurf

Wir haben uns dafür entschieden den Hauptteil des Programms und die
Methoden zum finden der besten Route zu trennen. Das hat den Vorteil,
dass man verschiedene Algorithmen an einem Ort findet und somit zum
Finden der besten Route verwenden kann. Zudem werden Hilfsklassen wie
Z.B. bei der Map verwendet. Hilfsklassen protected Klassen, die in der
gleichen Datei verwendet werden.

Die mitgelieferten Dateien (data.xml und map.png) haben wir in einem
asset Ordner außerhalb des Source Codes gespeichert.

# Projektplanung

## Persönliche Zielsetzungen

**Jan:** Ich habe mir als Ziel gesetzt, den Algorithmus für die
Berechnung der besten Route zu implementieren  
**Merlin:**

**Radek**

## Arbeitsaufteilung

Die Arbeitsaufteilung war relativ simpel:  
**Jan:** Algorithmus zum finden der besten Route (Dijkstra) und
Protokoll

**Merlin:** Backend und GUI

**Radek:**

Dadurch, dass wir uns nur online absprechen konnten, haben wir uns am
Anfang einmal um die Arbeitsaufteilung gekümmert. Jeder hat dann einmal
mit den anderen besprochen, was jeder von uns machen möchte und was
deren Ziele sind. Daraus haben wir uns dann auf die Arbeitsaufteilung
geeinigt. Dies lief reibungs- und problemlos.

# Projektverlauf

## Überblick

Da wir keine PP Stunden hatten, lief die ganze Organisation online über
Discord und WhatsApp ab. Nach der Arbeitsaufteilung haben wir an dem
Projekt gearbeitet, wenn gerade Zeit war. Da wir an meist
unterschiedlichen Zeiten dran gearbeitet haben, haben wir uns
zwischendurch auf den neusten Stand gebracht. Als wir dann fertig waren,
haben wir das Projekt zusammengefügt.

## Tests

Um den Routen Algorithmus zu Testen haben wir einfach 2 Punkte
ausgewählt und die Route mit der Route auf Google Maps verglichen. Hier
haben wir uns einfach zufällig ein paar Punkte rausgesucht und diese
verglichen.

![](media/image1.png)

# Projektergebnisse

## Ergebnisse

Das Programm ist ein voller Erfolg geworden. Es erfüllt alle geforderten
Punkte und die Browniepoints. Unserer Meinung nach, ist es genau das
Programm was gefordert wurde und deshalb sind wir sehr zufrieden mit dem
Ergebnis.

## Mängel

Wenn man sich einmal alle Verbindungen zwischen den Punkten ausgeben
lässt, so kann man feststellen, dass manche Punkte keine Vernünftige
Route haben. Wir vermuten, dass diese Knoten keine direkte Autobahn
Verbindung haben und somit kein Weg direkt dorthin führt.

![](media/image2.jpeg)

## Fazit

**Jan:** Das Projekt war relativ spannend und durch die gute Arbeit
meiner Teamkollegen sehr gut und in dem zeitlichen Rahmen zu Bewältigen.
Es hat Spaß gemacht den Algorithmus zu implementieren und dann am Ende
zu sehen, dass alles so funktioniert wie es soll.  
**Merlin:**

**Radek:**
