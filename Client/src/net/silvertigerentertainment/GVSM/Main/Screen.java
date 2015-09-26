package net.silvertigerentertainment.GVSM.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Runnable {

	// dimensions
	public static final int WIDTH = Frame.size.width;
	public static final int HEIGHT = Frame.size.height;
	public static boolean gamePaused;

	// game thread
	private static Thread thread;
	public static boolean running = false;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// image
	public static BufferedImage image;
	private Graphics2D g;

	// game state manager
	private GameStateManager gsm;

	public Screen() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(new Listener());
			thread.start();
		}
	}

	public static int getX(int x) {
		return WIDTH / 800 * x;
	}

	public static int getY(int y) {
		return HEIGHT / 800 * y;
	}

	private void init() {

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		//running = true;

		gsm = new GameStateManager();

	}

	public void run() {
		init();

		long start;
		long elapsed;
		long wait;

		// game loop
		while (running == false) {

			start = System.nanoTime();

			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000000;
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void update() {
		gsm.tick();
	}

	private void draw() {
		gsm.render(g);
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

		g2.dispose();
	}

}
