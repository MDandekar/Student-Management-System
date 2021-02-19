import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.util.*;
import java.io.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblSrno,lblSname, lblSm1, lblSm2, lblSm3;
JTextField txtSrno,txtSname, txtSm1, txtSm2, txtSm3;
JButton btnSave,btnBack;
JFrame f;
int rollno;
String stuname;
double sub1, sub2, sub3;

UpdateFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());
lblSrno=new JLabel("Exter Roll No to be updated");
txtSrno=new JTextField(20);

lblSname=new JLabel("Enter updated Name");
txtSname=new JTextField(20);

lblSm1=new JLabel("Enter Sub Marks1");
txtSm1=new JTextField(20);

lblSm2=new JLabel("Enter Sub Marks2");
txtSm2=new JTextField(20);

lblSm3=new JLabel("Enter Sub Marks3");
txtSm3=new JTextField(20);

btnSave=new JButton("Save");
btnBack=new JButton("Back");

c.add(lblSrno);
c.add(txtSrno);

c.add(lblSname);
c.add(txtSname);

c.add(lblSm1);
c.add(txtSm1);

c.add(lblSm2);
c.add(txtSm2);

c.add(lblSm3);
c.add(txtSm3);

c.add(btnSave);
c.add(btnBack);

ActionListener a1=(ae)->{
MainFrame a=new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
    try {
        rollno = Integer.parseInt(txtSrno.getText());
        if (rollno < 1) {
            throw new Exception();
        } else {
            try {
                stuname = txtSname.getText();
                if (stuname.length() < 2) {
                    throw new Exception();
                } else {
                    try {
                        sub1 = Double.parseDouble(txtSm1.getText());
                        sub2 = Double.parseDouble(txtSm2.getText());
                        sub3 = Double.parseDouble(txtSm3.getText());
                        if (0 < sub1 && sub1 < 100 && 0 < sub2 && sub2 < 100 && 0 < sub3 && sub3 < 100) {
                            HbOp.updateStudent(rollno, stuname, sub1, sub2, sub3);
                            f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Record updated");
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Please enter valid marks between 0 and 100");
                    }
                }
            } catch (Exception e) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please enter a valid Name of at least 2 letters");
            }
        }
    } catch (Exception e) {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Please enter a valid Roll No.");
    }
};
btnSave.addActionListener(a2);

/* ActionListener a2=(ae)->{
HbOp.updateStudent(Integer.parseInt(txtSrno.getText()), txtSname.getText(), Double.parseDouble(txtSm1.getText()), Double.parseDouble(txtSm2.getText()), Double.parseDouble(txtSm3.getText()) );
};
btnSave.addActionListener(a2); */

setTitle("Update Students");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}