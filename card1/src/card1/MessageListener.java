package card1;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessageListener implements ActionListener {
	

	private Image image;
	private double currentImage;
	private JLabel img;

	public MessageListener(JLabel img) throws IOException {
		JLabel theImage = new JLabel();
		this.img = img;
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage image = ImageIO.read(new File("6.jpg"));
		JPanel panel = new JPanel(new GridLayout(1, 0));
		panel.add(new JLabel(new ImageIcon(colored(image, new Color(0, 240, 0, 32)))));
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
	}
	
	private void changeImage() {
		//create a new image but calls anohet image
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("6.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.setIcon(new ImageIcon(image));
	}
	private void setSize(int i, int j) {
		img.setSize(i, j);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Get the image to rotate") {
			img.setIcon(new ImageIcon("6.jpg"));
		}
	}
	private static BufferedImage colored(BufferedImage image, Color color) {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage colored = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = colored.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.setComposite(AlphaComposite.SrcAtop);
		g.setColor(color);
		g.fillRect(0, 0, w, h);
		g.dispose();
		return colored;
	}
	
	public void ImageMain(Image image) {
	     this.image = image;
	     MediaTracker mt = new MediaTracker(img);
	     mt.addImage(image, 0);
	     try {
	       mt.waitForID(0);
	     }
	     catch (Exception e) {
	       e.printStackTrace();
	     }
	   }
	
	 public void rotate() {
	     //rotate 5 degrees at a time
	     currentImage+=45.0;
	     if (currentImage >= 360.0) {
	       currentImage = 0;
	     }
//	     repaint();
	   }
	 
	 public void paintComponent(Graphics g) {
//	     super.paintComponent(g);
	     Graphics2D g2d = (Graphics2D)g;
	     AffineTransform origXform = g2d.getTransform();
	     AffineTransform newXform = (AffineTransform)(origXform.clone());
	     //center of rotation is center of the panel
	     int xRot = this.getWidth()/2;
	     int yRot = this.getHeight()/2;
	     newXform.rotate(Math.toRadians(currentImage), xRot, yRot);
	     g2d.setTransform(newXform);
	     //draw image centered in panel
	     int x = (getWidth() - image.getWidth((ImageObserver) this))/2;
	     int y = (getHeight() - image.getHeight((ImageObserver) this))/2;
	     g2d.drawImage(image, x, y, (ImageObserver) this);
	     g2d.setTransform(origXform);
	   }

	   private int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Dimension getPreferredSize() {
	     return new Dimension (image.getWidth((ImageObserver) this), image.getHeight((ImageObserver) this));
	   }

//	private JLabel labelWhitImg;
//
//	// costructur that demands a label and save it to a local label.
//	public MessageListener(JLabel labelWhitImg) {
//		System.out.println(" e ");
//		UserInterFace.Pixel();
//		this.labelWhitImg = labelWhitImg;
//	}
//
//	// this change image to file and set label to image
//	private void changeImage() {
//		System.out.println(" d ");
//		// create a new image but calls anohet image
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("6.jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(" c ");
//		labelWhitImg.setIcon(new ImageIcon(image));
//	}
//
//	private void setSize(int i, int j) {
//		System.out.println(" b");
//		labelWhitImg.setSize(i, j);
//	}
//	
//	private String getActionCommand() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}


}