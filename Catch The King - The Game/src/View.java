import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class View {

	 JFrame frame;
     JTextField textField;
	JButton a1 = new JButton("");
	JButton a2 = new JButton("");
	JButton a3 = new JButton("");
	JButton a4 = new JButton("");
	JButton a5 = new JButton("");
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	JButton b5 = new JButton("");
	JButton c5 = new JButton("");
	JButton c4 = new JButton("");
	JButton c3 = new JButton("");
	JButton c2 = new JButton("");
	JButton c1 = new JButton("");
	JButton d5 = new JButton("");
	JButton d4 = new JButton("");
	JButton d3 = new JButton("");
	JButton d2 = new JButton("");
	JButton d1 = new JButton("");
	JButton e5 = new JButton("");
	JButton e4 = new JButton("");
	JButton e3 = new JButton("");
	JButton e2 = new JButton("");
	JButton e1 = new JButton("");
	JTextArea battleDetails = new JTextArea();
	
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 989, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  A");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(74, 10, 66, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("  1");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label.setBounds(10, 63, 66, 43);
		frame.getContentPane().add(label);
		a1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		
		          //butonul din celula A1
		a1.setBackground(Color.LIGHT_GRAY);
		a1.setForeground(new Color(46, 139, 87));
		a1.setBounds(74, 63, 66, 43);
		frame.getContentPane().add(a1);
		
		
		a2.setForeground(new Color(46, 139, 87));
		a2.setBackground(Color.LIGHT_GRAY);
		a2.setBounds(74, 118, 66, 43);
		frame.getContentPane().add(a2);
		
		JLabel label_1 = new JLabel("  2");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_1.setBounds(10, 118, 66, 43);
		frame.getContentPane().add(label_1);
		
	
		a3.setForeground(new Color(46, 139, 87));
		a3.setBackground(Color.LIGHT_GRAY);
		a3.setBounds(74, 175, 66, 43);
		frame.getContentPane().add(a3);
		
		JLabel label_2 = new JLabel("  3");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_2.setBounds(10, 175, 66, 43);
		frame.getContentPane().add(label_2);
		
		
		a4.setForeground(new Color(46, 139, 87));
		a4.setBackground(Color.LIGHT_GRAY);
		a4.setBounds(74, 228, 66, 43);
		frame.getContentPane().add(a4);
		
		JLabel label_3 = new JLabel("  4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_3.setBounds(10, 228, 66, 43);
		frame.getContentPane().add(label_3);
		
		
		a5.setForeground(new Color(46, 139, 87));
		a5.setBackground(Color.LIGHT_GRAY);
		a5.setBounds(74, 283, 66, 44);
		frame.getContentPane().add(a5);
		
		JLabel label_4 = new JLabel("  5");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_4.setBounds(10, 283, 66, 44);
		frame.getContentPane().add(label_4);
		
		b1.setForeground(new Color(46, 139, 87));
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBounds(150, 63, 66, 44);
		frame.getContentPane().add(b1);
		
		b2.setForeground(new Color(46, 139, 87));
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setBounds(150, 118, 66, 43);
		frame.getContentPane().add(b2);
		
		b3.setForeground(new Color(46, 139, 87));
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setBounds(150, 175, 66, 43);
		frame.getContentPane().add(b3);
		
		b4.setForeground(new Color(46, 139, 87));
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setBounds(150, 228, 66, 43);
		frame.getContentPane().add(b4);
	
		b5.setForeground(new Color(46, 139, 87));
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setBounds(150, 283, 66, 43);
		frame.getContentPane().add(b5);
		
		JLabel lblB = new JLabel("  B");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblB.setBounds(150, 10, 66, 43);
		frame.getContentPane().add(lblB);
	
		c5.setForeground(new Color(46, 139, 87));
		c5.setBackground(Color.LIGHT_GRAY);
		c5.setBounds(226, 283, 66, 44);
		frame.getContentPane().add(c5);
	
		c4.setForeground(new Color(46, 139, 87));
		c4.setBackground(Color.LIGHT_GRAY);
		c4.setBounds(226, 228, 66, 43);
		frame.getContentPane().add(c4);
	
		c3.setForeground(new Color(46, 139, 87));
		c3.setBackground(Color.LIGHT_GRAY);
		c3.setBounds(226, 175, 66, 43);
		frame.getContentPane().add(c3);
		
		c2.setForeground(new Color(46, 139, 87));
		c2.setBackground(Color.LIGHT_GRAY);
		c2.setBounds(226, 118, 66, 43);
		frame.getContentPane().add(c2);
		
		c1.setForeground(new Color(46, 139, 87));
		c1.setBackground(Color.LIGHT_GRAY);
		c1.setBounds(226, 63, 66, 43);
		frame.getContentPane().add(c1);
		
		JLabel lblC = new JLabel("  C");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblC.setBounds(226, 10, 66, 43);
		frame.getContentPane().add(lblC);
		
		d5.setForeground(new Color(46, 139, 87));
		d5.setBackground(Color.LIGHT_GRAY);
		d5.setBounds(302, 283, 66, 44);
		frame.getContentPane().add(d5);
	
		d4.setForeground(new Color(46, 139, 87));
		d4.setBackground(Color.LIGHT_GRAY);
		d4.setBounds(302, 228, 66, 43);
		frame.getContentPane().add(d4);
	
		d3.setForeground(new Color(46, 139, 87));
		d3.setBackground(Color.LIGHT_GRAY);
		d3.setBounds(302, 175, 66, 43);
		frame.getContentPane().add(d3);
	
		d2.setForeground(new Color(46, 139, 87));
		d2.setBackground(Color.LIGHT_GRAY);
		d2.setBounds(302, 118, 66, 43);
		frame.getContentPane().add(d2);
	
		d1.setForeground(new Color(46, 139, 87));
		d1.setBackground(Color.LIGHT_GRAY);
		d1.setBounds(302, 63, 66, 43);
		frame.getContentPane().add(d1);
		
		JLabel lblD = new JLabel("  D");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblD.setBounds(302, 10, 66, 43);
		frame.getContentPane().add(lblD);
	
		e5.setForeground(new Color(46, 139, 87));
		e5.setBackground(Color.LIGHT_GRAY);
		e5.setBounds(378, 283, 66, 44);
		frame.getContentPane().add(e5);
		
		e4.setForeground(new Color(46, 139, 87));
		e4.setBackground(Color.LIGHT_GRAY);
		e4.setBounds(378, 228, 66, 43);
		frame.getContentPane().add(e4);
		
		e3.setForeground(new Color(46, 139, 87));
		e3.setBackground(Color.LIGHT_GRAY);
		e3.setBounds(378, 175, 66, 43);
		frame.getContentPane().add(e3);
		
		e2.setForeground(new Color(46, 139, 87));
		e2.setBackground(Color.LIGHT_GRAY);
		e2.setBounds(378, 118, 66, 43);
		frame.getContentPane().add(e2);
	
		e1.setForeground(new Color(46, 139, 87));
		e1.setBackground(Color.LIGHT_GRAY);
		e1.setBounds(378, 63, 66, 43);
		frame.getContentPane().add(e1);
		
		JLabel lblE = new JLabel("  E");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblE.setBounds(378, 10, 66, 43);
		frame.getContentPane().add(lblE);
		
		JLabel lblCatchTheKing = new JLabel("Catch the king");
		lblCatchTheKing.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCatchTheKing.setBounds(42, 365, 290, 71);
		frame.getContentPane().add(lblCatchTheKing);
		
		
		battleDetails.setBackground(new Color(248, 248, 255));
		battleDetails.setBounds(637, 109, 306, 441);
		frame.getContentPane().add(battleDetails);
		
		JLabel lblBattleDetails = new JLabel("Battle Details");
		lblBattleDetails.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBattleDetails.setBounds(653, 21, 290, 71);
		frame.getContentPane().add(lblBattleDetails);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblScore.setBounds(637, 549, 105, 71);
		frame.getContentPane().add(lblScore);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setText("0");
		textField.setBounds(752, 565, 146, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setVisible(true);
	}
}
