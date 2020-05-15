import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    private Router router;
    private PosTranslator posTranslator;

    private Pane buildMap() throws FileNotFoundException {

        Image mapImage = new Image(new FileInputStream("assets/map.png"));
        Pane mapContainer = new Pane(new ImageView(mapImage));

        for (Node node : router.getNodes()) {
            Point nodePoint = posTranslator.translate(node);
            mapContainer.getChildren().add(new Circle(nodePoint.x, nodePoint.y, 1, Color.RED));
        }

        return mapContainer;
    }

    @Override
    public void start(Stage stage) throws Exception {
        XMLReader xmlReader = new XMLReader("assets/data.xml");
        this.router = xmlReader.parseFile();

        ReferencePoint firstReference = new ReferencePoint(
                53.3251652f,
                7.238721f,
                new Point(88, 136)
        );
        ReferencePoint secondReference = new ReferencePoint(
                47.4638266f,
                13.001273f,
                new Point(380, 576)
        );
        this.posTranslator = new PosTranslator(firstReference, secondReference);

        Scene mainScene = new Scene(buildMap(), 720, 599);

        stage.setResizable(false);
        stage.setTitle("DQI Maps");
        stage.setScene(mainScene);
        stage.show();
    }
}
