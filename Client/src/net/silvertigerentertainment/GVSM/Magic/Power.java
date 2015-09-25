package net.silvertigerentertainment.GVSM.Magic;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Main.Screen;


public class Power {
	
	public boolean deleate;
	public int x,y,width,height;
	public BufferedImage texture;
	
	public Power(String path,int x, int y, int width, int height){
		try {
			texture = ImageIO.read(new File("res/" + path + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick(){
		if(x >= Screen.WIDTH) {
			deleate = true;
		}
		
		x += 5;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, x, y,width, height, null);
	}

}
