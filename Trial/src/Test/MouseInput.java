package Test;

import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener {
	private Handler handler;
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	public void mouseDragged(MouseEvent e) {
	/*	for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.awsome) {
				tempObject.setX(e.getX());
				tempObject.setY(e.getY());
			}
		} 	*/
	}

	public void mouseMoved(MouseEvent e) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.awsome) {
				tempObject.setX(e.getX());
				tempObject.setY(e.getY());
			}}  
		
	}

}
