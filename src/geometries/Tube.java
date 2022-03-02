package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry 
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
	// TODO Auto-generated method stub
	return null;
}

@Override
public String toString() {
	return "Tube [radius=" + radius + ", ray=" + ray + "]";
}

}
