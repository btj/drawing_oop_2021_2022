package drawing_oop;

abstract class Shape extends Object {}

class Circle extends Shape {
	
	int x;
	int y;
	int radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
}

class Polygon extends Shape {
	
	int[] coordinates;
	
	int getNbVertices() { return coordinates.length / 2; }
	int getX(int vertex) { return coordinates[vertex * 2]; }
	int getY(int vertex) { return coordinates[vertex * 2 + 1]; }
	
	public Polygon(int[] coordinates) {
		this.coordinates = coordinates.clone();
	}
}

public class Drawing {

	Shape[] shapes;
	
	public Drawing(Shape[] shapes) {
		this.shapes = shapes.clone();
	}
	
	public double getTotalCircumference() {
		double result = 0;
		for (Object myShape : shapes) {
			if (myShape instanceof Circle myCircle) {
				// Java's static type checker complains
				result += myCircle.radius * 2 * Math.PI;
			} else {
				Polygon myPolygon = (Polygon)myShape;
				for (int i = 0; i < myPolygon.getNbVertices(); i++) {
					int j = (i + 1) % myPolygon.getNbVertices();
					result += Math.sqrt(
							Math.pow(myPolygon.getX(i) - myPolygon.getX(j), 2) +
							Math.pow(myPolygon.getY(i) - myPolygon.getY(j), 2));
				}
			}
		}
		return result;
	}
	
}
