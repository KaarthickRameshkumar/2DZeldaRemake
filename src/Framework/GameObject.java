package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {
	protected int x, y;
	protected ObjectId id;
	
	public GameObject (int x, int y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick (LinkedList<GameObject> objects);
	public abstract void render (Graphics g);
	public abstract Rectangle getBounds();
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;;
	}

	public void setY(int y) {
		this.y = y;;
	}

	public ObjectId getObjectId() {
		return id;
	}
	
}
