/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producsalesgui;



import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingUtilities;

import javax.swing.SwingUtilities;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductApp() {

        setTitle("Product App");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        createMenu();

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 40, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(170, 40, 250, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 90, 120, 25);
        add(lblProduct);

        cmbProduct = new JComboBox<>();
        cmbProduct.addItem("Cozy Nights Monarch");
        cmbProduct.addItem("Restonic Barbados");
        cmbProduct.addItem("Sealy Phuket");
        cmbProduct.setBounds(170, 90, 250, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 140, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(170, 140, 250, 25);
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(170, 190, 250, 30);
        btnProcess.addActionListener(e -> processSale());
        add(btnProcess);

        setVisible(true);
    }

    private void processSale() {

        try {

            String customerName = txtCustomerName.getText();

            String product =
                    cmbProduct.getSelectedItem().toString();

            double price =
                    Double.parseDouble(txtPrice.getText());

            ProductCalculations calc =
                    new ProductCalculations(price);

            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Name: " + customerName
                            + "\nProduct: " + product
                            + "\nVAT: R " + vat
                            + "\nCOMMISSION: R " + commission
                            + "\nTOTAL: R " + total);

            saveToFile(
                    customerName,
                    product,
                    vat,
                    commission,
                    total);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid price.");
        }
    }

    private void saveToFile(
            String customerName,
            String product,
            double vat,
            double commission,
            double total) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("data.txt"));

            writer.write("DATA LOG");
            writer.newLine();
            writer.write("*****************************");
            writer.newLine();
            writer.write("Customer Name: " + customerName);
            writer.newLine();
            writer.write("Product: " + product);
            writer.newLine();
            writer.write("VAT: R " + vat);
            writer.newLine();
            writer.write("COMMISSION: R " + commission);
            writer.newLine();
            writer.write("TOTAL: R " + total);

            writer.close();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error saving file.");
        }
    }

    private void clearFields() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        exitItem.addActionListener(
                e -> System.exit(0));

        processItem.addActionListener(
                e -> processSale());

        clearItem.addActionListener(
                e -> clearFields());

        fileMenu.add(exitItem);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new ProductApp());
    }
}