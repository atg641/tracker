package quadraticEquation;

public class QuadraticEquation {
	double a;
	double b;
	double c;
	boolean hassolution;
	double solution1;
	double solution0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuadraticEquation q1 = new QuadraticEquation();
		q1.a = 5.0;
		q1.b = 20;
		q1.c = 5;
		q1.solve();
		System.out.println(q1.toString());
	}
	
	@Override
	public String toString() {
		return "QuadraticEquation [a=" + a + ", b=" + b + ", c=" + c + ", hassolution=" + hassolution + ", solution1="
				+ solution1 + ", solution0=" + solution0 + "]";
	}

	public void solve() {
		double dis;
		dis=b*b-4.0*a*c;
		hassolution=dis>=0;
		if (hassolution) {
			solution1=(-b+Math.sqrt(dis))/2*a;
			solution0=(-b-Math.sqrt(dis))/2*a;
		}
	}

}
