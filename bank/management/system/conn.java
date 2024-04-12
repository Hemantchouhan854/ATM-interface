package bank.management.system;
import java.sql.*;

public class conn {

    Connection c;
    public Statement s;
    public conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","8619");
            s=c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }

    }
}