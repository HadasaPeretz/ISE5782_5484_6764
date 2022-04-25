/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;

/** 
 * @author Dell
 * Unit tests for geometries.Plane class
 */
class PlaneTests {

	@Test
	public void testPlaneConstructor()
	{
		try
		{
			Point p1=new Point(1,2,3);
			Point p2=new Point(1,2,3);
			Point p3=new Point(1,7,5);
			Plane myPlane =new Plane(p1, p2 , p3);
			//assertThrows("failure text", IllegalArgumentException.class, () -> function call);
			fail ("The points coalesce and the constructor should send an exception");
		}
		catch(Exception ex) {}
		
		try
		{
			Point p1=new Point(1,2,3);
			Point p2=new Point(2,4,6);
			Point p3=new Point (1,2,3);
			Plane myPlane =new Plane(p1, p2 , p3);
			//assertThrows("failure text", IllegalArgumentException.class, () -> function call);
			
			fail ("The dots are on the same line");
		}
		catch(Exception ex) {}
		
	}	

	/**
	 * Test method for {@link geometries.Plane#getPoint()}.
	 */
	@Test
	void testGetPoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link geometries.Plane#getVector()}.
	 */
	@Test
	void testGetVector() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal()}.
	 */
	@Test
	void testGetNormal() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormalPoint() {
		fail("Not yet implemented");
	}

}
