package chains;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
public class Verificationcommand implements Command {
    public Verificationcommand(Context context) throws Exception {
        execute(context);
    }
    public boolean execute(Context context) throws Exception {
        String name=context.get("name").toString();
        String rollnum=context.get( "rollnum").toString();
        String branch=context.get( "branch").toString();
        String password=context.get( "password").toString();
        //System.out.println(name);
        //System.out.println(branch);
        if("".equals(name) || "".equals(rollnum)||"".equals(branch)||"".equals(password))
        {
            context.put("error","Please enter all the data");
        }
        return false;
    }
}
