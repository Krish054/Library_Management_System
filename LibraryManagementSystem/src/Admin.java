import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//AMAN
public class Admin implements ActionListener
{
	JFrame adminFrame = new JFrame();
	JPanel adminPanel = new JPanel();
	JLabel adminTitle = new JLabel("Enter the details of the book : ");
	JLabel note = new JLabel("NOTE : A unique bookID will be generated automatically");
	JLabel bookName = new JLabel("Book Name : ");
	JLabel bookAuthor = new JLabel("Author Name : ");
	JLabel bookID = new JLabel("BookID generated : ");
	JTextField name = new JTextField();
	JTextField author = new JTextField();
	JTextField id = new JTextField();
	JButton submit = new JButton("Submit");
	JButton backButton = new JButton("Back");
	Admin()
	{
		adminPanel.setBounds(0,0,1000,550);
		adminPanel.setLayout(null);
		
		adminTitle.setBounds(10,10,200,15);
		note.setBounds(10,30,400,15);
		bookName.setBounds(10,100,200,15);
		name.setBounds(250,100,100,15);
		bookAuthor.setBounds(10,130,200,15);
		author.setBounds(250,130,100,15);
		bookID.setBounds(10,160,200,15);
		id.setBounds(250,160,100,15);
		submit.setBounds(200,300,100,50);
		backButton.setBounds(500,300,100,50);
		
		id.setEditable(false);
		
		submit.addActionListener(this);
		backButton.addActionListener(this);
		
		adminPanel.add(adminTitle);
		adminPanel.add(note);
		adminPanel.add(bookName);
		adminPanel.add(name);
		adminPanel.add(bookAuthor);
		adminPanel.add(author);
		adminPanel.add(bookID);
		adminPanel.add(id);
		adminPanel.add(submit);
		adminPanel.add(backButton);
		
		adminFrame.add(adminPanel);
		
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1000,550);
        adminFrame.setVisible(true);
        adminFrame.setLayout(null);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<String> tempArray=new ArrayList<String>();
		String line;
		if(e.getSource()==submit)
		{
			String b = name.getText();
			int p = 31;
			long m = 10000;
		    String hash_value;
	        long hash_so_far = 0;
	        String s = b.toLowerCase();
	        for (int i = 0; i < s.length(); i++) 
	        {
	        	if(Character.isDigit(s.charAt(i)))
	        	{
	        		hash_so_far = (long) (hash_so_far + ((s.charAt(i)-46)*Math.pow(p, i)));
	        	}
	        	else if(s.charAt(i)==' ')
	        	{
	        		hash_so_far = (long) (hash_so_far + ((s.charAt(i)-31)*Math.pow(p, i)));
	        	}
	        	else if(Character.isAlphabetic(s.charAt(i)))
	        	{
	        		hash_so_far = (long)(hash_so_far + ((s.charAt(i)-85) * Math.pow(p, i)));
	        	}
	        }
	        hash_so_far = hash_so_far%m;
	        hash_value = String.format("%04d", hash_so_far);
			id.setText(hash_value);
			
			try
			{
                FileReader fr=new FileReader("Books.txt");
                Scanner reader=new Scanner(fr);
                while(reader.hasNextLine())
                {
                	line=reader.nextLine();
                	tempArray.add(line);
                }
                reader.close();
                fr.close();
            }
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1+"");
			}
            finally 
            {
				try 
				{
					FileWriter fw = new FileWriter("Books.txt");
					PrintWriter pw = new PrintWriter(fw);
					
					for(String str: tempArray)
					{
                        fw.write(str);
                        pw.println();
                    }
					String line1 = name.getText()+"  "+author.getText()+"  "+Integer.parseInt(id.getText());
					fw.write(line1);
					fw.close();
					pw.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1 + "");
				}
            }

		}
		else if(e.getSource()==backButton)
		{
			adminFrame.dispose();
			new Login();
		}
	}
}
