package chains;

import org.apache.commons.chain.impl.CatalogBase;

public class InsertCatalog extends CatalogBase {
    public InsertCatalog()
    {
        super();
        addCommand("insertionchain",new InsertionAndVerificationChain());
    }
}
