package programmering2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class ValuableWindow extends JFrame {
	
	JPanel name = new JPanel();
	JLabel nameLabel = new JLabel();
	JTextField nameTxtField = new JTextField();
	
	public ValuableWindow (String s){
		nameLabel.setText(s);
	}
	
	public String getNameField(){
		return nameTxtField.getText();
	}
}
