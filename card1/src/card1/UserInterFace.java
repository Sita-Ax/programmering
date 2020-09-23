package card1;

import java.awt.Color;
import java.awt.Container;
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
		this.mainFrame.setSize(450, 450);
		// the content say what you can do in the game and that is on the frame
		this.mainContentPane = this.mainFrame.getContentPane();
		// color of frame
		this.mainContentPane.setBackground(Color.gray);
		// the boxLayout get the buttons from up to down
		// //docs.oracle.com/javase/tutorial/uiswing/layout/box.html
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		// to it aging
		createComponents(mainFrame.getContentPane());
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	private void createComponents(Container container) {
		// do a grid and give it 3 rows and 2 columbs
		GridLayout layout = new GridLayout(3, 2);
		container.setLayout(layout);

		// create a image that kan inte göra så mycket med
		BufferedImage image = null;
		try {
			// read the file and get it to image
			image = ImageIO.read(new File("7.jpg"));
			// if the file is not found throw an exception
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bounds the picture into label, create a icon that is inside the label
		JLabel labelWhitImg = new JLabel(new ImageIcon(image));
		// put it in the pane
		container.add(labelWhitImg);
		// dont get the string whit textarea but label
		JButton button1 = new JButton("Get the picture");
		// copier get over and over an look if it has happend
		MessageListener copier1 = new MessageListener(labelWhitImg);
		button1.setActionCommand("Get the picture");

		JButton button2 = new JButton("Change size");
		MessageListener copier2 = new MessageListener(labelWhitImg);
		button2.setActionCommand("Change size");

		JButton button3 = new JButton("Get another picture");
		MessageListener copier3 = new MessageListener(labelWhitImg);
		button3.setActionCommand("Get another picture");

		JButton button4 = new JButton("Get the picture in black and white");
		MessageListener copier4 = new MessageListener(labelWhitImg);
		button4.setActionCommand("Get the picture in black and white");

		JButton button5 = new JButton("Get the first picture");
		MessageListener copier5 = new MessageListener(labelWhitImg);
		button4.setActionCommand("Get the first picture");

		// the changeImage is inside this actionListener and that is an expender
		button1.addActionListener(copier1);
		button2.addActionListener(copier2);
		button3.addActionListener(copier3);
		button4.addActionListener(copier4);
		button5.addActionListener(copier5);
		//
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		container.add(button5);
	}
	public JFrame getFrame() {
		return mainFrame;
	}
}
