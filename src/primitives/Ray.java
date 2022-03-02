package primitives;

import java.util.Objects;

public class Ray  
{
	final Point p0;
	final Vector dir;
	
	
	public Point getP0() 
	{
		return p0;
	}
	public Vector getDir() 
	{
		return dir;
	}
	
	public Ray(Point p0, Vector dir) 
	{
		super();
		this.p0 = p0;
		this.dir = dir.normelaize();
	}
	@Override
	public String toString() 
	{
		return "Ray [p0=" + p0 + ", dir=" + dir + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		return Objects.equals(dir, other.dir) && Objects.equals(p0, other.p0);
	}
	 
	
	

}
