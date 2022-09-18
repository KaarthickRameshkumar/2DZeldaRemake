package coms.MYPJavaPeople.TLOZ.MapObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Game;

public class Grass extends GameObject{

	private int type;
	Texture texture;
	public Grass(int x, int y, ObjectId id, int type) {
		super(x, y, id);
		texture = Game.getInstance();
		this.type = type;
	}


	public void tick(LinkedList<GameObject> objects) {
		
	}

	public void render(Graphics g) {
		switch (type){
			case 0:	g.drawImage(texture.grass[0],x, y,50,50,null);break;
			case 1:g.drawImage(texture.grass[1], x, y,50,50,null);break;
			case 2:g.drawImage(texture.grass[2], x, y,50,50,null);break;
			case 3:g.drawImage(texture.grass[3], x, y,50,50,null);break;
			case 4:g.drawImage(texture.grass[4], x, y,50,50,null);break;
			case 5:g.drawImage(texture.grass[5], x, y,50,50,null); break;
		}
	}

	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle (x,y,0,0);
		return bounds;
	}

}
