package net.silvertigerentertainment.GVSM.Levels;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Helpers.Camera;
import net.silvertigerentertainment.GVSM.Main.Game;

public class Potionhut {
	
	public BufferedImage potionhut;
	
	public Potionhut() {
		try {
			potionhut = ImageIO.read(new File("res/Structures/potion_hut.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int x = 0,y = 0;
	
	public void render(Graphics2D g2d) {
		AffineTransform backup = g2d.getTransform();
		AffineTransform trans = new AffineTransform();
		trans.translate(-Game.camera.getsX(),-Game.camera.getsY());
		trans.scale(Camera.SCALE, Camera.SCALE);

		g2d.transform(trans);
		g2d.drawImage(potionhut, x, y, null);

		g2d.setTransform(backup);
	}

}
