package programmering2;

import java.awt.GridLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import programmering2.Exempel.boxListen2;

public class JeweerleryPanel implements ActionListener{
	JFrame frame = new JFrame();
	JFrame faulty = new JFrame();
	JPanel panel = new JPanel();
	JTextField nameTxtField = new JTextField(8);
	JTextField rocksTxtField = new JTextField(4);
	JCheckBox goldCheckbox = new JCheckBox();
	JButton ok= new JButton("OK");
	JButton cancel = new JButton("Cancel");
	JButton okClose = new JButton("OK");

	
	Jewelery j = new Jewelery("a", 1, false);
	
	public JewelereryPanel(){

		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Namn:");
		namePanel.add(nameLabel);
		namePanel.add(nameTxtField);
		
		JPanel rocksPanel = new JPanel();
		JLabel rocksLabel = new JLabel("Stenar");
		rocksPanel.add(rocksLabel);
		rocksPanel.add(rocksTxtField);
		
		JPanel goldPanel = new JPanel();
		JLabel goldLabel = new JLabel("Av guld");
		goldPanel.add(goldLabel);
		goldPanel.add(goldCheckbox);
		
		GridLayout grid = new GridLayout(4, 1);
		frame.setLayout(grid);
		frame.add(namePanel);
		frame.add(rocksPanel);
		frame.add(goldPanel);
		
		JPanel btnPanel = new JPanel();
		ok.addActionListener(this);
		cancel.addActionListener(this);
		btnPanel.add(ok);
		btnPanel.add(cancel);
		frame.add(btnPanel);

		frame.setSize(200, 150);
		frame.setVisible(true);	
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	
	public void addJewelery(){
		
		if (nameTxtField.getText()!=null && isInteger(rocksTxtField.getText())){
			Jewelery k = new Jewelery(nameTxtField.getText(), Integer.parseInt(rocksTxtField.getText()), goldCheckbox.isSelected());
			frame.dispose();
		}
		
		else {
			
			JLabel errorMsg = new JLabel("Felaktig inmatning");
			
			GridLayout grid = new GridLayout(2, 1);
			faulty.setLayout(grid);
			JPanel top = new JPanel();
			top.add(errorMsg);
			JPanel bottom = new JPanel();
			bottom.add(okClose);
			okClose.addActionListener(this);
			faulty.add(top);
			faulty.add(bottom);
			faulty.setSize(200, 200);
			faulty.setVisible(true);	
		}
	}
	
	public void goBack(){
		frame.dispose();
	}
	
	public void actionPerformed(ActionEvent event){

			if(event.getSource() == ok){
				addJewelery();
			}
			
			else if(event.getSource() == cancel){
				goBack();
			}
			
			else if (event.getSource() == okClose){
				faulty.dispose();
			}
		}

	
	public boolean isInteger(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e){
			return false;	
		}
	}
	
	public boolean isDouble(String s){
		try{
			Double.parseDouble(s);
			return true;	
		}
		catch (NumberFormatException e){
			return false;	
		}
	}	
	
	public Jewelery getJewelery(){
		return j;
	}
}
