/**
 * 
 */
package unittests;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import primitives.Vector;

/**
 * @author Dell
 *Unit tests for geometries.Vector class
 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	void testAddVector() 
	{
        // ============ Equivalence Partitions Tests ==============
       
		Vector v1= new Vector(1,1,1);
		Vector v2= new Vector(-1,-1,1);
		Vector v3= new Vector(-1,-1,-1);
		assertEquals("Add() wrong result length", new Vector(0,0,2), v1.add(v2));	//check if the add works well (not the zero vector)
		
		
		  // =============== Boundary Values Tests ==================
      // 
      try {
          v1.add(v3);//zero vector
          fail("Add() should throw an exception, but it failed");
      } catch (Exception e) {}
	
	}

	/**
	 * Test method for {@link primitives.Vector#scale(java.lang.Double)}.
	 */
	@Test
	void testScale() {
		Vector v1 = new Vector(1, 1, 1);
		Vector v2 = new Vector(3.0, 3.0, 3.0);
		// ============ Equivalence Partitions Tests ==============
	    assertEquals(v2, v1.scale(3.0));//regular case
	    // =============== Boundary Values Tests ==================
        // 
        try {
            v1.scale(0.0);//multiple by 0- cannot get the zero vector
            fail("Scale() should throw an exception, but it failed");
        } catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	void testCrossProduct()
	{
		    Vector v1 = new Vector(1,-4,7);
	        Vector v2 = new Vector(-1, 2, 3);

	        // ============ Equivalence Partitions Tests ==============
	        Vector v3 = new Vector(0,4,-2);
	        Vector vcp = v1.crossProduct(v3); //vcp=(-20,-2,4)
	        // Test cross-product result orthogonality to its operands
	        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vcp.dotProduct(v1)));//in cross product, the third vector must be a normal to the plane of the others
	        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vcp.dotProduct(v3)));//in cross product, the third vector must be a normal to the plane of the others

	        // =============== Boundary Values Tests ==================
	        // test zero vector from cross-productof co-lined vectors
	        try {
	            v1.crossProduct(v2);//if the vector are on the same direction, the cross product must be 0
	            fail("crossProduct() for parallel vectors does not throw an exception");
	        } catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link primitives.Vector#normelaize()}.
	 */
	@Test
	void testNormelaize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct() {
		fail("Not yet implemented");
	}

}
