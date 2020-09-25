package card1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GrayScale {

	 BufferedImage  image;
	   int width;
	   int height;
	
	   public void testimage() {
		 
	      try {
	         File input = new File("/card1/6.jpg");
	         image = ImageIO.read(input);
	         BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.TYPE_INT_RGB);
	         
	         Graphics2D graphic = result.createGraphics();
	            graphic.drawImage(image, 0, 0, Color.WHITE, null);

	            for (int i = 0; i < result.getHeight(); i++) {
	                for (int j = 0; j < result.getWidth(); j++) {
	                    Color c = new Color(result.getRGB(j, i));
	                    int red = (int) (c.getRed() * 0.299);
	                    int green = (int) (c.getGreen() * 0.587);
	                    int blue = (int) (c.getBlue() * 0.114);
	                    Color newColor = new Color(
	                            red + green + blue,
	                            red + green + blue,
	                            red + green + blue);
	                    result.setRGB(j, i, newColor.getRGB());
	                }
	            }
	         
	         File ouptut = new File("new6.jpg");
	         ImageIO.write(image, "jpg", ouptut);
	         
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	   }
//	private static BufferedImage colored(BufferedImage image, Color color) {
//	int w = image.getWidth();
//	int h = image.getHeight();
//	BufferedImage colored = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//	Graphics2D g = colored.createGraphics();
//	g.drawImage(image, 0, 0, null);
//	g.setComposite(AlphaComposite.SrcAtop);
//	g.setColor(color);
//	g.fillRect(0, 0, w, h);
//	g.dispose();
//	return colored;
//}
	
	
}
