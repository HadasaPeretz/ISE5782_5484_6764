package geometries;


import static org.junit.Assert.fail;

import primitives.Point;
import primitives.Vector;
import primitives.Double3;

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
	

}
