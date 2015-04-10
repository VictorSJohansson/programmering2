package programmering2;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Exempel extends JFrame {

    private String[] types = {"Smycke", "Aktie", "Apparat"};

    private String type = null;

    private JPanel top = new JPanel();
    private JPanel mainRightPanel = new JPanel();
    private JPanel mainInsideRight = new JPanel();
    private JPanel mainRightBottom = new JPanel();
    private JPanel mainBottom = new JPanel();

    private JLabel label1 = new JLabel("Nytt:");
    private JLabel sort = new JLabel("Sortering");
    private JLabel title = new JLabel("Värdesaker");

    private JTextArea txtInfo = new JTextArea(14, 30);
    private JScrollPane scroll = new JScrollPane(txtInfo);

    private JButton show = new JButton("Visa");
    private JButton crash = new JButton("Börskrasch");

    private ButtonGroup group = new ButtonGroup();
    private JRadioButton showName = new JRadioButton("Namn");
    private JRadioButton showPrice = new JRadioButton("Värde");
    private JButton ok = new JButton("OK");

    private ArrayList<Valuable> valuables = new ArrayList<Valuable>();
    private JComboBox box = new JComboBox<String>(types);


    Exempel() {
        super("Sakregister");
        doExempel();
        addItems();
    }

    public void addItems() {
        Jewelery j1 = new Jewelery("j1", 5, true);
        Jewelery j2 = new Jewelery("j2", 3, false);
        Jewelery j3 = new Jewelery("j3", 0, false);

        Apparatus a1 = new Apparatus("a1", 20.50, 5);
        Apparatus a2 = new Apparatus("a2", 50.40, 2);
        Apparatus a3 = new Apparatus("a3", 10.30, 8);

        Stock s1 = new Stock("s1", 200, 50.10);
        Stock s2 = new Stock("s2", 120, 10.50);
        Stock s3 = new Stock("s3", 100, 40.50);


        valuables.add(j1);
        valuables.add(j2);
        valuables.add(j3);
        valuables.add(a1);
        valuables.add(a2);
        valuables.add(a3);
        valuables.add(s1);
        valuables.add(s2);
        valuables.add(s3);

    }

    public void doExempel() {



        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(top, BorderLayout.CENTER);
        top.add(title);
        top.add(scroll);

		/*Välj sortering */

        add(mainInsideRight, BorderLayout.EAST);

        GridLayout layout = new GridLayout(8, 1);
        mainInsideRight.setLayout(layout);

        mainInsideRight.add(sort);
        mainInsideRight.add(showName);
        mainInsideRight.add(showPrice);
        mainInsideRight.add(mainRightBottom, BorderLayout.SOUTH);

        group.add(showName);
        group.add(showPrice);

		/*Lägg till ny värdesak*/

        add(mainBottom, BorderLayout.SOUTH);
        mainBottom.add(label1);
        mainBottom.add(box);
        box.addActionListener(new boxListen());

		/*Visa på sortering eller börskrasch*/
        mainBottom.add(show);
        show.addActionListener(new boxListen2());
        mainBottom.add(crash);
        crash.addActionListener(new stockExchangeCrashButton());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430, 300);
        setVisible(true);
        setLocation(700, 300);
    }


    public void addValuable() {

        if (type.equals("Aktie")) {
            stockPanel();
        } else if (type.equals("Smycke")) {
            jeweleryPanel();
        } else if (type.equals("Apparat")) {
            apparatusPanel();
        }
    }
    

    /* ------------- JewelleryPanel --------------------*/

        public void jeweleryPanel() {
        	boolean isValid=false;
        	String name=null;
        	int rocks =0;
        	boolean isGold=false;
        	while (isValid==false){
        		JPanel form = new JPanel();
        		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        	
        		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        		JPanel row1 = new JPanel();
        		JTextField nfield = new JTextField(10);
        		row1.add(new JLabel("Namn:"));
        		row1.add(nfield);
        		form.add(row1);
        	
        		JPanel row2 = new JPanel();
        		JTextField numfield = new JTextField(10);
        		row2.add(new JLabel("Stenar:"));
        		row2.add(numfield);
        		form.add(row2);
        	
        		JPanel row3 = new JPanel();
        		JCheckBox cBox = new JCheckBox();
        		row3.add(cBox);
        		row3.add(new JLabel("Av guld:"));
        		form.add(row3);
        		
        		try{
        			int svar=JOptionPane.showConfirmDialog(null, form, "Smycke", JOptionPane.OK_CANCEL_OPTION);
        			if (svar==JOptionPane.YES_OPTION){
        				name = nfield.getText();
        				rocks = Integer.parseInt(numfield.getText());
        				isGold = cBox.isSelected();
        				Valuable v= new Jewelery(name, rocks, isGold);
        				valuables.add(v);
        				break;
        			}
        			else break;
        		}catch(NumberFormatException e){
        			JOptionPane.showMessageDialog(null, "Fel inmatning", "Felmeddelande", JOptionPane.ERROR_MESSAGE);	
        		}
        	}
 
    }

	/* ------------- StockPanel --------------------*/


    public void stockPanel() {
        	boolean isValid=false;
        	String name=null;
        	int quantity =0;
        	double price=0;
        	while (isValid==false){
        		JPanel form = new JPanel();
        		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        	
        		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        		JPanel row1 = new JPanel();
        		JTextField nfield = new JTextField(10);
        		row1.add(new JLabel("Namn:"));
        		row1.add(nfield);
        		form.add(row1);
        	
        		JPanel row2 = new JPanel();
        		JTextField numfield = new JTextField(10);
        		row2.add(new JLabel("Antal:"));
        		row2.add(numfield);
        		form.add(row2);
        	
        		JPanel row3 = new JPanel();
        		JTextField pfield = new JTextField(10);
        		row3.add(new JLabel("Kurs:"));
        		row3.add(pfield);
        		form.add(row3);
        		try{
        			int svar=JOptionPane.showConfirmDialog(null, form, "Aktie", JOptionPane.OK_CANCEL_OPTION);
        			if (svar==JOptionPane.YES_OPTION){
        		name = nfield.getText();
        		quantity = Integer.parseInt(numfield.getText());
        		price = Double.parseDouble(pfield.getText());
        		Valuable v= new Stock(name, quantity, price);
        		valuables.add(v);
        		break;
        			}
        			else break;
        		}catch(NumberFormatException e){
        			JOptionPane.showMessageDialog(null, "Fel inmatning", "Felmeddelande", JOptionPane.ERROR_MESSAGE);	
        		}
        	}
 
    }

	/* ------------- ApparatusPanel --------------------*/

            public void apparatusPanel() {
            	boolean isValid=false;
            	String name=null;
            	int price =0;
            	int wear=0;
            	while (isValid==false){
            		JPanel form = new JPanel();
            		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
            	
            		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
            		JPanel row1 = new JPanel();
            		JTextField nfield = new JTextField(10);
            		row1.add(new JLabel("Namn:"));
            		row1.add(nfield);
            		form.add(row1);
            	
            		JPanel row2 = new JPanel();
            		JTextField pfield = new JTextField(10);
            		row2.add(new JLabel("Pris:"));
            		row2.add(pfield);
            		form.add(row2);
            	
            		JPanel row3 = new JPanel();
            		JTextField wfield = new JTextField(10);
            		row3.add(new JLabel("Slitage:"));
            		row3.add(wfield);
            		form.add(row3);
            		
            		
            		try{
            			int svar=JOptionPane.showConfirmDialog(null, form, "Apparat", JOptionPane.OK_CANCEL_OPTION);
            			if (svar==JOptionPane.YES_OPTION){
            			name = nfield.getText();
            			price = Integer.parseInt(pfield.getText());
            				if (Integer.parseInt(wfield.getText())>=1 && Integer.parseInt(wfield.getText())<=9){
            					wear = Integer.parseInt(wfield.getText());
            					Valuable v= new Apparatus(name, price, wear);
            					valuables.add(v);
            					break;
            				}
            			}
            			else if(svar==JOptionPane.CANCEL_OPTION){ 
            				break;
            			}
            		else {
            			JOptionPane.showMessageDialog(null, "Fel inmatning", "Felmeddelande", JOptionPane.ERROR_MESSAGE);
            		}
            		}catch(NumberFormatException e){
            			JOptionPane.showMessageDialog(null, "Fel inmatning", "Felmeddelande", JOptionPane.ERROR_MESSAGE);	
            		}
            	}
        }


	
	/*---------------INDATA KONTROLL ---------------*/


    class boxListen2 implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == show) {
                txtInfo.setText("");
                if (showName.isSelected()) {
                    Collections.sort(valuables, new Comparator<Valuable>() {
                        @Override
                        public int compare(Valuable o1, Valuable o2) {

                            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());

                        }

                        @Override
                        public boolean equals(Object obj) {
                            return false;
                        }
                    });
                    for (Valuable v : valuables) {
                        txtInfo.append(v.toString() + "\n");
                    }
                } else if (showPrice.isSelected()) {
                    Collections.sort(valuables, new Comparator<Valuable>() {
                        @Override
                        public int compare(Valuable o1, Valuable o2) {
                            if (o1.value() > o2.value()) {
                                return 1;
                            } else if (o1.value() < o2.value()) {
                                return -1;
                            }
                            return 0;
                        }

//                            @Override
//                            public boolean equals (Object obj){
//                                return false;
//                            }


                    });
                    for (Valuable v : valuables) {
                        txtInfo.append(v.toString() + "\n");
                    }

                } else {
                    for (Valuable v : valuables) {
                        txtInfo.append(v.toString() + "\n");
                    }
                }

            }
        }
    }

    class boxListen implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == box) {
                type = (String) box.getSelectedItem();
                addValuable();
            } else if (event.getSource() == ok) {

            }
        }
    }

    class stockExchangeCrashButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == crash) {
                for (Valuable v : valuables) {
                    if (v instanceof Stock) {
                        ((Stock) v).setPrice(0.0);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Exempel();
    }
}