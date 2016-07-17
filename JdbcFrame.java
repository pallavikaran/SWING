import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class JdbcFrame extends JFrame 
{
	JButton b1;
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;

		JdbcFrame()
	{
			b1= new JButton("Save");
			l1=new JLabel("Roll :");
			l2=new JLabel("Name :");
			l3=new JLabel("Score :");
			t1=new JTextField(5);
			t2=new JTextField(10);
			t3=new JTextField(10);
			setVisible(true);
			setSize(300,300);
			setLayout(new FlowLayout());
			add(l1);			add(t1);			add(l2);			add(t2);
			add(l3);			add(t3);			add(b1);
			b1.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent ae)
				{					
					try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:dsn3i","sa","sa");
		Statement st= con.createStatement();
				st.executeUpdate("insert into students values("+t1.getText()+", '"+t2.getText()+"',"+t3.getText()+")");
		
				con.close();
		t1.setText("");
		t2.setText("");
		t3.setText("");
	}catch(Exception e)
		{
			System.out.println(e);
		}
				}				
			});

	}
	public static void main(String[] args) 
	{
		new JdbcFrame();
		System.out.println("Hello World!");
	}
}
