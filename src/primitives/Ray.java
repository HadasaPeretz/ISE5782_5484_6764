package primitives;

import java.util.List;
import java.util.Objects;
import geometries.Intersectable.GeoPoint; 
public class Ray  
{
	 Point p0;
	 Vector dir;

	
	public Point getP0() 
	{
		return p0;
	}
	public Vector getDir() 
	{
		return dir;
	}
	
	public Ray(Point p0, Vector dir) 
	{
		super();
		this.p0 = p0;
		this.dir = dir.normelaize();
	}
	
	/**
	 * returns a general point on the ray (according to 't')
	 */
	public Point getPoint(double t) {
		Point retP = this.p0.add(dir.scale(t));
		return retP;
	}

	
	@Override
	public String toString() 
	{
		return "Ray [p0=" + p0 + ", dir=" + dir + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		return Objects.equals(dir, other.dir) && Objects.equals(p0, other.p0);
	}
	
	/**
	 * The function returns the point closest to the beginning of the beam
	 * from all the intersection points of the resulting list.
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @param points List<Point3D> value
	 * @return Point3D value
	 * */
	
	public Point findClosestPoint(List<Point> points) 
	{
	    return points == null || points.isEmpty() ? null
	           : getClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
	}

	
	
	
	/*public Point findClosestPoint (List<Point> points)
	{
		if(points == null)
			return null;
		Point closet = points.get(0);
		for (Point point : points) 
		{
			if(point.distance(p0) < closet.distance(p0))
				closet= point;
		}
		return closet;
	}*/
	
	
	public GeoPoint getClosestGeoPoint(List<GeoPoint> intersections)
	{
		
		if(intersections == null)
			return null;
		GeoPoint closet = intersections.get(0);
		for (GeoPoint geoPoint : intersections) 
		{
			if(geoPoint.point.distance(p0) < closet.point.distance(p0))
				closet= geoPoint;
			
		}
		return closet;
	}
	
}
