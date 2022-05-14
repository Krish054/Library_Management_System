import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//PRASHI
public class MergeSort 
{
	JFrame mergeFrame = new JFrame("MergeSort");
	JPanel mergePanel = new JPanel();
	JLabel beforeSort = new JLabel();
	JLabel afterSort = new JLabel();
	JLabel title1 = new JLabel("Before sort : ");
	JLabel title2 = new JLabel("After Sort : ");
	JLabel pass = new JLabel();
	JButton BackButton = new JButton("Back");
	static String p = "Displaying all the passes : \n";
	
	MergeSort()
	{
		ArrayList<String> al = new ArrayList<String>();

		try 
		{
			FileReader f = new FileReader("Books.txt");
			Scanner reader = new Scanner(f);
			String line;
			String[] list;
			while(reader.hasNextLine())
			{
			line = reader.nextLine();
			list = line.split("  ");
			al.add(list[0]);
			}
			reader.close();
		} 
		catch (Exception e1) 
		{
            JOptionPane.showMessageDialog(null, e1 + "");
        }
		String[] s = new String[al.size()];
		for(int k=0;k<al.size();k++)
			s[k]=al.get(k);
		
		ArrayList<String>[] arrMerge = new ArrayList[al.size()+1];
		for (int i = 0; i < al.size()+1; i++) 
			arrMerge[i] = new ArrayList<String>();
		
		ArrayList<String>[] arr1Merge = new ArrayList[al.size()+1];
		for (int i = 0; i < al.size()+1; i++) 
			arr1Merge[i] = new ArrayList<String>();
		
		String str ="";
		for (int i = 0; i < s.length; i++) 
			str = str + s[i] + " ";
		beforeSort.setText( str );
		
		mergeSort(s,0,s.length-1,arrMerge,arr1Merge);
		
		 for(int i = arr1Merge.length-1;i>0;i--)
	        {	
	        	if(arr1Merge[i].size()>0)
	        	{
	        		for(int j=0;j<arr1Merge[i].size();j++)
	        			p= p + arr1Merge[i].get(j)+ " ";
	        		p = p + "\n";
	        	}
	        }
		
		for(int i = 0;i<arrMerge.length;i++)
        {	
        	if(arrMerge[i].size()>0)
        	{
        		for(int j=0;j<arrMerge[i].size();j++)
        			p= p + arrMerge[i].get(j)+ " ";
        		p = p + "\n";
        	}
        }
		
		String str1 ="";
		for (int i = 0; i < s.length; i++) 
			str1 = str1 + s[i] + " ";
		afterSort.setText( str1 );
		
		pass.setText("<html>" + p.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		mergePanel.setLayout(null);
		mergePanel.setBounds(0, 0, 1200, 550);
		
		title1.setBounds(10, 5, 100, 10);
		beforeSort.setBounds(10, 20, 1150, 20);
		pass.setBounds(10, 50, 1150, 240);
		title2.setBounds(10, 300, 100, 10);
		afterSort.setBounds(10,320,1150,20);
		BackButton.setBounds(400,400,100,50);
		mergePanel.add(title1);
		mergePanel.add(beforeSort);
		mergePanel.add(pass);
		mergePanel.add(title2);
		mergePanel.add(afterSort);
		mergePanel.add(BackButton);
		
		BackButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						mergeFrame.dispose();
						new Sort();
					}
				});
		
		mergeFrame.add(mergePanel);
		
        mergeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mergeFrame.setSize(1200,550);
        mergeFrame.setVisible(true);
        mergeFrame.setLayout(null);
        mergeFrame.setLocationRelativeTo(null);
        mergeFrame.setResizable(false);
	}
    public static void mergeSort(String[] a, int from, int to,ArrayList<String>[] arr,ArrayList<String>[] arr1) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
       
        arr1[to-from+1].add("[ ");
        for(int k = from ; k<=to ; k++)
        {
        	arr1[to-from+1].add(a[k]);
        }
        arr1[to-from+1].add("] ");
        
        mergeSort(a, from, mid,arr,arr1);
        mergeSort(a, mid + 1, to,arr,arr1);
        merge(a, from, mid, to,arr);
    }

    public static void merge(String[] a, int from, int mid, int to,ArrayList<String>[] arr) 
    {
        int n = to - from + 1; 
        String[] b = new String[n];  
        int i1 = from;               
        int i2 = mid + 1;            
        int j = 0;                 
        
        while (i1 <= mid && i2 <= to) 
        {
        	if(a[i1].charAt(0)==a[i2].charAt(0) && a[i1].length()<a[i2].length())
        	{
        		b[j] = a[i1];
                i1++;
        	}
        	else if (a[i1].compareTo(a[i2]) < 0) 
        	{
                b[j] = a[i1];
                i1++;
            } else 
            {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        
        arr[b.length].add("[ ");
        for(int k = 0 ; k<b.length ; k++)
        {
        	arr[b.length].add(b[k]);
        }
        arr[b.length].add("] ");
        
        for (j = 0; j < n; j++) 
        {
            a[from + j] = b[j];
        }
    }
}
