import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//AMAN
public class Customer implements ActionListener
{
	JFrame CustFrame = new JFrame("Customer");
	JLabel SortLabel = new JLabel();
	JLabel SearchLabel = new JLabel();
	JPanel CustPanel = new JPanel();
	ImageIcon SearchIcon = new ImageIcon(new ImageIcon("Search.png").getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT));
	ImageIcon SortIcon = new ImageIcon(new ImageIcon("sort.jpg").getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT));
	JButton SortButton = new JButton("Sort");
	JButton SearchButton = new JButton("Search");
	JButton backButton = new JButton("Back");

	Customer()
	{
		SortLabel.setText("View books in sorted order");
		SortLabel.setIcon(SortIcon);
		SortLabel.setHorizontalTextPosition(JLabel.CENTER);
		SortLabel.setVerticalTextPosition(JLabel.TOP);
		SortLabel.setLayout(null);
		SortLabel.setBounds(50,5,320,400);
		
		SearchLabel.setText("Search for books");
		SearchLabel.setIcon(SearchIcon);
		SearchLabel.setHorizontalTextPosition(JLabel.CENTER);
		SearchLabel.setVerticalTextPosition(JLabel.TOP);
		SearchLabel.setLayout(null);
		SearchLabel.setBounds(420,5,320,400);
		
		SortButton.setBounds(150,410,100,50);
		SortButton.addActionListener(this);
		
		SearchButton.setBounds(520,410,100,50);
		SearchButton.addActionListener(this);
		
		backButton.setBounds(800,225,100,50);
		backButton.addActionListener(this);
		
		CustPanel.setLayout(null);
		CustPanel.setBounds(0, 0, 1000, 550);
		CustPanel.add(SortLabel);
		CustPanel.add(SearchLabel);
		CustPanel.add(SortButton);
		CustPanel.add(SearchButton);
		CustPanel.add(backButton);
		
		CustFrame.add(CustPanel);
		
		CustFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustFrame.setSize(1000,550);
        CustFrame.setVisible(true);
        CustFrame.setLayout(null);
        CustFrame.setLocationRelativeTo(null);
        CustFrame.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==SortButton)
		{
			CustFrame.dispose();
			new Sort();
		}
		else if(e.getSource()==SearchButton)
		{
			CustFrame.dispose();
			new Search();
		}
		else if(e.getSource()==backButton)
		{
			CustFrame.dispose();
			new Login();
		}
		
	}
	
}