package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class DiceView {
	
	JLabel result;
	JTextField sides;
    JTextField amount;
    JTextField diff;
    JLabel succ;
    JCheckBox tensdouble;
	JCheckBox highestagain;
	JCheckBox explode;
	private Dimension minText = new Dimension(20,20);
	
	
	public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("DiceRoller - Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_START;
        // main dice setup line
        JPanel dpanel= new JPanel();
        dpanel.setLayout(new BoxLayout(dpanel,BoxLayout.LINE_AXIS));
        dpanel.setPreferredSize(new Dimension(300, 20));
        JLabel roll = new JLabel("Roll ");
        JLabel d = new JLabel(" d ");
        sides = new JTextField(3);
        sides.setMinimumSize(minText);
        amount = new JTextField(4);
        amount.setMinimumSize(minText);
        dpanel.add(roll);
        dpanel.add(amount);
        dpanel.add(d);
        dpanel.add(sides);
      //  dpanel.add(Box.createHorizontalGlue());
        mainPanel.add(dpanel,c);
        // roll button
        JButton start = new JButton("Roll");
        start.addActionListener(new DiceRoller(this));
        c.gridx+=2;
        c.gridy++;
        c.weightx=1;
        mainPanel.add(start,c);
        c.weightx=0;
        // options
        diff = new JTextField("0",3);
        diff.setMinimumSize(minText);
        JLabel difflabel = new JLabel("Difficulty: ");
        c.gridx=0;
        c.gridy+=1;
        mainPanel.add(difflabel,c);
        c.gridx++;
        mainPanel.add(diff,c);
        JLabel opt = new JLabel("<html> <u> Options </u></html>");
        c.gridx=0;
        c.gridy++;
        c.anchor=GridBagConstraints.CENTER;
        mainPanel.add(opt,c);
        c.anchor=GridBagConstraints.LINE_START;
        tensdouble=new JCheckBox("Count tens double.");
        highestagain= new JCheckBox("Roll dice that show the highest possible result again.");
        explode=new JCheckBox("and add the number rolled to previous result");
        c.gridy++;
        mainPanel.add(tensdouble,c);
        c.gridy++;
        mainPanel.add(highestagain,c);
        c.gridy++;
        c.anchor=GridBagConstraints.LINE_END;
        mainPanel.add(explode,c);
        c.gridy++;
        c.anchor=GridBagConstraints.LINE_START;
        // result display
        
        JPanel respane =new JPanel();
        BoxLayout reslay = new BoxLayout(respane, BoxLayout.LINE_AXIS);
        respane.setLayout(reslay);
        respane.setPreferredSize(new Dimension(450, 60));
        c.gridx=0;
        c.gridy++;
        c.fill=GridBagConstraints.BOTH;
        c.weighty=1;
        c.gridwidth=GridBagConstraints.REMAINDER;
        mainPanel.add(respane,c);
       
        result = new JLabel("nothing yet");
        JScrollPane scroll = new JScrollPane(result);
        scroll.setPreferredSize(new Dimension(400,60));
        respane.add(scroll);
       // respane.add(Box.createHorizontalGlue());
        respane.add(Box.createRigidArea(new Dimension(10,0)));
        succ = new JLabel("0");
        succ.setAlignmentX(Component.RIGHT_ALIGNMENT);
        respane.add(succ);
        JLabel succtext = new JLabel(" successes");
        succtext.setAlignmentX(Component.RIGHT_ALIGNMENT);
        succtext.setHorizontalAlignment(SwingConstants.RIGHT);
        respane.add(succtext);
        respane.add(Box.createRigidArea(new Dimension(10,0)));
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	



}
