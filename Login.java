import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;

class Login
{
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("LOGIN");
        frame.setSize(420,500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Label label = new Label("LOGIN");
        label.setBounds(165, 10, 60, 20);
        label.setFont(new Font("Roboto", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        frame.add(label);

        Label Username = new Label("Username: ");
        Username.setBounds(50, 100, 90, 20);
        Username.setFont(new Font("Roboto", Font.BOLD, 16));
        Username.setForeground(Color.WHITE);
        frame.add(Username);

        TextField ID = new TextField();
        ID.setBounds(140,100,150,22);
        frame.add(ID);

        Label code = new Label("Password");
        code.setBounds(50,140,90,20);
        code.setFont(new Font("Roboto", Font.BOLD, 16));
        code.setForeground(Color.WHITE);
        frame.add(code);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(140,140,150,22);
        frame.add(pass);

        JButton login = new JButton("Login");
        login.setBounds(140,250,100,30);
        login.setFont(new Font("Roboto", Font.BOLD, 18));
        frame.add(login);

        
        
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String User_Name = ID.getText();
                String password = pass.getText();
                if (User_Name.isEmpty()|| password.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"All fields are required");

                }

                else if (User_Name.equals("Rishabh") && password.equals("7045"))
                {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                }

                else
                {
                    JOptionPane.showMessageDialog(frame,"Invalid Username and Password");
                }
            }
        });

    }
}
    