import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

class HbOp{
public static void addStudent(int Srno, String Sname, double Sm1, double Sm2, double Sm3){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;
try{
	s = sf.openSession();
	System.out.println(" connected ");
	t = s.beginTransaction();
	
	int srno = Srno;
	String sname = Sname;
	double sm1 = Sm1;
	double sm2 = Sm2;
	double sm3 = Sm3;

	Student st = new Student(srno, sname, sm1, sm2, sm3);
	s.save(st);
	t.commit();
	System.out.println(" record added ");

} catch(Exception e){
	System.out.println(" issue " + e);
	t.rollback();
}finally{
	s.close();
	System.out.println(" closed ");
}
}

public static void updateStudent(int Srno, String Sname, double Sm1, double Sm2, double Sm3){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;
try{
	s = sf.openSession();
	System.out.println(" connected ");
	t = s.beginTransaction();
	
	int srno = Srno;

	Student st = (Student)s.get(Student.class, srno);
	if(st==null){
		System.out.println("invalid " + srno);
	} else {
		String sname = Sname;
		double sm1 = Sm1;
		double sm2 = Sm2;
		double sm3 = Sm3;
	st.setSname(sname);
	st.setSm1(sm1);
	st.setSm2(sm2);
	st.setSm3(sm3);
	s.save(st);
	t.commit();
	System.out.println("record updated ");
	}
} catch(Exception e){
	System.out.println(" issue " + e);
	t.rollback();
}finally{
	s.close();
	System.out.println(" closed ");
}
}

public static String viewStudent(){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;

String info = "";
try{
	s = sf.openSession();
	System.out.println(" connected ");

	List<Student> data = new ArrayList<>();
	data = s.createQuery("from Student").list();
	for(Student st:data)
		info = info + "Roll no:" + st.getSrno() + "\t" + "Name:" + st.getSname() + "\t" + "S1:" + st.getSm1() +"\t" + "S2:" + st.getSm2() + "\t" +"S3:" + st.getSm3() + "\n";
}catch(Exception e){
	System.out.println(" issue" + e);
}finally{
	s.close();
	System.out.println("closed ");
}
return info;
}

public static String deleteStudent(int Srno) {
	String msg;
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try {
s = sf.openSession();
System.out.println("Connected");

t = s.beginTransaction();

int srno = Srno;
Student st = (Student)s.get(Student.class, srno);
if(st == null) {
	msg = srno + " does not exists.";
} else {
	s.delete(st);
	msg = srno + " deleted";
}
t.commit();
}
catch (Exception e) {
msg = "Issue: " + e;
t.rollback();
}
finally {
s.close();
System.out.println("Closed");
}
return msg;
}
}