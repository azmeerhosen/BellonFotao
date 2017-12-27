package test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class drawing extends JPanel implements ActionListener {
	Random rand = new Random();
	int x1, y1;
	public int Color_belon = rand.nextInt(8);
	public int belonWidth = 50;
	public int belonHight = 100;
	public int Start_Angle = 0;
	public int Arc_Angle = 360;
	public int start_x = 15;
	public int start_y = 15;
	int x2;
	public int Color_belon2 = rand.nextInt(3);
	public int belonWidth2 = 50;
	public int belonHight2 = 70;
	public int start_x2 = 15;
	public int start_y2 = 15;

	int bn = 0;
	int level = 1;
	int fire = 0;
	int scr = 0;
	int scr1 = 0;
	int time = 5;
	public int life = 3;
	int belondelay = 1;
	int belondelay2 = 1;
	int buletdelay = 9;
	int frameHight = 650;
	int frameLength = 650;
	int bonduk_hight = 185;
	// int bulethight=
	// int bulet_srt_point= frameHight-(bonduk_hight+)
	int buletrn = frameHight - (start_y + belonHight + bonduk_hight);
	int belonfotrng = frameLength / 2 - (start_x + belonWidth);
	int belonfotrng2 = frameLength / 2 - (start_x2 + belonWidth2);

	public Timer timer;
	public JButton scrButton = new JButton(" Score board ");
	public JButton lbutton = new JButton("Life ");

	drawing() {
		//timer calu hobe ;

		x1 = -start_x - belonWidth - 10; // nirdisttho jayga theke belun gulu jabe 
		x2 = -start_x2 - belonWidth - 750;
		y1 = 0;

		timer = new Timer(time, this);
		

	}

	public void actionPerformed(ActionEvent timer) {
		//timer er kaj belun er x change and buleter y change,,, level onujayi x ba y er man briddi korbe ,, er jonno variable delay use korechi 
		if (bn >= 20 && bn < 50) {
			if (scr > 50) {
				belondelay = 2;
				level = 2;
			} else
				level = 0;
		} else if (bn >= 50) {
			if (scr > 130) {
				belondelay = 3;
				level = 3;

			} else
				level = 0;
		}

		if ((x1 > belonfotrng && x1 < belonfotrng + belonWidth)
				&& (y1 >= buletrn && y1 <= (buletrn + belonHight + start_y))) {
			new Addmusic().start();
			// if er vitore ja ache ei location a belun bulet ekotrito hoy tai ekta sound dibe plus score briddi pabe nicer man onujayi;
			x1 = 0;
			if (Color_belon == 0) {
				scr1 = 6;
			} else if (Color_belon == 1) {
				scr1 = 5;
				;

			} else if (Color_belon == 2) {
				scr1 = 4;// cyan
			} else if (Color_belon == 3) {
				scr1 = 3;// blue
			} else if (Color_belon == 4) {
				scr1 = -10;// black
			} else if (Color_belon == 5) {
				scr1 = 5;// pink
			} else if (Color_belon == 6) {
				scr1 = 2;// pink
			} else if (Color_belon == 7) {
				scr1 = 5;
			}
			scr = scr + scr1;
			scrButton.setText("Scores " + scr);
			lbutton.setText("Life " + life);
			Color_belon = rand.nextInt(6);
		} else if ((x2 > belonfotrng2 && x2 < belonfotrng2 + belonWidth2)
				&& (y1 >= buletrn && y1 <= (buletrn + belonHight + start_y))) {
			new Addmusic().start();
			//eta chotu belun er jonno .... er jonno  if er vitore ja ache ei location a belun bulet ekotrito hoy tai ekta sound dibe plus score briddi pabe nicer man onujayi;
			
			x2 = -start_x2 - belonWidth - 750;

			if (Color_belon2 == 0 && life < 5) {
				life++;
			} else if (Color_belon2 == 1) {
				life--;

			} else if (Color_belon2 == 2) {
				scr1 = 10;
			}
			scr = scr + scr1;
			scrButton.setText("Scores " + scr);
			lbutton.setText("Life " + life);
			Color_belon2 = rand.nextInt(3);
		} else if (x1 > frameLength - 250) {
			x1 = 0;
			scr1 = 0;
			Color_belon = rand.nextInt(6);

		} else if (x2 > frameLength - 100) {
			x2 = 0;

			Color_belon2 = rand.nextInt(3);

		}

		else {
			x1 += belondelay;
			x2 += belondelay2;
			fire = 0;
		}
		if (y1 > 0 && y1 < (frameHight - bonduk_hight)) {
			y1 += buletdelay;
		} else if (y1 >= (frameHight - bonduk_hight)) {
			y1 = 0;
		}
		if (x1 == start_x + 2) {

			bn++;
		}
		repaint();

	};

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (Color_belon == 0) {
			g.setColor(Color.GRAY);
		} else if (Color_belon == 1) {
			g.setColor(Color.ORANGE);
		} else if (Color_belon == 2) {
			g.setColor(Color.CYAN);
		} else if (Color_belon == 3) {
			g.setColor(Color.BLUE);
		} else if (Color_belon == 4) {
			g.setColor(Color.BLACK);
		} else if (Color_belon == 5) {
			g.setColor(Color.PINK);
		} else if (Color_belon == 6) {
			g.setColor(Color.YELLOW);
		} else if (Color_belon == 7) {
			g.setColor(Color.MAGENTA);
		}
		//drawing  belon,& x1 timer er maddhome change hoy tai belon x axis a bar bar drawq hocche ,, that means samne agacche  
		g.fillArc(start_x + x1, start_y, belonWidth, belonHight, Start_Angle,
				Arc_Angle);
		g.drawArc(start_x + x1 + 10, start_y + belonHight, 30, 80, Start_Angle,
				Arc_Angle - 180);
		g.drawLine(start_x + x1 + belonWidth / 2, start_y + belonHight, start_x
				+ x1 + belonWidth / 2, 160);

		if (fire == 1) {
			g.setColor(Color.YELLOW);
			Polygon fpolygon = new Polygon();// drawing ..a belun when bulet and belun are in same location eta na dileo hobe ;
			fpolygon.addPoint((frameLength - belonWidth) / 2, start_y - 10);
			fpolygon.addPoint((frameLength - belonWidth) / 2 - 10, belonHight
					/ 2 + start_y);
			fpolygon.addPoint(frameLength / 2, belonHight + start_y + 5);
			fpolygon.addPoint((frameLength + belonWidth) / 2 - 10, belonHight
					/ 2 + start_y);
			fpolygon.addPoint((frameLength + belonWidth) / 2, start_y - 10);
			fpolygon.addPoint(frameLength / 2, belonHight / 2 - 30);
			g.fillPolygon(fpolygon);
		}

		if (Color_belon2 == 0) {
			g.setColor(Color.GREEN);
		} else if (Color_belon2 == 1) {
			g.setColor(Color.RED);
		} else if (Color_belon2 == 2) {
			g.setColor(Color.DARK_GRAY);
		} //randomly color er jonno collor_belun2, er man change er sathe sathe drwaing ta color change hobe ;
		g.fillOval(start_x2 + x2, start_y2, belonWidth2, belonHight2);
		g.drawArc(start_x2 + x2 + 10, start_y2 + belonHight2, 30, 80,
				Start_Angle, Arc_Angle - 180);
		g.drawLine(start_x2 + x2 + belonWidth2 / 2, start_y2 + belonHight2,
				start_x2 + x2 + belonWidth2 / 2, 135);

		g.setColor(Color.MAGENTA);
		// drawing bonduk, etar kono axis e change hobe na 
		Polygon polygon = new Polygon();
		polygon.addPoint(frameHight / 2 - 8, frameLength - 160);// y
		polygon.addPoint(frameHight / 2 - 8, frameLength - 60);// x
		polygon.addPoint(frameHight / 2 + 52, frameLength - 60);// z
		polygon.addPoint(frameHight / 2 + 52, frameLength - 85);// a
		polygon.addPoint(frameHight / 2 + 12, frameLength - 85);// c
		polygon.addPoint(frameHight / 2 + 12, frameLength - 140);// d
		polygon.addPoint(frameHight / 2 + 7, frameLength - 140);// e
		polygon.addPoint(frameHight / 2 + 7, frameLength - 160);// b
		g.fillPolygon(polygon);
		g.setColor(Color.BLACK);
		g.drawLine(frameHight / 2 + 12, frameLength - 100, frameHight / 2 + 27,
				frameLength - 85);
		g.drawLine(frameHight / 2 + 12, frameLength - 85, frameHight / 2 + 17,
				frameLength - 95);
		g.setColor(Color.BLUE);// bonduk
		Polygon polygon3 = new Polygon();
		polygon3.addPoint(frameHight / 2 - 2, frameLength - 158);
		polygon3.addPoint(frameHight / 2 + 4, frameLength - 158);
		polygon3.addPoint(frameHight / 2 + 4, frameLength - 80);
		polygon3.addPoint(frameHight / 2 + 48, frameLength - 80);
		polygon3.addPoint(frameHight / 2 + 48, frameLength - 70);
		polygon3.addPoint(frameHight / 2 - 2, frameLength - 70);
		g.fillPolygon(polygon3);
		g.setColor(Color.YELLOW);// bulet
		Polygon polygon2 = new Polygon();
		polygon2.addPoint(frameHight / 2 - 6, frameLength - (165 + y1));// y"
		polygon2.addPoint(frameHight / 2 - 6, frameLength - (160 + y1));// y'
		polygon2.addPoint(frameHight / 2 + 6, frameLength - (160 + y1));// b'
		polygon2.addPoint(frameHight / 2 + 6, frameLength - (165 + y1));// b"
		polygon2.addPoint(frameHight / 2, frameLength - (185 + y1));// o
		g.fillPolygon(polygon2);

	}
}
