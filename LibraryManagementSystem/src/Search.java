import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//KRISH
public class Search implements ActionListener
{

	JFrame searchFrame = new JFrame();
	JPanel searchPanel = new JPanel();
	JButton BackButton = new JButton("Back");
	JButton searchButton = new JButton("search");
	JLabel searchLabel = new JLabel("Enter the name you want to search : ");
	JLabel ls = new JLabel("Linear Search : ");
	JLabel bs = new JLabel("Binary Search : ");
	JLabel lst = new JLabel("Time taken for Linear Search : ");
	JLabel bst = new JLabel("Time taken for Binary Search : ");
	JLabel t1 = new JLabel();
	JLabel t2 = new JLabel();
	JLabel FoundLabel = new JLabel("");
	JLabel FoundLabel1 = new JLabel("");
	JTextField txt = new JTextField("");
	JButton backButton = new JButton("Back");
	String text = "";
	String[] s;
	Search()
	{
		
		ArrayList<String> arr = new ArrayList<String>();
		FileReader f;
		try 
		{
			f = new FileReader("Books.txt");
			Scanner reader = new Scanner(f);
			String line;
			String[] list;
			while(reader.hasNextLine())
			{
			line = reader.nextLine();
			list = line.split("  ");
			arr.add(list[0]);
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		s = new String[arr.size()];
		for(int k=0;k<arr.size();k++)
			s[k]=arr.get(k);
		
		searchPanel.setBounds(0,0,1000,550);
		searchPanel.setLayout(null);
		
		searchLabel.setBounds(10, 10, 250, 15);
		txt.setBounds(280, 10, 100, 20);
		searchButton.setBounds(450, 10, 100, 30);
		ls.setBounds(10,80,100,15);
		FoundLabel.setBounds(120,80,300,15);
		lst.setBounds(10,100,190,15);
		t1.setBounds(220,100,100,15);
		bs.setBounds(10,200,100,15);
		FoundLabel1.setBounds(120,200,300,15);
		bst.setBounds(10,220,190,15);
		t2.setBounds(220,220,100,15);
		backButton.setBounds(400,380,100,50);
		
		searchButton.addActionListener(this);
		backButton.addActionListener(this);
		
		FoundLabel1.setVisible(false);
		FoundLabel.setVisible(false);
			
		searchPanel.add(searchLabel);
		searchPanel.add(txt);
		searchPanel.add(searchButton);
		searchPanel.add(ls);
		searchPanel.add(FoundLabel);
		searchPanel.add(lst);
		searchPanel.add(t1);
		searchPanel.add(bs);
		searchPanel.add(FoundLabel1);
		searchPanel.add(bst);
		searchPanel.add(t2);
		searchPanel.add(backButton);
		
		searchFrame.add(searchPanel);
		
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setSize(1000,550);
        searchFrame.setVisible(true);
        searchFrame.setLayout(null);
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setResizable(false);
	}
	
	void LS(String[] arr,String t)
	{
		int flag1=0;
		for(int i = 0 ; i<arr.length ; i++)
		{
			if(arr[i].compareTo(t)==0)
			{
				FoundLabel.setText(t + " found in the list " + "at position "+(i+1));
				FoundLabel.setVisible(true);
				flag1=1;
				break;
			}
		}
		if(flag1==0)
		{
			FoundLabel.setText(t + " not found in the list ");
			FoundLabel.setVisible(true);
		}
	}
	
	void BS(String[] arr,String t)
	{
		int flag=1;
		for (int i = 1; i < arr.length; i++)
		{  
			String temp;
	        temp = arr[i];  
	        int j = i - 1; 
	        while(j>=0 && temp.compareTo(arr[j])<0)  
	        { 
	            	arr[j+1] = arr[j];     
	            	j = j-1;  
	        }
	        arr[j+1] = temp;  
		}
		
		int f=0 , r=arr.length-1;
		while(f<=r)
		{
			int m = (f + r)/ 2;
			 
            int res = t.compareTo(arr[m]);
            if (res == 0)
            {
            	FoundLabel1.setText(t + " found in the list " + "at position "+(m+1));
				FoundLabel1.setVisible(true);
				flag=0;
				break;
            }

            if (res > 0)
                f = m + 1;
            else
                r = m - 1;
		}
		
		if(flag==1)
		{
			FoundLabel1.setText(t + " not found in the list ");
			FoundLabel1.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==searchButton)
		{
			text = txt.getText();
			
			long start = System.nanoTime();
			LS(s,text);
			long end = System.nanoTime();  
			t1.setText(Long.toString(end-start) + " ns");
			
			long start1 = System.nanoTime();
			BS(s,text);
			long end1 = System.nanoTime();  
			t2.setText(Long.toString(end1-start1) + " ns");
		}
		else if(e.getSource()==backButton)
		{
			searchFrame.dispose();
			new Customer();
		}
	}
}
