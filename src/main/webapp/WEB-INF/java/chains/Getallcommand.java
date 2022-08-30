package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Getallcommand implements Command {

    public Getallcommand(Context context) throws Exception {
        execute(context);
    }
    public boolean execute(Context context) throws Exception {
        String name;
        String password;
        String rollnum;
        String branch;
        int id;
        Connection connection = (Connection) context.get("connection");
        String Q = "select * from student";
        PreparedStatement ps = connection.prepareStatement(Q);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StudentContext context1=new StudentContext();
            context1.setId(rs.getInt(1));
            context1.setName(rs.getString(2));
            context1.setRollnum(rs.getString(3));
            context1.setPassword(rs.getString(4));
            context1.setBranch(rs.getString(5));
            list.add(context1);
            context.put("list",list);
        }
        System.out.println(list);

        return false;
    }
    ArrayList<StudentContext> list = new ArrayList<StudentContext>();
}
