package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube implements Geometry  
{

	public double higth;
	
	
public double getHigth() {
		return higth;
	}



public Cylinder(double radius, Ray ray, double higth) {
	super(radius, ray);
	this.higth = higth;
}



@Override
public String toString() {
	return "Cylinder [higth=" + higth + "]";
}



@Override
public Vector getNormal(Point p) {
	// TODO Auto-generated method stub
	return null;
}
}
