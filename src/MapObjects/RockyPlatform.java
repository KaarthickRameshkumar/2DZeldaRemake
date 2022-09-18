package coms.MYPJavaPeople.TLOZ.MapObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Window.Game;

public class RockyPlatform extends GameObject {

    private int orientation;
    Texture texture;

    public RockyPlatform(int x, int y, ObjectId id, int orientation) {
        super(x, y, id);
        this.orientation = orientation;
        texture = Game.getInstance();
    }


    public void tick(LinkedList<GameObject> objects) {

    }

    public void render(Graphics g) {
        switch (orientation){
            case 1:g.drawImage(texture.rockPlatforms[0], x, y, null);break;
            case 2:g.drawImage(texture.rockPlatforms[3], x, y, null);break;
            case 3:
            case 4:
            case 5:g.drawImage(texture.rockPlatforms[4], x, y, null);break;
            case 6:g.drawImage(texture.rockPlatforms[5], x, y, null);break;
        }
    }

    public Rectangle getBounds() {
        if (orientation != 5){
            Rectangle bounds = new Rectangle (x,y,texture.rockPlatforms[0].getWidth(null),texture.rockPlatforms[0].getHeight(null));
            return bounds;
        }
        else {
            Rectangle bounds = new Rectangle (x,y,0,0);
            return bounds;
        }
    }

    
}