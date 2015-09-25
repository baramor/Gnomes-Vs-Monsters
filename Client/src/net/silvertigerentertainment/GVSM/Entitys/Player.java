package net.silvertigerentertainment.GVSM.Entitys;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.silvertigerentertainment.GVSM.Helpers.Animation;
import net.silvertigerentertainment.GVSM.Magic.Power;
import net.silvertigerentertainment.GVSM.Main.Screen;

public class Player {

	public Sword sword;
	public Entity player;
	
	public Player(Entity player) {
		this.player = player;
		sword = new Sword(player.x,player.y);
	}
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			player.isWalking = true;
			player.isRight = true;
			break;
		case KeyEvent.VK_LEFT:
			player.isWalking = true;
			player.isLeft = true;
			break;
		case KeyEvent.VK_UP:
			player.jumpPressed = true;
			if(!player.isJump) {
				player.isJump = true;
			}
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			player.isWalking = false;
			player.isRight = false;
			break;
		case KeyEvent.VK_LEFT:
			player.isWalking = false;
			player.isLeft = false;
			break;
		case KeyEvent.VK_UP:
			player.jumpPressed = false;
			break;
		}
	}
	
	public void render(Graphics2D g){
		player.render(g);
		sword.render(g);
	}
	
	public void tick() {
		player.tick();
		sword.tick();
	}

}
