package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectioncommand implements Command {
    public Connectioncommand(Context context) throws Exception {
        execute(context);
    }
    public boolean execute(Context context) throws Exception {
        String error=context.get("error").toString();
        java.sql.Connection connection;
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
