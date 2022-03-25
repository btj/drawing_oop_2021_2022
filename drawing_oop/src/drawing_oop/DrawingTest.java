package drawing_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrawingTest {
	
	public void printObject(Object object) {
		System.out.println(object);
	}

	@Test
	void test() {
		Drawing myDrawing = new Drawing(new Shape[] {
				new Circle(0, 0, 5),
				new Polygon(new int[] {1, 2, 3, 4, 5, 6}),
				new Circle(5, 5, 10)
		});
		
		assertEquals(105.56148810667855, myDrawing.getTotalCircumference());
		
		printObject(myDrawing);
		printObject(10);
		
		int x = 10;
		Object myObject = x;
		//Object myObject = Integer.valueOf(x); // Autoboxing
		int y = (int)myObject;
		//int y = ((Integer)myObject).intValue() // Auto-unboxing
	}

}
