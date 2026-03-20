import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Inventory {

    static Database db = new Database();

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Inventory Management System");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.getContentPane().setBackground(new Color(18, 18, 18));
        frame.setResizable(false);

        ImageIcon icon = new ImageIcon("InventoryIcon!.png");
        frame.setIconImage(icon.getImage());

        JLabel label = new JLabel("DETAILS");
        label.setFont(new Font("Roboto", Font.BOLD, 16));
        label.setBounds(25, 0, 150, 30);
        label.setForeground(new Color(0, 255, 150));   
        frame.add(label);

        
        Label nameLabel = new Label("Item Name");
        nameLabel.setBounds(10, 40, 80, 30);
        nameLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        nameLabel.setForeground(new Color(220, 220, 220));

        JTextField itemName = new JTextField();
        itemName.setBounds(95, 45, 100, 22);
        itemName.setFont(new Font("Roboto", Font.PLAIN, 14));
        itemName.setBackground(new Color(38, 38, 38));  
        itemName.setForeground(Color.WHITE);

        Label qtyLabel = new Label("Item Qty");
        qtyLabel.setBounds(10, 70, 80, 30);
        qtyLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        qtyLabel.setForeground(new Color(220, 220, 220));

        JTextField itemQty = new JTextField();
        itemQty.setBounds(95, 75, 100, 22);
        itemQty.setFont(new Font("Roboto", Font.PLAIN, 14));
        itemQty.setBackground(new Color(38, 38, 38));
        itemQty.setForeground(Color.WHITE);

        Label priceLabel = new Label("Item Price");
        priceLabel.setBounds(10, 100, 80, 30);
        priceLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        priceLabel.setForeground(new Color(220, 220, 220));

        JTextField itemPrice = new JTextField();
        itemPrice.setBounds(95, 105, 100, 22);
        itemPrice.setFont(new Font("Roboto", Font.PLAIN, 14));
        itemPrice.setBackground(new Color(38, 38, 38));
        itemPrice.setForeground(Color.WHITE);

      
        JButton addButton = new JButton("Add Item");
        addButton.setBounds(95, 140, 100, 30);
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 200, 100)); 
        addButton.setForeground(Color.BLACK);

        JButton deleteButton = new JButton("Delete Item");
        deleteButton.setBounds(220, 140, 120, 30);
        deleteButton.setFont(new Font("Roboto", Font.BOLD, 14));
        deleteButton.setBackground(new Color(220, 50, 50)); 
        deleteButton.setForeground(Color.WHITE);

       
        List itemList = new List();
        itemList.setBounds(10, 190, 460, 150);
        itemList.setFont(new Font("Roboto", Font.PLAIN, 14));
        itemList.setBackground(new Color(30, 30, 30));
        itemList.setForeground(Color.WHITE);


        JSONArray saved = db.readJSONFile();
        for (Object o : saved) {
            JSONObject obj = (JSONObject) o;
            String n = (String) obj.get("name");
            String q = (String) obj.get("qty");
            String p = (String) obj.get("price");

            itemList.add(n + " | " + q + " | " + p);
        }

    
        frame.add(nameLabel);
        frame.add(itemName);

        frame.add(qtyLabel);
        frame.add(itemQty);

        frame.add(priceLabel);
        frame.add(itemPrice);

        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(itemList);

        frame.setVisible(true);

       
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nameInput = itemName.getText();
                String qtyInput = itemQty.getText();
                String priceInput = itemPrice.getText();

                if (nameInput.isEmpty() || qtyInput.isEmpty() || priceInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Field cannot be empty!");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Added Successfully");
                    itemList.add(nameInput + " | " + qtyInput + " | " + priceInput);
                db.addItem(nameInput, qtyInput, priceInput);
                }
                
            }
        });

        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int index = itemList.getSelectedIndex();
                itemList.remove(index);
                db.deleteItem(index);

                JOptionPane.showMessageDialog(frame, "Item Deleted");
                
            }
        });
    }
}
