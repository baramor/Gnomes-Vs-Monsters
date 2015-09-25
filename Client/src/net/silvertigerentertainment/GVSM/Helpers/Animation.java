package net.silvertigerentertainment.GVSM.Helpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Animation {

	// The Tileset Animation
	BufferedImage texture;

	// Frame Variables
	int x, y, width, height;
	int cols, frame, imageWidth, imageHeight;
	int minFrame, maxFrame;

	public Animation(BufferedImage source, int x, int y, int cols, int width,
			int height, int imageWidth, int imageHeight, int minFrame,
			int maxFrame) {
		this.texture = source;
		this.x = x;
		this.y = y;
		this.cols = cols;
		this.frame = minFrame;
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.maxFrame = maxFrame;
		this.minFrame = minFrame;
	}

	int switcher = 0;
	int counter = 0;
	int counter2 = 0;
	int counter3 = 0;

	// Updates Animation
	public void update(int x, int y, int fps) {
		this.x = x;
		this.y = y;

		if (maxFrame != 0) {

			if (frame >= maxFrame) {
				frame = minFrame;
			} else {

				if (counter >= fps) {
					counter = 0;
					frame += 1;
				} else {
					counter += 1;
				}
			}
		} else {
			if (counter3 >= 500) {
				if (switcher == 0) {
					if (counter >= fps) {
						switcher = 1;
						counter = 0;
						frame = 8;
					} else {
						counter += 1;
					}
				} else {
					if (counter2 >= fps) {
						switcher = 0;
						counter2 = 0;
						counter3 = 0;
						frame = 0;
					} else {
						counter2 += 1;
					}
				}
			} else {
				frame = 0;
				counter3+=1;
			}
		}

	}
	

	// renders the animation
	public void render(Graphics2D dest) {
		int fx = (frame % cols) * imageWidth;
		int fy = (frame / cols) * imageHeight;
		dest.drawImage(texture, x, y, x + width, y + width, fx, fy, fx
				+ imageWidth, fy + imageHeight, null);
	}

}
