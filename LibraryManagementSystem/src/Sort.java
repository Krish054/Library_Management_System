import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//PRASHI
public class Sort implements ActionListener 
{
	JFrame sortFrame = new JFrame("Sort");
	JPanel sortPanel = new JPanel();
	JButton BSortButton = new JButton("Bucket Sort");
	JButton MSortButton = new JButton("Merge Sort");
	JButton ISortButton = new JButton("Insertion Sort");
	JButton BackButton = new JButton("Back");
	String[] arr;
	
	Sort()
	{

		
		BSortButton.setBounds(80,100,200,100);
		MSortButton.setBounds(380, 100, 200, 100);
		ISortButton.setBounds(680,100,200,100);
		BackButton.setBounds(430,300,100,100);
		
		sortPanel.add(BSortButton);
		sortPanel.add(MSortButton);
		sortPanel.add(ISortButton);
		sortPanel.add(BackButton);
		
		sortPanel.setLayout(null);
		sortPanel.setBounds(0, 0, 1000, 550);
		sortFrame.add(sortPanel);
		
		BSortButton.addActionListener(this);
		MSortButton.addActionListener(this);
		ISortButton.addActionListener(this);
		BackButton.addActionListener(this);
		
		sortFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sortFrame.setSize(1000,550);
        sortFrame.setVisible(true);
        sortFrame.setLayout(null);
        sortFrame.setLocationRelativeTo(null);
        sortFrame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==MSortButton)
		{
			new MergeSort();
			sortFrame.setVisible(false);
		}
		else if(e.getSource()==BSortButton)
		{
			sortFrame.setVisible(false);
			new BucketSort();
		}
		else if(e.getSource()==ISortButton)
		{
			sortFrame.setVisible(false);
			new InsertionSort();
		}
		else if(e.getSource()==BackButton)
		{
			sortFrame.dispose();
			new Customer();
		}
		
	}

}