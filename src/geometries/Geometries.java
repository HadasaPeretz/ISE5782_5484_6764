package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import primitives.Ray;


public class Geometries extends Intersectable {
	
	private List<Intersectable> sceneGeometries;
	
	public Geometries ()
	{
		sceneGeometries=new ArrayList<Intersectable>();
	}

	public Geometries(Intersectable... geometries)
	{
		
		sceneGeometries =  new ArrayList<Intersectable>(Arrays.asList(geometries));

	}
	
	public  Iterator<Intersectable> iterator()
	{
		return sceneGeometries.iterator();
	}
	
	
	public void add(Intersectable... geometries)
	{
		if (sceneGeometries!=null)
			sceneGeometries.addAll(Arrays.asList(geometries));
	}
	
   /* @Override
	public List<Point> findIntsersections(Ray ray)
	{
    	return null;
 
	}
	*/
	
	
	/*@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	
	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray,double maxDistance)
	{
		List<GeoPoint> points = null;
		if (sceneGeometries != null) {
		for (var body : sceneGeometries) {
		var result = body.findGeoIntersections(ray, maxDistance);
		if (result != null)
		if (points == null)
		points = new LinkedList<GeoPoint>(result);
		else
		points.addAll(result);
		}
		}
		return points;
	}
	
}
