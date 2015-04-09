package programmering2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Exempel extends JFrame {

    private String[] types = {"Smycke", "Aktie", "Apparat"};

    private String type = null;
    private String tempStr1 = null;
    private String tempStr2 = null;

    private JPanel btnPanel = new JPanel();
    private JPanel top = new JPanel();
    private JPanel mainRightPanel = new JPanel();
    private JPanel mainInsideRight = new JPanel();
    private JPanel mainRightBottom = new JPanel();
    private JPanel mainBottom = new JPanel();

    private JLabel str = new JLabel();
    private JLabel label1 = new JLabel("Nytt:");

    private JLabel str2 = new JLabel();
    private JLabel test = new JLabel();
    private JLabel chosenLabel = new JLabel("Inget valt");
    private JLabel sort = new JLabel("Sortering");

    private JTextArea txtInfo = new JTextArea(30, 25);

    private JCheckBox checkbox = new JCheckBox();

    private JButton show = new JButton("Visa");
    private JButton crash = new JButton("Börskrasch");

    private ButtonGroup group = new ButtonGroup();
    private JRadioButton showName = new JRadioButton("Namn");
    private JRadioButton showPrice = new JRadioButton("Pris");
    private JButton ok = new JButton("OK");
    private JButton ok2 = new JButton("OK");
    private JButton cancel = new JButton("Cancel");

    private ArrayList<Valuable> valuables = new ArrayList<Valuable>();
    private JComboBox box = new JComboBox<String>(types);


    Exempel() {
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
        crash.addActionListener(new stockExchangeCrashButton());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocation(700, 300);
    }


    public void addValuable() {

        if (type.equals("Aktie")) {
            StockPanel sP = new StockPanel();
        } else if (type.equals("Smycke")) {
            JeweleryPanel jP = new JeweleryPanel();
        } else if (type.equals("Apparat")) {
            ApparatusPanel aP = new ApparatusPanel();
        }
    }

    /* ------------- JewelleryPanel --------------------*/

    class JeweleryPanel implements ActionListener {
        private JFrame frame = new JFrame();
        private JFrame faulty = new JFrame();
        private JPanel panel = new JPanel();
        private JTextField nameTxtField = new JTextField(8);
        private JTextField rocksTxtField = new JTextField(4);
        private JCheckBox goldCheckbox = new JCheckBox();
        private JButton ok = new JButton("OK");
        private JButton cancel = new JButton("Cancel");
        private JButton okClose = new JButton("OK");


        public JeweleryPanel() {

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

        public void addJewelery() {

            if (nameTxtField.getText() != null && isInteger(rocksTxtField.getText())) {
                Valuable k = new Jewelery(nameTxtField.getText(), Integer.parseInt(rocksTxtField.getText()), goldCheckbox.isSelected());
                valuables.add(k);
                frame.dispose();
            } else {

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

        public void goBack() {
            frame.dispose();
        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == ok) {
                addJewelery();
            } else if (event.getSource() == cancel) {
                goBack();
            } else if (event.getSource() == okClose) {
                faulty.dispose();
            }
        }
    }

	/* ------------- StockPanel --------------------*/


    class StockPanel implements ActionListener {
        private JFrame frame = new JFrame();
        private JFrame faulty = new JFrame();
        private JPanel panel = new JPanel();
        private JTextField nameTxtField = new JTextField(8);
        private JTextField quantityTxtField = new JTextField(4);
        private JTextField priceTxtField = new JTextField(4);
        private JButton ok = new JButton("OK");
        private JButton cancel = new JButton("Cancel");
        private JButton okClose = new JButton("OK");

        public StockPanel() {

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

        public void addStock() {

            if (nameTxtField.getText() != null && isDouble(priceTxtField.getText())) {
                if (isInteger(quantityTxtField.getText())) {
                    Valuable q = new Stock(nameTxtField.getText(), Integer.parseInt(quantityTxtField.getText()), Double.parseDouble(priceTxtField.getText()));
                    valuables.add(q);
                    frame.dispose();
                }
            } else {

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

        public void goBack() {
            frame.dispose();
        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == ok) {
                addStock();
            } else if (event.getSource() == cancel) {
                goBack();
            } else if (event.getSource() == okClose) {
                faulty.dispose();
            }
        }
    }

	/* ------------- ApparatusPanel --------------------*/

    class ApparatusPanel implements ActionListener {
        private JFrame frame = new JFrame();
        private JFrame faulty = new JFrame();
        private JPanel panel = new JPanel();
        private JTextField nameTxtField = new JTextField(8);
        private JTextField priceTxtField = new JTextField(4);
        private JTextField wearTxtField = new JTextField(4);
        private JButton ok = new JButton("OK");
        private JButton cancel = new JButton("Cancel");
        private JButton okClose = new JButton("OK");


        public ApparatusPanel() {

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

        public void addApparatus() {

            if (nameTxtField.getText() != null && isInteger(priceTxtField.getText())) {
                if (isInteger(wearTxtField.getText())) {
                    if (Integer.parseInt(wearTxtField.getText()) >= 1 && Integer.parseInt(wearTxtField.getText()) <= 9) {
                        Valuable b = new Apparatus(nameTxtField.getText(), Integer.parseInt(priceTxtField.getText()), Integer.parseInt(wearTxtField.getText()));
                        valuables.add(b);
                        frame.dispose();
                    }
                }
            } else {

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

        public void goBack() {
            frame.dispose();
        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == ok) {
                addApparatus();
            } else if (event.getSource() == cancel) {
                goBack();
            } else if (event.getSource() == okClose) {
                faulty.dispose();
            }
        }
    }


	
	/*---------------INDATA KONTROLL ---------------*/

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    class boxListen2 implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == show) {
                txtInfo.setText("");
                if (showName.isSelected()) {
                    Collections.sort(valuables, new Comparator<Valuable>() {
                        @Override
                        public int compare(Valuable o1, Valuable o2) {

                            return o1.getName().compareTo(o2.getName());

                        }

                        @Override
                        public boolean equals(Object obj) {
                            return false;
                        }
                    });
                    for (Valuable v : valuables) {
                        txtInfo.append(v.toString() + "\n");
                    }
                } else {
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
                }

            }
        }
    }

    class boxListen implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == box) {
                type = (String) box.getSelectedItem();
                //removeAll();
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

    class SortingRadioButtons implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (showName.isSelected()) {
                Collections.sort(valuables, new Comparator<Valuable>() {
                    @Override
                    public int compare(Valuable o1, Valuable o2) {

                        return o1.getName().compareTo(o2.getName());

                    }

                    @Override
                    public boolean equals(Object obj) {
                        return false;
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        new Exempel();
    }
}