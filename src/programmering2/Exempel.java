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
	
	JPanel btnPanel = new JPanel();
	JPanel top = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel insideRight= new JPanel();
	JPanel rightBottom= new JPanel();
	JPanel bottom = new JPanel();
	JLabel name=new JLabel("Namn:");
	JLabel str = new JLabel();
	JLabel label1 = new JLabel("Nytt:");
	
	JLabel str2 = new JLabel(tempStr2);
	JLabel test= new JLabel();
	JLabel chosenLabel= new JLabel("Inget valt");
	JLabel sort = new JLabel("Sortering");
	
	JTextArea txtInfo = new JTextArea(30,25);
	
	JCheckBox checkbox= new JCheckBox();

	JTextField field1=new JTextField(8);
	JTextField field2=new JTextField(8);
	JTextField field3=new JTextField(8);
	String field1Str=field1.getText();
	
	JButton show = new JButton("Visa");
	JButton crash= new JButton("Börskrasch");
	
	ButtonGroup group = new ButtonGroup();
	JRadioButton showName = new JRadioButton("Namn");
	JRadioButton showPrice = new JRadioButton("Pris");
	JButton ok= new JButton("OK");
	JButton ok2= new JButton("OK");
	JButton cancel = new JButton("Cancel");
	
	
	
	ArrayList<Valuable> valuables= new ArrayList<Valuable>();
	JComboBox box = new JComboBox<String>(types);
	

	
	Exempel(){
		doExempel();
	}
		public void doExempel(){
		removeAll();

		add(top, BorderLayout.WEST);
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
		
		/*Visa på sortering eller börskrasch*/
		bottom.add(show);
		bottom.add(crash);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	
	public void addValuable(String type){
		
		/*Måla om fönstret*/
		removeAll();
		GridLayout grid = new GridLayout(4, 1);
		setLayout(grid);
		
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
		str.setText(tempStr1);
		add(str);
		add(field2);

		if (type=="Smycke"){
			add(checkbox);
			JLabel gold= new JLabel("Av guld");
			add(gold);	
		}
		
		else {
			
			str2.setText(tempStr2);
			add(str2);
			add(field3);
		}
		
		boxListen2 box2 = new boxListen2();
		ok.addActionListener(box2);
		add(ok);
		cancel.addActionListener(new boxListen2());
		add(cancel);

		setSize(200, 150);
		setVisible(true);	
	}
	
	public void removeAll(){

		remove(btnPanel);
		remove(top);
		remove(rightPanel);
		remove(insideRight);
		remove(rightBottom);
		remove(bottom);
		remove(name);
		remove(str);
		
		remove(str2);
		remove(test);
		remove(chosenLabel);
		remove(sort);
		
		remove(checkbox);
		remove(ok);
		remove(ok2);
		remove(cancel);
		
		remove(field1);
		remove(field2);
		remove(field3);
		
		remove(show);
		remove(crash);
		remove(txtInfo);
		
		remove(showName);
		remove(showPrice);
		remove(label1);

	}
	
	
	class boxListen2 implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event){
			
			if (event.getSource() == ok){
				
				boolean validInput=false;
			
				if (field1!=null){
					if (isInteger(field2.getText())){
				
						int i=Integer.parseInt(field2.getText());
				
						if (type.equals("Aktie")){
							if(isDouble(field3.getText())){
						
								double d = Double.parseDouble(field3.getText());
								Stock stock = new Stock(field1.getText(), i, d);
								valuables.add(stock);
								validInput=true;
							}
						}
			
						else if (type.equals("Smycke")){
						
							Jewelery jewel = new Jewelery(field1.getText(), i, checkbox.isSelected());
							valuables.add(jewel);
							validInput=true;
						}
				
						else if (type.equals("Apparat")){
					
							if(isInteger(field3.getText())){
								int j=Integer.parseInt(field3.getText());
								if(j>=1 && j<=10){
									Apparatus apparat = new Apparatus(field1.getText(), i, j);
									valuables.add(apparat);
									validInput=true;
								}
							}
						}
					}
				}
			
				if(validInput==false){
					removeAll();
					
					
					GridLayout grid = new GridLayout(2,1);
					test.setText("Felaktig inmatning");
					add(test);
					
					btnPanel.add(ok2);
					ok2.addActionListener(new boxListen2());
					add(btnPanel);
					setLayout(grid);
					setSize(200, 100);
					setVisible(true);
				}
			}
			
			else if (event.getSource()==ok2){
				removeAll();
				
				addValuable(type);
			}
			
			else if(event.getSource()==cancel){
				removeAll();
				doExempel();
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
	}

	class boxListen implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == box){
				chosen=(String)box.getSelectedItem();
				type=chosen;
				addValuable(chosen);
				}
			
			else if(event.getSource() == ok){
				
			}
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
}