package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Game;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class Ruby extends GameObject {

    private static boolean show;
    Texture texture;

	public Ruby(int x, int y, ObjectId id) {
		super(x, y, id);
        texture = Game.getInstance(); 
        show = false;
	}


	public void tick(LinkedList<GameObject> objects) {
		if ((Handler.objects.size()-1)==0 && MapRenderer.mapNum == 22){
            show = true;
            checkCollisions();
        }
	}

	public void render(Graphics g) {
        if (show){
            g.drawImage(texture.rubys[0],x, y,50,50,null); 
        }
    }
    public void checkCollisions() {
        
    }

	public Rectangle getBounds() {
        if (show){
            return new Rectangle (x,y,100,100);
        }
        else {
            return new Rectangle (0,0,100,100);
        }
		
	}

}