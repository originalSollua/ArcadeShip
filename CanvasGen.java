// this class is responcible for generating instances of a drawing canvas.


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CanvasGen extends Canvas{
	
// start loading up the start screen
	private BufferStrategy strategy;
	private int x;
	private int y;
	private int xMax;
	private int yMax; 
	public CanvasGen(int xS, int yS, int mX, int mY){
		this.x = xS;
		this.y = yS;
		xMax = mX;
		yMax = mY;

		JFrame container = new JFrame("ArcadeShip");
		// set up resolution for start screen
		JPanel panel = (JPanel)container.getContentPane();
		// need to figure out dynamic resolution things later
		panel.setPreferredSize(new Dimension(800,600));
		panel.setLayout(null);
	
		setBounds(x,y,xMax,yMax);
		panel.add(this);
		setIgnoreRepaint(true);
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		container.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
			});
		requestFocus();
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	
	}
	public BufferStrategy getSt(){
		return strategy;
	}
	// returning an array of the bounding coordinates of the window
	public int[] getfillBounds(){
		int[] bc = new int[4];
		bc[0] = this.x;
		bc[1] = this.y;
		bc[2] = this.xMax;
		bc[3] = this.yMax;
		return bc;
	}
	
}	

