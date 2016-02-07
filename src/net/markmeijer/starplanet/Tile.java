package net.markmeijer.starplanet;

import java.awt.image.*;
import java.io.File;
import javax.imageio.*;

public class Tile {
	public static int tileSize = 32;
	public static int[] air = {-1,-1};
	public static int[] earth = {0,0};
	public static int[] character = {0,18};
	public static BufferedImage texturemap_terrain;
	
	public Tile(){
		try{
			texturemap_terrain = ImageIO.read(new File("res/texturemap_terrain.png"));
		}catch(Exception e){
			
		}
	}
}
