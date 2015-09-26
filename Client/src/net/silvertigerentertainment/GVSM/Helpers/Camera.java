package net.silvertigerentertainment.GVSM.Helpers;

import net.silvertigerentertainment.GVSM.Main.Game;
import net.silvertigerentertainment.GVSM.Main.Screen;

public class Camera {
	
	public static float SCALE = Screen.getY(2);
	public float sX = 0, sY = 0;
	
	public void tick(){
		//SCALE += 1;
	}
	
	public  float getsX() {
		return sX / 64;
	}
	public float getsY() {
		return sY / 64;
	}
	
	
	

}
