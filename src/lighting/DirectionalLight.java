package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;



/**
 * class DirectionalLight that extends from class light
 * and implement the interface LightSource
 * @author hadassa peretz & galit malkiel
 */
public class DirectionalLight extends Light implements LightSource
{
	private Vector direction;

	/**
	 * Constructor for DirectionalLight
	 * this c-tor is normalize the direction vector
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @param intensity Color value
	 * @param direction Vector value
	 */
	public DirectionalLight(Color intensity, Vector direction) 
	{
		super(intensity);
		this.direction=direction.normelaize();
	}

	
	@Override
	public Color getIntensity(Point p)
	{
		return super.getIntensity();
	}
	
	@Override
	public Vector getL(Point p)
	{
		return direction;
	}

	
}
