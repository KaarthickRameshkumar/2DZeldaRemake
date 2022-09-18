package coms.MYPJavaPeople.TLOZ.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import coms.MYPJavaPeople.TLOZ.Framework.KeyAdapt;
import coms.MYPJavaPeople.TLOZ.Framework.MapRenderer;
import coms.MYPJavaPeople.TLOZ.Framework.ObjectId;
import coms.MYPJavaPeople.TLOZ.Framework.Texture;
import coms.MYPJavaPeople.TLOZ.MapObjects.MiniMenu;
import coms.MYPJavaPeople.TLOZ.Objects.Link;


public class Game extends Canvas implements Runnable{
	//KAARTHICK AND SHANGHEETHAN
	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	
	Thread thread;
	
	Handler handler;
	public static Camera camera;
	BufferedImageLoader loader;
	static Texture texture;
	
	BufferedImage level;
	
	private void initialize (){
		texture = new Texture();
		camera = new Camera (0,0);
		loader = new BufferedImageLoader();
		
		MapRenderer.renderMap();
		MiniMenu m = new MiniMenu(0, 0, ObjectId.MiniMenu);
		Link link = new Link (600,450,ObjectId.Link);

		Handler.addObject(link);
		Handler.addMapObject(m);

		this.addKeyListener(new KeyAdapt (handler));
		
	}
	
	
	public synchronized void start () {
		if (running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run () {
		initialize();
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick () {
		Handler.tick();

		for (int i = 0;i<Handler.objects.size();i++) {
			if (Handler.objects.get(i).getObjectId()==ObjectId.Link) {
				camera.tick(Handler.objects.get(i));
			}
		}
	}
	
	private void render () {
		BufferStrategy strategy = this.getBufferStrategy();
		if (strategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = strategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1300,1000);

		g2d.translate(camera.getX(), camera.getY());
		
		Handler.renderMap(g);
		Handler.render(g);
		
		g2d.translate(camera.getX(), camera.getY());
		
		g.dispose();
		strategy.show();
		
	}
	
	public static Texture getInstance () {
		return texture;
	}
	
	public static void main (String[] agrs) {
		System.out.println("hi");
		new Window (1200, 900, "The Legend of Zelda: Name Subject To Change", new Game());
	}
}
