package card1;

import java.awt.Color;
import java.awt.Container;
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
	BufferedImage img;
	boolean evenClick = false;

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
			try {
				createComponents(mainFrame.getContentPane());
			} catch (IOException e) {

				e.printStackTrace();
			}
			mainFrame.pack();
			mainFrame.setVisible(true);
			Tutorial.getDefaultLocale();

	}

	private void createComponents(Container container) throws IOException {
		JLabel img = new JLabel();
		container.add(img);
		// create a image
		BufferedImage image = null;
		try {
			// read the file and get it to image
			image = ImageIO.read(new File("1.jpg"));
			// if the file is not found throw an exception
		} catch (IOException e) {
			e.printStackTrace();
		}

		// dont get the string whit textarea but label
		JButton button1 = new JButton("Get the image to rotate");
		button1.setBounds(20,20,150,150);
		// copier get over and over an look if it has happend
		MessageListener copier1 = new MessageListener(img);
		button1.addActionListener(copier1);

		JButton button2 = new JButton("Change size");
		button2.setBounds(20,20,150,150);
		MessageListener copier2 = new MessageListener(img);
		button2.addActionListener(copier2);

		JButton button3 = new JButton("Get another picture");
		button3.setBounds(20,20,150,150);
		MessageListener copier3 = new MessageListener(img);
		button3.addActionListener(copier3);

		// the changeImage is inside this actionListener and that is an expender
		container.add(button1);
		container.add(button2);
		container.add(button3);
		
	}
	
	public JFrame getFrame() {
		return mainFrame;
	}
		
	}