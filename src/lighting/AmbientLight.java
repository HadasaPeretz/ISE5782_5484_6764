package lighting;
import primitives.Color;
import primitives.Double3;

public class AmbientLight extends Light 
{
	/**
	 * constructor for light
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @return the intensity
	 */
	public AmbientLight(Color La ,Double3 Ka )
	{
		 super(La.scale(Ka));
		 //intensity=super(La.scale(Ka));
		// intensity=La.scale(Ka);
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructor for light
	 * if not receive color its Booting in black
	 * 
	 * @author hadassa peretz & galit malkiel
	 * @return the intensity 
	 * */
	public AmbientLight()
	{
		super(Color.BLACK)    ;
	}
	
	

}
