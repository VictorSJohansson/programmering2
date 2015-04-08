package programmering2;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Exempel extends JFrame{
	
	String[] types={"Smycke", "Aktie", "Apparat"};
	String chosen=null;
	String type=null;
	String tempStr1=null;
	String tempStr2=null;
	
	JPanel top = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel insideRight= new JPanel();
	JPanel rightBottom= new JPanel();
	JPanel bottom = new JPanel();
	
	JLabel test= new JLabel();
	JLabel chosenLabel= new JLabel("Inget valt");
	JLabel sort = new JLabel("Sortering");
	
	JCheckBox checkbox= new JCheckBox();
	JButton ok= new JButton("OK");
	JButton cancel = new JButton("Cancel");
	
	JTextField field1=new JTextField(8);
	JTextField field2=new JTextField(8);
	JTextField field3=new JTextField(8);
	String field1Str=field1.getText();
	
	
	ArrayList<Stock> valuables= new ArrayList<Stock>();
	JComboBox box = new JComboBox<String>(types);
	

	
	Exempel(){
		
		/*Text area*/
		JLabel label1 = new JLabel("Nytt:");
		
		JButton show = new JButton("Visa");
		JButton crash= new JButton("Börskrasch");
		JTextArea txtInfo = new JTextArea(30,25);
		ButtonGroup group = new ButtonGroup();
		JRadioButton showName = new JRadioButton("Namn");
		JRadioButton showPrice = new JRadioButton("Pris");
			
		add (top, BorderLayout. WEST);
		top.add(txtInfo);
		
		/*Välj sortering */

		add(rightPanel, BorderLayout.EAST);
	
		
		GridLayout layout = new GridLayout(3, 1);
		insideRight.setLayout(layout);
		
		rightPanel.add(insideRight);
		
		insideRight.add(sort);


		insideRight.add(showName);
		
		insideRight.add(rightBottom, BorderLayout.SOUTH);

		
		group.add(showName);
		group.add(showPrice);
		rightBottom.add(showPrice);
		
		/*Lägg till ny värdesak*/
		
		add(bottom, BorderLayout.SOUTH);
		bottom.add(label1);
		bottom.add(box);
		box.addActionListener(new boxListen());
		
		/*Visa sortering eller börskrasch*/
		bottom.add(show);
		bottom.add(crash);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
		
	}
	
	public void addValuable(String type){
		
		/*Måla om fönstret*/
		remove(top);
		remove(bottom);
		remove(rightPanel);
		remove(insideRight);
		remove(rightBottom);

		GridLayout grid = new GridLayout(4, 1);
		setLayout(grid);
		
		JLabel name=new JLabel("Namn:");
		JLabel str = new JLabel(tempStr1);
		
		if (type.equals("Aktie")){
			tempStr1="Antal:";
			tempStr2="Kurs:";
		}
		
		else if (type=="Smycke"){
			tempStr1="Stenar:";
		}
		
		else if (type=="Apparat"){
			tempStr1="Pris";
			tempStr2="Slitage";
			
		}
		
		add(name);
		add(field1);
		add(str);
		add(field2);

		
		if (type=="Smycke"){
			add(checkbox);
			JLabel gold= new JLabel("Av guld");
			add(gold);
			
		}
		
		else {
			
			JLabel str2 = new JLabel(tempStr2);
			add(str2);
			add(field3);
		}
		

		
		boxListen2 box2 = new boxListen2();
		ok.addActionListener(box2);
		add(ok);
		add(cancel);

		setSize(200, 150);
		setVisible(true);
		

		
	}
	
	
	class boxListen2 implements ActionListener{
		
		
		public void actionPerformed(ActionEvent ave){
			
			JFrame frame = new JFrame();
			boolean validInput=false;
			
			if (isInteger(field2.getText())){
				
				int i=Integer.parseInt(field2.getText());
				
				if (type.equals("Aktie")){
					if(isDouble(field3.getText())){
						
						double d = Double.parseDouble(field3.getText());
						Stock stock = new Stock(field1.getText(), i, d);
						validInput=true;
					}
				}
			
				else if (type.equals("Smycke")){
					
					Jewelery jewel = new Jewelery(field1.getText(), i, checkbox.isSelected());
				}
				
				else if (type.equals("Apparat")){
					
					if(isInteger(field3.getText())){
						int j=Integer.parseInt(field3.getText());
						if(j>=1 && j<=10){
							Apparatus apparat = new Apparatus(field1.getText(), i, j);
							validInput=true;
						}
					}
				}
			}
			
			if(validInput==false){
			
				GridLayout grid = new GridLayout(2,1);
				test.setText("Felaktig inmatning");
				frame.add(test);
				JPanel btnPanel = new JPanel();
				btnPanel.add(ok);
				frame.add(btnPanel);
				frame.setLayout(grid);
				frame.setSize(200, 100);
				frame.setVisible(true);
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
		
		/*public boolean isString(String s){
			
		}*/
	
	}
	
	

	class boxListen implements ActionListener{
		public void actionPerformed(ActionEvent ave){
			chosen=(String)box.getSelectedItem();
			
			type=chosen;
			addValuable(chosen);
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
	
	}
