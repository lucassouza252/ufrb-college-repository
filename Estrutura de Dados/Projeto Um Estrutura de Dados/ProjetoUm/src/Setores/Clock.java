package Setores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clock extends JFrame {

	private JPanel contentPane;
	private JLabel JClk,JClkGet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock frame = new Clock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Clock() {
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JClk = new JLabel();
		JClk.setBounds(10, 11, 273, 31);
		contentPane.add(JClk);
		
		Relogio clk = new Relogio(JClk);
	    Thread th = clk;
	    th.start();
		
		JButton btnPegarHora = new JButton("PEGAR HORA");
		btnPegarHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JClkGet.setText(clk.pegar());
			}
		});
		btnPegarHora.setBounds(10, 114, 122, 23);
		contentPane.add(btnPegarHora);
		
		JClkGet = new JLabel();
		JClkGet.setBounds(172, 118, 111, 14);
		contentPane.add(JClkGet);
	}
}
