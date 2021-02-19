class Student{
private int srno;
private String sname;
private double sm1;
private double sm2;
private double sm3;

public Student(){}

public Student(int srno, String sname, double sm1, double sm2, double sm3){
this.srno=srno;
this.sname=sname;
this.sm1=sm1;
this.sm2=sm2;
this.sm3=sm3;
}

public void setSrno(int srno)		{this.srno = srno;		}
public int getSrno()			{return srno;		}
public void setSname(String sname)	{this.sname = sname;	}
public String getSname()		{return sname;		}
public void setSm1(double sm1)		{this.sm1 = sm1;		}
public double getSm1()		{return sm1;		}
public void setSm2(double sm2)		{this.sm2 = sm2;		}
public double getSm2()		{return sm2;		}
public void setSm3(double sm3)		{this.sm3 = sm3;		}
public double getSm3()		{return sm3;		}
}
