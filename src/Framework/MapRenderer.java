package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.image.BufferedImage;

import coms.MYPJavaPeople.TLOZ.MapObjects.Grass;
import coms.MYPJavaPeople.TLOZ.MapObjects.Rock;
import coms.MYPJavaPeople.TLOZ.MapObjects.RockyPlatform;
import coms.MYPJavaPeople.TLOZ.MapObjects.Tree;
import coms.MYPJavaPeople.TLOZ.Objects.Bat;
import coms.MYPJavaPeople.TLOZ.Objects.OctoRock;
import coms.MYPJavaPeople.TLOZ.Objects.Ruby;
import coms.MYPJavaPeople.TLOZ.Objects.SqaureEnemy;
import coms.MYPJavaPeople.TLOZ.Window.BufferedImageLoader;
import coms.MYPJavaPeople.TLOZ.Window.Handler;

public class MapRenderer {
	private static BufferedImage image = null;
	private static BufferedImageLoader loader = new BufferedImageLoader();
	public static int w, h;
	public static int mapNum = 11;
	private static boolean added = false;

	public static void renderMap() {

		switch (mapNum) {
		case 11:
			image = loader.loadImage("/HyruleField.png");
			break;
		case 21:
			image = loader.loadImage("/HyruleField21.png");
			break;
		case 22:
			image = loader.loadImage("/HyruleField22.png");
			break;
		case 23:
			image = loader.loadImage("/HyruleField23.png");
			break;
		case 31:
			image = loader.loadImage("/HyruleField31.png");
			break;
		case 32:
			image = loader.loadImage("/HyruleField32.png");
			break;
		case 33:
			image = loader.loadImage("/HyruleField33.png");
			break;
		}
		w = image.getWidth();
		h = image.getHeight();

		for (int i = 0; i < h; i++) {
			for (int j = 2; j < w+2; j++) {

				int pixel = image.getRGB(i, j-2);

				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				//Grass
				if (red == 0 && green == 0 && blue == 0) {
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,0));
				}
				else if (red == 0 && green == 1 && blue == 0){
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,1));
				}
				else if (red == 0 && green == 2 && blue == 0){
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,2));
				}
				else if (red == 0 && green == 3 && blue == 0){
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,3));
				}
				else if (red == 0 && green == 4 && blue == 0){
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,4));
				}
				else if (red == 0 && green == 5 && blue == 0){
					Handler.addTile(new Grass(i * 50, j * 50, ObjectId.Grass,5));
				}

				//Normal Map Objects
				if (red == 78 && green == 255 && blue == 0) {
					Handler.addMapObject(new Tree(i * 50, j * 50, ObjectId.Tree));
					added = true;
				}
				else if (red == 255 && blue == 10) {
					Handler.addMapObject(new Rock(i * 50, j * 50, ObjectId.Rock));
					added = true;
				} 
				else if (red == 128 && green == 128 && blue == 128) {
					Handler.addMapObject(new RockyPlatform(i * 50, j * 50, ObjectId.RockyPlatform, 5));
					added = true;
				} 
				else if (red == 140 && green == 128 && blue == 128) {
					Handler.addMapObject(new RockyPlatform(i * 50, j * 50, ObjectId.RockyPlatform, 1));
					added = true;
				} 
				else if (red == 145 && green == 128 && blue == 128) {
					Handler.addMapObject(new RockyPlatform(i * 50, j * 50, ObjectId.RockyPlatform, 2));
					added = true;
				} 
				else if (red == 160 && green == 128 && blue == 128) {
					Handler.addMapObject(new RockyPlatform(i * 50, j * 50, ObjectId.RockyPlatform, 6));
					added = true;
				}
				else if (red == 254){
					Handler.addMapObject(new Ruby(i * 50, j * 50, ObjectId.Ruby));
					added = true;
				}

				//Enemies
				if( red == 0 && green == 0 && blue == 255 ){
					Handler.addObject(new Bat(i*50, j * 50, ObjectId.Bat));
					added = true;
				}
				else if( red == 187 && green ==124 && blue == 255){
					Handler.addObject(new SqaureEnemy(i*50, j * 50, ObjectId.SqaureEnemy));
					added = true;
				}
				else if( red == 255 && green ==0 && blue == 0){
					Handler.addObject(new OctoRock(i*50, j * 50, ObjectId.OctoRock));
					added = true;
				}

				

				if (added){
					added = false;
					Handler.addTile(new Grass (i*50,j*50,ObjectId.Grass,0));
				}

			}
		}

	}

	public static void changeMapNum(int change) {
		mapNum += change;

		GameObject temp = Handler.mapObjects.get(Handler.mapObjects.size()-1);
		
		for (int i = 0;i<Handler.objects.size();i++){
			EnemyObject t = Handler.objects.get(i);
			if (t.getObjectId() != ObjectId.Link){
				Handler.objects.remove(t);
			}
		}

		Handler.mapObjects.clear();
		Handler.tiles.clear();
		
		renderMap();
		Handler.mapObjects.add(temp);
	}
}