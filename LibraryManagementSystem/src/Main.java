import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//ADIL
public class Main 
{
	public static void main(String args[])
    {
        JFrame introFrame=new JFrame("APKA Library Mangement System");
        JPanel introPanel=new JPanel();
        JButton introButton=new JButton(new ImageIcon("IntroPage.png"));
        
        introPanel.setBounds(0,0,1000,550);
        introButton.setBounds(0,0,1000,550);
        introButton.setBorderPainted(false);
        
        introFrame.add(introPanel);
        introPanel.add(introButton);
        
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.setSize(1000,550);
        introFrame.setLayout(null);
        introPanel.setLayout(null);
        introFrame.setVisible(true);
        introFrame.setLocationRelativeTo(null);
        introFrame.setResizable(false);
        
        introButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                introFrame.dispose();
                new Login();
            }
        });
       
    }
}
