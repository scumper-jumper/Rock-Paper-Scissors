package rockPaperScissor;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				GUIClass rockPaperScissorGUI = new GUIClass();
				rockPaperScissorGUI.setVisible(true);
			}
			
		});

	}

}
