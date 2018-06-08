package pong_af_michael;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Principal extends Application{
	public static int width = 680;
	public static int height = 420;
	public static Player joueur;
	public static Ball ball;
	public static Enemy enemy;
	public static int score[] = {0,0};
	public static Text score_txt;
	public static int cte_level = 1;
	public static Text level;
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		Scene scene = new Scene(root, width, height, Color.BLACK);
		joueur = new Player(root);
		ball = new Ball();
		enemy = new Enemy(ball);
		score_txt = new Text(""+score[0]+"\t"+score[1]);
		score_txt.setFill(Color.WHITE);
		score_txt.setStyle("-fx-font-size : 50px");
		score_txt.relocate(280, 55);
		
		
		level = new Text("Level "+cte_level);
		level.setFill(Color.WHITE);
		level.setStyle("-fx-font-size : 16px");
		level.relocate(10, 400);
		
		root.getChildren().addAll(ball, joueur, enemy, score_txt, level);
		
		for(int k=0; k < 4; k++){
			Rectangle tmp = new Rectangle(680/2, k * 120, 15, 80);
			tmp.setFill(Color.WHITE);
			root.getChildren().add(tmp);
		}
		stage.setScene(scene);
		stage.show();
		stage.setTitle("JFX-Pong :: AF.Michael :: Pong avec Intelligence Artificielle IMBATTABLE");
		stage.setResizable(false);
	}
	public static void main(String[] args){
		launch(args);
	}

}
