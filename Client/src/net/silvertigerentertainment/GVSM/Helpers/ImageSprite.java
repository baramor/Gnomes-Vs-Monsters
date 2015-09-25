package net.silvertigerentertainment.GVSM.Helpers;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;

public class ImageSprite {
	
	public static BufferedImage convertToARGB(BufferedImage image) {
		BufferedImage newImage = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}

	public static BufferedImage createFlipped(BufferedImage image) {
		AffineTransform at = new AffineTransform();
		at.concatenate(AffineTransform.getScaleInstance(1, -1));
		at.concatenate(AffineTransform.getTranslateInstance(0,
				-image.getHeight()));
		return createTransformed(image, at);
	}

	public static BufferedImage createRotated(BufferedImage image) {
		AffineTransform at = AffineTransform.getRotateInstance(Math.PI,
				image.getWidth() / 2.0, image.getHeight() / 2.0);
		return createTransformed(image, at);
	}

	public static BufferedImage createTransformed(BufferedImage image,
			AffineTransform at) {
		BufferedImage newImage = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.transform(at);
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}
	
	public static BufferedImage rotate(BufferedImage image, double angle) {
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww-w)/2, (newh-h)/2);
	    g.rotate(angle, w/2, h/2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}
	
	public static GraphicsConfiguration getDefaultConfiguration() {
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}

	public static BufferedImage createInverted(BufferedImage image) {
		if (image.getType() != BufferedImage.TYPE_INT_ARGB) {
			image = convertToARGB(image);
		}
		LookupTable lookup = new LookupTable(0, 4) {
			@Override
			public int[] lookupPixel(int[] src, int[] dest) {
				dest[0] = (int) (255 - src[0]);
				dest[1] = (int) (255 - src[1]);
				dest[2] = (int) (255 - src[2]);
				return dest;
			}
		};
		LookupOp op = new LookupOp(lookup, new RenderingHints(null));
		return op.filter(image, null);
	}

}
