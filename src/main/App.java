package main;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pathfinding.PathFindingAlgorithm;
import pathfinding.PathFindingAlgorithmType;
import pathfinding.Dijkstra;

import java.io.*;
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

    private Stage mainStage;
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
            edgeLine.setStroke(Color.RED);
            edgeLine.setStrokeWidth(1);
            drawContainer.getChildren().add(edgeLine);

            drawContainer.getChildren().add(new Circle(sourcePoint.x, sourcePoint.y, 1, Color.GREEN));
            drawContainer.getChildren().add(new Circle(targetPoint.x, targetPoint.y, 1, Color.GREEN));
        }

        Node sourceNode = router.getNodeByName(selectedSourceProperty.getValue());
        if (sourceNode != null) {
            Point point = map.translate(sourceNode);
            drawContainer.getChildren().add(new Circle(point.x, point.y, 5, Color.BLUE));
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

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("route.txt");
        Button exportButton = new Button("Export Route");
        exportButton.setOnAction(e -> {
            File file = fileChooser.showSaveDialog(mainStage);
            if (file != null) {
                try {
                    FileWriter writer = new FileWriter(file);
                    for (javafx.scene.Node node : textContainer.getChildren()) {
                        if (node instanceof Label) {
                            writer.write(((Label) node).getText() + "\n");
                        }
                    }
                    writer.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        VBox menuPane = new VBox(sourceBox, targetBox, submitButton, scrollPane, exportButton);
        menuPane.setSpacing(10);
        menuPane.setPadding(new Insets(10));
        return menuPane;
    }

    private MenuBar buildMenuBar() {
        Menu algorithmMenu = new Menu("Algorithm");
        ToggleGroup algorithms = new ToggleGroup();
        for (PathFindingAlgorithmType algorithm : PathFindingAlgorithmType.values()) {
            RadioMenuItem item = new RadioMenuItem(algorithm.name());
            if (algorithm == this.algorithmType) {
                item.setSelected(true);
            }
            item.selectedProperty().addListener((ob, ws, is) -> {
                if (is) this.algorithmType = algorithm;
            });
            algorithms.getToggles().add(item);
            algorithmMenu.getItems().add(item);
        }

        Menu settingsMenu = new Menu("Settings");
        settingsMenu.getItems().add(algorithmMenu);

        MenuBar menuBar = new MenuBar(settingsMenu);
        menuBar.setMaxHeight(30);
        return menuBar;
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        XMLReader xmlReader = new XMLReader("assets/data.xml");
        this.router = xmlReader.parseFile();

        HBox mainContent = new HBox(buildMap(), buildMenu());
        BorderPane root = new BorderPane();
        root.setCenter(mainContent);
        root.setTop(buildMenuBar());
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene mainScene = new Scene(root, 900, 629);

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
