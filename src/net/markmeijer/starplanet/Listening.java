package net.markmeijer.starplanet;

import java.awt.event.*;

public class Listening implements KeyListener {
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_D:
			Component.isMoving = true;
			Component.dir = Component.character.movementSpeed;
			break;
		case KeyEvent.VK_A:
			Component.isMoving = true;
			Component.dir = -Component.character.movementSpeed;
			break;
		case KeyEvent.VK_SPACE:
			Component.isJumping = true;
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_D:
			if(Component.dir == Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
		case KeyEvent.VK_A:
			if(Component.dir == -Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
		case KeyEvent.VK_SPACE:
			Component.isJumping = false;
			break;
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
}
