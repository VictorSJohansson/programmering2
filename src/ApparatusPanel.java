package programmering2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFrame;

import programmering2.Exempel.boxListen2;

public class ApparaertusPanel{
	
	JPanel panel = new JPanel();
	
	public ApparaterusPanel(){
		
		
		
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Namn:");
		JTextField nameTxtField = new JTextField(8);
		namePanel.add(nameLabel);
		namePanel.add(nameTxtField);
		
		
		JPanel pricePanel = new JPanel();
		JLabel priceLabel = new JLabel("Pris");
		JTextField priceTxtField = new JTextField(4);
		pricePanel.add(priceLabel);
		pricePanel.add(priceTxtField);
		
		JPanel wearPanel = new JPanel();
		JLabel wearLabel = new JLabel("Kurs");
		JTextField wearTxtField = new JTextField(4);
		wearPanel.add(wearLabel);
		wearPanel.add(wearTxtField);
		
		GridLayout grid = new GridLayout(4, 1);
		panel.setLayout(grid);
		panel.add(namePanel);
		panel.add(pricePanel);
		panel.add(wearPanel);
		
/*
		frame.setSize(200, 150);
		frame.setVisible(true);	*/
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
