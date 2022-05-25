package geometries;

import java.util.List;

//import java.util.List;

//import geometries.Intersectable.GeoPoint;
import primitives.Point;
import primitives.Ray;
//import primitives.Ray;
import primitives.Vector;
import static  primitives.Util.isZero;
//import static  primitives.Util.alignZero;;


public class Traingle extends Polygon //implements Geometry 
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
/*	@Override
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
*/
	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
		//get Intersections of plane
		List<GeoPoint> planeIntersections = plane.findGeoIntersections(ray);

		if (planeIntersections == null)
			return null;

		Point p0 = ray.getP0();
		Vector rayDir = ray.getDir();

		//all the vectors ( (v1-p0)x(v2-p0) ) * (ray dir)  should be the same signe
		// else the ray outside the polygon

		//first check the sign of dot product the last and the first
		Vector v1 = vertices.get(0).subtract(p0);
		Vector vn = vertices.get(vertices.size() - 1).subtract(p0);

		double s1 = rayDir.dotProduct(vn.crossProduct(v1));

		//if the ray cross in the edge of the polygon
		if (isZero(s1))
			return null;

		double s2; //keep the next product
		Vector v2; //the next vector
		for (var vertex : vertices.subList(1, vertices.size())) {

			v2 = vertex.subtract(p0);
			s2 = rayDir.dotProduct(v1.crossProduct(v2));

			//if the ray cross in the edge of the polygon
			if (isZero(s2)) return null;

			//if they not the same sign
			if( s1 * s2 < 0  )
				return null;

			v1 = v2; //for the next round
		}

		//if the func not return null than we have Intersections with the polygon
		return planeIntersections.stream().map(gp->new GeoPoint(this,gp.point)).toList();
	}
		
}
