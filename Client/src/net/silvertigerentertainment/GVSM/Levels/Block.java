package net.silvertigerentertainment.GVSM.Levels;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import net.silvertigerentertainment.GVSM.Entitys.Player;
import net.silvertigerentertainment.GVSM.Helpers.Camera;
import net.silvertigerentertainment.GVSM.Main.Game;
import net.silvertigerentertainment.GVSM.Main.Screen;

public class Block extends Rectangle {
	public int id;

	public Block(int x, int y, int width, int height, int id) {
		setBounds(x, y, width, height);
		this.id = id;

	}

	public void render(Graphics2D g) {
		if (id != 0) {

			if (id == 33) {
				Game.player.player.x = x;
				Game.player.player.y = y - (int) Game.camera.sY - 32;
				g.setColor(new Color(7, 173, 227));
				//g.setColor(Color.BLACK);
				g.fillRect(x, y - (int) Game.camera.sY, Level.blockSize, Level.blockSize);
			} else {

				drawBlock(Level.tileset, g, x - (int) Game.camera.getsX(), y - (int) Game.camera.sY, 8, id - 1, 16, 16);
			}
		}
	}

	public Rectangle collisionBounds() {
		return new Rectangle(x, y - (int) Game.camera.sY, width, height);
	}

	public void drawBlock(Image source, Graphics2D dest, int x, int y, int cols, int frame, int width, int height) {
		int fx = (frame % cols) * width;
		int fy = (frame / cols) * height;

		dest.drawImage(source, x, y, x + Level.blockSize, y + Level.blockSize, fx, fy, fx + width, fy + height, null);

	}

}
