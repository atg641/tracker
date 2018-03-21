package shape;

public class Palate  {
	Shape[] shapes;
	
	void render() {
		for(Shape s : shapes) {
			//s.render();
		}
	}
	
	
	public static void main(String[] args) {
		Palate p = new Palate();
		p.shapes = new Shape[2];
		
		
		Circle c  = new Circle();
		c.xPosition = 10;
		c.yPosition = 20;
		c.radius = 5;
		Rectangle r = new Rectangle();
		r.xPosition = 100;
		r.yPosition = 200;
		r.length = 10;
		r.width  = 30;
		
		
		
	}
}
