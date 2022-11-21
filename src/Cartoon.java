import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Cartoon {
    private boolean moveRight = true;
    private Rectangle bone;
    private Ellipse boneLeft;
    private Ellipse boneRight;

    public Cartoon(Pane myPane) {
        this.setUpBone();
        this.setXLoc(Constants.X_OFFSET, true);
        this.setYLoc(Constants.Y_OFFSET);
        myPane.getChildren().addAll(this.bone, this.boneLeft, this.boneRight);
    }

    public void move() {
        if (this.bone.getX() >= Constants.APP_WIDTH) {
            this.moveRight = false;
        } else if (this.bone.getX() < 10) {
            this.moveRight = true;
        }
        if (this.moveRight) {
            this.moveRight();
        } else {
            this.moveLeft();
        }
    }

    public void moveRight() {
        this.setXLoc(this.bone.getX() + Constants.DISTANCE_X, false);
    }

    public void moveLeft() {
        this.setXLoc(this.bone.getX() - Constants.DISTANCE_X, false);
    }

    private void setXLoc(double x, boolean first) {
        if (!first) {
            this.bone.setX(x);
            this.boneRight.setCenterX(x + 2 * Constants.BONE_X_OFFSET);
            this.boneLeft.setCenterX(x);
        } else {
            this.bone.setX(x - Constants.BONE_X_OFFSET);
            this.boneRight.setCenterX(x + Constants.BONE_X_OFFSET);
            this.boneLeft.setCenterX(x - Constants.BONE_X_OFFSET);
        }
    }

    private void setYLoc(double y) {
        this.bone.setY(y - 5);
        this.boneRight.setCenterY(y);
        this.boneLeft.setCenterY(y);
    }

    private void setUpBone() {
        this.bone = new Rectangle(Constants.BONE_WIDTH, 10);
        this.bone.setFill(Color.WHITE);
        this.boneRight = new Ellipse(10, 30);
        this.boneRight.setFill(Color.WHITE);
        this.boneLeft = new Ellipse(10, 30);
        this.boneLeft.setFill(Color.WHITE);
    }

    public Rectangle getBone() {
        return this.bone;
    }

    public Ellipse getBoneRight() {
        return this.boneRight;
    }

    public Ellipse getBoneLeft() {
        return this.boneLeft;
    }
}