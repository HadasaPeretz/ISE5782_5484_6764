package renderer;
import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.Color;
import primitives.Double3;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import primitives.Util;
import static  primitives.Util.alignZero;

import java.util.List;

import scene.Scene;
public class RayTracerBasic extends RayTracerBase
{
	
	private static final double DELTA = 0.1;
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


	/**
	 * A function that check if there is shaded or not
	 * 
	 * @author Hadassa oeretz &galit malkiel
	 * @param light LightSource value
	 * @param l Vector value
	 * @param n Vector value
	 * @param geopoint GeoPoint value
	 * @return true or false
	 * */
	private boolean unshaded(Vector l, Vector n, GeoPoint geopoint ,LightSource light)
	{
		Vector lightDirection = l.scale(-1.0); // from point to light source
		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
		Point point = geopoint.point.add(delta);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(lightRay);
		if (intersections == null) return true;
		double lightDistance = light.getDistance(geopoint.point);
		for (GeoPoint gp : intersections) 
		{
			if (alignZero(gp.point.distance(geopoint.point)- lightDistance) <= 0)
				return false;
		}
		return true;
	}
	
	
	
	/**
	* Function for calculating a point color - recursive function
	*
	* @param point Point value
	* @return Color
	* */
	private Color calcColor(GeoPoint intersection, Ray ray) throws IllegalArgumentException 
	{
		
		Color KaIa = myscene.ambientLight.getIntensity();
		Color Ie = intersection.geometry.getEmission(); 

		return KaIa.add(Ie).add(calcLocalEffects(intersection, ray));
	}

	

	
	
	/* private Color calcColor(GeoPoint geopoint, Ray ray) {
	return calcColor(geopoint, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(myscene.ambientLight.getIntensity());
	}

	
	/*private Color calcColor(GeoPoint intersection, Ray ray, int level, double k)  {
	Color Ie = intersection.geometry.getEmission();
	Color color = Ie.add(calcLocalEffects(intersection, ray,k));
	return 1 == level ? color : color.add(calcLocalEffects(intersection, ray, level, k , intersection.geometry.getNormal(intersection.point)));
	}*/
	

	
	@Override
	public Color traceRay(Ray ray) 
	{
		var intersections = myscene.geometries.findGeoIntersections(ray);
		if (intersections == null)
			return myscene.background;
		GeoPoint closestPoint = ray.getClosestGeoPoint(intersections);
		return calcColor(closestPoint, ray);
	}
	
	
	private Color calcLocalEffects(GeoPoint intersection, Ray ray)
	{
		Vector v = ray.getDir();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = Util.alignZero(n.dotProduct(v));
		if (nv == 0)
			return Color.BLACK;
		int nShininess = intersection.geometry.getMaterial().nShininess;
		Double3 kd = intersection.geometry.getMaterial().KD , ks = intersection.geometry.getMaterial().KS;
		Color color = Color.BLACK;
		
		for (LightSource lightSource : myscene.lights) {
			Vector l = lightSource.getL(intersection.point);
			double nl = Util.alignZero(n.dotProduct(l));
			if (nl * nv > 0) { // sign(nl) == sign(nv)
				
				  if (unshaded( l, n, intersection,lightSource))
				  { 
					  Color lightIntensity = lightSource.getIntensity(intersection.point);
                    color = color.add(calcDiffusive(kd, l, n, lightIntensity),
                            calcSpecular(ks, l, n, v, nShininess, lightIntensity));
				  }
			/*	Color lightIntensity = lightSource.getIntensity(intersection.point);
				color = color.add(calcDiffusive(kd, l, n, lightIntensity),
						calcSpecular(ks, l, n, v, nShininess, lightIntensity));*/
			}
		}
		return color;
	}
	/**
	 * Function for calculating a point color - recursive function	
	 * 
	 * @author hadassa & galit
	 * @param point Point3D value
	 * @return Color
	 * @throws IllegalArgumentException 
	 * */
	

   /*private Color calcColor(GeoPoint geo, Ray ray) {
		return myscene.ambientLight.getIntensity().add(geo.geometry.getEmission()).add(calcLocalEffects(geo, ray));
	}*/
	
	/*private Color calcDiffusive(Double3 kd, Vector l, Vector n, Color lightIntensity) {
		return lightIntensity.scale(Math.abs(l.dotProduct(n))*(kd));
	}*/
	
	private Color calcSpecular(Double3 ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.add(n.scale(-2*n.dotProduct(l)));
		double result = -Util.alignZero(v.dotProduct(r));
		if (result <= 0)
			return Color.BLACK;
		return lightIntensity.scale(ks.scale(Math.pow(result, nShininess)));

	}
	/**
	 * help function that calculate the difusive effect
	 * 
	 * @author hadassa & galit
	 * @param kd double value
	 * @param nl double value
	 * @param lightIntensity Color value
	 * @return double value for calcDiffusive
	 * */
	private Color calcDiffusive(Double3 kd, Vector l, Vector n, Color lightIntensity) 
	{
		return lightIntensity.scale(kd.scale(Math.abs(l.dotProduct(n))));
	}
	
	
	
	
	/* private Color calcColor(GeoPoint geoPoint, Ray ray)
	    {
	        return calcColor(geoPoint, ray, MAX_CALC_COLOR_LEVEL, new Double3(INITIAL_K)).add(scene.ambientLight.getIntensity());
	    }*/
	  
}