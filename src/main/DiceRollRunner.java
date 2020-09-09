package main;

public class DiceRollRunner {
	
	static DiceView view = new DiceView();
	
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.createAndShowGUI();
            }
        });
	}


}
