import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HistoryDatabase {

	private JFrame frmHistory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryDatabase window = new HistoryDatabase();
					window.frmHistory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoryDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistory = new JFrame();
		frmHistory.setTitle("History");
		frmHistory.setBounds(100, 100, 700, 700);
		frmHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHistory.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("History");
		lblQuestion.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		lblQuestion.setBounds(288, 13, 110, 40);
		frmHistory.getContentPane().add(lblQuestion);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 66, 658, 531);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Vector<Vector<Object>> data = null;
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("Nama");
        columnNames.add("IP Address");
        columnNames.add("Tanggal & Waktu");
        columnNames.add("Score");

        try {
            Database db = new Database();
            data = db.select_history();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // masukkan isi tabel score ke dalam JTable
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
                columnNames.add("Nama");
                columnNames.add("IP Address");
                columnNames.add("Tanggal & Waktu");
                columnNames.add("Score");

                try {
                	Database db = new Database();
                	data = db.select_history();
                } catch (Exception es) {
                    es.printStackTrace();
                }

                // masukkan isi tabel score ke dalam JTable
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
        frmHistory.getContentPane().add(btnRefresh);
		
		frmHistory.getContentPane().add(panel);
        
        frmHistory.setVisible(true);
	}

}
