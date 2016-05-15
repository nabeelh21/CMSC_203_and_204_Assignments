import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
 
public class Rebound extends Application {
    
    //main timeline
    private AnimationTimer timer;
    private int x,y,moveX,moveY;
    final int HEIGHT = 300;
    final int WIDTH = 500;
    final int IMAGE_SIZE = 50;
 
    //variable for storing actual frame
    private Integer i=0;
 
    @Override public void start(Stage stage) {
        Group p = new Group();
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(350); // accomodate the header of the stage
        p.setTranslateX(0);
        p.setTranslateY(20);
        x = 0;
        y = 0;
        moveX=moveY=3;
        //create a circle with effect
        final Circle circle = new Circle(20,  Color.rgb(156,216,255));
        Rectangle rectangle = new Rectangle(0,0,550,300);
        circle.setEffect(new Lighting());
        
        //create a layout for circle
        final StackPane stack = new StackPane();
        stack.getChildren().addAll(circle);
        stack.setLayoutX(30);
        stack.setLayoutY(30);
        p.getChildren().add(rectangle);
        p.getChildren().add(stack);
        stage.show();
 
        //You can add a specific action when each frame is started.
        timer = new AnimationTimer()
        {
            @Override
            public void handle(long l) {
            	x += moveX;
            	y += moveY;
            	
            	if (x <= 0 || x >= WIDTH - IMAGE_SIZE)
                    moveX = moveX * -1;

                 if (y <= 0 || y >= HEIGHT - IMAGE_SIZE)
                    moveY = moveY * -1;

            	stack.setLayoutX(x);
            	stack.setLayoutY(y);
            }
 
        };
 
        timer.start();
    }
        
        
    public static void main(String[] args) {
        Application.launch(args);
    }
  } 