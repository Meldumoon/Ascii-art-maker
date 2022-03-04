import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		
		String chr = " .:nöOG@";
		String output = "";
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("data/smolschmanu.PNG"));
		} catch (IOException e) {
			System.out.println("Konnte nicht geladen werden, folgender Fehler:"+e);
		}
		
		for(int y=0; y < img.getHeight(); y++) {
		
			for(int x=0; x < img.getWidth(); x++) {
				
				int pixelrgb = img.getRGB(x,y);
				Color c = new Color(pixelrgb,true);
				
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				int brightness = red + green + blue;
				int maxb = 255*3+10;
				int stepsize = maxb / chr.length();
				
				char pc = chr.charAt( (int)Math.floor(brightness/stepsize));
				output = output+pc;
			}
			output = output + '\n';
		}

		System.out.println(output);
		
	}

}
