package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase
{
	/**
	 * constructor of RayTracerBasic
	 * 
	 * @author hadassa & galit
	 * @param myscene Scene value
	 */
	public RayTracerBasic(Scene myscene) 
	{
		super(myscene);
	}

	public Color traceRay(Ray ray) throws IllegalArgumentException
	{
		Point closestPoint = findClosestIntersection(ray);
		return closestPoint == null ? myscene.background : calcColor(closestPoint, ray);	
		
	}
	/**
	 * Function for calculating a point color - recursive function	
	 * 
	 * @author hadassa & galit
	 * @param point Point3D value
	 * @return Color
	 * @throws IllegalArgumentException 
	 * */
	

	private Color calcColor(GeoPoint geopoint, Ray ray) 
	{
		return calcColor(geopoint, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(myscene.ambientLight.getIntensity());
	}
}
