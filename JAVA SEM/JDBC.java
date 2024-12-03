import java.sql.*;
public class JDBC{
    public static void main(String[] args){
        String jdbcURL="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="password";
        try(Connection connection=DriverManager.getConnection(jdbcURL,username,password)){
            if(connection!=null){
                System.out.println("Connected to database");
            }
            Statement statement=connection.createStatement();
            String SQL="Select * from Users";
            ResultSet resultset=statement.executeQuery(SQL);
            while(resultset.next()){
                int id=resultset.getInt("ID");
                String name=resultset.getString("Name");
                String email=resultset.getString("email");
                System.out.println("ID: "+id+" Name: "+name+" email: "+email);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
