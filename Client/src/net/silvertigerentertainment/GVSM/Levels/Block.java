package net.silvertigerentertainment.GVSM.Levels;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import net.silvertigerentertainment.GVSM.Entitys.Player;
import net.silvertigerentertainment.GVSM.Main.Screen;

public class Block extends Rectangle{
	public int id;
	
	public Block(int x, int y, int width, int height, int id) {
		setBounds(x, y, width, height);
		this.id = id;
		
	}
	
	public void render(Graphics2D g) {
		
		if(id != 0) {
			drawBlock(Level.tileset, g, x - (int) Screen.sX / 64,y - (int)Screen.sY / 64, 8, id - 1, 16, 16);
		}
		//g.draw(collisionBounds());
		
	}
	
	public Rectangle collisionBounds(){
		return new Rectangle(x,y,width,height);
	}
	
	public void drawBlock(Image source, Graphics2D dest, int x, int y, int cols, int frame, int width, int height){
		int fx = (frame % cols) * width;
		int fy = (frame / cols) * height;
		
		dest.drawImage(source, x, y, x+Level.blockSize, y+Level.blockSize, fx, fy, fx+width, fy+height, null);
		
	}

}
