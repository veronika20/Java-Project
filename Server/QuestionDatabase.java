import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionDatabase {

	private JFrame frmQuestions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionDatabase window = new QuestionDatabase();
					window.frmQuestions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuestionDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuestions = new JFrame();
		frmQuestions.setTitle("Questions");
		frmQuestions.setBounds(100, 100, 700, 700);
		frmQuestions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQuestions.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("Questions");
		lblQuestion.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		lblQuestion.setBounds(264, 13, 124, 40);
		frmQuestions.getContentPane().add(lblQuestion);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 66, 658, 531);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Vector<Vector<Object>> data = null;
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("Nomor");
        columnNames.add("Pertanyaan");
        columnNames.add("Jawaban");

        try {
            Database db = new Database();
            data = db.select();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // masukkan isi tabel question ke dalam JTable
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        panel.add(scrollPane, new BorderLayout().CENTER);
        
        // refresh JTable
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Vector<Vector<Object>> data = null;
                Vector<Object> columnNames = new Vector<Object>();
                columnNames.add("Nomor");
                columnNames.add("Pertanyaan");
                columnNames.add("Jawaban");

                try {
                	Database db = new Database();
                    data = db.select();
                } catch (Exception es) {
                    es.printStackTrace();
                }

             // masukkan isi tabel question ke dalam JTable
                // remove isi panel, add komponen, revalidate
                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                table.setFillsViewportHeight(true);
                table.setEnabled(false);
                panel.removeAll();
                panel.add(scrollPane, BorderLayout.CENTER);
                panel.revalidate();
        	}
        });
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRefresh.setBounds(301, 610, 97, 30);
        frmQuestions.getContentPane().add(btnRefresh);
		
		frmQuestions.getContentPane().add(panel);
        
        frmQuestions.setVisible(true);
	}

}
