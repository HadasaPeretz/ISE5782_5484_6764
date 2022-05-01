package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import primitives.Point;
import primitives.Ray;

public class Geometries implements Intersectable {
	
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
	
	public List<Point> findIntsersections(Ray ray)
	{
		return null;
	}
	
	
	
	/*@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
