package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase
{
	/**
	 * constructor of RayTracerBasic
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param myscene Scene value
	 */
	public RayTracerBasic(Scene myscene) 
	{
		super(myscene);
	}

	public Color traceRay(Ray ray) throws IllegalArgumentException
	{
		return null;
	}

}
