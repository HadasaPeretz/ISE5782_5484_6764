package geometries;

import java.util.List;

//import geometries.Intersectable.GeoPoint;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube extends Geometry 
{
	public double radius;
	public Ray ray;
public double getRadius() {
		return radius;
	}

	public Ray getRay() {
		return ray;
	}
	
public Tube(double radius, Ray ray) {
		super();
		this.radius = radius;
		this.ray = ray;
	}

@Override
public Vector getNormal(Point p) {
	double t=ray.getDir().dotProduct(p.subtract(ray.getP0()));
	Point pointO =ray.getP0().add(ray.getDir().scale(t));
	Vector myVec=p.subtract(pointO);
	return myVec.normelaize();
}

@Override
public String toString() {
	return "Tube [radius=" + radius + ", ray=" + ray + "]";
}

/*@Override
public List<Point> findIntsersections(Ray ray) {
	// TODO Auto-generated method stub
	return null;
}*/
@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray,double maxDistance)
	{
  	return null;

	}

}






