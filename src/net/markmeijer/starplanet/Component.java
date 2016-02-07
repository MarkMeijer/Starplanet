package net.markmeijer.starplanet;

import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class Component extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private static int pixelSize = 2;
	public static double sX=0,sY=0;
	public static double dir = 0;
	public static Dimension size = new Dimension(1280,720);
	public static Dimension pixel = new Dimension(size.width/pixelSize,size.height/pixelSize);
	public static String name = "Starplanet ";
	public static String version = "Pre-Alpha 1.0";
	public static boolean isRunning = false;
	public static boolean isMoving = false;
	public static boolean isJumping = false;
	private Image screen;
	public static Level level;
	public static Character character;
	public Component(){
		setPreferredSize(size);
		addKeyListener(new Listening());
	}
	public void start(){
		new Tile();
		level = new Level();
		character = new Character(Tile.tileSize,Tile.tileSize*2);
		isRunning = true;
		new Thread(this).start();
	}
	public void stop(){
		isRunning = false;
	}
	public static void main(String args[]){
		Component component = new Component();
		
		JFrame frame = new JFrame();
		frame.add(component);
		frame.pack();
		frame.setTitle(name + " " + version);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		component.start();
	}
	public void tick(){
		
	}
	public void render(){
		Graphics g = screen.getGraphics();
		g.setColor(new Color(150,150,255));
		g.fillRect(0, 0, pixel.width, pixel.height);
		level.render(g,(int)sX,(int)sY,(pixel.width/Tile.tileSize)+2,(pixel.height/Tile.tileSize)+2);
		character.render(g);
		g = getGraphics();
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();
	}
	public void run(){
		screen = createVolatileImage(pixel.width,pixel.height);
		while(isRunning){
			tick();
			render();
			
			try{
				Thread.sleep(5);
			} catch(Exception e){
				
			}
		}
	}
}
