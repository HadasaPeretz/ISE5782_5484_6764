package lighting;
import primitives.Color;
import primitives.Double3;

public class AmbientLight {
	Color intensity;

	/**
	 * 
	 */
	public AmbientLight(Color La ,Double3 Ka ) {
		 //intensity=super(La.scale(Ka));
		 intensity=La.scale(Ka);
		// TODO Auto-generated constructor stub
	}
	
	public AmbientLight()
	{
		intensity=Color.BLACK;
	}
	
	public Color getIntensity()
	{
		return intensity;
	}

}
