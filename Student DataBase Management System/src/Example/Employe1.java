package Example;

public class Employe1 
{
	String id;
	String name;

	static int count=101;//101 102 103 104

	public Employe1(String name) {
		this.id = "JSP"+count; //101 102 103
		this.name = name;
		count++; //102 103 104
	}

	public static void main(String[] args) 
	{
		Employe1 e1=new Employe1("Somu");
		System.out.println("Emp ID of "+e1.name+" is "+e1.id);

		Employe1 e2=new Employe1("Kantu");
		System.out.println("Emp ID of "+e1.name+" is "+e2.id);

		Employe1 e3=new Employe1("Ayappa");
		System.out.println("Emp ID of "+e1.name+" is "+e3.id);
	}
}
