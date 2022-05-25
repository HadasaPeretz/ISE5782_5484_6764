package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

public abstract class Geometry extends Intersectable
{
	protected  Color emission = Color.BLACK;
	public  abstract Vector getNormal(Point p);
	private Material material=new Material();
	
	/**
	 * getter function for the Material filed in geometry class
	 * 
	 * @author  hadassa & galit
	 * @return the material
	 */
	public Material getMaterial() 
	{
		return material;
	}

	/**
	 * setter function for the Material filed 
	 * 
	 * @author  hadassa & galit
	 * @param material the material to set
	 * @return the object - builder
	 */
	public Geometry setMaterial(Material material) 
	{
		this.material = material;
		return this;
	}
	
	
	
	
	/**
	 * getter function for the color filed in geometry class
	 * 
	 * @author hadassa & galit
	 * @return emission Color value
	 * */
	public Color getEmission() 
	{
		return emission;
	}
	
	/**
	 * setter function for the color filed and return this- geometry class
	 * 
	 * @author hadassa & galit
	 * @return the geometry-this
	 * */
	public Geometry setEmission(Color emission) 
	{
		this.emission = emission;
		return this;
	}
	
   

}
