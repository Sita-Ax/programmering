package card1;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MessageListener implements ActionListener {

	private JLabel img;
	private BufferedImage image;

	public MessageListener(JLabel img, BufferedImage image) {
		this.img = img;
		this.image = image;
	}

	// this is ActionListener and it's a class that is responsible for handling all
	// action events action listeners are used most for JButtons.
	// I change from e.getActionCommand() == "black" to this because the
	// SonarLint-varning
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("black".equals(e.getActionCommand())) {
			updateImage();
		}
		if ("rotate".equals(e.getActionCommand())) {
			updateImageRotate();
		}
		if ("resize".equals(e.getActionCommand())) {
			updateImageResize();
		}
	}

	// this methods updates the image and saved them to imageIcon
	private void updateImage() {
		img.setIcon(new ImageIcon(blackAndWhite()));
	}

	private void updateImageRotate() {
		img.setIcon(new ImageIcon(rotate()));
	}

	private void updateImageResize() {
		img.setIcon(new ImageIcon(resizeImage(image, 100, 100)));
	}

	// blackAndWhite is the method where Graphics2D is used to do the image black an
	// white and image and return it as BufferedImage object.
	BufferedImage blackAndWhite() {
		BufferedImage blackImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D graphics = blackImg.createGraphics();
		graphics.drawImage(image, 0, 0, null);
		return blackImg;
	}

	// rotate is the method where Graphics2D is used to rotate image and return it
	// as BufferedImage object.
	BufferedImage rotate() {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage rotated = new BufferedImage(w, h, image.getType());
		Graphics2D graphic = rotated.createGraphics();
		// 45 is the rotated degrees and w/2,h/2 is the place of the image
		graphic.rotate(Math.toRadians(45), (double) w / 2, (double) h / 2);
		graphic.drawImage(image, null, 0, 0);
		graphic.dispose();
		return rotated;
	}

	// resizeImage is the method where Graphics2D is used to resize image and return
	// it as BufferedImage object.
	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}
}