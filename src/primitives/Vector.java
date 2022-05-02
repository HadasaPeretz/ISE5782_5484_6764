package primitives;

public class Vector extends Point
{


  public  Vector(Double3 xyz) 
	{
		super(xyz);
		if(xyz.equals(new Double3(0, 0, 0)))
			throw new IllegalArgumentException("The function dosent support the zero vector");
		// TODO Auto-generated constructor stub
	}

  public  Vector(double x, double y, double z) 
	{
		super(x, y, z);
		
		if(xyz.equals(new Double3(0, 0, 0)))
			throw new IllegalArgumentException("The function dosent support the zero vector");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() 
	{	
		return "Vector ["+super.toString()+"]";
	}
	
	@Override
	public  Vector add  (Vector v) 
	{	
        return new Vector(super.add(v).xyz);
	}
	public  Vector scale  (Double x) // מכפלה סקלרית
	{
		
		return new Vector(this.xyz.scale(x) );
	}
	
	public  Vector crossProduct  (Vector x)// מכפלה וקטורית
	{
		double xx=this.xyz.d2*x.xyz.d3-this.xyz.d3*x.xyz.d2;
		double yy=this.xyz.d3*x.xyz.d1-this.xyz.d1*x.xyz.d3;// למה לא עובד עם מינוס
		double zz=this.xyz.d1*x.xyz.d2-this.xyz.d2*x.xyz.d1;	
		Vector sum=new Vector(xx,yy,zz);
		return sum;
	}
	
   public  double lengthSquared () 
	{
	    Double3 temp=this.xyz.product(this.xyz);
		return (temp.d1+temp.d2+temp.d3);
	}
	
	public  double length() 
	{	
		return Math.sqrt(this.lengthSquared());
	}
	
	public  Vector normelaize() 
	{
		double temp1=Math.sqrt(this.lengthSquared());
	    Vector vector1=new Vector(this.xyz.d1/temp1 , this.xyz.d2/temp1 ,this.xyz.d3/temp1 );
		//this.xyz=new Double3(this.xyz.d1/temp1 , this.xyz.d2/temp1 ,this.xyz.d3/temp1);
		//return this;
	    return vector1;
		
	}
	
	
	public  double dotProduct  (Vector x) 
	{
		double xx=(this.xyz.d1*x.xyz.d1);
		double yy=(this.xyz.d2*x.xyz.d2);
		double zz=(this.xyz.d3*x.xyz.d3);			
		return xx+yy+zz;
	  
		
	    
	}
}
