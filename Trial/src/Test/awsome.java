package Test;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class awsome extends GameObject{
	public double deg = 360/P;
	public double PI = 3.14159265358979323846;
	public double theta = deg*(PI/180);
	public int cx[][] = new int[N][P]; 
	public int cy[][] = new int[N][P];
	public int nx[][] = new int[N][P]; 
	private ecal a = new ecal();
	public int c = 0;
	float k = 0;
	public awsome(int x, int y, ID id, int P, int N) {super(x, y, id, P, N);}
	public void tick() {
//		k = (float) ((Math.sin( (System.currentTimeMillis()%10) ))*(0.5)+0.5);
//		System.out.println(System.currentTimeMillis());
//		System.out.println(10/(System.currentTimeMillis()%10+1));
		System.out.println(k);
		k = ((k + 0.001f)%1);
		if(cx[N-1][0] != x && cy[N-1][0] != y) {	
			for(int i = 0; i < (N-1); i++) {
				cx[i][0] = cx[i+1][0];
				cy[i][0] = cy[i+1][0];
				nx[i][0] = a.orx((-1)*(a.xcorwrto(cx[i+1][0])));}
			cx[N-1][0] = x;
			cy[N-1][0] = y;
			nx[N-1][0] = a.orx((-1)*(a.xcorwrto(x)));
			for(int j = 0; j < (P-1); j++) {
				for(int i = 0; i < (N-1); i++) {
					cx[i][j+1] = a.krotx(cx[i][j], cy[i][j], theta) ;
					cy[i][j+1] = a.kroty(cx[i][j], cy[i][j], theta) ;
					nx[i][j+1] = a.orx((-1)*(a.xcorwrto(cx[i][j+1])));}
				cx[N-1][j+1] = a.krotx(x, y, (j+1)*(theta));
				cy[N-1][j+1] = a.kroty(x, y, (j+1)*(theta));
				nx[N-1][j+1] = a.orx((-1)*(a.xcorwrto(cx[N-1][j+1])));}}
		else {}}										
	public void render(Graphics g) {
	//	g.setColor(Color.black);
		for(int j = 0; j < P; j++) {
			for(int i = 0; i < (N-1); i++) {
				g.setColor(Color.getHSBColor(k, 1f, 1f));
				g.drawLine(nx[i][j], cy[i][j],nx[1+i][j], cy[1+i][j]);
				g.drawLine(cx[i][j], cy[i][j],cx[1+i][j], cy[1+i][j]);
				}
			}
	//	g.setColor(Color.black);
		g.setColor(Color.white);
		String s1 = "Length: ";
		String s2 = " Number Of Points: ";
		String s3 = Integer.toString(N);
		String s4 = Integer.toString(P);
		String string = s1+s3+s2+s4;
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(string, 500, 40);
		}
	}
