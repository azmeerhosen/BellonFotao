package test;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Bonduk_Class extends JPanel {
	int frameHight = 650;
	int frameLength = 650;
	//JButton f = new JButton("fire");

	  // add(f);
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.MAGENTA);
		Polygon polygon = new Polygon();
		polygon.addPoint(frameHight / 2 - 10, frameLength - 150);// y
		polygon.addPoint(frameHight / 2 - 10, frameLength - 50);// x
		polygon.addPoint(frameHight / 2 + 50, frameLength - 50);// z
		polygon.addPoint(frameHight / 2 + 50, frameLength - 75);// a
		polygon.addPoint(frameHight / 2 + 10, frameLength - 75);// c
		polygon.addPoint(frameHight / 2 + 10, frameLength - 130);// d
		polygon.addPoint(frameHight / 2 + 5, frameLength - 130);// e
		polygon.addPoint(frameHight / 2 + 5, frameLength - 150);// b
		g.fillPolygon(polygon);
		g.drawLine(frameHight / 2 + 10, frameLength - 90, frameHight / 2 + 25,frameLength - 75);
		g.drawLine(frameHight / 2 + 10, frameLength - 75, frameHight / 2 + 15,frameLength - 85);
	}
}
