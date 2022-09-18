package coms.MYPJavaPeople.TLOZ.MapObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Game;

public class Tree extends GameObject{

	Texture texture;
	public Tree(int x, int y, ObjectId id) {
		super(x, y, id);
		texture = Game.getInstance();
	}


	public void tick(LinkedList<GameObject> objects) {
		
	}

	public void render(Graphics g) {
		g.drawImage(texture.field[1], x, y, 50,50,null);
		
	}

	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle (x,y,texture.field[1].getWidth(null),texture.field[1].getHeight(null));
		return bounds;
	}


}
