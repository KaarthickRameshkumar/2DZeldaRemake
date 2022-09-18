package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Animation;
import coms.MYPJavaPeople.TLOZ.Window.Game;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class Link extends EnemyObject{

	Texture texture;
	private Animation walkTo;
	private Animation walkBack;
	private Animation walkRight;
	private Animation walkLeft;

	private Animation attackTo;
	private Animation attackBack;
	private Animation attackRight;
	private Animation attackLeft;

	private static int direction;
	public static int health;
	public static int rupees;
	private static int invincibility;
	private static boolean attack = false;
	private static int attackFrames = 0;

	private Sword sword;

	public Link(int x, int y, ObjectId id) {
		super(x, y, id);
		sword = new Sword(x, y, ObjectId.Sword);
		texture = Game.getInstance();
		setDirection(0);

		walkTo = new Animation(4, texture.links[0], texture.links[1]);
		walkLeft = new Animation(4, texture.links[3], texture.links[4]);
		walkBack = new Animation(4, texture.links[5], texture.links[6]);
		walkRight = new Animation(4, texture.links[8], texture.links[9]);

		attackTo = new Animation(1, texture.links[10]);
		attackLeft = new Animation(1, texture.links[11]);
		attackBack = new Animation(1, texture.links[13]);
		attackRight = new Animation(1, texture.links[12]);

		health = 6;
		rupees = 0;
	}

	public void tick(LinkedList<EnemyObject> objects) {
		x += velX;
		y += velY;

		sword.tick(x,y);

		if (health<=0){
			System.exit(0);
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

		checkCollisions();
	}

	private void checkCollisions() {
		if (x > MapRenderer.w * 50 - 70) {
			MapRenderer.changeMapNum(-10);
			x = 70;
			Game.camera.setX(0);
		} else if (x < 5) {
			MapRenderer.changeMapNum(10);
			x = MapRenderer.w * 50 - 80;
			Game.camera.setX(MapRenderer.w - 450);
		} else if (y < 5) {
			MapRenderer.changeMapNum(1);
			y = MapRenderer.h * 50 - 100;
			Game.camera.setY(MapRenderer.h-825);
		} else if (y > MapRenderer.h * 50 - 70) {
			MapRenderer.changeMapNum(-1);
			y = 70;
			Game.camera.setY(0);
		}
		for (int i = 0;i<Handler.mapObjects.size();i++) {
			GameObject temp = Handler.mapObjects.get(i);
			if(temp.getObjectId()==ObjectId.Ruby){
				if (getBounds().intersects(temp.getBounds())){
					System.exit(0);
				}
			}
			if (getBounds().intersects(temp.getBounds())){
				switch (direction){
					case 0:y-=10;break;
					case 1:x+=10;break;
					case 2:y+=10;break;
					case 3:x-= 10;break;
				}
			}
		}

		for (int i = 0;i<Handler.objects.size();i++){
			EnemyObject temp = Handler.objects.get(i);
			if (invincibility>0){
				invincibility--;
				break;
			}
			if (temp.getObjectId() != ObjectId.Link && getBounds().intersects(temp.getBounds())){
				health--;
				invincibility = 50;
			}
		}

	}

	public void render(Graphics g) {
		if (velX != 0 && !attack|| velY != 0 && !attack) {
			switch (direction) {
			case 0:
				walkTo.drawAnimation(g, x, y,60,78);
				break;
			case 1:
				walkLeft.drawAnimation(g, x, y,60,78);
				break;
			case 2:
				walkBack.drawAnimation(g, x, y,60,78);
				break;
			case 3:
				walkRight.drawAnimation(g, x, y ,60,78);
				break;
			}
		}
		else if (attack){
			switch (direction) {
				case 0:
					attackTo.drawAnimation(g, x, y, 60, 78);
					sword.render(g);
					break;
				case 1:
					sword.render(g);
					attackLeft.drawAnimation(g, x, y, 60, 78);
					break;
				case 2:
					sword.render(g);
					attackBack.drawAnimation(g, x, y, 60, 78);
					break;
				case 3:
					sword.render(g);
					attackRight.drawAnimation(g, x, y, 60, 78);
					break;
				}

				attackFrames++;
				if (attackFrames == 30){
					attackFrames = 0;
					attack = false;
				}
		}
		else {
			switch (direction) {
			case 0:
				g.drawImage(texture.links[2], x, y, 60, 78, null);
				break;
			case 1:
				g.drawImage(texture.links[3], x, y, 60, 78, null);
				break;
			case 2:
				g.drawImage(texture.links[6], x, y, 60, 78, null);
				break;
			case 3:
				g.drawImage(texture.links[8], x, y, 60, 78, null);
				break;
			}

		}

		sword.setDirection(direction);
	}

	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle(x, y, 60,78);
		return bounds;
	}

	public static int getDirection() {
		return direction;
	}

	public static void setDirection(int direction) {
		Link.direction = direction;
	}

	public static void attack (){
		attack = true;
	}

	public static boolean isAttacking (){
		return attack;
	}

	public static int isInvincible () {
		return invincibility;
	}

	public static void stopAttack (){
		attackFrames = 29;
	}

	public void damaged(int damage) {
		health-=damage;
		invincibility = 50;
	}

}
