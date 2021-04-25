package octalsubscriber;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import octalpublisher.OctalService;
import octalpublisher.OctalConverter;



public class OctalDisplayer extends JDialog {
	
private OctalService octalConvert;
	
	private JPanel jPannel;
	private JButton Convert,Clear;
	private JTextField input_box, output_box;
	public String units,units2;
	public JComboBox OctalDisplay;
	public JComboBox dropdown;
	public JLabel title,input,output;


	public String inputNumber,outputNumber;


	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					OctalDisplayer frame = new OctalDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			
			}
		
		});
		
	}
	
	
	public OctalDisplayer() {
		
		
		
		octalConvert = (OctalService) new OctalConverter();
		setResizable(false);
		setTitle("IT19126234 - S.L Jayasinghe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 750, 500);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Octal Converter");
		title.setFont(new Font("Arial", Font.PLAIN, 35));
		title.setBounds(260, 10, 460, 40);
		jPannel.add(title);
	
	
		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(60, 120, 250, 40);
		dropdown.setBackground(Color.white);
		jPannel.add(dropdown);
		
		dropdown.addItem("Decimal");
		dropdown.addItem("Binary");
		dropdown.addItem("Hexa Decimal");
		
		input = new JLabel("Input");
		input.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		input.setBounds(160, 80, 200, 20);
		jPannel.add(input);

		output = new JLabel("Output");
		output.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		output.setBounds(480, 80, 200, 20);
		jPannel.add(output);

		input_box = new JTextField();
		input_box.setHorizontalAlignment(SwingConstants.CENTER);
		input_box.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		input_box.setBounds(50, 180, 280, 70);

		input_box.setColumns(10);
		jPannel.add(input_box);
		
		output_box = new JTextField();
		output_box.setEditable(false);
		output_box.setBackground(Color.white);
		output_box.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		output_box.setHorizontalAlignment(SwingConstants.CENTER);
		output_box.setBounds(400, 180,280, 70);		
		output_box.setColumns(10);
		jPannel.add(output_box);

		

		Convert = new JButton("Convert");
		Convert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Convert.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Convert.setBackground(Color.cyan);
		Convert.setBounds(140, 330, 100, 40);
		Convert.setFocusable(false);
		jPannel.add(Convert);

		Clear = new JButton("Clear");
		Clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Clear.setBounds(490, 330, 100, 40);
		Clear.setBackground(Color.cyan);
		Clear.setFocusable(false);
		jPannel.add(Clear);
		
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				input_box.setText("");
				output_box.setText("");
			}
		});
		Convert.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				units = String.valueOf(dropdown.getSelectedItem());
				String input_text_value = input_box.getText();

			if (input_text_value.isEmpty()) {
				
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);
			
			} else {
				
					inputNumber = input_box.getText();

					if ((units.equalsIgnoreCase("Decimal"))  ) {
						
						if  (inputNumber.matches("[0-9]+")) {
						
							outputNumber = octalConvert.DecimalToOctal(inputNumber);
					
						}
						else {
						
							JOptionPane.showMessageDialog(null, " Invalid Input", "Alert", JOptionPane.OK_OPTION);
							System.out.println("Invalid number");
							outputNumber ="";
						}
					}
					
					else if ((units.equalsIgnoreCase("Binary"))) {
						
						if (inputNumber.matches("[01]+")) {
	
								outputNumber = octalConvert.BinaryToOctal(inputNumber);
	
						}
						
						else {
							
							JOptionPane.showMessageDialog(null, " Invalid Input", "Alert", JOptionPane.OK_OPTION);
							System.out.println("Invalid number");
							outputNumber ="";
							}
					}  
					
					
					else if ((units.equalsIgnoreCase("Hexa Decimal")) ) {
						
						if (inputNumber.matches("[0123456789ABCDEF]+")) {
							
							outputNumber = octalConvert.HexaDecimalToOctal(inputNumber);
							
						
						}
						else {
							
							JOptionPane.showMessageDialog(null, " Invalid Input", "Alert", JOptionPane.OK_OPTION);
							System.out.println("Invalid number");
							outputNumber ="";
							
						}
					}
					
			}
					output_box.setText(outputNumber);

				}

			
			
		});
	}

}
