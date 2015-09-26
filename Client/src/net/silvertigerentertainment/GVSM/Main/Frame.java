package net.silvertigerentertainment.GVSM.Main;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;


public class Frame extends JFrame{
	
	public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Frame(){
		
		GraphicsDevice d = GraphicsEnvironment
			    .getLocalGraphicsEnvironment().getDefaultScreenDevice();
			if (d.isFullScreenSupported()) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setUndecorated(true);
			    setResizable(false);
			    init();
			    addFocusListener(new FocusListener() {

			        @Override
			        public void focusGained(FocusEvent arg0) {
			            setAlwaysOnTop(true);
			        }

			        @Override
			        public void focusLost(FocusEvent arg0) {
			            setAlwaysOnTop(false);
			        }
			    });
			    d.setFullScreenWindow(this);
			} else {
				setTitle("Gnomes vs Monsters");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				init();
				setVisible(true);
			}
	}
	Screen screen = new Screen();
	
	public void init(){
		add(screen);
		addKeyListener(new Listener());
		//setFocusable(true);
	}
	
	public static void main(String args[]) {
		Frame frame = new Frame();
	}
	
}
