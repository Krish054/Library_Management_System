import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//ADIL
public class Login implements ActionListener
{

	JFrame DispLogin = new JFrame("Login");
	JPanel Login = new JPanel();
	JLabel Lib = new JLabel();
	JLabel Cust = new JLabel();
	ImageIcon c = new ImageIcon(new ImageIcon("Customer.png").getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT));
	ImageIcon l = new ImageIcon(new ImageIcon("Librarian.png").getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT));
	JButton libr = new JButton(l);
	JButton cust = new JButton(c);

	
	Login()
	{
		Lib.setText("Admin");
		Lib.setBounds(210, 30, 200, 50);
		Lib.setFont(new Font("MV Boli",Font.PLAIN,40));

		libr.setBounds(140,100,300,400);
		libr.addActionListener(this);
		libr.setOpaque(false);
		cust.setBounds(530,100, 300, 400);
		cust.addActionListener(this);
		
		
		Cust.setText("Customer");
		Cust.setBounds(590,30,200, 50);
		Cust.setFont(new Font("MV Boli",Font.PLAIN,40));
		
		Login.setLayout(null);
		Login.setBounds(0,0,1000,550);
		Login.add(Lib);
		Login.add(Cust);
		Login.add(libr);
		Login.add(cust);
		Login.setOpaque(false);
		
		DispLogin.add(Login);
		
        DispLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DispLogin.setSize(1000,550);
        DispLogin.setVisible(true);
        DispLogin.setLayout(null);
        DispLogin.setLocationRelativeTo(null);
        DispLogin.setResizable(false);
        DispLogin.getContentPane().setBackground(Color.WHITE);
  
        
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==libr) 
		{
            DispLogin.dispose();
            new Admin();
            
		}
        else if(e.getSource()==cust)
        {
            DispLogin.dispose();
            new Customer();
        }
		
	}
}
