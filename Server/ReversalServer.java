import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReversalServer {

	private JFrame frmAdminForm;
	private JTextField text1;
	private JTextField text2;
	private JTextField text4;
	private JTextField text3;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReversalServer window = new ReversalServer();
					window.frmAdminForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		final int PORT = 9090;
		System.out.println("The server is running on port " + PORT);

		// socket
		ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                Socket s = listener.accept();
                Thread t = new Reversal(s);
                t.start();
            }
        }
        finally {
            listener.close();
        }
	}

	/**
	 * Create the application.
	 */
	public ReversalServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminForm = new JFrame();
		frmAdminForm.setTitle("Admin Form");
		frmAdminForm.setBounds(100, 100, 800, 550);
		frmAdminForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdminForm.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Insert & Update Question", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 68, 758, 223);
		frmAdminForm.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nomor Pertanyaan (hanya untuk update):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 39, 314, 28);
		panel.add(lblNewLabel);
		
		JLabel lblPertanyaan = new JLabel("Pertanyaan:");
		lblPertanyaan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPertanyaan.setBounds(12, 80, 95, 28);
		panel.add(lblPertanyaan);
		
		JLabel lblJawaban = new JLabel("Jawaban:");
		lblJawaban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJawaban.setBounds(12, 127, 79, 28);
		panel.add(lblJawaban);
		
		text1 = new JTextField();
		text1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text1.setColumns(10);
		text1.setBounds(103, 78, 649, 34);
		panel.add(text1);
		
		text2 = new JTextField();
		text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text2.setColumns(10);
		text2.setBounds(103, 125, 649, 34);
		panel.add(text2);
		
		JButton button1 = new JButton("Insert");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button1.setBounds(279, 172, 97, 38);
		panel.add(button1);
		
		JButton button2 = new JButton("Update");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(388, 172, 97, 38);
		panel.add(button2);
		
		text3 = new JTextField();
		text3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text3.setColumns(10);
		text3.setBounds(299, 39, 198, 30);
		panel.add(text3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Delete Question", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 304, 360, 186);
		frmAdminForm.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomorPertanyaan = new JLabel("Nomor Pertanyaan:");
		lblNomorPertanyaan.setBounds(12, 51, 138, 19);
		lblNomorPertanyaan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNomorPertanyaan);
		
		text4 = new JTextField();
		text4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text4.setColumns(10);
		text4.setBounds(150, 46, 198, 30);
		panel_1.add(text4);
		
		JButton button3 = new JButton("Delete");
		button3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button3.setBounds(131, 119, 97, 38);
		panel_1.add(button3);
		
		JButton btnShowQuestionDatabase = new JButton("Show Question Database");
		btnShowQuestionDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// buka form QuestionDatabase
				new QuestionDatabase();
			}
		});
		btnShowQuestionDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowQuestionDatabase.setBounds(458, 341, 239, 43);
		frmAdminForm.getContentPane().add(btnShowQuestionDatabase);
		
		JButton btnShowHistoryDatabase = new JButton("Show History Database");
		btnShowHistoryDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// buka form HistoryDatabase
				new HistoryDatabase();
			}
		});
		btnShowHistoryDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowHistoryDatabase.setBounds(458, 409, 239, 43);
		frmAdminForm.getContentPane().add(btnShowHistoryDatabase);
		
		JLabel lblAdminForm = new JLabel("Admin Form");
		lblAdminForm.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		lblAdminForm.setBounds(292, 13, 180, 48);
		frmAdminForm.getContentPane().add(lblAdminForm);
		
		// insert question
		button1.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                if (text1.getText().equals("") && text2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Pertanyaan dan jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (text1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Pertanyaan tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (text2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        Database db = new Database();

                        db.insert(text1.getText(), text2.getText());
                        Vector<Vector<Object>> data = null;
                        Vector<Object> columnNames = new Vector<Object>();
                        columnNames.add("Nomor");
                        columnNames.add("Pertanyaan");
                        columnNames.add("Jawaban");

                        try {
                            data = db.select();
                        } catch (Exception es) {
                            es.printStackTrace();
                        }

                        text1.setText("");
                        text2.setText("");
                        text3.setText("");
                    }
                    catch(Exception ef){
                        System.out.println(ef);
                    }
                }
            }
        });

		// update question
        button2.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent z){
                try {
                    if (text1.getText().equals("") && text2.getText().equals("") && text3.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Nomor, pertanyaan, dan jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text1.getText().equals("") && text2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Pertanyaan dan jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text1.getText().equals("") && text3.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Nomor dan pertanyaan tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text2.getText().equals("") && text3.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Nomor dan jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Pertanyaan tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Jawaban tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (text3.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Nomor tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        Database db = new Database();
                        db.update(Integer.parseInt(text3.getText()), text1.getText(), text2.getText());
                        Vector<Vector<Object>> data = null;
                        Vector<Object> columnNames = new Vector<Object>();
                        columnNames.add("Nomor");
                        columnNames.add("Pertanyaan");
                        columnNames.add("Jawaban");

                        try {
                            data = db.select();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        text1.setText("");
                        text2.setText("");
                        text3.setText("");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        });

        // delete question
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Database db = new Database();

                    db.delete(Integer.parseInt(text4.getText()));
                    Vector<Vector<Object>> data = null;
                    Vector<Object> columnNames = new Vector<Object>();
                    columnNames.add("Nomor");
                    columnNames.add("Pertanyaan");
                    columnNames.add("Jawaban");

                    try {
                        data = db.select();
                    }
                    catch (Exception ea) {
                        ea.printStackTrace();
                    }
                    
                    text4.setText("");
                }
                catch(Exception ef){
                    System.out.println(ef);
                }
            }
        });
	}
}

class Reversal extends Thread {
    private Socket socket;
    private String client;

    Reversal(Socket s){
        socket = s;
        client = s.getRemoteSocketAddress().toString();
        System.out.println("Incomming connection from " + client);
    }

    public void run(){
        try {
        	// untuk menerima input dari client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // untuk mengirim output ke client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String nama = "";
            while (nama.equals("")) {
            	// menerima input dari client berupa nama
                nama = in.readLine();
            }

            System.out.println("client " + client + " dengan username " + nama);

            Database db = new Database();
            Vector data = null;

            try {
            	// select nomor pertanyaan dari database
                data = db.selectnomor();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            int random;
            String no_quest;
            int no_q;
            String question;
            String answer;
            int[] acak = new int[10000];
            int a = 0;
            
            int lives = 5;
            boolean right = false;

            while (lives > 0) {
            	// random index vector
            	int randomNum = 1 + (int)(Math.random() * data.size());
            	// get data pada index randomNum-1
                no_quest = data.get(randomNum-1).toString();
                no_q = Integer.parseInt(no_quest);
                
                // jika pertanyaan sama dengan pertanyaan yang sudah muncul sebelumnya, akan dirandom lagi
                int i = 0;
                if (a > 0){
	                while(i < a){
	                	if (no_q == acak[i]){
	                		randomNum = 1 + (int)(Math.random() * ((data.size() - 1) + 1));
	                		no_quest = data.get(randomNum-1).toString();
	                        no_q = Integer.parseInt(no_quest);
	                        i = -1;
	                	}
	                	i++;
	                }
                }
                
                acak[a] = no_q;
                a++;
                // get pertanyaan dengan nomor pertanyaan = no_q
                question = db.select_pertanyaan(no_q);
                // get jawaban dengan nomor pertanyaan = no_q
                answer = db.select_jawaban(no_q);
                String input = "";
                // mengirim output variabel question ke client
                out.println(question);
                while (!input.toLowerCase().equals(answer.toLowerCase()) && lives > 0){
                	// menerima input dari client berupa jawaban
                    input = in.readLine();
                    System.out.println(question);
                    System.out.println(nama + ": " + input);
                    // mengirim output berupa status jawaban dan lives ke client
                    if (input.toLowerCase().equals(answer.toLowerCase())){
                        out.println("Right");
                        out.println(lives);
                    }
                    else
                    {
                        out.println("False");
                        lives = lives - 1;
                        out.println(lives);
                    }
                }

            }
            // jika game sudah selesai, menerima input dari client berupa score
            int scoreakhir = Integer.parseInt(in.readLine());
            Vector score = null;

            try {
            	// select score dari database
                score = db.select_highscore();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
            // cari nilai max
            String high_score = Collections.max(score).toString();
            // mengirim output berupa highscore ke client
            out.println(high_score);
            
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String tanggal_waktu = dtf.format(now).toString();
            // insert ke dalam tabel history
            db.insert_history(nama, client, tanggal_waktu, scoreakhir);   
        }
        catch (Exception e) {
            System.out.println("Error " + client + ": " + e);
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e) {
                 e.printStackTrace();
            }
            System.out.println("Close connection from " + client);
        }
    }
}
