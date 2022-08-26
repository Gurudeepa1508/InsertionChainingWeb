package chains;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
public class Verificationcommand implements Command {
    public boolean execute(Context context) throws Exception {
        String name=context.get("name").toString();
        String rollnum=context.get( "rollnum").toString();
        String branch=context.get( "branch").toString();
        String password=context.get( "password").toString();
       // System.out.println("verification");
        if(name.equals("") || rollnum.equals("")||branch.equals("")||password.equals(""))
        {
            context.put("error","Please enter all the data");
        }
        else if(password.length()<8)
            context.put("error","Password should contain atleast 8 characters");
        return false;
    }
}
