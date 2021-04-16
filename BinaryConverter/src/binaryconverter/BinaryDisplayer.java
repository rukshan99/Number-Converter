package binaryconverter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	
	public class BinaryDisplayer extends JDialog {
		
		private JPanel jPannel;
		private JButton btn_Convert,btn_Clear;
		private JTextField input_box, output_box;
		public String units;
		public JComboBox dropdown;
		public JLabel title,input,output;
		private BinaryService binaryCal;
		String outputValue;
		String inputValue;
		ErrorHandling errorHandling = new ErrorHandling();

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						BinaryDisplayer frame = new BinaryDisplayer();
						frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
		public BinaryDisplayer() {
			binaryCal = new BinaryCalculate();
			setResizable(false);
			setTitle("");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 80, 750, 500);
			setLocationRelativeTo(null);
			jPannel = new JPanel();
			jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(jPannel);
			jPannel.setLayout(null);
			
			title = new JLabel("Binary Converter");
			title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			title.setBounds(260, 20, 460, 40);
			jPannel.add(title);
			
			dropdown = new JComboBox();
			dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
			dropdown.setBounds(280, 85, 200, 40);
			jPannel.add(dropdown);
			
			dropdown.addItem(" Decimal To Binary");
			dropdown.addItem(" Octal To Binary");
			dropdown.addItem(" Hexa To Binary");
			


			input = new JLabel("Input");
			input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			input.setBounds(160, 120, 60, 20);
			jPannel.add(input);
			
			output = new JLabel("Output");
			output.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			output.setBounds(510, 120, 60, 20);
			jPannel.add(output);
			
			input_box = new JTextField();
			input_box.setHorizontalAlignment(SwingConstants.CENTER);
			input_box.setFont(new Font("Tahoma", Font.BOLD, 20));
			input_box.setBounds(50, 160, 280, 140);
			input_box.setColumns(10);
			jPannel.add(input_box);

			output_box = new JTextField();
			output_box.setEditable(false);
			output_box.setBackground(Color.WHITE);
			output_box.setFont(new Font("Tahoma", Font.BOLD, 20));
			output_box.setHorizontalAlignment(SwingConstants.CENTER);
			output_box.setColumns(10);
			output_box.setBounds(400, 160,280, 140);
			jPannel.add(output_box);

			

			btn_Convert = new JButton("Convert");
			btn_Convert.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_Convert.setBounds(140, 330, 100, 40);
			btn_Convert.setFocusable(false);
			jPannel.add(btn_Convert);

			btn_Clear = new JButton("Clear");
			btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_Clear.setBounds(490, 330, 100, 40);
			btn_Clear.setFocusable(false);
			jPannel.add(btn_Clear);
			
			btn_Clear.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					input_box.setText("");
					output_box.setText("");
				}
			});

			btn_Convert.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					units = String.valueOf(dropdown.getSelectedItem());

					String input_text_value = input_box.getText();


					if (input_text_value.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);
						}

						else if (input_text_value.length() > 10) {
						JOptionPane.showMessageDialog(null, "Input Value is Too High", "Alert", JOptionPane.OK_OPTION);
						output_box.setText(" ");

					} else {
						
						inputValue = input_box.getText();
						
						 if(units.equalsIgnoreCase(" Decimal To Binary")) 
								outputValue = binaryCal.DecimalToBinary(Integer.parseInt(inputValue));
						else if ((units.equalsIgnoreCase(" Octal To Binary")) && !errorHandling.isOctal(inputValue)) {
								input_box.setText("");
								JOptionPane.showMessageDialog(null, "Invalid Octal Value! Please Enter Again.", "Alert", JOptionPane.OK_OPTION);
							}
						else if(units.equalsIgnoreCase(" Octal To Binary"))	outputValue = binaryCal.OctalToBinary(inputValue);
							 
						else if((units.equalsIgnoreCase(" Hexa To Binary"))&& !errorHandling.isHexa(inputValue)) {
							input_box.setText("");
							JOptionPane.showMessageDialog(null, "Invalid Hexa Value! Please Enter Again.", "Alert", JOptionPane.OK_OPTION);
						}
						else if (units.equalsIgnoreCase(" Hexa To Binary"))outputValue = binaryCal.HexaToBinary(inputValue);
						
					}
							output_box.setText(outputValue);
				
				}
			});
		}

	
}
