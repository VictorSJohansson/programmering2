package programmering2;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Exempel extends JFrame{
	
	String[] types={"Smycke", "Aktie", "Apparat"};

	String type=null;
	String tempStr1=null;
	String tempStr2=null;
	
	JPanel btnPanel = new JPanel();
	JPanel top = new JPanel();
	JPanel mainRightPanel = new JPanel();
	JPanel mainInsideRight= new JPanel();
	JPanel mainRightBottom= new JPanel();
	JPanel mainBottom = new JPanel();

	JLabel str = new JLabel();
	JLabel label1 = new JLabel("Nytt:");
	
	JLabel str2 = new JLabel();
	JLabel test= new JLabel();
	JLabel chosenLabel= new JLabel("Inget valt");
	JLabel sort = new JLabel("Sortering");
	
	JTextArea txtInfo = new JTextArea(30,25);
	
	JCheckBox checkbox= new JCheckBox();

	
	JButton show = new JButton("Visa");
	JButton crash= new JButton("Börskrasch");
	
	ButtonGroup group = new ButtonGroup();
	JRadioButton showName = new JRadioButton("Namn");
	JRadioButton showPrice = new JRadioButton("Pris");
	JButton ok= new JButton("OK");
	JButton ok2= new JButton("OK");
	JButton cancel = new JButton("Cancel");
	
	Jewelery j;
	Stock s;
	Apparatus a;
	
	ArrayList<Valuable> valuables= new ArrayList<Valuable>();
	JComboBox box = new JComboBox<String>(types);
	

	
	Exempel(){
		doExempel();
	}
		public void doExempel(){
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		add(top, BorderLayout.WEST);
		top.add(txtInfo);
		
		/*Välj sortering */

		add(mainRightPanel, BorderLayout.EAST);

		GridLayout layout = new GridLayout(3, 1);
		mainInsideRight.setLayout(layout);
		
		mainRightPanel.add(mainInsideRight);
		
		mainInsideRight.add(sort);

		mainInsideRight.add(showName);
		
		mainInsideRight.add(mainRightBottom, BorderLayout.SOUTH);

		
		group.add(showName);
		group.add(showPrice);
		mainRightBottom.add(showPrice);
		
		/*Lägg till ny värdesak*/
		
		add(mainBottom, BorderLayout.SOUTH);
		mainBottom.add(label1);
		mainBottom.add(box);
		box.addActionListener(new boxListen());
		
		/*Visa på sortering eller börskrasch*/
		mainBottom.add(show);
		show.addActionListener(new boxListen2());
		mainBottom.add(crash);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	
	public void addValuable(){
		
		if (type.equals("Aktie")){
			StockPanel sP = new StockPanel();
		}
		
		else if (type.equals("Smycke")){
			
			JeweleryPanel jP = new JeweleryPanel();			
		}
		
		else if (type.equals("Apparat")){
			ApparatusPanel aP = new ApparatusPanel();
		}
	}
	
	class JeweleryPanel implements ActionListener{
		JFrame frame = new JFrame();
		JFrame faulty = new JFrame();
		JPanel panel = new JPanel();
		JTextField nameTxtField = new JTextField(8);
		JTextField rocksTxtField = new JTextField(4);
		JCheckBox goldCheckbox = new JCheckBox();
		JButton ok= new JButton("OK");
		JButton cancel = new JButton("Cancel");
		JButton okClose = new JButton("OK");

		
		//Jewelery j = new Jewelery("a", 1, false);
		
		public JeweleryPanel(){

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

		public void addJewelery(){
			
			if (nameTxtField.getText()!=null && isInteger(rocksTxtField.getText())){
				Jewelery k = new Jewelery(nameTxtField.getText(), Integer.parseInt(rocksTxtField.getText()), goldCheckbox.isSelected());
				valuables.add(k);
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
	}
	/* ------------- StockPanel --------------------*/
	
	class StockPanel implements ActionListener{
		JFrame frame = new JFrame();
		JFrame faulty = new JFrame();
		JPanel panel = new JPanel();
		JTextField nameTxtField = new JTextField(8);
		JTextField quantityTxtField = new JTextField(4);
		JTextField priceTxtField = new JTextField(4);
		JButton ok= new JButton("OK");
		JButton cancel = new JButton("Cancel");
		JButton okClose = new JButton("OK");

		
		//Jewelery j = new Jewelery("a", 1, false);
		
		public StockPanel(){

			JPanel namePanel = new JPanel();
			JLabel nameLabel = new JLabel("Namn:");
			namePanel.add(nameLabel);
			namePanel.add(nameTxtField);
			
			JPanel quantityPanel = new JPanel();
			JLabel quantityLabel = new JLabel("Antal:");
			quantityPanel.add(quantityLabel);
			quantityPanel.add(quantityTxtField);
			
			JPanel pricePanel = new JPanel();
			JLabel priceLabel = new JLabel("Pris:");
			pricePanel.add(priceLabel);
			pricePanel.add(priceTxtField);
			
			GridLayout grid = new GridLayout(4, 1);
			frame.setLayout(grid);
			frame.add(namePanel);
			frame.add(quantityPanel);
			frame.add(pricePanel);
			
			JPanel btnPanel = new JPanel();
			ok.addActionListener(this);
			cancel.addActionListener(this);
			btnPanel.add(ok);
			btnPanel.add(cancel);
			frame.add(btnPanel);

			frame.setSize(200, 150);
			frame.setVisible(true);	
		}
	
		public void addStock(){
			
			if (nameTxtField.getText()!=null && isInteger(priceTxtField.getText())){
				if (isInteger(quantityTxtField.getText())){
					Stock q = new Stock(nameTxtField.getText(), Integer.parseInt(quantityTxtField.getText()), Integer.parseInt(priceTxtField.getText()));
					valuables.add(q);
					frame.dispose();
					}
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
					addStock();
				}
				
				else if(event.getSource() == cancel){
					goBack();
				}
				
				else if (event.getSource() == okClose){
					faulty.dispose();
				}
			}
	}
	
	/* ------------- ApparatusPanel --------------------*/
	
	class ApparatusPanel implements ActionListener{
		JFrame frame = new JFrame();
		JFrame faulty = new JFrame();
		JPanel panel = new JPanel();
		JTextField nameTxtField = new JTextField(8);
		JTextField priceTxtField = new JTextField(4);
		JTextField wearTxtField = new JTextField(4);
		JButton ok= new JButton("OK");
		JButton cancel = new JButton("Cancel");
		JButton okClose = new JButton("OK");

		
		public ApparatusPanel(){

			JPanel namePanel = new JPanel();
			JLabel nameLabel = new JLabel("Namn:");
			namePanel.add(nameLabel);
			namePanel.add(nameTxtField);
			
			JPanel pricePanel = new JPanel();
			JLabel priceLabel = new JLabel("Pris:");
			pricePanel.add(priceLabel);
			pricePanel.add(priceTxtField);
			
			JPanel wearPanel = new JPanel();
			JLabel wearLabel = new JLabel("Slitage:");
			wearPanel.add(wearLabel);
			wearPanel.add(wearTxtField);
			
			GridLayout grid = new GridLayout(4, 1);
			frame.setLayout(grid);
			frame.add(namePanel);
			frame.add(pricePanel);
			frame.add(wearPanel);
			
			JPanel btnPanel = new JPanel();
			ok.addActionListener(this);
			cancel.addActionListener(this);
			btnPanel.add(ok);
			btnPanel.add(cancel);
			frame.add(btnPanel);

			frame.setSize(200, 150);
			frame.setVisible(true);	
		}
	
		public void addApparatus(){
			
			if (nameTxtField.getText()!=null && isInteger(priceTxtField.getText())){
				if (isInteger(wearTxtField.getText())){
					if (Integer.parseInt(wearTxtField.getText())>=1 && Integer.parseInt(wearTxtField.getText())<=9){
						Apparatus b = new Apparatus(nameTxtField.getText(), Integer.parseInt(priceTxtField.getText()), Integer.parseInt(wearTxtField.getText()));
						valuables.add(b);
						frame.dispose();
						}
					}
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
					addApparatus();
				}
				
				else if(event.getSource() == cancel){
					goBack();
				}
				
				else if (event.getSource() == okClose){
					faulty.dispose();
				}
			}
	}
	
	/*---------------INDATA KONTROLL ---------------*/
	
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
	
	class boxListen2 implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event){
			
			if (event.getSource()==show){
				for(Valuable v : valuables){
					txtInfo.append(v.toString() + "\n");
				}
			}
		}
	}

	class boxListen implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == box){
				type=(String)box.getSelectedItem();
				//removeAll();
				addValuable();
				}
			
			else if(event.getSource() == ok){
				
			}
		}
	}
	
	public static void main (String[] args){
		new Exempel();
	}
}