package card1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

//build interface and get the method run 
public class UserInterFace implements Runnable {

	private JFrame mainFrame;
	private Container mainContentPane;

	public UserInterFace() {
		// empty constructur for now every init is inside run
	}

	// this start is a override loop a interface of the frame
	@Override
	public void run() {
		// this is the whole frame is created and this is Image
		this.mainFrame = new JFrame("Image");
		// the exit button in the right corner in the frame
		this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// this is the size on the frame
		this.mainFrame.setPreferredSize(new Dimension(1000, 500));
		// the content say what you can do in the program and that is on the frame
		this.mainContentPane = this.mainFrame.getContentPane();
		// color of frame
		this.mainContentPane.setBackground(Color.gray);
		// the boxLayout get the buttons from up to down
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		createComponents(mainFrame.getContentPane());
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(1, 3);
		container.setLayout(layout);
		// create a image that will be used in the hole program
		BufferedImage image = null;
		try {
			// read the file and get it to image
			image = ImageIO.read(new File("./card1/1.jpg"));
			// if the file is not found throw an exception
		} catch (IOException e) {
			e.printStackTrace();
		}
		// do it to a icon ImageIcon and put it in a JLabel that is a textArea "bound
		// the image here".
		JLabel img = new JLabel(new ImageIcon(image));
		// put the image in to our container
		container.add(img);
		// this is used to do some result in some action when the button is pushed.
		JButton button1 = new JButton("Get the image to rotate");

		// copier get over and over an look if it has happened
		MessageListener copier1 = new MessageListener(img, image);
		button1.addActionListener(copier1);
		button1.setActionCommand("rotate");
		// the changeImage is inside this actionListener and that is an expender
		container.add(button1);

		JButton button2 = new JButton("Change size");
		MessageListener copier2 = new MessageListener(img, image);
		button2.addActionListener(copier2);
		button2.setActionCommand("resize");
		container.add(button2);

		JButton button3 = new JButton("Get it black and white");
		MessageListener copier3 = new MessageListener(img, image);
		button3.addActionListener(copier3);
		button3.setActionCommand("black");
		container.add(button3);
	}

	public JFrame getFrame() {
		return mainFrame;
	}

}