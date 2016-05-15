import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReboundThreadJavaFX extends Application {
	public static void main(String[] args) {
		launch(args);   
	}
	
	public void start(Stage stage) throws Exception {
		      
		
		ReboundRunnable r1 = new ReboundRunnable(0,0,320,435);
		ReboundRunnable r2 = new ReboundRunnable(400,300,527,232);
		Thread t1 = new Thread(r1);
		Thread t2= new Thread(r2);
		t1.start();
		t2.start();
		      
		   }
}