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
//PRASHI
public class BucketSort 
{
	BucketSort()
	{
		JFrame BucketFrame = new JFrame("BucketSort");
		JPanel BucketPanel = new JPanel();
		JLabel beforeSort = new JLabel();
		JLabel afterSort = new JLabel();
		JLabel title1 = new JLabel("Before sort : ");
		JLabel title2 = new JLabel("After Sort : ");
		JLabel pass = new JLabel();
		String p = "Displaying all the buckets : \n";
		JButton BackButton = new JButton("Back");
		JLabel newPass = new JLabel();
		
		
		int ch;
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String>[] a = new ArrayList[26];
		for (int i = 0; i < 26; i++) 
		{
			a[i] = new ArrayList<String>();
	    }
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
		String[] s = new String[arr.size()];
		String[] temp = new String[s.length];
		String str = "";
		String str1 = "";
		for(int k=0;k<arr.size();k++)
		{
			s[k]=arr.get(k);
			temp[k]=arr.get(k);
			str = str + arr.get(k) + " ";
		}
		beforeSort.setText(str);
		

		for(int i=0;i<s.length;i++)
		{
				ch = Character.toLowerCase(temp[i].charAt(0))-97;
				a[ch].add(temp[i]);
		}
		int k=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i].isEmpty()==false)
			{	
				for(int z = 0; z<a[i].size()-1; z++) 
				{
			         for (int h = z+1; h<a[i].size(); h++) 
			         {
			        	 if(a[i].get(z).length()>a[i].get(h).length())
			        	 {
			        		 String tempVar = a[i].get(z);
				             a[i].set(z,a[i].get(h));
				             a[i].set(h, tempVar);
			        	 }
			        	 else if(a[i].get(z).length()==a[i].get(h).length() && a[i].get(z).compareTo(a[i].get(h))>0)
			        	 {
			        		 String tempVar = a[i].get(z);
				             a[i].set(z,a[i].get(h));
				             a[i].set(h, tempVar);
			        	 }
			         }
			    }
				p = p + "Bucket "+a[i].get(0).charAt(0)+" : ";
				for(int t=0;t<a[i].size();t++)
				{
						p = p + a[i].get(t) + " ";
						temp[k] = a[i].get(t);
						k++;
				}
				p = p + "\n";
			}
		}
		for(k=0;k<temp.length;k++)
		{
			str1 = str1 + temp[k] + " ";
		}
		afterSort.setText(str1);
		
		newPass.setText("<html>" + p.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		BucketPanel.setLayout(null);
		BucketPanel.setBounds(0, 0, 1000, 550);
		
		title1.setBounds(10, 5, 100, 10);
		beforeSort.setBounds(10, 10, 900, 40);
		newPass.setBounds(10, 60, 1000, 250);
		title2.setBounds(10, 320, 100, 10);
		afterSort.setBounds(10,335,900,40);
		BackButton.setBounds(430,400,100,50);

		BackButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						BucketFrame.dispose();
						new Sort();
					}
				});
		
		BucketPanel.add(title1);
		BucketPanel.add(beforeSort);
		BucketPanel.add(newPass);
		BucketPanel.add(title2);
		BucketPanel.add(afterSort);
		BucketPanel.add(BackButton);
		
		BucketFrame.add(BucketPanel);
		
        BucketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BucketFrame.setSize(1000,550);
        BucketFrame.setVisible(true);
        BucketFrame.setLayout(null);
        BucketFrame.setLocationRelativeTo(null);
        BucketFrame.setResizable(false);
	}
}
