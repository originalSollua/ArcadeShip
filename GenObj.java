// GenObj
// using this as an abstract model for things that exist in the game
// ecamples include buttons, ships, explosions, weapon projectiles, powerups

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GenObj{
	// object's data
	private double x;
	private double y;
	public Sprite sprite;
	// velocity
	private double dx;
	private double dy;
	// collision area
	private Rectangle hitBoxThis = new Rectangle();
	// for the thing we hit
	private Rectangle hitBoxOther = new Rectangle();
	
	// buildify
	
	public GenObj(String path, double x, double y){
		this.sprite = SpriteBox.get().getSprite(path);
		this.x = x;
		this.y = y;
	}
	// some things gotta move
	// not buttons tho
	public void move(long delta){
		// move claculations based on the diference in time passed
		// calced in main loop
		x+=(delta*dx)/1000;
		y+=(delta*dy)/1000;
	}
	// modify horizontal movement params
	public void setHorizontalMove(double dx){
		this.dx = dx;
	}
	// and change vertical
	public void setVerticalMove(double dy){
		this.dy = dy;
	}
	// get info regarding the object

	public double getHorizontalMove(){
		return dx;
	}
	public double getVerticalMove(){
		return dy;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
	//implement logic method
	public void doLogic(){
	}
	
	public void draw(Graphics g){
		sprite.draw(g, (int)x, (int)y);
	}
	
	//collisionDetcection
	// check to see if our box hit the box of another object
	public boolean collidesWith(GenObj other){
		hitBoxThis.setBounds((int)x, (int)y, sprite.getWidth(), sprite.getHeight());
		hitBoxOther.setBounds((int)other.getX(), (int)other.getY(), other.sprite.getWidth(), other.sprite.getHeight());
		return hitBoxThis.intersects(hitBoxOther);
	}
	// do things if we hit somethign
	public abstract void collidedWith(GenObj other);
}
