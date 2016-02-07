package net.markmeijer.starplanet;

import java.awt.*;

public class Character extends DoubleRectangle {
	public double playerGravity = 2.2;
	public double movementSpeed = 2;
	public double jumpingSpeed = playerGravity;
	public int jumpingHeight = 50;
	public int jumpingCount = 0;
	public int animation = 0;
	public int animationFrame = 0;
	public int animationTime = 20;
	public boolean isJumping = false;
	public Character(int width,int height){
		setBounds((Component.pixel.width/2)-(width/2),(Component.pixel.height/2)-(height/2),width,height);
	}
	public void tick(){
		if(!isJumping && !isCollidingWithBlock(new Point((int)x,(int)y+(int)height),new Point((int)(x+width),(int)(y+height)))){
			y+= playerGravity;
			Component.sY += playerGravity;
		}else{
			if (Component.isJumping){
				isJumping = true;
			}
		}
		if(Component.isMoving){
			boolean canMove = false;
			if(Component.dir==movementSpeed){
				canMove = isCollidingWithBlock(new Point((int)(x+width),(int)y),new Point((int)(x+width),(int)(y+(height-2))));
			}else if(Component.dir==-movementSpeed){
				canMove = isCollidingWithBlock(new Point((int)x-1,(int)y),new Point((int)x-1,(int)y+(int)(height-2)));
			}
			
			if(!canMove){
				x+=Component.dir;
				Component.sX += Component.dir;
			}
		}
		if(isJumping){
			if(!isCollidingWithBlock(new Point((int)x,(int)y),new Point((int)(x+width),(int)y))){
				if(jumpingCount>=jumpingHeight){
					isJumping = false;
					jumpingCount = 0;
				}else{
					y-=jumpingSpeed;
					Component.sY -= jumpingSpeed;
					jumpingCount+=1;
				}
			}else{
				isJumping = false;
				jumpingCount = 0;
			}
		}
	}
	public boolean isCollidingWithBlock(Point pt1, Point pt2){
		for(int x=(int)(this.x/Tile.tileSize);x<(int)(this.x/Tile.tileSize+3);x++){
			for(int y=(int)(this.y/Tile.tileSize);y<(int)(this.y/Tile.tileSize+3);y++){
				if(x>=0&&y>=0&&x<Component.level.block.length&&y<Component.level.block[0].length)
				if(Component.level.block[x][y].id!= Tile.air){
					if(Component.level.block[x][y].contains(pt1)||Component.level.block[x][y].contains(pt2)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public void render(Graphics g){
		if(Component.dir==movementSpeed){
		g.drawImage(Tile.texturemap_terrain, (int)x-(int)Component.sX, (int)y-(int)Component.sY,(int)x+(int)width-(int)Component.sX,(int)y+(int)height-(int)Component.sY,Tile.character[0]*Tile.tileSize,Tile.character[1]*Tile.tileSize,Tile.character[0]*Tile.tileSize+(int)width,Tile.character[1]*Tile.tileSize+(int)height,null);
		}
		tick();
	}
}
