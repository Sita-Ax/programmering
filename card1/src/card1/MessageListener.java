package card1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MessageListener implements ActionListener {

	private JLabel labelWhitImg;
	static JLabel labelWhitChange = new JLabel(new ImageIcon("2.jpg"));

	//costructur that demands a label  and save it to a local label.
	public MessageListener(JLabel labelWhitImg) {
		this.labelWhitImg = labelWhitImg;
	}

	//this change image to file and set label to image 
		private void changeImage() {
			//create a new image but calls anohet image
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File("1.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			labelWhitImg.setIcon(new ImageIcon(image));
		}
		
		private void setSize(int i, int j) {
			labelWhitImg.setSize(i, j);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// this is a new picture
		changeImage();
		//this is what happens if the user press the button always when the button is pressed
		if (e.getActionCommand()== "Get the picture ") {
			//the labels send the info to actionlistener in user
			labelWhitImg.setIcon(new ImageIcon("1.jpg"));
			}
		if (e.getActionCommand()== "Change size") {
			setSize(400, 400);
			labelWhitImg.setIcon(new ImageIcon("1S.jpg"));
			}
		if (e.getActionCommand()== "Get another picture") {
			labelWhitImg.setIcon(new ImageIcon("2.jpg"));
			}
		if (e.getActionCommand()== "Get the picture in black and white") {
			labelWhitImg.setIcon(new ImageIcon("1BW.jpg"));
			}
		if (e.getActionCommand()== "Get the first picture") {
			labelWhitImg.setIcon(new ImageIcon("7.jpg"));
			}
		}
}
