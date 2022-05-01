package geometries;
import primitives.Ray;

import java.util.List;

import primitives.Point;



public interface Intersectable
{
	/***
	 * 
	 * @param ray
	 * @return the cutting between ray and object. 
	 */
	public List<Point> findIntsersections(Ray ray);

}
