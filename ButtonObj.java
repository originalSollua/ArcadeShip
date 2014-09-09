// button obj
// class for an interactiove object describing buttons.
// mostly used for intro screen
// other uses are possible

public class ButtonObj extends GenObj{
	// buttons shouldnt need reference to the game loop, unless
	// they have functionality inside the loop
	private String name;	
	public ButtonObj(String n,String path, int x, int y){
		super(path, (double)x, (double)y);
		name = n;
	}
	public void collidedWith(GenObj other){
		
	}
	
}
