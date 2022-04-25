package geometries;

import primitives.Point;
import primitives.Vector;

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

}
