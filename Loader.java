// loader class for arcade style space themed shooter
// contains main
// will load up the start menu
// read in configuration and save files
// respond to mouse input
// call the level constructor to build a level when new game or continue selected
//
//

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferStrategy;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Loader{
	
// start loading up the start screen

	public static void main(String [] args){
		// this would be a good spot to read in some config info
		// as in screen size
		//
		//
		//
		int [] res = {0, 0, 800, 600};
		CanvasGen screen = new CanvasGen(res[0], res[1], res[2], res[3]);
	
		BufferStrategy strat = screen.getSt();
		Graphics2D g = (Graphics2D)(strat).getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(res[0], res[1], res[2], res[3]);
		// calculate the positions of the buttosn
		// using objs to represent acting things in the game window
		ButtonObj newGame = new ButtonObj("newGame", "art/buttons/newGame.png", res[2]/2, res[3]/2);
		// more things here maybe
		// like the actual content
		newGame.draw(g);
		g.dispose();
		strat.show();
	}
}	
