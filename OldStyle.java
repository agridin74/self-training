import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class OldStyle extends Application {
	public static void main(String[] args){
		Woker w = new Woker();
		new Thread(w).start();

		class LengthComparator implements Comparator<String>{
			public int compare(String first, String second){
				return Integer.compare(first.length(), second.lengtj());
			}
		}
		String[] strings ="jdfhksj ajksdhasjk aksjdhkj kjhs kl".split(" ");
		Arrays.sort(strings, new LengthComparator());
		System.out.println(Arrays.toString(strings));
		launch(args);
	}
	public void start(Stage stage){
		Button button = new Button("Click me");
		button.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				System.out.println("++++===+++++");
			}
		});
		stage.setScene(new Scene(button));
		stage.show();
	}
}

class Woker implements Runnable {
	public void run(){
		for (int i =0; i<10 ; i++)
				  doWork();
	}

	public void doWork(){
		System.out.println("==>>.....");
		try{
			Thread.sleep(100);
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
}
