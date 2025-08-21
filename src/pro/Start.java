package pro;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.imageio.*;
import java.io.*;



public class Start extends JFrame {

	private JPanel contentPane;
	JFrame F = new JFrame(" Maze Collapse 1");
	
	static int i = 50;
	JButton start, contin, exit;
	public static int nrlvl ;
	public static int count;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true); 					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	
	private void resetCounter() { 
//		 counterlvl1 = 0;
	}

	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscape = new JLabel("Maze Collapse 1");
		lblEscape.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEscape.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscape.setForeground(Color.WHITE);
		lblEscape.setBounds(218, 60, 234, 59);
		contentPane.add(lblEscape);
		
		Button button_1 = new Button("Exit");
//		button_1.setIcon(new ImageIcon(""));
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				 System.exit(0);
			}
		});
 		button_1.setBackground(new Color(230, 230, 250)); 
		button_1.setBounds(268, 353, 125, 39);
		contentPane.add(button_1);
		
		
		
		Button button = new Button("Start");
		button.setBackground(new Color(230, 230, 250));
		button.setActionCommand("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   
 
				
				SubjectObserver subject = new SubjectObserver();
				new StartObserver(subject);
				subject.setState(0);
				
				dispose();
				F.dispose();
				 BaseLevel baseLevel = new BaseLevel();  // Creezi nivelul de bază
	                PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);  // Adaugi funcționalitatea de puncte

				
				Level1 lvl1 = new Level1(pointsDecorator);
				//lvl1.playMusic();
				lvl1.setVisible(true);
			

			}
		});
		button.setBounds(268, 265, 125, 39);
		contentPane.add(button);
		
		Button btnNewButton = new Button("Continue");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SubjectObserver subject = new SubjectObserver();
				new ContinueObserver(subject);
				subject.setState(1);
				
				
				NameRepository NameRepository = new NameRepository();
				count = NameRepository.getCount(); 
				
				System.out.println("Ati ajuns la lvl-ul : " + count);
				
				if (count == 1) {
					BaseLevel baseLevel = new BaseLevel();  // Creezi nivelul de bază
				    PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);  // Adaugi funcționalitatea de puncte

					Level1 lvl1 = new Level1(pointsDecorator);
					lvl1.setVisible(true);
					//lvl1.playMusic();
					
					LevelFactory factory = new Level1Factory();
					Level level = factory.createLevel();
					dispose();	
			
				}		
				
				if (count == 2) {
					BaseLevel baseLevel = new BaseLevel();  // Creezi nivelul de bază
				    PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);  // Adaugi funcționalitatea de puncte

					Level2 lvl2 = new Level2(pointsDecorator);
					lvl2.setVisible(true);
					//lvl2.playMusic();
					LevelFactory factory = new Level2Factory();
					Level level = factory.createLevel();
					dispose();	
			
				}	
				if (count == 3) {
					BaseLevel baseLevel = new BaseLevel();  // Creezi nivelul de bază
				    PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);
					Level3 lvl3 = new Level3(pointsDecorator);
					lvl3.setVisible(true);
					//lvl3.playMusic();
					dispose();	
					LevelFactory factory = new Level3Factory();
					Level level = factory.createLevel();
				}	
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(268, 190, 125, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblescapemain = new JLabel("");
		lblescapemain.setIcon(new ImageIcon("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\Proiect\\h.jpg"));
		lblescapemain.setBounds(0, 0, 811, 553);
		contentPane.add(lblescapemain);
		
		
		start = new JButton("Start");
		start.setIcon(new ImageIcon(""));
		contentPane.add(start);
		
//		getContentPane().setLayout(new FlowLayout());
//		getContentPane().add(start);
		
		
}
	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}	
}
