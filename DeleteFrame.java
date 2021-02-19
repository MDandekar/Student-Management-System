import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.util.*;
import java.io.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblSrno;
JTextField txtSrno;
JButton btnSave,btnBack;
JFrame f;
int rollno;
String msg;

DeleteFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());
lblSrno=new JLabel("Enter Roll No to be deleted");
txtSrno=new JTextField(20);

btnSave=new JButton("Save");
btnBack=new JButton("Back");

c.add(lblSrno);
c.add(txtSrno);

c.add(btnSave);
c.add(btnBack);

ActionListener a1=(ae)->{
MainFrame a=new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2=(ae)->{
    try {
        rollno = Integer.parseInt(txtSrno.getText());
        if (rollno > 0) {
            msg = HbOp.deleteStudent(Integer.parseInt(txtSrno.getText()));
            f = new JFrame();
            JOptionPane.showMessageDialog(f, msg);
        } else {
            throw new Exception();
        }
    } catch (Exception e) {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Please enter a valid Roll No.");
    }
};
btnSave.addActionListener(a2);

setTitle("Delete Students");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}