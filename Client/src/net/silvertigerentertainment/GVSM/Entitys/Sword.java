package net.silvertigerentertainment.GVSM.Entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Helpers.Camera;
import net.silvertigerentertainment.GVSM.Main.Game;
import net.silvertigerentertainment.GVSM.Main.Screen;
import static net.silvertigerentertainment.GVSM.Helpers.ImageSprite.*;

public class Sword {

	public BufferedImage sword;

	boolean isRepeating = false, callRepeat;
	AffineTransform identity = new AffineTransform();
	int currentrotate = 0;
	int rotate = 330;
	double changetime, changetimer = -1500;

	int x = 440, y = 394;

	public Sword() {
		try {
			sword = ImageIO.read(new File("res/Items/sword" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		//swing();
	}

	public void swing() {
		getReady();
		if (callRepeat) {
			currentrotate = 0;
			// isRepeating = true;
		}

		if (isRepeating && !callRepeat) {

			if (currentrotate >= 24) {
				System.out.println("Hi");
				rotate = 330;
				isRepeating = false;
			}

			if (changetime >= changetimer) {
				currentrotate += 1;
				rotate -= 1;
				changetime = 0;
			} else {
				changetime += 1;
			}
		}
	}

	int time, timer = 3;

	public void getReady() {

		if (rotate <= 270) {
			isRepeating = true;
		}else{
			rotate -= 5;
		}

		if (isRepeating == false) {

			if (time >= timer) {
				rotate -= 5;
				time = 0;
			} else {
				time += 1;
			}
		}
	}

	public void render(Graphics2D g) {

		AffineTransform backup = g.getTransform();
		AffineTransform trans = new AffineTransform();
		trans.scale(Camera.SCALE, Camera.SCALE);
		trans.rotate(Math.toRadians(rotate), x, y);

		g.transform(trans);
		g.drawImage(sword, x, y, null);

		g.setTransform(backup);

	}

}
