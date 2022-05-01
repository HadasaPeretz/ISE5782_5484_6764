package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static  primitives.Util.isZero;
import static  primitives.Util.alignZero;;


public class Traingle extends Polygon implements Geometry
{
	
	public Traingle(Point... vertices)
	{
		super(vertices);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() 
	{
		return "Traingle ["+super.toString()+"]";
	}

	@Override
	public Vector getNormal(Point point) {
		return super.getNormal(point);
	}
	/***
	 * Returns a cut between a triangle and a ray
	 */
	@Override
	 public List<Point> findIntsersections(Ray ray) throws IllegalArgumentException
	{
			
		List<Point>	pInters = plane.findIntsersections(ray);

		//check if the found point is in the triangle's boarders or not...
		Vector v1 = vertices.get(0).subtract(ray.getP0());
		Vector v2 = vertices.get(1).subtract(ray.getP0());
		Vector v3 = vertices.get(2).subtract(ray.getP0());
		
		Vector n1 = v1.crossProduct(v2).normelaize();
		Vector n2 = v2.crossProduct(v3).normelaize();
		Vector n3 = v3.crossProduct(v1).normelaize();
		
		//if all Vi*Ni have the same sign --> the point is in the triangle
		if (alignZero(n1.dotProduct(ray.getDir())) > 0 && alignZero(n2.dotProduct(ray.getDir())) > 0 && alignZero(n3.dotProduct(ray.getDir())) > 0)
			{
				return pInters;
			}
			else if (alignZero(n1.dotProduct(ray.getDir())) < 0 && alignZero(n2.dotProduct(ray.getDir())) < 0 && alignZero(n3.dotProduct(ray.getDir())) < 0)
			{
				return pInters;
			}
			if (isZero(n1.dotProduct(ray.getDir())) || isZero(n2.dotProduct(ray.getDir())) || isZero(n3.dotProduct(ray.getDir())))
				return null; //there are no intersections
			return null;		
	}

		
		
}
