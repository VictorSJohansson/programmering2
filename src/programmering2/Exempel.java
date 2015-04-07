package programmering2;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Exempel extends JFrame{
	
	String[] types={"Smycke", "Aktie", "Apparat"};
	String chosen=null;
	JPanel top = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel insideRight= new JPanel();
	JPanel rightBottom= new JPanel();
	JPanel bottom = new JPanel();
	
	JLabel test= new JLabel();
	
	ArrayList<Stock> valuables= new ArrayList<Stock>();
	JComboBox box = new JComboBox<String>(types);
	
	JLabel chosenLabel= new JLabel("Inget valt");
	
	Exempel(){
		
		/*Text area*/
		JLabel label1 = new JLabel("Nytt:");
		
		JButton show = new JButton("Visa");
		JButton crash= new JButton("Börskrasch");
		JTextArea txtInfo = new JTextArea(30,25);
		ButtonGroup group = new ButtonGroup();
			
		add (top, BorderLayout. WEST);
		top.add(txtInfo);
		
		/*Välj sortering */

		add(rightPanel, BorderLayout.EAST);
	
		
		GridLayout layout = new GridLayout(3, 1);
		insideRight.setLayout(layout);
		
		rightPanel.add(insideRight);
		JLabel sort = new JLabel("Sortering");
		insideRight.add(sort);
		
		JRadioButton showName = new JRadioButton("Namn");
		insideRight.add(showName);
		
		insideRight.add(rightBottom, BorderLayout.SOUTH);
		JRadioButton showPrice = new JRadioButton("Pris");
		
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
		
		
		JFrame frameTest = new JFrame();
		JLabel tester = new JLabel("Inne i addValuable");
		remove(top);
		remove(bottom);
		remove(insideRight);
		remove(rightBottom);
		
		add(tester);
		JPanel panel1 = new JPanel();
		JTextField field1=new JTextField(8);
		add(field1, BorderLayout.EAST);
		JTextField field2=new JTextField(8);
		JTextField field3=new JTextField(8);
		JCheckBox checkbox= new JCheckBox();
		String namn=null;
		//JLabel test= new JLabel();

		
		JFrame frame = new JFrame("Ny " + type);
		String tempStr1="hellu";
		String tempStr2="";
		
		
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
		
		frameTest.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel name=new JLabel("Namn:");
		frameTest.add(name);
		frameTest.add(field1);
		JLabel str = new JLabel(tempStr1);
		frameTest.add(str);
		frameTest.add(field2);
		
		if (type=="Smycke"){
			frameTest.add(checkbox);
			JLabel gold= new JLabel("Av guld");
			frameTest.add(gold);
			
		}
		
		else {
			
			JLabel str2 = new JLabel(tempStr2);
			frameTest.add(str2);
			frameTest.add(field3);
		}
		
		JButton ok= new JButton("OK");
		boxListen2 box2 = new boxListen2();
		ok.addActionListener(box2);
		frameTest.add(ok);
		JButton cancel = new JButton("Cancel");
		frameTest.add(cancel);
		frameTest.add(test);
		//box2.setType(type);
		
		
		setSize(500, 500);
		setVisible(true);
		
		Stock valuable = new Stock(namn, 1, 1.2);
		//return valuable;
		/*ValuableWindow win = new ValuableWindow(type);
		win.getValuable();*/
		
	}
	
	
	
	class boxListen2 implements ActionListener{
		
		private String typ;
		public void actionPerformed(ActionEvent ave){
			JFrame frame = new JFrame();
			
			if (typ.equals("Aktie")){
				test.setText("Är en aktie");
				
			}
			else if (typ.equals("Smycke")){
				test.setText("Är en aktie");
				
			}
			
			else {
				test.setText("Typ");
			}
			frame.add(test);
			frame.setSize(200, 50);
			frame.setVisible(true);
		}
		public void setType(String typ){
			
			this.typ=typ;
		}
	}
	
	

	class boxListen implements ActionListener{
		public void actionPerformed(ActionEvent ave){
			chosen=(String)box.getSelectedItem();
			
			addValuable(chosen);
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
	
	}
