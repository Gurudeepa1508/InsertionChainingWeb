package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.Connection;
import java.sql.Statement;

public class deletecommand implements Command {
    public String value="";

    public deletecommand (Context context) throws Exception {
        execute(context);
    }
    public boolean execute(Context context) throws Exception {
        value=context.get("id").toString();
        int id= Integer.parseInt(value);
        Connection connection= (Connection) context.get("connection");
        String Q1="delete from student where id='"+id+"'";
        Statement ps = connection.createStatement();
        ps.executeUpdate(Q1);
        return false;
    }
}
