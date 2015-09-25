package net.silvertigerentertainment.GVSM.Entitys;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Helpers.Animation;
import net.silvertigerentertainment.GVSM.Main.Screen;

public class Entity {

	public int jumpTime, jumpTimer = 30;

	public int hasCollided = 0;
	public boolean isFalling = true;

	public BufferedImage animationTileset;
	public Animation walk;
	public Animation stand;

	public BufferedImage texture;

	public float speed;
	public int x, y;
	public boolean isLeft, isRight, isJump, isGrounded;
	public String textureName;

	public boolean jumpPressed;
	public boolean isWalking, isJumping, isRunning, isAttacking,
			isStanding = true;

	public int width = 96, height = 128;

	public Entity() {
		int mydir = x - Screen.WIDTH / 2;
		Screen.sX += mydir;
		this.x = Screen.WIDTH / 2 - 8;
	}

	public void render(Graphics2D g) {
		
		if (isWalking) {
			walk.render(g);
		} else {
			stand.render(g);
		}
	}

	public void tick() {
		stand.update(x, y, 10);
		walk.update(x, y,10);

		// Movement Code Here

		if (isFalling) {
			y += 3;
		}

		for (int x = 0; x < Screen.level.block.length; x++) {
			for (int y = 0; y < Screen.level.block[0].length; y++) {
				if (getBounds()
						.intersects(Screen.level.block[x][y].getBounds())) {
					if (Screen.level.block[x][y].id == 12) {
						isGrounded = true;
					}
				}
			}
		}

		if (isFalling) {
			for (int x = 0; x < Screen.level.block.length; x++) {
				for (int y = 0; y < Screen.level.block[0].length; y++) {
					if (getBounds().intersects(
							Screen.level.block[x][y].getBounds())) {
						if (Screen.level.block[x][y].id != 0) {
							if (isGrounded) {
								isFalling = false;
							}
						} else {
							isFalling = true;
						}
					}
				}
			}
		}

		double speed = 150.5;

		if (jumpPressed) {

			if (isJump && !isFalling) {
				if (jumpTime >= jumpTimer) {
					isFalling = true;
					isJump = false;
					jumpTime = 0;
				} else {
					// isJump = false;
					isGrounded = false;
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
			// x += 1;
			Screen.sX += speed;
		}

		if (isLeft) {
			Screen.sX -= speed;
		}
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void setAirTime(int airTime) {
		this.jumpTimer = airTime;
	}

	public String getTextureName() {
		return textureName;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height - 30);
	}
	
	public void setAnimationTileset(String path) {
		try {
			BufferedImage animationTileset;
			animationTileset = ImageIO.read(new File("res/" + path + ".png"));
			this.animationTileset = animationTileset;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTexture(String path) {
		try {
			BufferedImage texture;
			texture = ImageIO.read(new File("res/" + path + ".png"));
			this.texture = texture;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setWalkAnimation(Animation walk) {
		this.walk = walk;
	}
	
	public void setStandAnimation(Animation stand) {
		this.stand = stand;
	}
	
	
	
	
	
	

}
