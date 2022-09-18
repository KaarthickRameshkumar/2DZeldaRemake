package coms.MYPJavaPeople.TLOZ.Framework;

import java.awt.Image;
import java.awt.image.BufferedImage;

import coms.MYPJavaPeople.TLOZ.Window.BufferedImageLoader;

public class Texture {
	
	SpriteSheet link;
	SpriteSheet rockyplatforms;
	SpriteSheet SqaureEnemySheet;
	SpriteSheet OctoRock;
	SpriteSheet attackss;
	SpriteSheet batSheet;
	
	public BufferedImage [] links = new BufferedImage [14];
	public BufferedImage [] linkObjects = new BufferedImage [12];
	public BufferedImage [] attacks = new BufferedImage [4];
	public BufferedImage [] grass = new BufferedImage [6];
	public BufferedImage [] sqaureEnemies = new BufferedImage[12];
	public BufferedImage [] octoRocks = new BufferedImage[24];
	public BufferedImage [] bats = new BufferedImage[2];
	public BufferedImage [] field = new BufferedImage[3];
	public BufferedImage [] rockPlatforms = new BufferedImage [8];
	public BufferedImage [] miniMenus = new BufferedImage [10];
	public BufferedImage [] rubys = new BufferedImage [1];

	private BufferedImage Ruby = null;
	public BufferedImage octoRockRock = null;
	private BufferedImage linkSheet = null;
	private BufferedImage attackSheet = null;
	private BufferedImage link_basicSword = null;
	private BufferedImage OctoRockRock = null;
	private BufferedImage SqaureEnemySheetImg= null;
	private BufferedImage OctoRockSheet= null;
	private BufferedImage BatsImg= null;
	private BufferedImage rockSheet = null;
	public BufferedImage tree;
	public BufferedImage rock;

	BufferedImageLoader loader = new BufferedImageLoader();
	public Image[] sqaureEnemy;
	
	public Texture () {	
		
		linkSheet = loader.loadImage("/Images/links.png");
		rockSheet = loader.loadImage("/RockSheet.png");
		attackSheet = loader.loadImage("/attacks.png");

		OctoRockSheet = loader.loadImage("/e_octorok.png");

		rock = loader.loadImage("/rock.png");
		tree = loader.loadImage("/t_bush.png");
		Ruby= loader.loadImage("/Ruby.png");
		octoRockRock = loader.loadImage("/RockForOctoRock.png");

		link_basicSword = loader.loadImage("/link_basic_sword.png");
		
		link = new SpriteSheet (linkSheet);
		rockyplatforms = new SpriteSheet(rockSheet);
		attackss = new SpriteSheet (attackSheet);
		SqaureEnemySheet = new SpriteSheet (SqaureEnemySheetImg);
		OctoRock = new SpriteSheet (OctoRockSheet);
		batSheet = new SpriteSheet (BatsImg);
		
		getTextures();
	}
	
	private void getTextures() {
		//Towards
		links[0] = link.getImage(1, 1, 20, 26);
		links[1] = link.getImage(2, 1, 20, 26);
		links[2] = link.getImage(3, 1, 20, 26);

		//Left
		links[3] = link.getImage(4, 1, 20, 26);
		links[4] = link.getImage(5, 1, 20, 26);
		//Up
		links[5] = link.getImage(1, 2, 20, 26);
		links[6] = link.getImage(2, 2, 20, 26);
		links[7] = link.getImage(3, 2, 20, 26);

		//Right
		links[8] = link.getImage(4, 2, 20, 26);
		links[9] = link.getImage(5, 2, 20, 26);

		links[10] = link.getImage(1, 3, 20, 26);
		links[11] = link.getImage(2, 3, 20, 26);
		links[12] = link.getImage(3, 3, 20, 26);
		links[13] = link.getImage(4, 3, 20, 26);

		//shooting down
		octoRocks[0]=OctoRock.getImage(1,1,20,20);
		octoRocks[1]=OctoRock.getImage(2,1,20,20);
		octoRocks[2]=OctoRock.getImage(3,1,20,20);
		octoRocks[3]=OctoRock.getImage(4,1,20,20);
		//walking down
		octoRocks[4]=OctoRock.getImage(1,2,20,20);
		octoRocks[5]=OctoRock.getImage(2,2,20,20);
		//shooting right 
		octoRocks[6]=OctoRock.getImage(1,3,20,20);
		octoRocks[7]=OctoRock.getImage(2,3,20,20);
		octoRocks[8]=OctoRock.getImage(3,3,20,20);
		octoRocks[9]=OctoRock.getImage(4,3,20,20);
		//walking right
		octoRocks[10]=OctoRock.getImage(1,4,20,20);
		octoRocks[11]=OctoRock.getImage(2,4,20,20);
		//shooting up
		octoRocks[12]=OctoRock.getImage(1,5,20,20);
		octoRocks[13]=OctoRock.getImage(2,5,20,20);
		octoRocks[14]=OctoRock.getImage(3,5,20,20);
		octoRocks[15]=OctoRock.getImage(4,5,20,20);
		//walking up 
		octoRocks [16]=OctoRock.getImage(1,6,20,20);
		octoRocks[17]=OctoRock.getImage(2,6,20,20);
		//shooting left
		octoRocks[18]=OctoRock.getImage(1,7,20,20);
		octoRocks[19]=OctoRock.getImage(2,7,20,20);
		octoRocks[20]=OctoRock.getImage(3,7,20,20);
		octoRocks[21]=OctoRock.getImage(4,7,20,20);
		//walking left
		octoRocks[22]=OctoRock.getImage(1,8,20,20);
		octoRocks[23]=OctoRock.getImage(2,8,20,20);

		field[0] = rock;
		field[1] = tree;

		rockPlatforms[0] = rockyplatforms.getImage(1, 1, 50, 50);
		rockPlatforms[1] = rockyplatforms.getImage(2, 1, 50, 50);
		rockPlatforms[2] = rockyplatforms.getImage(3, 1, 50, 50);
		rockPlatforms[3] = rockyplatforms.getImage(4, 1, 50, 50);
		
		rockPlatforms[4] = rockyplatforms.getImage(1, 2, 50, 50);
		rockPlatforms[5] = rockyplatforms.getImage(2, 2, 50, 50);

		grass[0] = loader.loadImage("/t_grass0.png");
		grass[1] = loader.loadImage("/t_grass1.png");
		grass[2] = loader.loadImage("/t_grass2.png");
		grass[3] = loader.loadImage("/t_grass3.png");
		grass[4] = loader.loadImage("/t_grass4.png");
		grass[5] = loader.loadImage("/t_grass5.png");

		linkObjects[0] = link_basicSword;
		rubys[0]= Ruby;

		miniMenus [0] = loader.loadImage("/Heart.png");

		bats[0] = loader.loadImage("/e_bat1.png");
		bats[1] = loader.loadImage("/e_bat2.png");

		


	}
}
