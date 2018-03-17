package Test;
import java.awt.Color;
import java.awt.Graphics;
public class awsome extends GameObject{
	public int n = 20;	//number of length points Or the length of the trail
	public int p = 5; // number of points
	public double deg = 72;
	public double PI = 3.14159265358979323846;
	public double theta = deg*(PI/180);
	public int cx[][] = new int[n][p]; 
	public int cy[][] = new int[n][p];
	private ecal a = new ecal();
	public int c = 0;
	public awsome(int x, int y, ID id) {
		super(x, y, id);
		}
	public void tick() {
	/*	if(c=0) {
			for(int j = 0; j < p; j++) {
				for(int i = 0; i < n; i++) {
					cx[i][j] = 0;
					cy[i][j] = 0;
				}
			}
		}
	*/	
		
		
		if(cx[n-1][0] != x && cy[n-1][0] != y) {	
			for(int i = 0; i < (n-1); i++) {
				cx[i][0] = cx[i+1][0];
				cy[i][0] = cy[i+1][0];
				}
			cx[n-1][0] = x;
			cy[n-1][0] = y;
			for(int j = 0; j < (p-1); j++) {
				for(int i = 0; i < (n-1); i++) {
					cx[i][j+1] = a.krotx(cx[i][j], cy[i][j], theta) ;
					cy[i][j+1] = a.kroty(cx[i][j], cy[i][j], theta) ;
				}
				cx[n-1][j+1] = a.krotx(x, y, (j+1)*(theta));
				cy[n-1][j+1] = a.kroty(x, y, (j+1)*(theta));
				
			}
		
			
		}
		else {
			
		}
/*		if(cx[n-1][0] != x && cy[n-1][0] != y) {
			for(int j = 0; j < (n-1); j++) {
				for(int i = 0; i < (n-1); i++) {
				cx[i][j+1] = a.krotx(cx[i][j], cy[i][j], theta) ;
				cy[i][j+1] = a.kroty(cx[i][j], cy[i][j], theta) ;
				}
			}
		}
		else {
			
		}
	*/	
		
		
		
		
	}										
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
	for(int j = 0; j < p; j++) {
		for(int i = 0; i < (n-1); i++) {
			
			
		g.drawLine(cx[i][j], cy[i][j],cx[1+i][j], cy[1+i][j]);
		}
	/*	for(int i = 0; i < n; i++) {
			
			g.fillOval(cx[(n-1)-i], cy[(n-1)-i], 3, 3);}
	*/
		
		
	} }
}
