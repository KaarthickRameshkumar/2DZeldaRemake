package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Animation;
import coms.MYPJavaPeople.TLOZ.Window.Game;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class Bat extends EnemyObject{
Texture texture;
private Animation fly;
public int health;

	public Bat(int x, int y, ObjectId id) {
		super(x,y,id);
		texture = Game.getInstance();
		velX = 4;
		velY = 4;
		health = 3;

		fly = new Animation (7,texture.bats[0],texture.bats[1]);
    }
    public void tick(LinkedList<EnemyObject> objects) {
		Rectangle linkBounds = new Rectangle (Handler.linkX,Handler.linkY,120,120);
		fly.runAnimation();

		if (health <= 0){
			Handler.removeObject(Handler.index);
		}

		if (getFollowBounds().intersects(linkBounds)) {
			if (Link.isInvincible() == 0){
				follow();
				x+=velX;
				y+=velY;
			}
			else {
				x+=velX;
				y+=velY;
			}
		} 
		else{
			x += velX;
		}
		checkCollisions();	
    }
	
	public void follow()  {
		if (x>Handler.linkX){
			velX = -3;
		}
		else if (x<Handler.linkX){
			velX = 3;
		}
		
		if (y<Handler.linkY){
			velY = 3;
		}
		else if (y>Handler.linkY){
			velY = -3;
		}

	}
	
	
	public void checkCollisions() {

		if(x<1){
			velX*=-1;
		}
		else if (x>MapRenderer.w*50-50){
			velX*=-1;
		}
		else if (y<50){
			velY*=-1;
		}
		else if (y>MapRenderer.h*50-50){
			velY*=-1;
		}

		for (int i = 0;i<Handler.mapObjects.size();i++){
			GameObject temp = Handler.mapObjects.get(i);
			if(getBounds().intersects(temp.getBounds())){
				if (velX<0){
					velX*=-1;
					x+=10;
				}
				else if (velX>0){
					velX*=-1;
					x-=10;
				}

				if(velY<0){
					velY*=-1;
					y+=10;
				}
				else if (velY>0){
					velY*=-1;
					y-=10;
				}
			}
		}

	}
	
    public void render(Graphics g) {
    	fly.drawAnimation(g, x, y);
    }
	
	public Rectangle getBounds() {
        return new Rectangle (x,y,texture.bats[0].getWidth(),texture.bats[0].getHeight());
	}
	
	public Rectangle getFollowBounds (){
		return new Rectangle (x-100,y-100,250,250);
	}

	public void damaged(int damage) {
		health-=damage;
	}






}