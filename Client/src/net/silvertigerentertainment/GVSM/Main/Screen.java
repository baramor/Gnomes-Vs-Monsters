package net.silvertigerentertainment.GVSM.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.File;

import javax.swing.JPanel;

import net.silvertigerentertainment.GVSM.Entitys.Player;
import net.silvertigerentertainment.GVSM.Entitys.Players;
import net.silvertigerentertainment.GVSM.Levels.Level;
import net.silvertigerentertainment.GVSM.Levels.MapLoader;

public class Screen extends JPanel implements Runnable {
	public static BufferedImage backbuffer;
	public static final int WIDTH = Game.size.width, HEIGHT = Game.size.height;
	public static boolean gamePaused = false;

	public Thread thread;

	public static double sX = 0, sY = 0;

	public Players players;

	public static Player player;
	public static Level level;
	public MapLoader loader;

	public static Graphics2D g2d;

	AffineTransform identity = new AffineTransform();

	public AffineTransform trans = new AffineTransform();

	public Screen() {
		define();
		thread = new Thread(this);
		thread.start();
	}

	public void define() {
		backbuffer = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		g2d = backbuffer.createGraphics();
		players = new Players();
		level = new Level();
		player = new Player(players.firegnome);

		loader = new MapLoader();
		loader.loadLevel(new File("maps/test.map"), "dungeon_tileset", 32, 16);
	}

	public void tick() {
		player.tick();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render(g2d);
		g2.drawImage(backbuffer, 0, 0, this);
	}

	public void render(Graphics2D g) {
		g2d.setColor(new Color(87, 176, 249));
		g2d.fillRect(0, 0, WIDTH * (level.worldWidth * 64), HEIGHT
				* (level.worldHeight * 64));
		// Render the game
		player.render(g);
		level.render(g);

	}

	public void run() {
		while (gamePaused == false) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			tick();
			repaint();

		}
	}
	
	
}