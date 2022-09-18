package coms.MYPJavaPeople.TLOZ.Window;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;

public class Camera {
	private int x,y;
	public int move;
	
	public Camera (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void tick(EnemyObject enemyObject) {
		if (-enemyObject.getX() + 600 < 0 && -enemyObject.getX() + 600 > -1*(MapRenderer.w*50 - 1200)){
			int tempX = x;
			x = -enemyObject.getX() + 600;

			if (tempX>x){
				move = 2;
			}else if (tempX<x){
				move = 4;
			}
			else {
				move = 0;
			}
		}
		else {
			move = 0;
		}

		if (-enemyObject.getY() + 450 < 0 && -enemyObject.getY() + 450 > -1*(MapRenderer.w*50 - 800)){
			int tempY = y;
			y = -enemyObject.getY() + 450;
			
			if (tempY>y){
				move = 1;
			}else if (tempY<y){
				move = 3;
			}
		}
		else {
			move = 0;
		}
		
		
	}

}
