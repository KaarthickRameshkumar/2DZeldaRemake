package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Weapon {

    protected int damage;
    protected int travel;
    protected int x,y;
    protected int velX, velY;
    protected ObjectId id;
    
    public Weapon (int x, int y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id; 
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

    public abstract void tick(int x, int y);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

	public ObjectId getObjectId() {
		return id;
	}
}