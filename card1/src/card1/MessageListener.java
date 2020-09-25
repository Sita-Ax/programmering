package card1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MessageListener implements ActionListener {
	
	private JLabel img;

	public MessageListener(JLabel img) throws IOException {
		JLabel theImage = new JLabel();
		this.img = img;
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage image = ImageIO.read(new File("6.jpg"));
		JPanel panel = new JPanel(new GridLayout(1, 0));
//		panel.add(new JLabel(new ImageIcon(colored(image, new Color(0, 240, 0, 32)))));
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
		   }

	@Override
	public void actionPerformed(ActionEvent e) {
		changeImage();
	}

	private void changeImage() {
		BufferedImage image = null;
		try {
			// read the file and get it to image
			image = ImageIO.read(new File("6.jpg"));
			// if the file is not found throw an exception
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.setIcon((Icon) img);
	}

}