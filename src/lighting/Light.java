package lighting;

import primitives.Color;

abstract class Light 
{
   private Color intensity;
	
	
	/**
	 * constructor for light
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @return the intensity
	 */
	protected Light(Color intensity)
	{
		this.intensity=intensity;
	}
 
	/**
	 * getter to intensity
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @return intensity Color 
	 * */
	public Color getIntensity() 
	{
		return intensity;
	}

}
