
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ExemploLayout  implements ActionListener {
	JTextArea textArea;

	public ExemploLayout() {
		JFrame frame;
		frame = new JFrame("Exemplo Layout");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JButton button;
		
		//Regiao North
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.setBackground(Color.black);
		button = new JButton("Botão 1");
		button.addActionListener(this);
		p1.add(button);
		button = new JButton("Botão 2");
		button.addActionListener(this);
		p1.add(button);
		button = new JButton("Botão 3");
		button.addActionListener(this);
		p1.add(button);
		frame.add( p1, "North");
		
		//Regiao South
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.setBackground(Color.RED);
		button = new JButton("Botão 4");
		button.addActionListener(this);
		p2.add(button);
		button = new JButton("Botão 5");
		button.addActionListener(this);
		p2.add(button);
		button = new JButton("Botão 6");
		button.addActionListener(this);
		p2.add(button);
		frame.add( p2, BorderLayout.SOUTH);
		
		//Regiao East
		JPanel p3 = new JPanel(new GridLayout(2, 1));
		button = new JButton("Limpar");
		button.addActionListener(this);
		p3.add(button);
		button = new JButton("Fechar");
		button.addActionListener(this);
		p3.add(button);
		frame.add(p3, "East");
		
		//Regiao West
		JPanel p4 = new JPanel(new GridLayout(2, 1));
		button = new JButton("Limpar");
		button.addActionListener(this);
		p4.add(button);
		button = new JButton("Fechar");
		button.addActionListener(this);
		p4.add(button);
		JPanel p5 = new JPanel();
		p5.add(p4);
		p5.setBackground(Color.green);
		frame.add(p5, BorderLayout.WEST);

		//Regiao Center
		textArea = new JTextArea();
		textArea.setEditable(false);	 	
		JScrollPane scroll = new JScrollPane(textArea);
		frame.add(scroll, "Center");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Fechar")) {
			System.exit(0);	
		}else if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
			textArea.setText("");
		}else {
			textArea.setText(textArea.getText()+e.getActionCommand() + "\n");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new ExemploLayout();
			}
		});
	}
}