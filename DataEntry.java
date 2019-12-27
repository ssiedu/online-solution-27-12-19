

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


public class DataEntry {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        String sql="insert into campus(name,joinD,campus) values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, "Manoj");
        //take the date in string format
        String dateStr="18-11-2019";
        //create SimpleDateFormat object for date formatting
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        //call parse method to obtain a date from string
        java.util.Date utilDate=dateFormat.parse(dateStr);
        //parse method returns java.util.Date 
        //now convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        //set date to parameter 2 using setDate
        ps.setDate(2,sqlDate);
        ps.setString(3, "Indore");
        int n=ps.executeUpdate();
        System.out.println(n+" row added");
        con.close();
    }

}
