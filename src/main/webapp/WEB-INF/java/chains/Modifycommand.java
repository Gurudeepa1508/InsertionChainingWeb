package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modifycommand implements Command {
    public Modifycommand(Context context) throws Exception {
        execute(context);
    }

    public boolean execute(Context context) throws Exception {
        String error=context.get("error").toString();
        System.out.println(error);
        Connection connection= (Connection) context.get("connection");
        String name=context.get("name").toString();
        String rollnum=context.get( "rollnum").toString();
        String branch=context.get( "branch").toString();
        String password=context.get( "password").toString();
        String value=context.get("id").toString();
        int id= Integer.parseInt(value);
        if("".equals(error))
        {
            try{
                String InsertQuery="update student set name=?,rollnum=?,password=?,branch=? where id=?";
                PreparedStatement ps=connection.prepareStatement(InsertQuery);
                ps.setString(1,name);
                ps.setString(2,rollnum);
                ps.setString(3,password);
                ps.setString(4,branch);
                ps.setInt(5,id);
                ps.executeUpdate();
                System.out.println("data modified");
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

        }
        return false;
    }
}
