package net.silvertigerentertainment.GVSM.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Entitys.Player;
import net.silvertigerentertainment.GVSM.Entitys.Player2;
import net.silvertigerentertainment.GVSM.Helpers.ScreenShot;

public class Listener implements KeyListener { 

	public void keyPressed(KeyEvent e) {
		Screen.player.keyPressed(e);
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_F11:
			ScreenShot.takeScreenShoot();
			break;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		Screen.player.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
