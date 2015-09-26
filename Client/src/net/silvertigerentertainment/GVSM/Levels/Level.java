package net.silvertigerentertainment.GVSM.Levels;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Main.Screen;

public class Level {
	public int worldWidth = 64;
	public int worldHeight = 24;
	public static int blockSize = 64;

	public static BufferedImage tileset;
	public Block[][] block;

	public Level() {
		define();
	}
	
	public void LoadTileset(String path){
		try {
			tileset = ImageIO.read(new File("res/" + path + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void define() {
		block = new Block[worldWidth][worldHeight];

		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(x * blockSize, y * blockSize + 32,blockSize, blockSize, 0);
			}
		}
	}

	public void render(Graphics2D g) {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y].render(g);
			}
		}
	}
}
