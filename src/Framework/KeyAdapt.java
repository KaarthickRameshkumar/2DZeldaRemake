package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import coms.MYPJavaPeople.TLOZ.Objects.Link;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class KeyAdapt extends KeyAdapter{
	Handler handler;
	
	public KeyAdapt (Handler handler) {
		this.handler = handler;
	}

	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		EnemyObject temp;

		for (int i = 0;i<Handler.objects.size();i++){
			temp = Handler.objects.get(i);
			if (temp.getObjectId() == ObjectId.Link || temp.getObjectId() == ObjectId.Sword) {
				if (key == KeyEvent.VK_W||key ==KeyEvent.VK_UP) {
					temp.setVelX(0);
					temp.setVelY (-6);
					Link.setDirection(2);
		        } 
		        else if (key == KeyEvent.VK_D||key ==KeyEvent.VK_RIGHT) {
					temp.setVelY(0);
		        	temp.setVelX (6);
					Link.setDirection(3);
		        } 
		        else if (key == KeyEvent.VK_S||key ==KeyEvent.VK_DOWN) {
					temp.setVelX(0);
		        	temp.setVelY (6);
					Link.setDirection(0);
		        } 
		        else if (key == KeyEvent.VK_A||key ==KeyEvent.VK_LEFT) {
					temp.setVelY(0);
		        	temp.setVelX (-6);
					Link.setDirection(1);
				}
				else if (key == KeyEvent.VK_H){
					Link.attack();
				}
			}
		}
	}
	
	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
		EnemyObject temp;
		
		for (int i = 0;i<Handler.objects.size();i++){
			temp = Handler.objects.get(i);
			if (temp.getObjectId() == ObjectId.Link || temp.getObjectId() == ObjectId.Sword) {
				if (key == KeyEvent.VK_W||key ==KeyEvent.VK_UP) {
					temp.setVelY (0);
		        } 
		        else if (key == KeyEvent.VK_D||key ==KeyEvent.VK_RIGHT) {
		        	temp.setVelX (0);
		        } 
		        else if (key == KeyEvent.VK_S||key ==KeyEvent.VK_DOWN) {
		        	temp.setVelY (0);
		        } 
		        else if (key == KeyEvent.VK_A||key ==KeyEvent.VK_LEFT) {
					temp.setVelX (0);
				}
				else if (key == KeyEvent.VK_H) {
					
		        }
			}
		}
	}
}
