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
//KRISH	
public class InsertionSort {
	
	InsertionSort()
	{
		JFrame InsFrame = new JFrame("Insertion Sort");
		JPanel InsPanel = new JPanel();
		JLabel beforeSort = new JLabel();
		JLabel afterSort = new JLabel();
		JLabel title1 = new JLabel("Before sort : ");
		JLabel title2 = new JLabel("After Sort : ");
		String p = "Displaying all the passes :";
		String p1 = "";
		JButton BackButton = new JButton("Back");
		JLabel p1Label = new JLabel();
		JLabel pLabel = new JLabel();

		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String temp = new String();
		String[] s = new String[arr.size()];
		String str = "";
		String str1 = "";
		for(int k=0;k<arr.size();k++)
		{
			s[k]=arr.get(k);
			str = str + arr.get(k) + " ";
		}
		beforeSort.setText(str);
		for (int i = 1; i < s.length; i++)
		{  
			for(int k=0;k<s.length;k++)
			{
				if(k==i)
	        		p1 = p1 + " [" + s[k] + "] ";
	        	else
	        		p1 = p1 + s[k] + " ";
			}
			p1 = p1 + "\n";
	        temp = s[i];  
	        int j = i - 1; 
	        while(j>=0 && temp.compareTo(s[j])<0)  
	        { 
	        		if((temp.charAt(0)==s[j].charAt(0) && temp.length()>s[j].length()))
	        			break;
	        		s[j+1] = s[j];     
	            	j = j-1;  
	        }
	        s[j+1] = temp;  
		}
		for(int k=0;k<s.length;k++)
			str1 = str1 + s[k] + " ";
		
		pLabel.setText(p);
		p1Label.setText("<html>" + p1.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		afterSort.setText(str1);
		
		InsPanel.setLayout(null);
		InsPanel.setBounds(0, 0, 1000, 550);
		
		
		title1.setBounds(10, 5, 100, 15);
		beforeSort.setBounds(10, 25, 900, 15);
		pLabel.setBounds(10, 50, 200, 15);
		p1Label.setBounds(10, 65, 900, 300);
		title2.setBounds(10, 350, 100, 15);
		afterSort.setBounds(10,370,900,15);
		BackButton.setBounds(400, 450, 100, 50);
		
		BackButton.addActionListener(new ActionListener()
		{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					InsFrame.dispose();
					new Sort();
				}
		});
		
		InsPanel.add(title1);
		InsPanel.add(beforeSort);
		InsPanel.add(pLabel);
       	InsPanel.add(p1Label); 
		InsPanel.add(title2);
		InsPanel.add(afterSort);
		InsPanel.add(BackButton);
		
		InsFrame.add(InsPanel);
		
        InsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InsFrame.setSize(1000,550);
        InsFrame.setVisible(true);
        InsFrame.setLayout(null);
        InsFrame.setLocationRelativeTo(null);
        InsFrame.setResizable(false);
	}  
}
