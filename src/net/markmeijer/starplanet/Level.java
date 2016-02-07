package net.markmeijer.starplanet;

import java.awt.*;

public class Level  {
	public int worldW = 70,worldH = 50;
	public Block[][] block = new Block[50][50];
	public Level(){
		for(int x=0;x<block.length;x++){
			for(int y=0;y<block[0].length;y++){
				block[x][y] = new Block(new Rectangle(x*Tile.tileSize,y*Tile.tileSize,Tile.tileSize,Tile.tileSize),Tile.air);
			}
		}
		generateLevel();
	}
	
	public void generateLevel(){
		for(int x=0;x<block.length;x++){
			for(int y=0;y<block[0].length;y++){
				 if (x==0||y==0||x==block.length-1||y==block[0].length-1){
					 block[x][y].id = Tile.earth;
				 }
			}
		}
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g,int camX,int camY,int renW,int renH){
		for(int x=(camX/Tile.tileSize);x<(camX/Tile.tileSize)+renW;x++){
			for(int y=(camY/Tile.tileSize);y<(camY/Tile.tileSize)+renH;y++){
				if(x>=0&&y>=0&&x<block.length&&y<block[0].length){
					block[x][y].render(g);
				}
			}
		}
	}
}
