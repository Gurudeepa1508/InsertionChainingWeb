package chains;

import org.apache.commons.chain.impl.ChainBase;

public class InsertionAndVerificationChain extends ChainBase {
    public InsertionAndVerificationChain(){
        super();
        addCommand(new Verificationcommand());
        addCommand(new Connectioncommand());
        addCommand(new Insertioncommand());

    }
}
