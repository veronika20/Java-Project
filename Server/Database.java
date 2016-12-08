import java.sql.*;
import java.util.Vector;

public class Database {
    private Connection conn;

    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database", "root", "");
    }

    public boolean isConnected() {
        return (conn != null);
    }

    // insert pertanyaan dan jawaban ke dalam tabel question
    public void insert(
            String pertanyaan,
            String jawaban
    ) throws Exception{
        String query = "INSERT INTO question(pertanyaan, jawaban) VALUES(?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, pertanyaan);
        stmt.setString(2, jawaban);
        stmt.execute();
        stmt.close();
    }

 // select tabel question
    public Vector<Vector<Object>> select() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM question");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // return the resultset as Vector
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getInt("no"));
            v.add(rs.getString("pertanyaan"));
            v.add(rs.getString("jawaban"));
            data.add(v);
        }
        return data;
    }

    // update tabel question berdasarkan nomor pertanyaan
    public void update(
            int no,
            String pertanyaan,
            String jawaban
    )throws Exception{
        String query = "UPDATE question SET pertanyaan = ?, jawaban = ? WHERE no = ?";
        PreparedStatement a;
        a = conn.prepareStatement(query);
        a.setString(1, pertanyaan);
        a.setString(2, jawaban);
        a.setInt(3, no);
        a.executeUpdate();
    }

    // delete pertanyaan dari tabel question berdasarkan nomor pertanyaan
    public void delete(
            int nomor
    )throws Exception{
        String query = "DELETE from question WHERE no = ?";
        PreparedStatement a;
        a = conn.prepareStatement(query);
        a.setInt(1, nomor);
        a.executeUpdate();
    }

    // select isi kolom no dari tabel question
    public Vector selectnomor() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT no FROM question");

        Vector data = new Vector(); // return the resultset as Vector
        while (rs.next()) {
            data.add(rs.getInt("no"));
        }
        return data;
    }

    // select pertanyaan dari tabel question berdasarkan nomor pertanyaan
    public String select_pertanyaan(int nomor) throws Exception {
        String query = "SELECT pertanyaan from question WHERE no = " + nomor;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        String value = "";

        if (rs.next()) {
            value = rs.getString("pertanyaan");
        }
        return value;
    }

    // select jawaban dari tabel question berdasarkan nomor pertanyaan
    public String select_jawaban(int nomor) throws Exception {
        String query = "SELECT jawaban from question WHERE no = " + nomor;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        String value = "";

        if (rs.next()) {
            value = rs.getString("jawaban");
        }
        return value;
    }
    
    // insert history ke dalam tabel score
    public void insert_history(
            String nama,
            String ip_address,
            String tanggal_waktu,
            int score
    ) throws Exception{
        String query = "INSERT INTO score(nama, ip_address, tanggal_waktu, score) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, nama);
        stmt.setString(2, ip_address);
        stmt.setString(3, tanggal_waktu);
        stmt.setInt(4, score);
        stmt.execute();
        stmt.close();
    }
    
    // select tabel score
    public Vector<Vector<Object>> select_history() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM score");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // return the resultset as Vector
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getString("nama"));
            v.add(rs.getString("ip_address"));
            v.add(rs.getString("tanggal_waktu"));
            v.add(rs.getInt("score"));
            data.add(v);
        }
        return data;
    }
    
    // select isi kolom score dari tabel score
    public Vector select_highscore() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT score FROM score");

        Vector data = new Vector(); // return the resultset as Vector
        while (rs.next()) {
            data.add(rs.getInt("score"));
        }
        return data;
    }
}
