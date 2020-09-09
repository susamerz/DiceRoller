package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRoller implements ActionListener {
	
	private DiceView view;
	private Random rand = new Random();

	public DiceRoller(DiceView view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		int successes =0;
		String rString = "<html>";
		int dx=Integer.parseInt(view.sides.getText());
		int limit = Integer.parseInt(view.diff.getText());
		String am=view.amount.getText();
		for (int i=1;i<=Integer.parseInt(am);i++){
			int r=rand.nextInt(dx);
			r++;
			if (r==dx && view.highestagain.isSelected())
			{
				 if (view.explode.isSelected()){
					 int add=(rand.nextInt(dx)+1);
					 r=r+add;
					 while (add==dx){
						 add=rand.nextInt(dx)+1;
						 r=r+add;
						 }
					 }
				 else {i--;}
			}
			if (r>= limit){
				rString= rString+"<font color=green>"+r+" </font>";
				successes++;
				if (r==10&&view.tensdouble.isSelected()){successes++;}
					
			}
			
			else {
				rString= rString+"<font color=red>"+r+" </font>";
			}
			if (i%20==0){
				rString=rString+"<br>";
			}
		}
		rString=rString+" </html>";
		view.result.setText(rString);
		view.succ.setText(Integer.toString(successes));	

	}

}
