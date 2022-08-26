package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.DriverManager;

public class Connectioncommand implements Command {
    public boolean execute(Context context) throws Exception {
        System.out.println("connection");
        String error=context.get("error").toString();
        System.out.println(error);
        java.sql.Connection connection;
//        Class.forName("com.mysql.jdbc.Driver");
//        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Guru@1508");
//        System.out.println("connected succesfully");
//        context.put("connection",connection);
        if("".equals(error))
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Guru@1508");
            System.out.println("connected succesfully");
            context.put("connection",connection);

        }
        return false;
    }
}
