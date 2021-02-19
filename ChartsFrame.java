import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChartsFrame extends JFrame{
ChartsFrame(){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
DefaultCategoryDataset ds = new DefaultCategoryDataset();

String info = "";
try{
	s = sf.openSession();
	System.out.println(" connected ");

	java.util.List<Student> data = new ArrayList<>();
	data = s.createQuery("from Student").list();
	for(Student st:data){
		String sname = st.getSname();
		double sm1 = st.getSm1();
		double sm2 = st.getSm2();
		double sm3 = st.getSm3();

		ds.addValue(sm1, "Subject 1", sname);
		ds.addValue(sm2, "Subject 2", sname);
		ds.addValue(sm3, "Subject 3", sname);
    }
}catch(Exception e){
	System.out.println(" issue" + e);
}finally{
	s.close();
	System.out.println("closed ");
}

//step2: design chart
JFreeChart chart = ChartFactory.createBarChart("Performance" , "Subjects", "Marks" , ds, PlotOrientation.VERTICAL, true, false, false);

//step3: chart display
ChartPanel p= new ChartPanel(chart);
JButton btnBack = new JButton("Back");
JPanel content = new JPanel(new BorderLayout());
content.add(p);
content.add(btnBack, BorderLayout.SOUTH);
setContentPane(content);

ActionListener a1 = (ae) -> {
	MainFrame a = new MainFrame();
	dispose();
};
btnBack.addActionListener(a1);

//step4: save chart as jpeg
try{
	File img = new File("perform.jpeg");
	ChartUtilities.saveChartAsJPEG(img, chart, 700, 300);
}catch(IOException e){
System.out.println(" issue " + e );
}

setTitle("Students Performance ");
setSize(600, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}

/* class ChartsFrameTest{
public static void main(String args[]){
ChartsFrame p = new ChartsFrame();
}
} */
