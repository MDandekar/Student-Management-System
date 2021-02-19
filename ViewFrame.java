import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

taData=new TextArea(10,50);
btnBack =new JButton("Back");

c.add(taData);
c.add(btnBack);

taData.setText(HbOp.viewStudent());
ActionListener a1=(ae)->{
MainFrame a=new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("View Student");
setSize(500,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}