package Test;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyInput extends KeyAdapter{
	private Handler handler;
	public KeyInput(Handler handler) {this.handler = handler;}
	public void keyPressed(KeyEvent e) 
	{	int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.awsome) {
				if(key == KeyEvent.VK_UP) {
					int N = tempObject.getN()+1;
					int P = tempObject.getP();
					handler.removeObject(tempObject);
					handler.addObject(new awsome(678, 360, ID.awsome, P, N));}
				if(key == KeyEvent.VK_DOWN) {
					int N = tempObject.getN()-1;
					int P = tempObject.getP();
					handler.removeObject(tempObject);
					handler.addObject(new awsome(678, 360, ID.awsome, P, N));}
				if(key == KeyEvent.VK_LEFT) {
					int N = tempObject.getN();
					int P = tempObject.getP()-1;
					handler.removeObject(tempObject);
					handler.addObject(new awsome(678, 360, ID.awsome, P, N));}
				if(key == KeyEvent.VK_RIGHT) {
					int N = tempObject.getN();
					int P = tempObject.getP()+1;
					handler.removeObject(tempObject);
					handler.addObject(new awsome(678, 360, ID.awsome, P, N));}}}}
	public void keyReleased(KeyEvent e) {}}
