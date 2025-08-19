import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exercise16_21 extends Application {

    public void start(Stage pStage){

        TextField tf = new TextField();
        tf.setFont(Font.font("Times", FontWeight.BOLD,40));
        tf.setAlignment(Pos.BASELINE_CENTER);
        tf.setMaxSize(300,100);

        Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");

        MediaPlayer md = new MediaPlayer(media);

        //even handler
        EventHandler<ActionEvent> eventHandler = e -> {

            tf.setText(Integer.toString(Integer.parseInt(tf.getText()) - 1));
            if(tf.getText().equals("0")){
                md.play();
            }

        };

        //animation
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
        timeline.setCycleCount(30);

        tf.setOnAction(e-> timeline.play() );


        //scene

        Pane pane = new Pane();
        pane.getChildren().add(tf);

        Scene scene = new Scene(pane,300,100);
        pStage.setScene(scene);
        pStage.setTitle("countdown");
        pStage.show();

    }

}
