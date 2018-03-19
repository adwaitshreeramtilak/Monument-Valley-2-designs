package Test;
import java.awt.Graphics;
public abstract class GameObject {
	protected int x,y,P,N;
	protected ID id;
	public GameObject(int x, int y, ID id,int P, int N) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.P = P;
		this.N = N;}
	public abstract void tick();
	public abstract void render(Graphics g);
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setP(int P) {this.P = P;}
	public void setN(int N) {this.N = N;}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getP() {return P;}
	public int getN() {return N;}
	public void setId(ID id) {this.id = id;}
	public ID getId() {return id;}}
