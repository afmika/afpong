package pong_af_michael;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Player extends Rectangle{
	public static double x=1;
	public static double y = 0;
	public Player(Pane g){
		relocate(x, y);
		setWidth(30);
		setHeight(100);
		setFill(Color.WHITE);
		g.setOnMouseMoved(e->{
			y = e.getY()-50;
			relocate(x,  y );
		});
	}

}
