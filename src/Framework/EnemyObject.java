package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;

public abstract class EnemyObject {
	  public int health;
	  protected int collisionDamage;
    protected int x,y;
    protected int velX, velY;
    protected ObjectId id;
    
    public EnemyObject(int x, int y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;

        if (id == ObjectId.Bat){
            health = 3;
            collisionDamage = 2;
        if (id == ObjectId.OctoRock){
          health = 4;
          collisionDamage = 1;
        }  
        }
    }

    public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
    }
    
    public void setY(int y) {
		this.y= y;
    }

    public void setX(int x) {
		this.x = x;
    }

    public int getX() {
		return x;
    }

    public int getY (){
        return y;
    }

    public abstract void damaged (int damage);
    public abstract void tick(LinkedList<EnemyObject> objects);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

	public ObjectId getObjectId() {
		return id;
	}

    
}