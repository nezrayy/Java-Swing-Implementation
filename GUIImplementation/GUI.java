package GUIImplementation;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Nama     : Rayhan Fanez Fathiadi
 * NIM      : 221524027
 * Kelas    : 1A - TI4
 */
public class GUI extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JLabel title = new JLabel("APLIKASI PEMESANAN");

    /* Panels */
    private JPanel customerPanel = new JPanel(null);
    private JPanel pricePanel = new JPanel(null);
    private JPanel outputPanel = new JPanel(null);
    private JPanel menuPanel = new JPanel(new GridLayout(3, 2));

    /* Special font */
    private Font calibriBold = new Font("Calibri", Font.BOLD, 25);

    /* Customer panel */
    JLabel nameLabel = new JLabel("Nama:");
    JLabel addressLabel = new JLabel("Alamat:");
    JLabel phoneLabel = new JLabel("No Telp:");
    JTextField nameTField = new JTextField();
    JTextField addressTField = new JTextField();
    JTextField phoneTField = new JTextField(20);

    /* Menu panel */
    JLabel stLabel = new JLabel("Steak");
    JLabel spLabel = new JLabel("Spaghetti");
    JLabel pzLabel = new JLabel("Pizza");
    JCheckBox stCBox = new JCheckBox();
    JCheckBox spCBox = new JCheckBox();
    JCheckBox pzCBox = new JCheckBox();

    /* Total price panel */
    JLabel totalLabel = new JLabel("TOTAL PEMBAYARAN");
    JTextArea priceBox = new JTextArea();
    JButton addBtn = new JButton("Tambah");

    /* Output panel */
    JTextArea outputBox = new JTextArea();

    /* Order property */
    private String name, address, phone, outputText;
    private double totalPay = 0;
    private DecimalFormat dcf = new DecimalFormat("###,###.###");

    public void MyFrame() {

        /* Frame setting */
        frame.setSize(600, 680);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Aplikasi Pemesanan");
        title.setBounds(180, 0, 500, 100);
        title.setFont(calibriBold);
        frame.add(title);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Adding components to frame */
        Customer();
        frame.add(customerPanel);
        Menu();
        frame.add(menuPanel);
        Price();
        frame.add(pricePanel);
        Output();
        frame.add(outputPanel);

        /* Visibility */
        frame.setVisible(true);
        customerPanel.setVisible(true);
        menuPanel.setVisible(true);
        pricePanel.setVisible(true);
        outputPanel.setVisible(true);
    }

    public void Customer() {

        /* Panel setting */
        customerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Data Pemesan"));
        customerPanel.setBounds(30, 70, 350, 180);

        /* Labels for customer */
        nameLabel.setBounds(20, 30, 100, 20); // menentukan posisi dan ukuran label
        customerPanel.add(nameLabel);

        addressLabel.setBounds(20, 80, 100, 20); // menentukan posisi dan ukuran label
        customerPanel.add(addressLabel);

        phoneLabel.setBounds(20, 130, 100, 20); // menentukan posisi dan ukuran label
        customerPanel.add(phoneLabel);

        /* Textfields */
        nameTField.setBounds(80, 30, 150, 22); // menentukan posisi dan ukuran label
        customerPanel.add(nameTField);
        name = nameTField.getText();

        addressTField.setBounds(80, 80, 150, 22); // menentukan posisi dan ukuran label
        customerPanel.add(addressTField);
        address = nameTField.getText();

        phoneTField.setBounds(80, 130, 150, 22); // menentukan posisi dan ukuran
        customerPanel.add(phoneTField);
        phone = phoneTField.getText();

        customerPanel.revalidate();
    }

    public void Menu() {

        /* Panel setting */
        menuPanel.setBounds(400, 120, 155, 130);
        menuPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Pilih Menu"));

        /* Adding component to panel in order */
        menuPanel.add(stCBox);
        stCBox.addActionListener(this);
        menuPanel.add(stLabel);
        menuPanel.add(spCBox);
        spCBox.addActionListener(this);
        menuPanel.add(spLabel);
        menuPanel.add(pzCBox);
        pzCBox.addActionListener(this);
        menuPanel.add(pzLabel);

        menuPanel.revalidate();
    }

    public void Price() {

        pricePanel.setBounds(380, 265, 175, 120);

        /* Label */
        totalLabel.setBounds(0, 0, 150, 30);
        pricePanel.add(totalLabel);

        /* Textfield */
        priceBox.setFont(calibriBold);
        priceBox.setBackground(Color.BLACK);
        priceBox.setForeground(Color.YELLOW);
        priceBox.setBounds(2, 40, 168, 30);
        priceBox.setEditable(false);
        priceBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pricePanel.add(priceBox);

        /* Buttons */
        pricePanel.add(addBtn);
        addBtn.setBounds(90, 80, 80, 30);
        addBtn.addActionListener(this);

        pricePanel.revalidate();
    }

    public void Output() {

        /* Panel setting */
        outputPanel.setBounds(30, 400, 520, 200);
        outputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Data Penjualan"));

        /* Text area */
        outputBox.setBounds(10, 20, 500, 165);
        outputBox.setEditable(true);
        outputPanel.add(outputBox);
    }

    public void actionPerformed(ActionEvent e) {

        /* Getting text from textfields */
        name = nameTField.getText();
        address = addressTField.getText();
        phone = phoneTField.getText();

        outputText = "Nama: " + name + "\nAlamat: " + address + "\nNo. Telp: " + phone + "\n------------------\n"
                + "Pesananmu:";

        /* Total payment */
        if (e.getSource() == addBtn) {
            totalPay = 0;
            if (stCBox.isSelected()) {
                outputText += "\nSteak = Rp. 75.000";
                totalPay += 75000;
            }
            if (spCBox.isSelected()) {
                outputText += "\nSpaghetti = Rp. 40.000";
                totalPay += 40000;
            }
            if (pzCBox.isSelected()) {
                outputText += "\nPizza = Rp. 80.000";
                totalPay += 80000;
            }

            outputBox.setText(
                    outputText + "\n------------------\nTotal bayar: Rp. " + dcf.format(totalPay));
            priceBox.setText(dcf.format(totalPay));
        }
    }

    public static void main(String[] args) {
        GUI app = new GUI();
        app.MyFrame();
    }

}
