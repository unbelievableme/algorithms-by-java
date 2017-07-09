package DivideAndConquer;

public class point {
	int x;// ģ�������
	int y;// ģ��������

	public point() {
		this.x = 0;
		this.y = 0;
	}

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ��������֮��ľ���
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