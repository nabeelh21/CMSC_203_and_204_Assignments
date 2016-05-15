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
 
public class ReboundRunnable implements Runnable {
    
    //main timeline
    private AnimationTimer timer;
    private int x,y,moveX,moveY;
    int stageHeight;
    int stageWidth;
    final int IMAGE_SIZE = 50;
    final StackPane stack = new StackPane();
    Stage stage = new Stage();
 
    //variable for storing actual frame
    private Integer i=0;
 
    public ReboundRunnable(int x, int y, int width, int height) {
    	stageHeight = height;
    	stageWidth = width;
        Group p = new Group();
        Scene scene = new Scene(p);
        stage.setX(x);
        stage.setY(y);
        stage.setScene(scene);
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight+50); //accomodate for header portion of stage
        p.setTranslateX(0);
        p.setTranslateY(20);
        x = 0;
        y = 0;
        moveX=moveY=3;
        //create a circle with effect
        final Circle circle = new Circle(20,  Color.rgb(156,216,255));
        Rectangle rectangle = new Rectangle(0,0,stageWidth,stageHeight);
        circle.setEffect(new Lighting());
        
        //create a layout for circle
        stack.getChildren().addAll(circle);
        stack.setLayoutX(30);
        stack.setLayoutY(30);
        p.getChildren().add(rectangle);
        p.getChildren().add(stack);
        stage.show();
    }
    public void run()
	{
        //You can add a specific action when each frame is started.
        timer = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
            	x += moveX;
            	y += moveY;
            	
            	if (x <= 0 || x >= stageWidth - IMAGE_SIZE)
                    moveX = moveX * -1;

                 if (y <= 0 || y >= stageHeight - IMAGE_SIZE)
                    moveY = moveY * -1;

            	stack.setLayoutX(x);
            	stack.setLayoutY(y);
            }
        };
        timer.start();	

	}
}






















