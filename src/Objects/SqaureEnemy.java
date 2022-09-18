package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Game;


public class SqaureEnemy extends EnemyObject {
	private static int moveX;
    private static int  moveY;
    Texture texture;
	public SqaureEnemy(int x, int y,ObjectId id) {
		super(x,y,id);
		texture = Game.getInstance();
		moveX=4;
		moveY=4;
		
    }
	
    public void tick(LinkedList<EnemyObject> objects) {
		x+= moveX;
		y+= moveY;
		
		checkCollisions();
    }
	private void checkCollisions(){
		if (x+texture.sqaureEnemies[0].getWidth(null) >400){ 	
	        velX*=-1;
		}
		 if ( x+texture.sqaureEnemies[0].getWidth(null) <0) {
			 velX*=-1;
		 }
		 if (y+texture.sqaureEnemies[0].getHeight(null)>400) {
			 velY*=-1;
		 }
		 if (y+texture.sqaureEnemies[0].getHeight(null)<0) {
			 velY*=-1;
		 }
	}
	
    public void render(Graphics g) {
       g.drawImage(texture.sqaureEnemy[0], x, y, null);
    }
    
    
    public Rectangle getBounds() {
        return null;
	}
	
	public Rectangle getFollowBounds (){
		return new Rectangle (x-50,y-50,150,150);
	}

	public void damaged(int damage) {

	}
}