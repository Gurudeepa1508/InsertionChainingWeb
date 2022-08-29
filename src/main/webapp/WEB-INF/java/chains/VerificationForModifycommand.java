package chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class VerificationForModifycommand implements Command {
    public VerificationForModifycommand(Context context) throws Exception {
        execute(context);
    }

    public boolean execute(Context context) throws Exception {
        String name=context.get("name").toString();
        String rollnum=context.get( "rollnum").toString();
        String branch=context.get( "branch").toString();
        String password=context.get( "password").toString();
        String value=context.get("id").toString();
        if("".equals(name) || "".equals(rollnum)||"".equals(branch)||"".equals(password) || "".equals(value))
        {
            context.put("error","Please enter all the data");
        }
        else if(password.length()<8)
            context.put("error","Password should contain atleast 8 characters");
        return false;

    }
}
