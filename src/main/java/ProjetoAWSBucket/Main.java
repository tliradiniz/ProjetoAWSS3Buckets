package ProjetoAWSBucket;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_4;
	public String fileID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(597, 56, 375, 383);
		frame.getContentPane().add(textArea);
		
		JButton btnAdicionarInstncia = new JButton("Criar Bucket");
		btnAdicionarInstncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateBucket.CriarBucket(textField_2.getText());
					textField_2.setText("");
					textArea.setText(ListBuckets.listarBuckets());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdicionarInstncia.setBounds(10, 57, 152, 23);
		frame.getContentPane().add(btnAdicionarInstncia);
		
		JButton btnNewButton = new JButton("Deletar Bucket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteBucket.DeletarBucket(textField_2.getText());
				textField_2.setText("");
				textArea.setText(ListBuckets.listarBuckets());
			//	DescribeInstances.describe();
			//	textArea.setText(DescribeInstances.describe());
			}
		});
		
//		List<String> columns = new ArrayList<String>();
//        List<String[]> values = new ArrayList<String[]>();
//        
//        columns.add("Instance ID");
//        columns.add("State");
//		
//        for (int i = 0; i < DescribeInstances.describe().getId().size(); i++) {
//            values.add(new String[] {DescribeInstances.describe().getId().get(i),DescribeInstances.describe().getState().get(i)});
//        }
//        
//        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
//		table = new JTable(tableModel);
//		table.setBounds(180, 55, 244, 195);
//		frame.getContentPane().add(table);
		
		JLabel lblProjetoAmazonAws = new JLabel("PROJETO AMAZON AWS");
		lblProjetoAmazonAws.setBounds(10, 11, 199, 33);
		frame.getContentPane().add(lblProjetoAmazonAws);
		
		
		btnNewButton.setBounds(10, 91, 152, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(285, 126, 194, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Upload de Arquivo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UploadObject.upload(textField_2.getText(), textField_4.getText(), textField.getText());
					textArea.setText(ListObjects.listaObjetos(textField_2.getText()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StartStopInstance.startInstance(textField.getText());
			}
		});
		
		btnNewButton_1.setBounds(10, 125, 152, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnPararInstncia = new JButton("Remover Arquivo");
		btnPararInstncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteObject.deletar(textField_2.getText(), textField_4.getText());
				textArea.setText(ListObjects.listaObjetos(textField_2.getText()));
			//	StartStopInstance.stopInstance(textField_1.getText());
			}
		});
		btnPararInstncia.setBounds(10, 182, 152, 23);
		frame.getContentPane().add(btnPararInstncia);
		
		JLabel lblNome = new JLabel("Nome do Bucket");
		lblNome.setBounds(172, 61, 103, 14);
		frame.getContentPane().add(lblNome);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(285, 58, 194, 20);
		frame.getContentPane().add(textField_2);
		
		final JButton btnNewButton_2 = new JButton("Procurar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_2)
			    {
					JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); //Downloads Directory as default
			        chooser.setDialogTitle("Select Location");
			        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        chooser.setAcceptAllFileFilterUsed(false);

			        if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION)
			        { 
			            fileID = chooser.getSelectedFile().getPath();
			            textField.setText(fileID);
			        }
			    }
			}
		});
		btnNewButton_2.setBounds(172, 125, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(285, 157, 194, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNomeArquivo = new JLabel("Nome Arquivo");
		lblNomeArquivo.setBounds(172, 159, 103, 14);
		frame.getContentPane().add(lblNomeArquivo);
		
		JButton button = new JButton("Fazer Download");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XferMgrDownload.downloadFile(textField_2.getText(), textField_4.getText(), textField.getText(), false);
			}
		});
		button.setBounds(10, 216, 152, 23);
		frame.getContentPane().add(button);
		
		
		
		

		
	
		
		
	}
}
