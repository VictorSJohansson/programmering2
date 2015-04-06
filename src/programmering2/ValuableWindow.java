package programmering2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ValuableWindow extends JFrame implements ActionListener {
	
	//Vet inte om vi behöver använda en egen klass till när man behöver lägga in nya värdesaker
	//men lämnar denna då det kan finnas kod att återanvända.
	
	JTextField field1=new JTextField(8);
	JTextField field2=new JTextField(8);
	JTextField field3=new JTextField(8);
	JCheckBox checkbox= new JCheckBox();
	String type="";
	String namn=null;

	
	JLabel test= new JLabel();
	
	
	public ValuableWindow(String type){
		this.type=type;
	}
		
	
	
	public Valuable getValuable(){
		
		JFrame frame = new JFrame();
		
		
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
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel name=new JLabel("Namn:");
		frame.add(name);
		frame.add(field1);
		JLabel str = new JLabel(tempStr1);
		frame.add(str);
		frame.add(field2);
		
		if (type=="Smycke"){
			frame.add(checkbox);
			JLabel gold= new JLabel("Av guld");
			frame.add(gold);
			
		}
		
		else {
			
			JLabel str2 = new JLabel(tempStr2);
			frame.add(str2);
			frame.add(field3);
		}
		
		JButton ok= new JButton("OK");
		ok.addActionListener(this);
		add(ok);
		JButton cancel = new JButton("Cancel");
		add(cancel);
		add(test);
		
		
		setSize(200, 150);
		setVisible(true);
		
		Stock valuable = new Stock(namn, 1, 1.2);
		return valuable;
		
	}
	
	public void actionPerformed(ActionEvent ave){
		namn=field1.getText();
		test.setText(namn + " testar " + type);
		
	}

}
