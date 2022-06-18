package renderer;

import static  primitives.Util.isZero;


import java.util.MissingResourceException;

import primitives.Color;
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
	private ImageWriter imageWriter;
	private RayTracerBase rayTrace;
	private static final String RESOURCE_ERROR = "Camera resource not set";
	private static final String RENDER_CLASS = "Camera";
	private static final String IMAGE_WRITER_COMPONENT = "Image writer";
//	private static final String RAY_TRACER_COMPONENT = "Ray tracer";
	private Camera camera;
	private int numOfRays;
	

	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	public Camera setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
		return this;
	}

	public RayTracerBase getRayTrace() {
		return rayTrace;
	}

	public Camera setRayTrace(RayTracerBasic rayTrace) {
		this.rayTrace = rayTrace;
		return this;
	}

	/**
	 * Getter for p0
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return Point3D value for p0	 
	 */
	public Point getP0() 
	{
		return p0;
	}

	/**
	 * Getter for vUp
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return Vector value for vUp	 
	 */
	public Vector getvUp() 
	{
		return vUp;
	}

	/**
	 * Getter for vTo
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return Vector value for vTo	 
	 */
	public Vector getvTo() 
	{
		return vTo;
	}
	
	/**
	 * Getter for vRight
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return Vector value for vRight	 
	 */
	public Vector getvRight() 
	{
		return vRight;
	}

	/**
	 * Getter for width
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return double value for width	 
	 */
	public double getWidth() 
	{
		return width;
	}

	/**
	 * Getter for height
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return double value for height	 
	 */
	public double getHeight() 
	{
		return height;
	}

	/**
	 * Getter for distance
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @return double value for distance	 
	 */
	public double getDistance() 
	{
		return distance;
	}

	public Camera() 
	{
		
	}

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
	/**
	 * The function is responsible for creating the rays from the camera
	 * 
	 * @author hadassa peretz 325016764 & galit malkiel
	 * @param nX int value - resolution of pixel in X
	 * @param nY int value - resolution of pixel in Y
	 * @param j int value - index of column
	 * @param i int value - index of row
	 * @return Ray that created	 
	 * @throws Exception 
	 */
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i ) 
	{
		Point Pc;
		if (isZero(distance))
			Pc=p0;
		else
			Pc=p0.add(vTo.scale(distance));
		
		double Ry= height/nY;
		double Rx=width/nX;
		double Yi=(i-(nY-1)/2d)*Ry;
		double Xj=(j-(nX-1)/2d)*Rx;
		
		if(isZero(Xj) && isZero(Yi))
			return new Ray (p0, Pc.subtract(p0));
		
		Point Pij = Pc;
		
		if(!isZero(Xj))
			Pij = Pij.add(vRight.scale(Xj));
		
		if(!isZero(Yi))
			Pij = Pij.add(vUp.scale(-Yi));
		
		Vector Vij = Pij.subtract(p0);
		
		if(Pij.equals(p0))
			return new Ray(p0, new Vector(Pij.getXyz()));
		return new Ray(p0, Vij);

	}
	/**
	 * Cast ray from camera in order to color a pixel
	 * @param nX resolution on X axis (number of pixels in row)
	 * @param nY resolution on Y axis (number of pixels in column)
	 * @param col pixel's column number (pixel index in row)
	 * @param row pixel's row number (pixel index in column)
	 */
	
	private void castRay(int nX, int nY, int col, int row) {
		Ray ray = constructRayThroughPixel(nX, nY, col, row);
		Color color = rayTrace.traceRay(ray);
		imageWriter.writePixel(col, row, color);
	}
	
	
	/**
	 * This function renders image's pixel color map from the scene included with
	 * the Renderer object
	 */
	public void renderImage()
	{
		if(this.p0==null || this.vTo==null|| this.vUp==null || this.rayTrace==null || this.vRight==null||this.imageWriter==null)
			throw new MissingResourceException("one of the properties contains empty value", null, null);
		//throw new UnsupportedOperationException();
		for (int i = 0; i <imageWriter.getNy() ; i++) {
			for (int j = 0; j < imageWriter.getNx(); j++) {
				castRay(imageWriter.getNx(),imageWriter.getNy(),j,i);
			}
		}
	}
	/**
	 * Create a grid [over the picture] in the pixel color map. given the grid's
	 * step and color.
	 * 
	 * @param step  grid's step
	 * @param color grid's color
	 */
	public void printGrid(int interval, Color color) {
		if (imageWriter == null)
			throw new MissingResourceException (RESOURCE_ERROR, RENDER_CLASS, IMAGE_WRITER_COMPONENT);

		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();

		for (int i = 0; i < nY; ++i)
			for (int j = 0; j < nX; ++j)
				if (j % interval == 0 || i % interval == 0)
					imageWriter.writePixel(j, i, color);
	}
	
	/**
	 * Produce a rendered image file
	 */
	public void writeToImage() {
		if (imageWriter == null)
			throw new MissingResourceException(RESOURCE_ERROR, RENDER_CLASS, IMAGE_WRITER_COMPONENT);

		imageWriter.writeToImage();
	}
	/**
	 * A seter function for parameter rayTracer
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param rayTracer RayTracerBase value
	 * */
	public Camera setNumOfRays(int numOfRays)
	{
		if(numOfRays == 0)
			this.numOfRays=1;
		else
		 this.numOfRays = numOfRays;
		return this;
	}
	/**
	 * A seter function for parameter camera
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param camera Camera value
	 * */
	public Camera setCamera(Camera camera)
	{
		this.camera = camera;
		return this;
	}

}
