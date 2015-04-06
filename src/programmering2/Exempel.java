package programmering2;

import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Exempel extends JFrame{
	
	String[] types={"Smycke", "Aktie", "Apparat"};
	String chosen=null;
	JLabel label1 = new JLabel("Nytt:");
	JComboBox box = new JComboBox<String>(types);
	JButton show = new JButton("Visa");
	JButton crash= new JButton("Börskrasch");
	JTextArea txtInfo = new JTextArea(30,25);
	ButtonGroup group = new ButtonGroup();
	
	ArrayList<Stock> valuables= new ArrayList<Stock>();

	
	JLabel chosenLabel= new JLabel("Inget valt");
	
	Exempel(){
		JPanel top = new JPanel();
		add (top, BorderLayout. WEST);
		top.add(txtInfo);
		
		JPanel right = new JPanel();
		add(right, BorderLayout.EAST);
		JPanel rightTop= new JPanel();
		right.add(rightTop, BorderLayout.NORTH);
		JRadioButton showName = new JRadioButton("Namn");
		rightTop.add(showName);
		JPanel rightBottom= new JPanel();
		right.add(rightBottom, BorderLayout.SOUTH);
		JRadioButton showPrice = new JRadioButton("Pris");
		rightBottom.add(showPrice);
		
		
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.add(label1);
		bottom.add(box);
		box.addActionListener(new boxListen());

		bottom.add(show);
		
		bottom.add(crash);
		
		setSize(400, 300);
		setVisible(true);
		
		
	}
	
	public void addValuable(String type){
		ValuableWindow win = new ValuableWindow(type);
		win.getValuable();
		
	}
	
	/*------------------------------
		
		JTextField field1=new JTextField(8);
		JTextField field2=new JTextField(8);
		JTextField field3=new JTextField(8);
		JCheckBox checkbox= new JCheckBox();
		
		action
		
		JLabel test= new JLabel();
		String tempStr1="";
		String tempStr2="";
		
		
		if (type=="Aktie"){
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
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel name=new JLabel("Namn:");
		add(name);
		add(field1);
		JLabel str = new JLabel(tempStr1);
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
		
		JButton ok= new JButton("OK");
		ok.addActionListener(this);
		add(ok);
		JButton cancel = new JButton("Cancel");
		add(cancel);
		add(test);
		
		
		setSize(200, 150);
		setVisible(true);
		
	}
		
		
		
	}*/

	class boxListen implements ActionListener{
		public void actionPerformed(ActionEvent ave){
			chosen=(String)box.getSelectedItem();
			addValuable(chosen);
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
	/*
	class ValuableWindow{
		
		String type;
		Valuable valuable= new Valuable();
		
		ValuableWindow(String type){
			this.type=type;
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
	

	//---------------------------------------------------------------
	//---------------------------------------------------------------
	//---------------------------------------------------------------
	//---------------------------------------------------------------
/* class ValuableWindow extends JFrame implements ActionListener {
	
	JTextField field1=new JTextField(8);
	JTextField field2=new JTextField(8);
	JTextField field3=new JTextField(8);
	JCheckBox checkbox= new JCheckBox();
	String type="";
	
	JLabel test= new JLabel();
	
	
	ValuableWindow(String type){
		
		super (type);
		this.type=type;
		String tempStr1="";
		String tempStr2="";
		
		
		if (type=="Aktie"){
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
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel name=new JLabel("Namn:");
		add(name);
		add(field1);
		JLabel str = new JLabel(tempStr1);
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
		
		JButton ok= new JButton("OK");
		ok.addActionListener(this);
		add(ok);
		JButton cancel = new JButton("Cancel");
		add(cancel);
		add(test);
		
		
		setSize(200, 150);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ave){
		String name=field1.getText();
		int str2=Integer.parseInt(field2.getText());
		
		if (type=="Smycke"){
			boolean isGold=checkbox.isSelected();
			Valuable v4 = new Jewelery(name, str2, isGold);
		}
		
		else if (type=="Aktie"){
			int price=Integer.parseInt(field3.getText());
			Valuable v4 = new Stock(name, str2, price);
		}
		
		else if (type=="Apparatus"){
			int wear=Integer.parseInt(field3.getText());
			Valuable v4=new Apparatus(name, str2, wear);
			valuables.add(v4);
		}
		
	}

 
//public class Main {
 }	

}}

//}*/
	}
