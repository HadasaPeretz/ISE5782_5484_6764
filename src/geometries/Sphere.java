package geometries;

import primitives.Point;
import primitives.Vector;

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
		super();
		this.point = point;
		this.radius = radius;
	}

@Override
public String toString() {
	return "Sphere [point=" + point + ", radius=" + radius + "]";
}



@Override
public Vector getNormal(Point p) {
	Vector v=p.subtract(point);	
	return v.normelaize();
}
}
