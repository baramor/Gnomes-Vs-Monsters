package net.silvertigerentertainment.GVSM.Entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player2 {

	public BufferedImage player;

	public static boolean jumpPressed;
	public static boolean isLeft, isRight, isJump;

	public int jumpTime, jumpTimer = 30;

	public boolean isFalling = true;
	public int x, y;

	public Player2() {

		try {
			player = ImageIO.read(new File("res/the_rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 350;
		y = 50;
	}

	public void tick() {

		if (isFalling) {
			y += 3;
		}

	/*	if (isFalling) {
			if (getBounds().intersects(Floating_Isle.base())) {
				isFalling = false;
			} else {
				isFalling = true;

			}
		}*/

		if (jumpPressed) {

			if (isJump && !isFalling) {
				if (jumpTime >= jumpTimer) {
					isFalling = true;
					isJump = false;
					jumpTime = 0;
				} else {
					y -= 4.8;
					jumpTime += 1;
				}
			}
		}

		if (!jumpPressed && isJump) {
			isFalling = true;
			isJump = false;
			jumpTime = 0;

		}

		if (isRight) {
			x += 2;
		}

		if (isLeft) {
			x -= 2;
		}
	}

	public void render(Graphics g) {
		g.drawImage(player, x, y, 96, 128, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 96, 128);
	}

}
