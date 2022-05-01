package renderer;

import static  primitives.Util.isZero;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;


public class Camera {
	
	private Point p0; //location of the camera
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;
	private double width;
	private double height;
	private double distance;

	/**
	 * This constructor that creat new camera
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @param vTo Vector value
	 * @param vUp Vector value
	 * @param p0 Point value
	 * @return Camera
	 * @throws Exception 
	 */
	public Camera(Point p0, Vector vTo, Vector vUp) throws IllegalArgumentException 
	{
		if(!isZero(vTo.dotProduct(vUp))) // if vTo doesn't orthogonal to vUp
			throw new IllegalArgumentException("vUp doesnt ortogonal to vTo");
		
		//all the vectors need to be normalize:
		this.vTo = vTo.normelaize();
		this.vUp = vUp.normelaize();
		vRight = (vTo.crossProduct(vUp)).normelaize();
		
		this.p0 = p0;

	}
	/**
	 * Update function for View Plane size  
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @param width double value
	 * @param height double value
	 * @return Camera	 
	 */
	public Camera setViewPlaneSize(double width, double height)
	{
		this.width = width;
		this.height = height;
		return this;
	}
	
	
	/**
	 * Update function for distance
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @param distance double value
	 * @return Camera	 
	 */
	public Camera setDistance(double distance)
	{
		this.distance = distance;
		return this;
	}


}
