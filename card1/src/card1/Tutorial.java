package card1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//this is where i create the rotator to my image in JPanel i can drew in it
public class Tutorial extends JPanel {

	private Image image;
	private double currentImage;

//this is the frame that creates image inside
	public Tutorial(Image testImage) {
	
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		Image img = Toolkit.getDefaultToolkit().getImage("6.jpg");
		final Tutorial rotatePanel = new Tutorial(testImage);
		JButton button = new JButton("Rotate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				rotatePanel.rotate();
			}
		});
		c.add(rotatePanel, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public void ImageMain(Image image) {
		this.image = image;
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(image, 0);
		try {
			mt.waitForID(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rotate() {
		// rotate 5 degrees at a time
		double currentImage = 45.0;
		if (currentImage >= 360.0) {
			currentImage = 0;
		}
		repaint();
	}
//here we can draw the image

	public void paintComponent(Graphics g) {


		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform origXform = g2d.getTransform();
		AffineTransform newXform = (AffineTransform) (origXform.clone());
		// center of rotation is center of the panel
		int xRot = this.getWidth() / 2;
		int yRot = this.getHeight() / 2;
		newXform.rotate(Math.toRadians(currentImage), xRot, yRot);
		g2d.setTransform(newXform);
		// draw image centered in panel
		int x = (getWidth() - image.getWidth(this)) / 2;
		int y = (getHeight() - image.getHeight(this)) / 2;
		g2d.drawImage(image, x, y, this);
		g2d.setTransform(origXform);
	}

	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(this), image.getHeight(this));
	}
}
