package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static  primitives.Util.isZero;
import static  primitives.Util.alignZero;;

public class Sphere implements Geometry 
{
	public Point point;
	public double radius;
	
	
public Point getPoint() {
		return point;
	}



	public double getRadius() {
		return radius;
	}


public Sphere(Point point, double radius) {
		//super();
		this.point = point;
		this.radius = radius;
	}

@Override
public String toString() {
	return "Sphere [point=" + point + ", radius=" + radius + "]";
}



@Override
public Vector getNormal(Point point) throws IllegalArgumentException
{	
	return point.subtract(this.point).normelaize();
}
/***
 * Returns a cut between Sphere and ray
 */
@Override
public List<Point> findIntsersections (Ray ray) throws IllegalArgumentException
{
	if (ray.getP0().equals(point)) // if the ray begins at the center, the point is on the radius
		return List.of(ray.getPoint(radius));
	Vector u = point.subtract(ray.getP0());
	double tM = alignZero(ray.getDir().dotProduct(u));
	double d = alignZero(Math.sqrt(u.length()*u.length()- tM * tM));
	double tH = alignZero(Math.sqrt(radius*radius - d*d));
	double t1 = alignZero(tM+tH);
	double t2 = alignZero(tM-tH);
	
	if (d > radius)
		return null; // if there are no instructions
	if (t1 <= 0 && t2 <= 0)
		return null;
	if (t1 > 0 && t2 > 0)
		return List.of(ray.getPoint(t1), ray.getPoint(t2));
	if (t1 > 0)
		return List.of(ray.getPoint(t1));
	else
		return List.of(ray.getPoint(t2));	
	}
	

}
