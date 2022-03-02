package primitives;

import java.util.Objects;

 public class Point 
 {
	
	 Double3 xyz;
	 

	 public	Double3 getXyz()
	{
		return xyz;
	}
	 public Point(double x,double y,double z) {
		super();
		Double3 a=new Double3(x,y,z);
		this.xyz =a;
	}

	public  Point(Double3 xyz) {
		super();
		this.xyz = xyz;
	}

	@Override
	public  String toString() 
	{
		return "Point [xyz=" + xyz + "]";
	}

	@Override
	public  boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Objects.equals(xyz, other.xyz);
	}
  public  Point add  (Vector v) 
	{
	    Point temp=new Point(this.xyz.add(v.xyz)) ;  
		return temp ;
	}
	public Vector subtract  (Point p) 
	{
		Vector v=new Vector(this.xyz.subtract(p.xyz)) ;
		return v; 
	}
	 public double distanceSquared (Point p)
	 {
	   Double3 temp=this.xyz.subtract(p.xyz);
	   temp = temp.product(temp);
	   return (temp.d1+temp.d2+temp.d3);
	 }
	 public double distance (Point p)
	 { 
	   double temp1 = Math.sqrt(this.distanceSquared(p));
	   return temp1;
	 }
	
}
