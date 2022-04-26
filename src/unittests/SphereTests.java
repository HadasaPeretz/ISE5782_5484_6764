/**
 * 
 */
package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Point;
import primitives.Vector;

/**
 * @author Dell
 *Unit tests for geometries.Sphere class
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal()
	{	// ============ Equivalence Partitions Tests ==============
		Point p= new Point(2, 1, 5);
		Point p1=new Point(1,1,1);
		Sphere s = new Sphere(p1,5);
		Vector v= p1.subtract(p).normelaize();

		assertEquals("Bad normal to sphere",v,s.getNormal(p));//regular case
		// =============== Boundary Values Tests ==================
		// 
		try {
			new Sphere(p1,0).getNormal(p);//a case where the radius is 0, the ctor of sphere will throw an exception
			fail("GetNormal() should throw an exception, but it failed");
		} catch (Exception e) {}
	}

}
