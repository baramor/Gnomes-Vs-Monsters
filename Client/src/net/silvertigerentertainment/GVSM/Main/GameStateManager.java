package net.silvertigerentertainment.GVSM.Main;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	
	public ArrayList<GameState> gamestates = new ArrayList<GameState>();
	public int currentGameState = 1;
	
	public GameStateManager() {
		registerGameState(new Game());
	}
	
	public void registerGameState(GameState state) {
		gamestates.add(state);
	}
	
	public void tick() {
		for(GameState gamestate:gamestates) {
			if(gamestate.id == currentGameState) {
				gamestate.tick();
			}
		}
	}
	
	public void render(Graphics2D g) {
		for(GameState gamestate:gamestates) {
			if(gamestate.id == currentGameState) {
				gamestate.render(g);
			}
		}
	}

}
