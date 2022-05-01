/**
 * 
 */
package unittests;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;
import primitives.Ray;

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

	
	public void testfindIntersections() 
	{
		try
		{
			Plane myPlane = new Plane(new Point(0,5,0), new Point(-5,0,0), new Point(0,0,3));
			// =============== Boundary Values Tests ==================
			
			//Ray is parallel to the plane
			// TC01: the ray included in the plane
			Ray myRay= new Ray(new Point(0,5,0), new Vector(-5,0,0));//the plane include this ray
			assertNull("A included ray has zero intersection points", myPlane.findIntsersections(myRay));
			// TC02: the ray not included in the plane
			myRay= new Ray(new Point(0,-5,0), new Vector(5,0,0));//the plane un included this ray
			assertNull("An un included ray has zero intersection points", myPlane.findIntsersections(myRay));
			
			//Ray is orthogonal to the plane
			// TC03:נ�‘ƒ0 before the plane
			myRay= new Ray(new Point(2,4,0), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertEquals("Ray is orthogonal to the plane and starts before the plane",1, myPlane.findIntsersections(myRay).size());
			// TC04:נ�‘ƒ0 at the plane
			myRay= new Ray(new Point(-5,0,0), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertNull("Ray is orthogonal to the plane and starts at the plane", myPlane.findIntsersections(myRay));
			// TC05:נ�‘ƒ0 after the plane
			myRay= new Ray(new Point(-7,2,4), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertNull("Ray is orthogonal to the plane and starts after the plane",myPlane.findIntsersections(myRay));
			
			//Ray is neither orthogonal nor parallel to and begins at the plane
			// TC06:
			myRay= new Ray(new Point(-1,-1,0), new Vector(1,0,0));//the ray isnt orthogonal or parallel to the plane
			assertNull("Ray is neither orthogonal nor parallel to and begins at reference point in the plane", myPlane.findIntsersections(myRay));
			
			//Ray is neither orthogonal nor parallel to the plane and begins in
			//the same point which appears as reference point in the plane
			// TC07:
			myRay= new Ray(new Point(0,0,3), new Vector(-5,4,-3));//the ray isnt orthogonal or parallel to the plane but not intersects the plane
			assertNull("Ray is neither orthogonal nor parallel to and begins at the plane", myPlane.findIntsersections(myRay));
			
			// ============ Equivalence Partitions Tests ================
			// TC08: The Ray must be neither orthogonal nor parallel to the plane
			//Ray does not intersect the plane
			myRay= new Ray(new Point(1,2,0), new Vector(-3,-7,0));
			assertNull("Ray is neither orthogonal nor parallel but doesnt intersects the plane", myPlane.findIntsersections(myRay));
			
			// TC09:
			// Ray intersects the plane
			myRay= new Ray(new Point(4,3,0), new Vector(-5.75,3.57,0));//the ray isnt orthogonal or parallel to the plane and intersects the plane
			assertEquals("Ray is neither orthogonal nor parallel and intersects the plane ",1, myPlane.findIntsersections(myRay).size());
		}
		catch(Exception ex)
		{
			
		}
	}
}
