package programmering2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFrame;

import programmering2.Exempel.boxListen2;

public class StockPanel {
	
	JPanel panel = new JPanel();
	
	public StockPanel(){
		
		JFrame frame = new JFrame();
		
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Namn:");
		JTextField nameTxtField = new JTextField(8);
		namePanel.add(nameLabel);
		namePanel.add(nameTxtField);
		
		JPanel quantityPanel = new JPanel();
		JLabel quantityLabel = new JLabel("Kurs");
		JTextField quantityTxtField = new JTextField(4);
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityTxtField);
		
		
		JPanel pricePanel = new JPanel();
		JLabel priceLabel = new JLabel("Pris");
		JTextField priceTxtField = new JTextField(4);
		pricePanel.add(priceLabel);
		pricePanel.add(priceTxtField);
		
		GridLayout grid = new GridLayout(4, 1);
		frame.setLayout(grid);
		frame.add(namePanel);
		frame.add(quantityPanel);
		frame.add(pricePanel);


		frame.setSize(200, 150);
		frame.setVisible(true);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
