/**
 * 
 */
package unittests;
import geometries.Tube;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Dell
 * Unit tests for geometries.Tube class
 */
class TubeTests {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		try 
		{
			// ============ Equivalence Partitions Tests ==============
			Ray myRay=new Ray(new Point(1, 0, 0), new Vector(0, 1, 0));
			Tube myTube=new Tube(5, myRay);
			Vector normal = new Vector(1,0,0);
			assertEquals("Bad normal to tube", normal , myTube.getNormal(new Point(3,1,0)));
			
			// =============== Boundary Values Tests ==================
			double lengthNormal=Math.sqrt(21);
			normal=new Vector(4d/lengthNormal, 0, Math.sqrt(5)/lengthNormal);
			assertEquals("Bad normal to tube", normal , myTube.getNormal(new Point(5,4,Math.sqrt(5))));
		} 
		
		catch (Exception e) 
		{		
			fail("for vectors that not zero vector does not need throw an exception");
		}
		
	}

}
