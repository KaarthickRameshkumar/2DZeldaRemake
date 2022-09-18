package coms.MYPJavaPeople.TLOZ.MapObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Objects.Link;
import coms.MYPJavaPeople.TLOZ.Window.Game;

public class MiniMenu extends GameObject {
    Texture texture;

    public MiniMenu(int x, int y, ObjectId id) {
        super(x, y, id);
        texture = Game.getInstance();
    }

    public void tick(LinkedList<GameObject> objects) {
        x = -Game.camera.getX();
        y = -Game.camera.getY();
    }

    public void render(Graphics g) {
        int moveX = 0;
        int moveY = 0;
        switch (Game.camera.move){
            case 1: moveY = 6; break;
            case 2: moveX = 6; break;
            case 3: moveY = -6; break;
            case 4: moveX = -6; break;
        }
        g.fillRect(x+moveX, y+moveY, 1200, 100);
        g.setColor(Color.BLACK);

        int health = Link.health;
        int row = 0;
        int counter = 0;

        do {
            g.drawImage(texture.miniMenus[0],x+counter*50 + moveX,y+row*50 + moveY,null);
            counter++;
            health--;
            if (counter == 10){
                row = 1;
                counter = 0;
            }
        } while (health!=0);

    }

    public Rectangle getBounds() {
        return new Rectangle (0,0,2,2);
    }

}