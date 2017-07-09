package DivideAndConquer;

public class point {
	int x;// 模拟横坐标
	int y;// 模拟纵坐标

	public point() {
		this.x = 0;
		this.y = 0;
	}

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 求两个点之间的距离
	public static double getDistance(point p1, point p2) {
		double a = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		return a;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void SetY(int y) {
		this.y = y;
	}
}