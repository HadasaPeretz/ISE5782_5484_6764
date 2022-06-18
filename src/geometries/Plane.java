package geometries;




//import java.util.LinkedList;
import java.util.List;
//import geometries.Intersectable.GeoPoint;
import primitives.Point;
import primitives.Ray;
//import primitives.Util;
import primitives.Vector;

import static  primitives.Util.isZero;
import static primitives.Util.alignZero;

public class Plane extends Geometry 
{
	Point point;
	Vector vector;
	
	public Point getPoint() {
		return point;
	}
	
	public Vector getVector() {
		return vector;
	}
	
	public Vector getNormal() {
		
		return vector;
	}
	@Override
    public Vector getNormal(Point p) {
		
		return vector;
	}


	@Override
	public String toString() {
		return "Plane [point=" + point + ", vector=" + vector + "]";
	}

	public Plane(Point point, Vector vector) 
	{
		super();
		this.point = point;
		this.vector = vector.normelaize();
	}

	public Plane(Point point1,Point point2,Point point3)
	{
		
		if (point1.equals(point2)|| point2.equals(point3)|| point3.equals(point1))//Check if two points coalesce
			throw new IllegalArgumentException("Two points converge");
		this.point = point1;
		Vector myVec1=(point2.subtract(point1));// vector p2p1
		Vector myVec2=(point3.subtract(point1));//vector p3p1	
		this.vector = myVec1.crossProduct(myVec2).normelaize();
				
	}
	
	
	/*@Override
	public List<Point> findIntsersections(Ray ray) throws IllegalArgumentException
	{
		double nv = vector.dotProduct(ray.getDir());
		if(isZero(nv))
			return null;
		try {
			Vector v = ray.getP0().subtract(point);//calculate vector 'Q - P'
			double t = vector.dotProduct(v) / nv;//calculate 't' according to the given instructions
			if(t <= 0)
				return null;
			Point intersectionP = ray.getPoint(t);//and then the wanted point
			List<Point> lstP = List.of(intersectionP);
			if(lstP.isEmpty())
				return null;
			return lstP;
		}                 
		catch(Exception ex) {
			return null;
		}
	}
	*/
	
	/***
	 * Returns a cut between a plane and a ray
	 */
	
@Override
  protected  List<GeoPoint> findGeoIntersectionsHelper(Ray ray,double maxDistance)
  {/*
	double nv = vector.dotProduct(ray.getDir());
	if (isZero(nv))
	{
		return null;
	}
	
	try 
	{
		Vector pSubtractP0 = point.subtract(ray.getP0());
		double t = alignZero((vector.dotProduct(pSubtractP0))/nv);

		if(t <= 0)
		{
			return null;
		}
	 List<GeoPoint> temp1=List.of(new GeoPoint(this,ray.getPoint(t)));
	 List<GeoPoint>  finish=new LinkedList<GeoPoint>();
	 for(GeoPoint xxx:temp1)
		 if(Util.alignZero(t-maxDistance)<=0)
			 finish.add(xxx);
	 return finish;
	}
	catch(Exception ex) 
	{
		return null;
	}*/
	
	
	double nv = vector.dotProduct(ray.getDir());
	if (isZero(nv))
	{
		return null;
	}
	
	try 
	{
		Vector pSubtractP0 = point.subtract(ray.getP0());
		double t = alignZero((vector.dotProduct(pSubtractP0))/nv);

		if(t <= 0)
		{
			return null;
		}
		return List.of(new GeoPoint(this,ray.getPoint(t)));
	}
	catch(Exception ex) 
	{
		return null;
	}
	
	
	
	
  }
}
