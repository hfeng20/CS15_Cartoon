import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.animation.*;
import javafx.util.*;

public class PaneOrganizer {
    private BorderPane root = new BorderPane();
    private Cartoonmover main;
    private Label label;

    public PaneOrganizer() {
        this.root.setStyle("-fx-background-color: #e4cbff");
        this.setupBottom();
        this.setupCenter();
        this.setupTop();
        this.setupTimeline();
    }

    private void setupTop() {
        HBox top = new HBox();
        label = new Label();
        top.getChildren().add(label);
        this.root.setTop(top);
    }

    private void setupCenter() {
        Pane center = new Pane();
        root.setCenter(center);
        main = new Cartoonmover(center);
        center.setFocusTraversable(true);
        center.setOnKeyPressed(KeyEvent -> handleKeyPress(KeyEvent));
    }

    private void setupBottom() {
        HBox bottom = new HBox();
        Button quit = new Button("Quit");
        bottom.getChildren().addAll(quit);
        this.root.setBottom(bottom);
        quit.setOnAction((ActionEvent e) -> System.exit(0));
        bottom.setFocusTraversable(false);
        quit.setFocusTraversable(false);
    }

    private void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(0.0333333333),
                (ActionEvent e) -> this.main.getCartoon().move());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public BorderPane getRoot() {
        return root;
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        if (keyPressed == KeyCode.SPACE) {
            main.colorChanger();
        }
        e.consume();
    }
}