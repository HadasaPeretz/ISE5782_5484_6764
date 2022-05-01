/**
 * 
 */
package unittests;
import static primitives.Util.isZero;
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
		 /*   Vector v1 = new Vector(1,-4,7);
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
	        } catch (Exception e) {}*/
	        
	        
	        Vector v1;
	        Vector v2;
			try 
			{
				v1 = new Vector(1, 2, 3);
				v2 = new Vector(-2, -4, -6);
		        // ============ Equivalence Partitions Tests ==============
		        Vector v3 = new Vector(0, 3, -2);
		        Vector vr = v1.crossProduct(v3);

		        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
		        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

		        // Test cross-product result orthogonality to its operands
		        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
		        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

			}
			catch (Exception e)
			{
				fail("CrossProduct() for vectors that not zero vector does not need throw an exception");
			}

	        // =============== Boundary Values Tests ==================
	        // test zero vector from cross-productof co-lined vectors
	        try
	        {
	        	v1 = new Vector(1, 2, 3);
				v2 = new Vector(-2, -4, -6);
	            v1.crossProduct(v2);
	            fail("crossProduct() for parallel vectors does not throw an exception");
	        }
	        catch (Exception e)
	        {}
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() 
	{
		Vector v1;
		try 
		{
			// ============ Equivalence Partitions Tests ==============
			v1 = new Vector(1, 2, 3);
			assertTrue("lengthSquared() return wrong value", isZero(v1.lengthSquared() - 14));
		} 
		catch (Exception e) 
		{
			fail("LengthSquared() for vectors that not zero vector does not need throw an exception");
		}
		
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() 
	{
		try
		{
			// ============ Equivalence Partitions Tests ==============
			assertTrue("Length() return wrong value", isZero(new Vector(0, 3, 4).length() - 5));
		}
		catch (Exception e) 
		{
			fail("Length() for vectors that not zero vector does not need throw an exception");
		}
	}

	/**
	 * Test method for {@link primitives.Vector#normelaize()}.
	 */
	@Test
	void testNormelaize() 
	{
		/*Vector v;
		Vector vCopy;
		Vector vCopyNormalize;
		// ============ Equivalence Partitions Tests ==============
		try 
		{
			v = new Vector(1, 2, 3);
			vCopy = new Vector(v.getXyz());//vcopy==v
			vCopyNormalize = vCopy.normelaize();
			assertFalse("ERROR: normalize() function creates a new vector", vCopy != vCopyNormalize);
			assertTrue("ERROR: normalize() result is not a unit vector", isZero(vCopyNormalize.length() - 1));    
		} 
		catch (Exception e) 
		{
			fail("Normalize() for vectors that not zero vector does not need throw an exception");
		}

		try 
		{
			v = new Vector(3.5,-5,10);
			v.normelaize();
			assertEquals("ERROR: normalize() result is not a unit vector", 1, v.length(),1e-10);
		}
		catch (Exception e) {}
		 // =============== Boundary Values Tests ==================
		try
		{
			v = new Vector(0,0,0);
			v.normelaize();
			fail("Didn't throw divide by zero exception!");
		} 
		catch (ArithmeticException e) 
		{
			assertTrue(true);
		} 
		catch (Exception e) {}*/
		
		
		Vector v;
		Vector vCopy;
		Vector vCopyNormalize;
		// ============ Equivalence Partitions Tests ==============
		try 
		{
			v = new Vector(1, 2, 3);
			vCopy = new Vector(v.getXyz());//vcopy==v
			vCopyNormalize = vCopy.normelaize();
			assertFalse("ERROR: normalize() function creates a new vector", vCopy != vCopyNormalize);
			assertTrue("ERROR: normalize() result is not a unit vector", isZero(vCopyNormalize.length() - 1));    
		} 
		catch (Exception e) 
		{
			fail("Normalize() for vectors that not zero vector does not need throw an exception");
		}

		try 
		{
			v = new Vector(3.5,-5,10);
			v.normelaize();
			assertEquals("ERROR: normalize() result is not a unit vector", 1, v.length(),1e-10);
		}
		catch (Exception e) {}
		 // =============== Boundary Values Tests ==================
		try
		{
			v = new Vector(0,0,0);
			v.normelaize();
			fail("Didn't throw divide by zero exception!");
		} 
		catch (ArithmeticException e) 
		{
			assertTrue(true);
		} 
		catch (Exception e) {}
		
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct()
	{
		  Vector v1;
		  Vector v2;
		  Vector v3;
		try 
		{
			// ============ Equivalence Partitions Tests ==============
			v1 = new Vector(1, 2, 3);
			v2 = new Vector(-2, -4, -6);
		    v3 = new Vector(0, 3, -2);
		    assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", isZero(v1.dotProduct(v3)));
		    // =============== Boundary Values Tests ==================
		    assertTrue("ERROR: dotProduct() wrong value",isZero(v1.dotProduct(v2) + 28));
		} 
		catch (Exception e) 
		{
			fail("DotProduct() for vectors that not zero vector does not need throw an exception");
		}
	      
	}
	
	

}
