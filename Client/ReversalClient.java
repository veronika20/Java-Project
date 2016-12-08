import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

public class ReversalClient {
    ReversalClient() throws IOException, FileNotFoundException {
        // connect ke server
        try (Socket s = new Socket("192.168.1.105", 9090)){
            // buka interface main form
            MainForm();
            String nama = "";
            File file = new File("nama.txt");

            // selama file nama.txt belum ada
            while(!file.exists()) {
                Thread.sleep(1000);
            }

            // baca isi dari file nama.txt lalu masukkan ke variabel nama
            FileReader inputFile1 = new FileReader("nama.txt");
            BufferedReader bufferReader1 = new BufferedReader(inputFile1);
            nama = bufferReader1.readLine();
            bufferReader1.close();

            // untuk menerima input dari server
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // untuk mengirim output ke server
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            // mengirim output berupa nama ke server
            out.println(nama);
            // delete file
            file.delete();

            int score = 0;
            int count = 0;

            String ans = "";

            int lives = 5;

            while(lives > 0) {
                // menerima input dari server berupa pertanyaan
                String question = in.readLine();
                count = count + 1;
                String right = "False";

                while(lives > 0 && right.equals("False")){
                    // buka interface game
                    gui(question, count, lives, score, nama);

                    File f = new File("answer.txt");
                    // selama file answer.txt belum ada
                    while(!f.exists()){
                        Thread.sleep(1000);
                    }

                    // baca isi dari file answer.txt lalu masukkan ke variabel ans
                    FileReader inputFile = new FileReader("answer.txt");
                    BufferedReader bufferReader = new BufferedReader(inputFile);
                    ans = bufferReader.readLine();
                    bufferReader.close();

                    // mengirim output berupa jawaban ke server
                    out.println(ans);
                    // delete file
                    f.delete();

                    // menerima input dari server berupa status game dan live
                    right = in.readLine();
                    lives = Integer.parseInt(in.readLine());

                }
                // jika jawaban benar, maka score +100
                if (right.equals("Right")){
                    score = score + 100;
                    JOptionPane.showMessageDialog(null, "Jawaban Anda benar!");
                }
            }
            // jika lives habis maka game over
            JOptionPane.showMessageDialog(null, "Game Over!");
            // mengirim output berupa score ke server
            out.println(score);
            // menerima input dari server berupa highscore
            String highscore = in.readLine();
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.BOLD, 13)));

            // jika score lebih kecil sama dengan highscore
            if (score <= Integer.parseInt(highscore)){
                JOptionPane.showMessageDialog(null,  "Your score: " + Integer.toString(score) + "\n" + "Highscore: " + highscore + "\n" + "Let's try again! :)");
            }
            // jika score lebih besar dari highscore
            else {
                JOptionPane.showMessageDialog(null, "Excellent! You beat the highscore! \n" + "Your score: " + Integer.toString(score) + "\n" + "Previous highscore: " + highscore);
            }

            new ReversalClient();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // interface game
    public void gui(String question, int count, int lives, int score, String nama){
        JFrame frmQuiz = new JFrame();
        frmQuiz.getContentPane().setBackground(UIManager.getColor("Button.background"));
        frmQuiz.setForeground(Color.WHITE);
        frmQuiz.setTitle("Quiz");
        frmQuiz.setBackground(Color.WHITE);
        frmQuiz.setBounds(100, 100, 850, 550);
        frmQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmQuiz.getContentPane().setLayout(null);

        JLabel label5 = new JLabel("Hello, " + nama + "!");
        label5.setForeground(Color.RED);
        label5.setBackground(Color.RED);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        label5.setBounds(604, 13, 216, 30);
        frmQuiz.getContentPane().add(label5);

        JLabel label1 = new JLabel("Lives: " + Integer.toString(lives));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label1.setBounds(12, 86, 96, 30);
        frmQuiz.getContentPane().add(label1);

        JLabel label2 = new JLabel("Score: " + Integer.toString(score));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label2.setForeground(Color.RED);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label2.setBounds(724, 86, 96, 30);
        frmQuiz.getContentPane().add(label2);

        JLabel label4 = new JLabel("Pertanyaan ke-" + Integer.toString(count));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.RED);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label4.setBounds(325, 131, 195, 30);
        frmQuiz.getContentPane().add(label4);

        JLabel lblQ = new JLabel("Q: " + question);
        lblQ.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblQ.setHorizontalAlignment(SwingConstants.CENTER);
        lblQ.setBounds(12, 174, 808, 67);
        frmQuiz.getContentPane().add(lblQ);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textField.setBackground(Color.WHITE);
        textField.setBounds(126, 255, 566, 57);
        frmQuiz.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\Veronika\\Desktop\\Java New\\Untitled-4.png"));
        label.setBounds(724, 382, 100, 108);
        frmQuiz.getContentPane().add(label);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSubmit.setBounds(377, 325, 97, 35);
        frmQuiz.getContentPane().add(btnSubmit);

        // isi jawaban ke file answer.txt
        textField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        PrintWriter output = new PrintWriter("answer.txt");
                        output.write(textField.getText());
                        output.close();
                        frmQuiz.dispose();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        // isi jawaban ke file answer.txt
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter output = new PrintWriter("answer.txt");
                    output.write(textField.getText());
                    output.close();
                    frmQuiz.dispose();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frmQuiz.setVisible(true);
    }


    // interface main form
    public void MainForm(){
        JFrame frmWelcome = new JFrame();
        frmWelcome.setTitle("Welcome");
        frmWelcome.setBounds(100, 100, 550, 550);
        frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmWelcome.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("WELCOME!!!");
        lblWelcome.setFont(new Font("Broadway", Font.PLAIN, 35));
        lblWelcome.setBounds(142, 13, 287, 73);
        frmWelcome.getContentPane().add(lblWelcome);

        JLabel lblTestYourKnowledge = new JLabel("Test your knowledge about Indonesia here! :)");
        lblTestYourKnowledge.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblTestYourKnowledge.setBounds(47, 83, 446, 27);
        frmWelcome.getContentPane().add(lblTestYourKnowledge);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
        lblName.setBounds(229, 201, 77, 27);
        frmWelcome.getContentPane().add(lblName);

        JTextField text1 = new JTextField();
        text1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        text1.setBounds(97, 227, 343, 48);
        frmWelcome.getContentPane().add(text1);
        text1.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Veronika\\Desktop\\Java New\\Untitled-2.png"));
        lblNewLabel.setBounds(420, 390, 100, 100);
        frmWelcome.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Veronika\\Desktop\\Java New\\Untitled-2.png"));
        label.setBounds(12, 390, 100, 100);
        frmWelcome.getContentPane().add(label);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("C:\\Users\\Veronika\\Desktop\\Java New\\Untitled-2.png"));
        label_1.setBounds(142, 390, 100, 100);
        frmWelcome.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon("C:\\Users\\Veronika\\Desktop\\Java New\\Untitled-2.png"));
        label_2.setBounds(279, 390, 100, 100);
        frmWelcome.getContentPane().add(label_2);

        // isi nama ke file nama.txt
        text1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        PrintWriter output = new PrintWriter("nama.txt");
                        output.write(text1.getText());
                        output.close();
                        frmWelcome.dispose();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        // isi nama ke file nama.txt
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    PrintWriter output = new PrintWriter("nama.txt");
                    output.write(text1.getText());
                    output.close();
                    frmWelcome.dispose();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlay.setBounds(212, 288, 97, 35);
        frmWelcome.getContentPane().add(btnPlay);

        frmWelcome.setVisible(true);
    }

    public static void main(String args[]) throws IOException {
        new ReversalClient();
    }
}
