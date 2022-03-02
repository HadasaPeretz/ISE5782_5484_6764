package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry 
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getNormal(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Plane [point=" + point + ", vector=" + vector + "]";
	}

	public Plane(Point point, Vector vector) 
	{
		super();
		this.point = point;
		this.vector = vector;
	}

	public Plane(Point point1,Point point2,Point point3)
	{
		this.vector=null;
		this.point=point1;
	}
	

}
