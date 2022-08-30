package chains;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Getcommand implements Command {
    public Getcommand(Context context) throws Exception {
        execute(context);
    }
    public boolean execute(Context context) throws Exception {
        StudentContext studentContext =new StudentContext();
        String name;
        String password;
        String rollnum;
        String branch;
        Connection connection = (Connection) context.get("connection");
        String value = context.get("id").toString();
        int id = Integer.parseInt(value);
        String Q = "select * from student where id=?";
        PreparedStatement ps = connection.prepareStatement(Q);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            name = rs.getString(2);
            rollnum = rs.getString(3);
            password= rs.getString(4);
            branch= rs.getString(5);
           // insertContext.setName(name);
            context.put("name", name);
            context.put("rollnum", rollnum);
            context.put("branch", branch);
            context.put("password", password);
        }
        return false;
    }
}
