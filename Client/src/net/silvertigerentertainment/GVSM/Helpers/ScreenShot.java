package net.silvertigerentertainment.GVSM.Helpers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Main.Screen;

public class ScreenShot {

	public static void takeScreenShoot() {
		try {
			Screen.running = true;
			ImageIO.write(Screen.image, "PNG", new File("res/ScreenShots/screenshot" + id() + ".png"));
			Screen.running = false;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	public static Random rand = new Random();

	public static int id() {
		int id = 0;
		for (int i = 0; i <= 10000; i += 1) {
			File f = new File("res/ScreenShots/screenshot" + i + ".png");
			if (!f.exists()) {
				id = i + rand.nextInt(100000);
			}
		}
		return id;
	}

}
