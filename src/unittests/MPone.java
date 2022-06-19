package unittests;


import org.junit.Test;


import lighting.*;
import geometries.Plane;
import geometries.Sphere;
//import geometries.Traingle;
import primitives.Color;
import primitives.Double3;
import primitives.Material;
import primitives.Point;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.*;
import scene.Scene;

public class MPone {
	
	private Scene scene = new Scene("Test scene");

	/**
	 * Produce a picture of spheres with improve of depth of field
	 */
	@Test
	public void WithDepthOfField() {
		Camera camera =new Camera(new Point(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0))
				.setViewPlaneSize(600, 600).setDistance(1000).setApHeight(1)
				.setApWidth(1).setFocalPlaneDistance(1010)//set aperture
				.setBeamRays(300);

		scene.background=new Color(java.awt.Color.PINK);
		scene.ambientLight=	new AmbientLight(new Color(java.awt.Color.WHITE),new  Double3(0.0));
		
		scene.geometries.add( //
				new Sphere(new Point(0, 0,20),20).setEmission(new Color(java.awt.Color.BLUE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(30,35,30),20).setEmission(new Color(java.awt.Color.GREEN)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(60,70,50),20).setEmission(new Color(java.awt.Color.ORANGE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(-30,-35,30),20).setEmission(new Color(java.awt.Color.GREEN)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(-60,-70,50),20).setEmission(new Color(java.awt.Color.ORANGE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(90,105,70),20).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Sphere(new Point(-90,-105,70),20).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new  Double3( 0.5)).setKt(new  Double3(0))),
				new Plane(new Point(0,0,200),new Vector(0,0,1)).setEmission(new Color(0,40,60)).setMaterial((new Material().setKD(0.5).setKS(0.5).setnShininess(1200).setKr(new  Double3( 0.0)).setKt(new  Double3(0)))));
		
				scene.lights.add( //
				new SpotLight(new Color(700,400,400), new Point(40, -40, -115), new Vector(0,0, 1)) //
				.setKC(1).setKL(4E-4).setKQ(2E-5));
				scene.lights.add(new SpotLight(new Color(200,200,200), new Point(1000,-550,1000), new Vector(0,-1,0)) //
						.setKL(4E-5).setKQ(2E-7));
				scene.lights.add(new PointLight(new Color(100, 150, 150), new Point(-50, -50, 50))//
						.setKL(0.00001).setKQ(0.000001));
				
				//
				camera .setImageWriter(new ImageWriter("MiniProject-part1-DepthOfField", 600, 600)) //
					.setRayTrace(new RayTracerBasic(scene));
				camera .renderImage();
				camera .writeToImage();
	}

	/**
	 * Produce a picture of spheres without improve of depth of field
	 */
	@Test
	public void WithoutDepthOfField() {
		Camera camera =new Camera(new Point(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0))
				.setViewPlaneSize(600, 600).setDistance(1000);
		
				//.setBeamRays(300);.setApHeight(1).setApWidth(1);setFocalPlaneDistance(1010);//dont set aperture- no improvization

		scene.background=new Color(java.awt.Color.PINK);
		scene.ambientLight=	new AmbientLight(new Color(java.awt.Color.WHITE),new Double3(0) );
		
		scene.geometries.add( //
				new Sphere(new Point(0, 0,20),20d).setEmission(new Color(java.awt.Color.BLUE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(30,35,30),20d).setEmission(new Color(java.awt.Color.GREEN)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(60,70,50),20d).setEmission(new Color(java.awt.Color.ORANGE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(-30,-35,30),20d).setEmission(new Color(java.awt.Color.GREEN)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(-60,-70,50),20d).setEmission(new Color(java.awt.Color.ORANGE)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(90,105,70),20d).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Sphere(new Point(-90,-105,70),20d).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.3).setKS(0.7).setnShininess(100).setKr(new Double3(0.5)).setKt(new Double3(0))),
				new Plane(new Point(0,0,200),new Vector(0,0,1)).setEmission(new Color(0,40,60)).setMaterial((new Material().setKD(0.5).setKS(0.5).setnShininess(1200).setKr(new Double3(0.0)).setKt(new Double3(0)))));
		
		
		
		
				scene.lights.add( //
				new SpotLight(new Color(700, 400, 400), new Point(40, -40, -115), new Vector(0,0, 1)) //
			      .setKC(1).setKL(4E-4).setKQ(2E-5));
				scene.lights.add(new SpotLight(new Color(200,200,200), new Point(1000,-550,1000), new Vector(0,-1,0)) //
						.setKL(4E-5).setKQ(2E-7));
				scene.lights.add(new PointLight(new Color(100, 150, 150), new Point(-50, -50, 50))//
						.setKL(0.00001).setKQ(0.000001));
				
				
				camera.setImageWriter(new ImageWriter("MiniProject-part1-NoDepthOfField", 600, 600)).setRayTrace(new RayTracerBasic(scene)); //
			
				camera.renderImage();
				camera.writeToImage();
	}


}
