package coms.MYPJavaPeople.TLOZ.Window;

import java.awt.Graphics;
import java.util.LinkedList;

import coms.MYPJavaPeople.TLOZ.Framework.EnemyObject;
import coms.MYPJavaPeople.TLOZ.Framework.GameObject;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;

public class Handler {
	
	public static LinkedList <EnemyObject> objects = new LinkedList<EnemyObject>();
	public static LinkedList <GameObject> mapObjects = new LinkedList<GameObject>();
	public static LinkedList <GameObject> tiles = new LinkedList<GameObject>();
	private static EnemyObject tempE;
	private static GameObject temp;
	public static int linkX,linkY;
	public static int index;

	public Handler (){
		linkX = 0;
		linkY = 0;
	}
	
	public static void tick () {
		temp = mapObjects.get(mapObjects.size()-1);
		temp.tick(mapObjects);

		for (int i = 0;i<objects.size();i++) {
			tempE = objects.get(i);
			index = i;
			
			tempE.tick(objects);

			if (tempE.getObjectId() == ObjectId.Link){
				linkX = tempE.getX();
				linkY = tempE.getY();
			}
		}

		for (int i = 0;i<mapObjects.size();i++){
			GameObject temp = mapObjects.get(i);
			if(temp.getObjectId() == ObjectId.Ruby){
				temp.tick(mapObjects);
			}
		}

	
	}

	public static void renderMap (Graphics g){
		for (int i = 0;i<tiles.size();i++){
			temp = tiles.get(i);
			temp.render(g);
		}

		for (int i = 0;i<mapObjects.size();i++) {
			temp = mapObjects.get(i);				
			temp.render(g);
		}
	}
	
	public static void render (Graphics g) {
		for (int i = 0;i<objects.size();i++) {
			tempE = objects.get(i);
			tempE.render(g);
		}
	}
	
	
	public static void addObject (EnemyObject object) {
		objects.add(object);
	}
	
	public static void removeObject (EnemyObject object) {
		objects.remove (object);
	}

	public static void removeObject (int index) {
		objects.remove (index);
	}

	public static void addMapObject (GameObject object) {
		mapObjects.add(object);
	}
	
	public static void removeMapObject (GameObject object) {
		mapObjects.remove (object);
	}

	public static void addTile (GameObject object) {
		tiles.add(object);
	}
	
	public static void removeTile (GameObject object) {
		tiles.remove (object);
	}

}
