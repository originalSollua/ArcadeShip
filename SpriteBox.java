// resource manager for sprites
// will be a static cache of sprites used so far
// hash map storage by path name
// if sprite not loaded, load it

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;	
	
public class SpriteBox{
	private static SpriteBox cache = new SpriteBox();
	// cache declared in init
	// pass it around with the frame ref
	
	public static SpriteBox get(){
		return cache;
	}
	
	private HashMap sprites = new HashMap();
	public Sprite getSprite(String path){
		if(sprites.get(path) !=null){
			return (Sprite) sprites.get(path);
		}
		BufferedImage sourceImage = null;
		try{
			URL url = this.getClass().getClassLoader().getResource(path);
			if(url == null){
				fail("cannot find image: "+path);
			}
			sourceImage = ImageIO.read(url);
		}
		catch(IOException e){
			fail("Failed to load image: "+path);
		}
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
		image.getGraphics().drawImage(sourceImage, 0, 0, null);
		Sprite sprite = new Sprite(image);
		sprites.put(path, sprite);
		return sprite;
	}
	private void fail(String message){
		System.err.println(message);
		System.exit(0);
	}
}

