package local;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display extends Canvas{
	
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 1000;
	public static final int BOX_WIDTH = 50;
	
	public boolean tankAppearFlag = false;
	public int[][] map = null;

	private BufferedImage grass;
	private BufferedImage wall;
	private BufferedImage circle;
	
	public Display()
	{	
		JFrame frame = new JFrame();	//wait for new class extending JFrame
		JLabel lbPlayer1 = new JLabel("Player 1");
		
		lbPlayer1.setSize(200, 50);
		lbPlayer1.setLocation(1000, 50);
		frame.add(lbPlayer1);
		loadImages();

		
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		try {
			tankAppearFlag = true;
			this.update(this.getGraphics());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		frame.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(10, 10, 950, 950);
		
		try 
		{
			map = ReadData.readFromFile("resource/map.txt");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Graphics2D g2d = (Graphics2D) g;
		for(int j=0; j<19; j++)
		{
			for(int i=0; i<19; i++)
			{
				if(map[j][i] == '0')
				{
					g2d.drawImage(grass,  10 + i * BOX_WIDTH, 10 + j * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH, null);

				}
				else if(map[j][i] == '1')
				{
					//g.setColor(new Color(0xff, 0x8c, 0x00));
					g2d.drawImage(grass, 10 + i * BOX_WIDTH, 10 + j * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH, null);
				}
				else if(map[j][i] == '2')
				{
					//g.setColor(new Color(0x44, 0x44, 0x44));
					g2d.drawImage(wall, 10 + i * BOX_WIDTH, 10 + j * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH, null);
				}
				else;
				
				//g.fillRect(10 + i * BOX_WIDTH, 10 + j * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH);
			}
		}
		if(tankAppearFlag)
		{
			g2d.drawImage(circle, 10 + 5 * BOX_WIDTH, 10 + 15 * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH, null);
//			try {
//				g.drawImage(ImageIO.read(new File("resource/circle.png")), 10 + 5 * BOX_WIDTH, 10 + 15 * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH, null);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public void loadImages() {
		try {
			grass = ImageIO.read(new File("resource/grass.jpg"));
			wall = ImageIO.read(new File("resource/wall.jpg"));
			circle = ImageIO.read(new File("resource/circle.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Graphics g)
	{
		this.paint(g);
	}
	
	public void addTank(Tank tank)
	{
		
	}
}
