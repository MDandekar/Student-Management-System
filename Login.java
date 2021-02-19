import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

class Login extends JFrame{
    Container c;
    JLabel lblUser, lblPass;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnSub;
    JFrame f;

    Login(){
        c=getContentPane();
        c.setLayout(new FlowLayout());

        lblUser = new JLabel("Username");
        lblPass = new JLabel("Password");

        txtUser = new JTextField(20);
        txtPass = new JPasswordField(20);

        btnSub = new JButton("Login");

        c.add(lblUser);
        c.add(txtUser);

        c.add(lblPass);
        c.add(txtPass);

        c.add(btnSub);

        Scanner scan = new Scanner (File("Project\\login_cred.txt"));
        String UserName = scan.nextLine();
        String PassWord = scan.nextLine();

        ActionListener a1=(ae)->{
            String username = txtUser.getText();
            String password = txtPass.getText();
            if(username.equals(UserName) && password.equals(PassWord)){
                MainFrame m = new MainFrame();
            }else{
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Incorrect Username or Password");
            }
        };
        btnSub.addActionListener(a1);
    }
}