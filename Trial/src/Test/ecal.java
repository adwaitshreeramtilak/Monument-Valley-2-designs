package Test;
public class ecal {
	public int xcorwrto(int x) {x = x - 678;return x;}
	public int ycorwrto(int y) {y = 360 - y;return y;}
	public int orx(int x) {x = x + 678;return x;}
	public int ory(int y) {y = 360 - y;return y;}
	public int krotx(int x, int y, double theta) 
	{	x = x - 678;
		y = 360 - y;
		double unrans = (x*(Math.cos(theta)))-(y*(Math.sin(theta)));
		int ans = (int) Math.round(unrans);
		ans = ans + 678;
		return ans;}
	public int kroty(int x, int y, double theta) 
	{	x = x - 678;
		y = 360 - y;
		double unrans = (y*(Math.cos(theta)))+(x*(Math.sin(theta)));
		int ans = (int) Math.round(unrans);
		ans = 360 - ans;
		return ans;}}
