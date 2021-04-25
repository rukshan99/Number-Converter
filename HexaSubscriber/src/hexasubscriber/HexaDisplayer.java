package hexasubscriber;

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

import hexapublisher.HexaConverterCalculator;
import hexapublisher.HexaService;

public class HexaDisplayer extends JDialog{
	private JPanel jPannel;
	private JButton btn_Convert, btn_Clear;
	private JTextField input_box, output_box;
	public String num;
	public JComboBox dropdown;
	public JLabel title, input, output;
	private HexaService hexaService;
	public String inputdec;
	public String outputHex;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HexaDisplayer frame = new HexaDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HexaDisplayer() {
		hexaService = (HexaService) new HexaConverterCalculator();

		setResizable(false);
		setTitle("IT19121352 - K.A.N.D. Kudarachchi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 750, 500);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);

		title = new JLabel("Hexa Decimal Converter");
		title.setFont(new Font("Arial", Font.PLAIN, 35));
		title.setBounds(210, 10, 460, 40);
		jPannel.add(title);

		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(60, 120, 250, 40);
		dropdown.setBackground(Color.white);
		jPannel.add(dropdown);

		dropdown.addItem("Decimal");
		dropdown.addItem("Octal");
		dropdown.addItem("Binary");

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

		btn_Convert = new JButton("Convert");
		btn_Convert.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btn_Convert.setBounds(140, 330, 100, 40);
		btn_Convert.setFocusable(false);
		btn_Convert.setBackground(Color.cyan);
		jPannel.add(btn_Convert);

		btn_Clear = new JButton("Clear");
		btn_Clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btn_Clear.setBounds(490, 330, 100, 40);
		btn_Clear.setFocusable(false);
		btn_Clear.setBackground(Color.cyan);
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

				String input_text_value = input_box.getText();
				num = String.valueOf(dropdown.getSelectedItem());



				if (input_text_value.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert",
							JOptionPane.OK_OPTION);


				} else if (input_text_value.length() > 10) {
					JOptionPane.showMessageDialog(null, "Input Value is Too High", "Alert", JOptionPane.OK_OPTION);
					output_box.setText(" ");

				} else {
					
					inputdec = input_box.getText();
					
					if (num.equalsIgnoreCase("Decimal")) {

						if (input_box.getText().matches("[0-9]+")) {
						
						outputHex = hexaService.DecimalHexadecimal(Integer.parseInt(inputdec));
						output_box.setText(outputHex);
						}
						else {
							JOptionPane.showMessageDialog(null, "Input Valid Numbers Between 0 - 9", "Alert",
									JOptionPane.OK_OPTION);
							output_box.setText(" ");
						}

					} else if (num.equalsIgnoreCase("Octal")) {
						if (input_box.getText().matches("[0-7]+")) {
							
							outputHex = hexaService.OctalHexadecimal(inputdec);
							output_box.setText(outputHex);
						}

						else {
							JOptionPane.showMessageDialog(null, "Input Valid Numbers Between 0 - 7", "Alert",
									JOptionPane.OK_OPTION);
							output_box.setText(" ");
						}

					} else if (num.equalsIgnoreCase("Binary")) {
						if (input_box.getText().matches("[01]+")) {
						
							outputHex = hexaService.BinaryHexadecimal(inputdec);
							output_box.setText(outputHex);
						} else {
							JOptionPane.showMessageDialog(null, "Input Should be 0 or 1", "Alert",
									JOptionPane.OK_OPTION);
							output_box.setText(" ");
						}

					}

				}
			}
		});

	}


}