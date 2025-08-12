import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.Label;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Animation extends Application {
    @Override
    public void start (Stage primaryStage){
        Scene scene = new Scene(new MyPentagon(),400,400);
        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class MyPentagon extends Pane {

    private void paint(){
        //label
        Label lb = new Label("press the left mouse to PLAY the animation\npress the right mouse to PAUSE");
        Rectangle rectangle = new Rectangle(60,60,40,80);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.GREEN);
        //pentagon
        Polygon pentagon = new Polygon();
        pentagon.setFill(Color.RED);
        pentagon.setStroke(Color.BLACK);
        ObservableList<Double> list = pentagon.getPoints();

        double centerX = getWidth() /2, centerY = getHeight()/2;
        double radius = Math.min(getHeight(),getWidth())*0.2;

        for (int i =0; i<5 ; i++){
            list.add(centerX + radius * Math.cos(2*i*Math.PI/5));
            list.add(centerY - radius * Math.sin(2*i*Math.PI/5));
        }

        getChildren().clear();
        getChildren().add(pentagon);
        getChildren().add(rectangle);
        getChildren().add(lb);
        //fadeTransition
        FadeTransition ft = new FadeTransition();
        ft.setNode(rectangle);
        ft.setDuration(Duration.millis(3000));
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        //path
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(3000));
        pt.setPath(pentagon);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);

        pentagon.setOnMousePressed(e -> {
            if(e.getButton() == MouseButton.PRIMARY ){
                pt.play();
            }
            else if (e.getButton() == MouseButton.SECONDARY){
                pt.pause();
            }

        });
        //pentagon.setOnMousePressed(mouseEvent -> pt.play());

    }
    @Override
    public void setWidth (double Width){
        super.setWidth(Width);
        paint();
    }
    @Override
    public void setHeight (double Height){
        super.setHeight(Height);
        paint();
    }

}
