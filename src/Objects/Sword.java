package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Framework.Weapon;
import coms.MYPJavaPeople.TLOZ.Window.Game;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class Sword extends Weapon {  
    private int direction;
    Texture texture;

    public Sword(int x, int y, ObjectId id) {
        super(x, y, id);
        texture = Game.getInstance();
        
        damage = 3;
        travel = 0;
    }

    public void tick(int x, int y) {
        this.x = x;
        this.y = y;

        checkCollisions();
    }

    private void checkCollisions (){
		for (int i = 0;i<Handler.mapObjects.size();i++) {
			GameObject temp = Handler.mapObjects.get(i);
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
            if (temp.getObjectId() != ObjectId.Link && getBounds().intersects(temp.getBounds()) && Link.isAttacking()){
                temp.damaged(damage);
			}
        }
    }

    public void render(Graphics g) {
        if (Link.isAttacking()){
            direction = Link.getDirection();
            Graphics2D g2d = (Graphics2D) g;
            AffineTransform at = null;
            

            switch (direction){
                case 0:
                    at= AffineTransform.getTranslateInstance(x+30, y+50);
                    at.rotate(Math.toRadians(0));
                    break;
                case 1:
                    at= AffineTransform.getTranslateInstance(x+10, y+35);
                    at.rotate(Math.toRadians(90));
                    break;
                case 2:
                    at= AffineTransform.getTranslateInstance(x+20, y+25);
                    at.rotate(Math.toRadians(180));
                    break;
                case 3:
                    at= AffineTransform.getTranslateInstance(x+45, y+60);
                    at.rotate(Math.toRadians(270));
                    break;
            }

            g2d.drawImage(texture.linkObjects[0], at,null);
        }
    }

    public Rectangle getBounds() {
        if (direction == 0){
            return new Rectangle (x+30, y+50,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else if (direction == 1){
            return new Rectangle (x-8, y+24,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else if (direction == 2){
            return new Rectangle (x+2, y+14,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else {
            return new Rectangle (x+65, y+49,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        
        
    }

	public void setDirection(int direction) {
        this.direction = direction;
    }
    

}