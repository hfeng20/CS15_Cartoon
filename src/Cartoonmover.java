import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.util.*;

public class Cartoonmover {
    private boolean on = false;
    private int count = 0;
    private KeyFrame keyframe;
    private Timeline timeline;
    private Cartoon cartoon;

    public Cartoonmover(Pane cartoonPane) {
        this.cartoon = new Cartoon(cartoonPane);
        this.setupBoneFrame();
    }

    public Cartoon getCartoon() {
        return cartoon;
    }

    private void setupBoneFrame() {
        keyframe = new KeyFrame(Duration.seconds(0.5),
                (ActionEvent e) -> colorSwap());
        timeline = new Timeline(keyframe);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void colorSwap() {
        switch (count % 5) {
            case 0:
                this.cartoon.getBoneRight().setFill(Color.RED);
                this.cartoon.getBoneLeft().setFill(Color.RED);
                this.cartoon.getBone().setFill(Color.RED);
                break;
            case 1:
                this.cartoon.getBoneRight().setFill(Color.YELLOW);
                this.cartoon.getBoneLeft().setFill(Color.YELLOW);
                this.cartoon.getBone().setFill(Color.YELLOW);
                break;
            case 2:
                this.cartoon.getBoneRight().setFill(Color.BLUE);
                this.cartoon.getBoneLeft().setFill(Color.BLUE);
                this.cartoon.getBone().setFill(Color.BLUE);
                break;
            case 3:
                this.cartoon.getBoneRight().setFill(Color.GREEN);
                this.cartoon.getBoneLeft().setFill(Color.GREEN);
                this.cartoon.getBone().setFill(Color.GREEN);
                break;
            case 4:
                this.cartoon.getBoneRight().setFill(Color.VIOLET);
                this.cartoon.getBoneLeft().setFill(Color.VIOLET);
                this.cartoon.getBone().setFill(Color.VIOLET);
                break;
        }
        count++;
    }

    public void colorChanger() {
        if (!on) {
            this.timeline.play();
            on = true;
        } else {
            on = false;
            this.timeline.stop();
            this.cartoon.getBone().setFill(Color.WHITE);
            this.cartoon.getBoneRight().setFill(Color.WHITE);
            this.cartoon.getBoneLeft().setFill(Color.WHITE);
        }
    }
}