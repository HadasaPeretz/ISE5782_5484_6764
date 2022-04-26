/**
 * 
 */
package unittests;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

/**
 * @author Dell
 * Unit tests for primitives.Point class
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 */
	@Test
	void testAdd() {
		// ============ Equivalence Partitions Tests ==============	
		// TC01: Connection between two vectors
		try 
		{
			Point point=new Point(1,1,1);
			Vector vector = new Vector(2,2,5);
			assertEquals("Function add doesnt work correct", new Point(3,3,6), point.add(vector));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("No need to throw exception");
		}
		// =============== Boundary Values Tests ==================
		try 
		{
			Point point=new Point(1,1,1);
			assertEquals("Function add doesnt work correct", point, point.add(new Vector(0,0,0)));
			fail("No need to throw exception");
		} 
		catch (Exception e) {}
		
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	void testSubtract() 
	{
		try 
		{
			Point point1=new Point(1,1,1);
			Point point2=new Point(1,3,4);
			assertEquals("Function subtract doesnt work correct", new Vector(0,-2,-3), point1.subtract(point2));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("No need to throw exception");
		}
		
		try 
		{
			Point point=new Point(1,1,1);
			assertEquals("Function subtract doesnt work correct", new Vector(1,1,1), point.subtract(new Vector(0,0,0)));
		} 
		catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	void testDistanceSquared()
	{
		Point point1=new Point(0,0,3);
		Point point2=new Point(0,4,0);
		assertEquals("Function distanceSquared doesnt work correct",25, point1.distanceSquared(point2), 0.0001);
	
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() 
	{
		Point point1=new Point(0,0,3);
		Point point2=new Point(0,4,0);
		assertEquals("Function distance doesnt work correct",5, point1.distance(point2), 0.0001);
	}

}
