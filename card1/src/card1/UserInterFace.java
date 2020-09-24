package card1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//build interface and get the method run
public class UserInterFace implements Runnable {

	private JFrame mainFrame;
	private Container mainContentPane;

	// this start is a override loop a interface of the frame
	@Override
	public void run() {

		// this is the whole frame is created and this is memory
		this.mainFrame = new JFrame("Image");
		// the exit button in the right corner in the frame
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this is the size on the frame
		this.mainFrame.setSize(1000, 1000);
		// the content say what you can do in the game and that is on the frame
		this.mainContentPane = this.mainFrame.getContentPane();
		// color of frame
		this.mainContentPane.setBackground(Color.gray);
		// the boxLayout get the buttons from up to down
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		System.out.println(" 1 ");
		
		 Image testImage = Toolkit.getDefaultToolkit().getImage("6.jpg");
//		 final Image rotatePanel = new Image(testImage);
		 // to it aging
		try {
			createComponents(mainFrame.getContentPane());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	private void createComponents(Container container) throws IOException {
		// do a grid and give it 3 rows and 2 columbs
		GridLayout layout = new GridLayout(3, 2);
		container.setLayout(layout);
//		LoadImageApp img = new LoadImageApp();
		JLabel img = new JLabel();
//		img.image();
//		container.add(img);
		// create a image that kan inte göra så mycket med
		BufferedImage image = null;
		try {
			// read the file and get it to image
			image = ImageIO.read(new File("6.jpg"));
			// if the file is not found throw an exception
		} catch (IOException e) {
			e.printStackTrace();
		}

		// dont get the string whit textarea but label
		JButton button1 = new JButton("Get the image to rotate");
		button1.setBounds(5,5,150,150);
		// copier get over and over an look if it has happend
		MessageListener copier1 = new MessageListener(img);
		button1.setActionCommand("Get the image to rotate");

		JButton button2 = new JButton("Change size");
		button2.setBounds(5,5,150,150);
		MessageListener copier2 = new MessageListener(img);
		button2.setActionCommand("Change size");

		JButton button3 = new JButton("Get another picture");
		button3.setBounds(5,5,150,150);
		MessageListener copier3 = new MessageListener(img);
		button3.setActionCommand("Get another picture");

		// the changeImage is inside this actionListener and that is an expender
		button1.addActionListener(copier1);
		button2.addActionListener(copier2);
		button3.addActionListener(copier3);

		container.add(button1);
		container.add(button2);
		container.add(button3);
	}
	

	public static void Pixel() {
	      try {
	         File input = new File("6.jpg");
	         BufferedImage image = ImageIO.read(input);
	         int width = image.getWidth();
	         int height = image.getHeight();
	         
	         int count = 0;
	         
	         for(int i=0; i<height; i++) {
	         
	            for(int j=0; j<width; j++) {
	            
	               count++;
	               Color c = new Color(image.getRGB(j, i));
	               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	            }
	         }

	      } catch (Exception e) {}
	   }

//	private void resizeFile() {
//		File jpgOrginal = new File ("6.jpg");
//		File jpgResized = new File ("6.jpg");
//		System.out.println(" 3 ");
//		resizeImage(jpgOrginal, jpgResized, 400, 400, "jpg");
//		
//	}
//	void resizeImage(File jpgOrginal, File jpgResized, int width, int height, String string) {
//
//		try {
//			BufferedImage orginal = ImageIO.read(jpgOrginal);
//			BufferedImage resized = new BufferedImage(width, height, orginal.getType());
//			Graphics2D g2 = resized.createGraphics();
//			g2.drawImage(orginal,  0,  0,  width,  height,  null);
//			g2.dispose();
//			ImageIO.write(resized, "jpg", jpgResized);
//			System.out.println(" 4 ");
//			
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public JFrame getFrame() {
		return mainFrame;
	}
}