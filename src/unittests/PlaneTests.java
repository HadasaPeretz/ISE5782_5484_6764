/**
 * 
 */
package unittests;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
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
			Point p1=new Point(2,7,5);
			Point p2=new Point(2,7,5);
			Point p3=new Point(1,3,4);
			Plane myPlane =new Plane(p1, p2 , p3);
			
			fail ("The points coalesce and the constructor should send an exception");
		}
		catch(Exception ex) {}
		
		try
		{
			Point p1=new Point(2,7,5);
			Point p2=new Point(2,4,6);
			Point p3=new Point (2,7,5);
			Plane myPlane =new Plane(p1, p2 , p3);
			
			fail ("The dots are on the same line");
		}
		catch(Exception ex) {}
		
	}	


	

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormalPoint() {
		try
		{
			/***
			 * EP
			 */
			Point p1=new Point(1,1,1);
			Point p2=new Point(2,4,5);
			Point p3=new Point(3,3,3);
			Plane myPlane =new Plane(p1, p2 , p3);
			Vector temp=new Vector(2,-6,4);
			double normalLength=temp.length();
			Vector normal=new Vector(2/normalLength, -6/normalLength, 4/normalLength);
			assertEquals("Bad normal to plane", normal, myPlane.getNormal());
		
		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
