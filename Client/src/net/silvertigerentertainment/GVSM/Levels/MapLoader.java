package net.silvertigerentertainment.GVSM.Levels;

import java.io.*;
import java.util.*;

import net.silvertigerentertainment.GVSM.Main.Screen;

public class MapLoader {

	public void loadLevel(File loadPath, String tilesetpath, int width, int height) {
		
		Screen.level.LoadTileset(tilesetpath);
		
		try {
			Scanner loadScanner = new Scanner(loadPath);
			
			while(loadScanner.hasNext()) {
				for(int x = 0; x < height; x++) {
					for(int y = 0; y < width; y++) {
						Screen.level.block[y][x].id = loadScanner.nextInt();
					}
				}
			}
			loadScanner.close();
		}catch(Exception e) { }
	}

}
