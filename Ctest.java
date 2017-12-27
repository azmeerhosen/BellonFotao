package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ctest extends JFrame {

	public int frameHight = 650;
	public int frameLength = 650;
	int cnt2=0;
	drawing d = new drawing();
	Bonduk_Class b = new Bonduk_Class();

	JPanel nJPanel = new JPanel();
	public JButton button = new JButton("        Fire        ");
	public JButton lbutton = new JButton("Level ");

	public JButton fbutton = new JButton("Play");

	Ctest() {
		setTitle("Azmeer¦“!!!!");
		setSize(frameHight, frameLength);
	    setLayout(new BorderLayout());
		button.setPreferredSize(new Dimension(150,30));
		button.setBackground(Color.RED);
		
		lbutton.setPreferredSize(new Dimension(100,30));
		lbutton.setBackground(Color.CYAN);
		fbutton.setPreferredSize(new Dimension(120,30));
		fbutton.setBackground(Color.CYAN);
		d.lbutton.setPreferredSize(new Dimension(100,30));
		d.lbutton.setBackground(Color.PINK);
		d.scrButton.setPreferredSize(new Dimension(120,30));
		d.scrButton.setBackground(Color.ORANGE);

		add(d);
		nJPanel.add(d.lbutton);
		nJPanel.add(fbutton);
		nJPanel.add(button);
		nJPanel.add(lbutton);
		nJPanel.add(d.scrButton);
		add(nJPanel, BorderLayout.SOUTH);
	
		setLocation(10, 10);
		setVisible(true);
		d.timer.stop();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt2<1)
				{
					button.setText("Fire");
				}
				
				if (d.y1 < 3) {
					d.y1 = 1;
					
					if(d.timer.isRunning()){
					new Addmusic1().start();}// fire buton a clik korle timer calu hobe and ekta sound dibe 
					

				}
				if (d.life < 1) {
					d.timer.stop();//life sonno hole timer off hoye jabe redrawing off hoye jabe 
					d.scrButton.setText("Scores " + d.scr);
					add(d.scrButton, BorderLayout.CENTER);

					button.setText("U Cn,t Fire");

				} else if (d.life > 0) {
					d.lbutton.setText("Life " + d.life);

					d.scrButton.setText("Scores " + d.scr);

					lbutton.setText("Level " + d.level);
				}
				if (d.level == 2) {

					d.scrButton.setText("Scores " + d.scr);

					lbutton.setText("Level 2" );

				}
				else if (d.level == 3) {

					d.scrButton.setText("Scores " + d.scr);

					lbutton.setText("Level 3");

				} else if (d.level == 0) {
					d.timer.stop();
					d.scrButton.setText("Scores " + d.scr);
					add(d.scrButton, BorderLayout.CENTER);

					button.setText("U cannot fire anymore");
					lbutton.setText("Level failed");
				}

			}
		});

		fbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt2++;
				
				
				
				//timer stop kore pause kora hocche , and start kore play kora hocche 

               
				if (!d.timer.isRunning() && d.life >= 1&&d.level>0) {
					d.timer.start();
					fbutton.setText("Pause");
				} else {
					d.timer.stop();
					fbutton.setText(" Play");
				}
				setBackground(Color.BLUE);

			}
		});
	}

	public static void main(String[] args) {

		new Ctest();
	 

	}
}
