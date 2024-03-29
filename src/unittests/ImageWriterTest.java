/**
 * 
 */
package unittests;



import org.junit.jupiter.api.Test;

import primitives.Color;
import renderer.ImageWriter;

/**
 * @author Dell
 *
 */
class ImageWriterTest {

	@Test
	/**
	 * Test method for {@link renderer.ImageWriter#writeToImage()}.
	 */
	public void testWriteToImage() 
	{
		ImageWriter image = new ImageWriter("firstImage",800,500);

		for (int i = 0; i<800; i++)
		{
			for (int j = 0; j<500;j++)
			{
				if(i%50 == 0 || j%50 == 0)
					image.writePixel(i, j, new Color(189,56,126));
				else
					image.writePixel(i, j, new Color(200,150,178));
			}
		}
		image.writeToImage();
	}

}
