package chains;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
public class InsertionAndVerificationChain extends ChainBase {
    public void insert(Context context) throws Exception{
        addCommand(new Verificationcommand(context));
        addCommand(new Connectioncommand(context));
        addCommand(new Insertioncommand(context));
    }
   public void delete(Context context) throws Exception
   {
       addCommand(new Connectioncommand(context));
       addCommand(new deletecommand(context));
   }
    public void modify(Context context) throws Exception
    {
        addCommand(new VerificationForModifycommand(context));
        addCommand(new Connectioncommand(context));
        addCommand(new Modifycommand(context));

    }
}
