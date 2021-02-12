package com.mobios.ep.web.util;


import java.io.File;
//import java.util.Base64;
import java.io.IOException;
import javax.imageio.ImageIO;
//import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;

public class Base64Convert {

	/*public String toBase64String(String requestImageModel) {

		System.out.println("Path = " + requestImageModel);

		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(requestImageModel)); // eventually
			//File file = new File(getClass().getResource(requestImageModel).toURI());
			//img = ImageIO.read(file); // eventually
		} catch (IOException e) {
			e.printStackTrace();
		} /*catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*System.out.println("Width " + img.getWidth());
		System.out.println("Height " + img.getHeight());

		return imgToBase64String(img, "jpg");*/
	/*}*/

	/*private static String imgToBase64String(final RenderedImage img, final String formatName) {
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			ImageIO.write(img, formatName, os);
			return Base64.getEncoder().encodeToString(os.toByteArray());
		} catch (final IOException ioe) {
			throw new UncheckedIOException(ioe);
		}
	}*/

}
