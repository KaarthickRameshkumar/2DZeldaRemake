package coms.MYPJavaPeople.TLOZ.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.Framework.Weapon;
import coms.MYPJavaPeople.TLOZ.Window.Game;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class RockShooter extends Weapon {  
    private int direction;
    Texture texture;
    private boolean attack;

    public RockShooter(int x, int y, ObjectId id) {
		super(x, y, id);
        texture = Game.getInstance();
        damage = 1;
        travel = 0;
	}

    public void tick(int x, int y) {

        if(travel>20){
            travel--;
            this.x += velX;
            this.y+=velY;
            checkCollisions();
        }
        else {
            travel--;
        }

        if (travel == 0){
            this.x = x;
            this.y = y;
        }
     
    }

    private void checkCollisions (){
		for (int i = 0;i<Handler.mapObjects.size();i++) {
			GameObject temp = Handler.mapObjects.get(i);
			if (getBounds().intersects(temp.getBounds())){
				travel = 0;
			}
        }
        
        for (int i = 0;i<Handler.objects.size();i++){
            EnemyObject temp = Handler.objects.get(i);
            if (temp.getObjectId() == ObjectId.Link && getBounds().intersects(temp.getBounds())){
                if (Link.isInvincible() == 0) {
                    temp.damaged(damage);
                }  
			}
        }
    }

    public void render(Graphics g) {
        if (travel>20){
            g.drawImage(texture.octoRockRock, x, y, null);
        }
    }

    public Rectangle getBounds() {
        if (direction == 0){
            return new Rectangle (x,y,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else if (direction == 1){
            return new Rectangle (x,y,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else if (direction == 1){
            return new Rectangle (x,y,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        else {
            return new Rectangle (x,y,texture.linkObjects[0].getWidth(),texture.linkObjects[0].getHeight());
        }
        
    }

	public void setDirection(int direction) {
        this.direction = direction;
    }

    public void attack (int velX, int velY){
        travel = 50;
        this.velX = velX;
        this.velY = velY;
    }

    public boolean isAttackting (){
        if (travel>0){
            return true;
        }
        else {
            return false;
        }
    }

    

}