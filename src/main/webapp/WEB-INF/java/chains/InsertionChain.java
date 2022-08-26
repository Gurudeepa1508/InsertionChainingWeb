package chains;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
public class InsertionChain extends ActionSupport implements ServletRequestAware {
    public String name="";
    public String password="";
    public String branch="";
    public String rollnum="";
    org.json.simple.JSONObject jsonchildbject;

    private boolean responseAsJson = true;
    private InsertContext insertcontext=new InsertContext();

    public void setServletRequest(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = request.getReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String line;
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null))
                        break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sb.append(line);
            }
            System.out.println(sb.toString());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String s = sb.toString();
        Object obj = JSONValue.parse(s);
        try {
            JSONObject jsonObject = (JSONObject) obj;
            jsonchildbject = (JSONObject) jsonObject.get("insertcontext");
        } catch (Exception e) {
            System.out.println(e);
        }
        name = (String) jsonchildbject.get("name");
        password = (String) jsonchildbject.get("password");
        branch = (String) jsonchildbject.get("branch");
        rollnum = (String) jsonchildbject.get("rollnum");
        System.out.println(name);

    }
    public void InsertData() throws Exception {
            Context context = new InsertContext();
            context.put("name", name);
            context.put("rollnum", rollnum);
            context.put("branch", branch);
            context.put("password", password);
            Catalog catalog = new InsertCatalog();
            Command insertionchain = catalog.getCommand("insertionchain");
            insertionchain.execute(context);
//         String error = context.get("error").toString();
//        setError(error);
//        if(error.equals(""))
//            return "display";
//        else
//            return "error";  }
        }


}





