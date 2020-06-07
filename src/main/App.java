package main;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import pathfinding.PathFindingAlgorithm;
import pathfinding.PathFindingAlgorithmType;
import pathfinding.Dijkstra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App extends Application {
    private Router router;
    private Map map = new Map(
            new Image(new FileInputStream("assets/map.png")),
            new ReferencePoint(
                    53.3251652f,
                    7.238721f,
                    new Point(88, 136)
            ),
            new ReferencePoint(
                    47.4638266f,
                    13.001273f,
                    new Point(380, 576)
            )
    );
    private Pane drawContainer;
    private Pane textContainer;
    private StringProperty selectedSourceProperty = new SimpleStringProperty();
    private StringProperty selectedTargetProperty = new SimpleStringProperty();
    private ArrayList<Edge> toDraw = new ArrayList<>();
    private PathFindingAlgorithmType algorithmType = PathFindingAlgorithmType.DIJKSTRA;

    public App() throws FileNotFoundException {
    }

    private void findRoute() {
        Node sourceNode = router.getNodeByName(selectedSourceProperty.getValue());
        Node targetNode = router.getNodeByName(selectedTargetProperty.getValue());
        if (sourceNode == null || targetNode == null) return;
        //for (main.Edge e : router.getEdges()) {
        //    System.out.println(e.getName() + " " + e.getLength() +" "  +e.getSource().getName() + " "+e.getSource().getEdges().size() + " "+ e.getTarget().getName()+ " "+e.getTarget().getEdges().size());
        //}

        PathFindingAlgorithm pathFindingAlgorithm = null;
        switch (algorithmType) {
            case DIJKSTRA:
                pathFindingAlgorithm = new Dijkstra();
                break;
        }

        toDraw.clear();
        if (pathFindingAlgorithm != null) {
            toDraw = pathFindingAlgorithm.findBestRoute(sourceNode, targetNode);
        }

        drawEdges();
    }

    private void drawEdges() {
        drawContainer.getChildren().clear();
        for (Edge edge : toDraw) {
            Point sourcePoint = map.translate(edge.getSource());
            Point targetPoint = map.translate(edge.getTarget());

            Line edgeLine = new Line(sourcePoint.x, sourcePoint.y, targetPoint.x, targetPoint.y);
            edgeLine.setStroke(Color.GREEN);
            edgeLine.setStrokeWidth(1);
            drawContainer.getChildren().add(edgeLine);

            drawContainer.getChildren().add(new Circle(sourcePoint.x, sourcePoint.y, 1, Color.RED));
            drawContainer.getChildren().add(new Circle(targetPoint.x, targetPoint.y, 1, Color.RED));
        }

        Node sourceNode = router.getNodeByName(selectedSourceProperty.getValue());
        if (sourceNode != null) {
            Point point = map.translate(sourceNode);
            drawContainer.getChildren().add(new Circle(point.x, point.y, 5, Color.GREEN));
        }

        Node targetNode = router.getNodeByName(selectedTargetProperty.getValue());
        if (targetNode != null) {
            Point point = map.translate(targetNode);
            drawContainer.getChildren().add(new Circle(point.x, point.y, 5, Color.RED));
        }

        textContainer.getChildren().clear();
        ArrayList<Edge> toDisplay = new ArrayList<>();
        int totalLength = 0;
        for (Edge edge : toDraw) {
            totalLength += edge.getLength();
            Edge lastElement = null;
            try {
                lastElement = toDisplay.get(toDisplay.size() - 1);
            } catch (IndexOutOfBoundsException ignored) {
            }

            if (lastElement == null || !lastElement.getName().equals(edge.getName())) {
                Edge tempEdge = new Edge(edge.getName(), edge.getLength());
                tempEdge.setSource(edge.getSource());
                tempEdge.setTarget(edge.getTarget());
                toDisplay.add(tempEdge);
            } else {
                lastElement.setTarget(edge.getTarget());
                lastElement.setLength(lastElement.getLength() + edge.getLength());
            }
        }

        textContainer.getChildren().add(new Label("Total Length: " + totalLength + " km"));
        textContainer.getChildren().add(new Label());
        for (Edge edge : toDisplay) {
            String name = String.format("%s: %s -> %s (%d km)", edge.getName(), edge.getSource().getName(), edge.getTarget().getName(), (int) edge.getLength());
            textContainer.getChildren().add(new Label(name));
        }

        toDraw.clear();
    }

    private Pane buildMap() {
        drawContainer = new Pane();
        Image mapImage = map.getImage();

        Pane imagePane = new Pane(new ImageView(mapImage), drawContainer);
        imagePane.setMinWidth(mapImage.getWidth());
        imagePane.setMinHeight(mapImage.getHeight());
        return imagePane;
    }

    private Pane buildMenu() {
        ComboBox<String> sourceSelect = new ComboBox<>();
        for (Node node : router.getNodes()) {
            sourceSelect.getItems().add(node.getName());
        }
        new ComboBoxAutoComplete<>(sourceSelect);
        sourceSelect.valueProperty().bindBidirectional(this.selectedSourceProperty);
        Label sourceLabel = new Label("Start:");
        sourceLabel.setMinWidth(100);
        HBox sourceBox = new HBox(sourceLabel, sourceSelect);

        ComboBox<String> targetSelect = new ComboBox<>();
        for (Node node : router.getNodes()) {
            targetSelect.getItems().add(node.getName());
        }
        new ComboBoxAutoComplete<>(targetSelect);
        targetSelect.valueProperty().bindBidirectional(this.selectedTargetProperty);
        Label targetLabel = new Label("Destination:");
        targetLabel.setMinWidth(100);
        HBox targetBox = new HBox(targetLabel, targetSelect);

        Button submitButton = new Button("Find Route");
        submitButton.setOnAction((e) -> findRoute());

        textContainer = new VBox();
        ScrollPane scrollPane = new ScrollPane(textContainer);

        VBox menuPane = new VBox(sourceBox, targetBox, submitButton, scrollPane);
        menuPane.setSpacing(10);
        menuPane.setPadding(new Insets(10));
        return menuPane;
    }

    @Override
    public void start(Stage stage) throws Exception {
        XMLReader xmlReader = new XMLReader("assets/data.xml");
        this.router = xmlReader.parseFile();

        HBox root = new HBox(buildMap(), buildMenu());
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene mainScene = new Scene(root, 900, 599);

        stage.setResizable(false);
        stage.setTitle("DQI Maps");
        stage.setScene(mainScene);
        stage.show();

        // toDraw = new HashSet<>(router.getEdges());
        drawEdges();

        selectedTargetProperty.addListener((ov, oldValue, newValue) -> drawEdges());
        selectedSourceProperty.addListener((ov, oldValue, newValue) -> drawEdges());
    }
}
