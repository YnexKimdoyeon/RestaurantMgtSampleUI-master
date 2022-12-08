package home;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class DataBase {
    Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public DataBase(){

        String server = "localhost"; // 서버 주소
        String user_name = "root"; //  접속자 id
        String password = "1234"; // 접속자 pw

        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);

        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

    }

    public int login(String name , String number ,String userID, String userPassword) throws SQLException {
        String SQL = "SELECT * FROM account.profile WHERE id = ?";
        try {
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1,  userID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).contentEquals(name) && rs.getString(2).contentEquals(number) &&
                rs.getString(3).contentEquals(userID) && rs.getString(4).contentEquals(userPassword)) {
                    return 1; // 로그인 성공
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -2;
    }
    void UserScheduleAdd(String[] Arr) throws SQLException {
        String Clear = String.format("TRUNCATE userschedule.%s", Session.getUserId());
        Statement stmt = con.createStatement();
        stmt.executeUpdate(Clear);
        for (String s : Arr) {

            String Data = String.format("INSERT INTO userschedule.%s VALUES ('%s')", Session.getUserId() , s);
            stmt.executeUpdate(Data);
        }
        new AlterController("성공적으로 저장돼었습니다!");
        con.close();
    }

    public ArrayList<String> UserSchedulePrint() throws SQLException{ //받을것 : 요일 , 시간 , 관?
        String sql = "select * from userschedule." + Session.getUserId();
        String str;
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        ArrayList<String> ListRoom = new ArrayList<>();
        while(rs.next()) {
            String s = (rs.getString("UserData"));
            String[] Split1 = s.split(" ");
            ArrayList<String> ListRoomToString = new SelectRoom().PrintRoom(Split1[0] , "1" , "inmun" , Integer.parseInt(Split1[1]) , Integer.parseInt(Split1[2]) , 1);
            str = String.join(",", ListRoomToString);
            ListRoom.add(Split1[0] +"," + Split1[1] + "교시," + str);

        }
        con.close();
        rs.close();
        return ListRoom;
    }

    public ArrayList<String> UserSchedulePrintList(){
        String sql = "select * from userschedule." + Session.getUserId();

        ArrayList<String> ListRoom = new ArrayList<>();
        try{
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ListRoom.add(rs.getString("UserData"));
            }
            con.close();
            rs.close();
        }
        catch (Exception e){
            new AlterController("해당하는 데이터가 존재하지 않습니다.");
        }
        return ListRoom;
    }


    int signup(String Name , String StudentNumber, String Id, String Password){
        String sql = "select id From account.profile where id = ?";
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,Id);
            rs = pstmt.executeQuery();
            String GoSignup = String.format("INSERT INTO account.profile VALUES ('%s' , '%s', '%s', '%s')" , Name , StudentNumber , Id , Password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(GoSignup);

            String DbCreate = String.format("CREATE table userschedule.%s (UserData VARCHAR(30));" , Id);
            stmt = con.createStatement();
            stmt.executeUpdate(DbCreate);
            con.close();
            rs.close();
            new AlterController("회원가입 완료");
            return 1;

        }
        catch (Exception e){
            new AlterController("이미 회원가입된 정보가 존재합니다");
            return -1;
        }
    }
    public ArrayList<String> PrintRoom(String place){ //받을것 : 요일 , 시간 , 관?
        String sql = "select * from schedule." + place;
        ArrayList<String> Room = new ArrayList<>();
        try{
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Room.add(rs.getString("UserData"));
            }
            con.close();
            rs.close();
        }
        catch (Exception e){
            new AlterController("해당하는 데이터가 존재하지 않습니다.");
        }
        return Room;
    }
}


