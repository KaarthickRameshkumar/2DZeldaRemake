
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


public class OctoRock extends EnemyObject {
	private Animation walkTo;
	private Animation walkBack;
	private Animation walkRight;
	private Animation walkLeft;

	private Animation attackTo;
	private Animation attackBack;
	private Animation attackRight;
	private Animation attackLeft;
	
	public int health;
	private static int direction;
	private static boolean attack = false;
	private int changeD;
	private RockShooter rock;

	Texture texture;
	public OctoRock(int x, int y,ObjectId id) {
		super(x,y,id);
		rock = new RockShooter(x,y,ObjectId.Rock);
		texture = Game.getInstance();
		health= 4;
		changeD = 200;
		setDirection( );

		attackBack= new Animation(10, texture.octoRocks[0],texture.octoRocks[1],texture.octoRocks[2],texture.octoRocks[3]);
		walkBack= new Animation(10, texture.octoRocks[4],texture.octoRocks[5]);
		attackRight= new Animation(10, texture.octoRocks[6],texture.octoRocks[7],texture.octoRocks[8],texture.octoRocks[9]);
		walkRight= new Animation(10, texture.octoRocks[10],texture.octoRocks[11]);
		attackTo= new Animation(10, texture.octoRocks[12],texture.octoRocks[13],texture.octoRocks[14],texture.octoRocks[15]);
		walkTo= new Animation(10, texture.octoRocks[6],texture.octoRocks[17]);
		attackLeft= new Animation(10, texture.octoRocks[18],texture.octoRocks[19],texture.octoRocks[20],texture.octoRocks[21]);
		walkLeft= new Animation(10, texture.octoRocks[22],texture.octoRocks[23]);
    }
	
    public void tick(LinkedList<EnemyObject> objects) {
		Rectangle linkBounds = new Rectangle (Handler.linkX,Handler.linkY,120,120);
		if(!attack){
			changeD--;
		}
		
		rock.tick(x, y);
		if(changeD == 0){
			changeD = 300;
			setDirection();
		}
		switch (direction) {
			case 0:
				walkTo.runAnimation();
				attackTo.runAnimation();
				break;
			case 1:
				walkLeft.runAnimation();
				attackLeft.runAnimation();
				break;
			case 2:
				walkBack.runAnimation();
				attackBack.runAnimation();
				break;
			case 3:
				walkRight.runAnimation();
				attackRight.runAnimation();
				break;
		}

		if (health <= 0){
			Handler.removeObject(Handler.index);
		}
		if(getFollowBounds().intersects(linkBounds)){
			if (Link.isInvincible() == 0){
				follow();
				if(!rock.isAttackting()){
					switch (direction){
						case 0: rock.attack(0, 10);break;
						case 1: rock.attack(-10, 0);break;
						case 2: rock.attack(0, 10);break;
						case 3: rock.attack(10, 0);break;
					}
				}
				
				attack = true;
			}
			else {
				x+=velX;
				y+=velY;
			}
		}
		else {
			switch (direction){
				case 0: y+=velY;break;
				case 1: x+=velX;break;
				case 2: y+=velY;break;
				case 3: x+=velX;break;	
			}

			attack = false;
			
		}

		
		checkCollisions();
	}
	
	private void checkCollisions(){
		if(x<50){
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
	public void follow(){
		if (x>Handler.linkX){
			velX = -1;
		}
		else if (x<Handler.linkX){
			velX = 1;
		}
		
		if (y<Handler.linkY){
			velY = 1;
		}
		else if (y>Handler.linkY){
			velY = -1;
		}
	}
	
    public void render(Graphics g) {
		rock.render(g);
		if (attack){
			switch(direction){
				case 0:
					attackTo.drawAnimation(g,x,y,40,40);
					break;
				case 1:
					attackLeft.drawAnimation(g,x,y,40,40);
					rock.render(g);
					break;
				case 2:
					attackBack.drawAnimation(g,x,y,40,40);
					rock.render(g);
					break;
				case 3:
					attackRight.drawAnimation(g,x,y,40,40);
					rock.render(g);
					break;
			}	
		}
		else {
			switch(direction){
				case 0:
					walkTo.drawAnimation(g,x,y,40,40);
					break;
				case 1:
					walkLeft.drawAnimation(g,x,y,40,40);
					break;
				case 2:
					walkBack.drawAnimation(g,x,y,40,40);
					break;
				case 3:
					walkRight.drawAnimation(g,x,y,40,40);
					break;
			}
			
		}
    }
    
    
    public Rectangle getBounds() {
        return new Rectangle (x,y,40,40);
	}
	public void setDirection() {
		direction = (int) (Math.random () * 4 + 0);

		switch (direction){
			case 0: velY = 1; break;
			case 1: velX = -1; break;
			case 2: velY = -1; break;
			case 3: velX = 1; break;
		}
	}
	public Rectangle getFollowBounds (){
		return new Rectangle (x-100,y-100,250,250);
	}

	public static void attack (){
		attack = true;
	}

	public static boolean isAttacking (){
		return attack;
	}

	public void damaged(int damage) {
		health-=damage;
	}

}
