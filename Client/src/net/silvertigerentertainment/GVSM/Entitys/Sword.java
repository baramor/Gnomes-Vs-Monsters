package net.silvertigerentertainment.GVSM.Entitys;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Main.Screen;
import static net.silvertigerentertainment.GVSM.Helpers.ImageSprite.*;

public class Sword {
	
	public BufferedImage sword;
	
	public int x,y;
	
	public Sword(int x, int y){
		try {
			sword = ImageIO.read(new File("res/sword_up" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		x += Screen.player.player.x;
		y += Screen.player.player.y;
	}
	
	public void render(Graphics2D g) {
		g.drawImage(sword,Screen.player.player.x + 35,Screen.player.player.y - 16,16,96,null);
	}
	
}
