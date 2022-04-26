/**
 * 
 */
package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import primitives.Point;
import geometries.Traingle;
import primitives.Vector;

import org.junit.jupiter.api.Test;

/**
 * @author Dell
 *Unit tests for geometries.Traingle class
 */
class TraingleTests {

	/**
	 * Test method for {@link geometries.Traingle#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
		try
		{
			Traingle myTriangle = new Traingle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
			double sqrt3 = Math.sqrt(1d / 3);
			Vector normal=new Vector(sqrt3, sqrt3, sqrt3);
		    assertEquals("Bad normal to trinagle", normal , myTriangle.getNormal(new Point(0, 0, 1)));
	
		}
		catch(Exception ex) 
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
