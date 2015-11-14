package test;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class Main extends JPanel{

	private static JPanel panel;
	 static Dot dot = new Dot(100, 50, 10);
	 
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		panel = new JPanel();
		SetBindings.setBindings();
		JFrame frame = new JFrame("KeyBindings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 600);
		frame.add(panel);
		frame.add(new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				setBackground(Color.white);
			}
		}) ;
		frame.setVisible(true);
		frame.setFocusable(true);
		

	}

	private static class SetBindings{
		private static InputMap inputMap;
		private static ActionMap actionMap;
		private static void setBindings(){
			inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
			actionMap = panel.getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RightArrowPressed");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LeftArrowPressed");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0,false), "UpArrowPressed");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0,false), "DownArrowPressed");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightArrowReleased");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0,true), "LeftArrowReleased");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpArrowReleased");
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownArrowReleased");


			actionMap.put("LeftArrowPressed", new ArrowAction("LeftArrowPressed"));
			actionMap.put("UpArrowPressed", new ArrowAction("UpArrowPressed"));
			actionMap.put("DownArrowPressed", new ArrowAction("DownArrowPressed"));
			actionMap.put("RightArrowReleased", new ArrowAction("RightArrowReleased"));
			actionMap.put("LeftArrowReleased", new ArrowAction("LeftArrowReleased"));
			actionMap.put("UpArrowReleased", new ArrowAction("UpArrowReleased"));
			actionMap.put("DownArrowReleased", new ArrowAction("DownArrowReleased"));
			actionMap.put("RightArrowPressed", new ArrowAction("RightArrowPressed"));

		}
	}

	static class ArrowAction extends AbstractAction {
		private String cmd;
		public ArrowAction(String cmd) {
			this.cmd = cmd;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (cmd){
			case "LeftArrowPressed":
				System.out.println("The left arrow was pressed!");
				break;
			case "LeftArrowReleased":
				System.out.println("The left arrow was released!");
				break;
			case "RightArrowReleased":
				System.out.println("The right arrow was released!");
                dot.setY(40);
                dot.repaint();
				break;
			case "RightArrowPressed":
				System.out.println("The right arrow was pressed!");
				break;
			case "UpArrowPressed":
				System.out.println("The up arrow was pressed!");
				break;
			case "UpArrowReleased":
				System.out.println("The up arrow was released!");
				break;
			case "DownArrowPressed":
				System.out.println("The down arrow was pressed!");
				break;
			case "DownArrowReleased":
				System.out.println("The down arrow was released!");
				break;

			} 
		}
	}

	
}
