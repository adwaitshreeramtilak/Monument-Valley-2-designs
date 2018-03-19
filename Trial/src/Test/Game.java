package Test;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 5953559785486325743L;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	public Game() 
	{	handler = new Handler(); 
		this.addMouseMotionListener(new MouseInput(handler));
		this.addKeyListener(new KeyInput(handler));
		new Window(1356, 720, "Let's Build a Game!", this);
		handler.addObject(new awsome(678, 360, ID.awsome, 5, 25));}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start(); 
		running = true;}
	public synchronized void stop() 
	{	try {thread.join();running = false;}
		catch(Exception e) {e.printStackTrace();}}
	public void run() 
	{	long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();
        while(running){ 
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                ticks++;
                delta--;}
            if(running)render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TPS: " + ticks);
                frames = 0;
                ticks = 0;}}
        stop();}
	private void tick() {
		handler.tick();}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(2);
			return;}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D)g;
	//	g.setColor(Color.WHITE);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1356, 720);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		handler.render(g);
		g.dispose();
		bs.show();}
	public static void main(String args[]){new Game();}}
	