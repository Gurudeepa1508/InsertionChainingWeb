
package chains;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
public class InsertionChain extends ActionSupport implements ServletRequestAware {

    public String name="";
    public String password="";
    public String branch="";
    public String rollnum="";
    public String value="";
    public int id;
    org.json.simple.JSONObject jsonchildbject;
    private StudentContext insertcontext=new StudentContext();


    private boolean responseAsJson = true;
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
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String s = sb.toString();
        System.out.println(s);
        Object obj = JSONValue.parse(s);
        try {
            JSONObject jsonObject = (JSONObject) obj;
            jsonchildbject = (JSONObject) jsonObject.get("insertcontext");
        } catch (Exception e)
        {
            System.out.println(e);
        }
          try {
              name = (String) jsonchildbject.get("name");
              password = (String) jsonchildbject.get("password");
              branch = (String) jsonchildbject.get("branch");
              rollnum = (String) jsonchildbject.get("rollnum");
          }
          catch (Exception e){

          }
        try {
            value = (String) jsonchildbject.get("id");
            id = Integer.parseInt(value);
        } catch (Exception e) {
        }
    }
    public String InsertData() throws Exception {
            Context context = new StudentContext();
            context.put("name", name);
            context.put("rollnum", rollnum);
            context.put("branch", branch);
            context.put("password", password);
            Catalog catalog = new InsertCatalog();
            Command insertionchain = catalog.getCommand("insertionchain");
            InsertionAndVerificationChain insertion=new InsertionAndVerificationChain();
            insertion.insert(context);
            String error=context.get("error").toString();
            System.out.println(error);
            if("".equals(error))
                return "display";
            else
                return "error";
        }
        public String DeleteData() throws Exception {
        Context context =new StudentContext();
        context.put("id",id);
        Catalog catalog = new InsertCatalog();
        Command insertionchain = catalog.getCommand("insertionchain");
        InsertionAndVerificationChain delete=new InsertionAndVerificationChain();
        delete.delete(context);
        return "delete";
    }
    public String ModifyData() throws Exception {
        Context context =new StudentContext();
        context.put("name", name);
        context.put("rollnum", rollnum);
        context.put("branch", branch);
        context.put("password", password);
        context.put("id",id);
        Catalog catalog = new InsertCatalog();
        Command insertionchain = catalog.getCommand("insertionchain");
        InsertionAndVerificationChain modify=new InsertionAndVerificationChain();
        modify.modify(context);
        String error=context.get("error").toString();
        if("".equals(error))
            return "modify";
        else
            return "error";
    }
   public String GetData()throws Exception{
       Context context =new StudentContext();
       context.put("id",id);
       Catalog catalog = new InsertCatalog();
       Command insertionchain = catalog.getCommand("insertionchain");
       InsertionAndVerificationChain get=new InsertionAndVerificationChain();
       get.get(context);
       name=context.get("name").toString();
       rollnum=context.get("rollnum").toString();
       branch=context.get("branch").toString();
       password=context.get("password").toString();
       insertcontext.setName(name);
       insertcontext.setBranch(branch);
       insertcontext.setPassword(password);
       insertcontext.setRollnum(rollnum);
       insertcontext.setId(id);
       studentContext.add(insertcontext);
       return "get";
   }
    public String GetallData()throws Exception{
        Context context =new StudentContext();
        Catalog catalog = new InsertCatalog();
        Command insertionchain = catalog.getCommand("insertionchain");
        InsertionAndVerificationChain getall=new InsertionAndVerificationChain();
        getall.getall(context);
        studentContext = (ArrayList<StudentContext>) context.get("list");
        setInsertcontext(studentContext);
        return "getall";
    }
    ArrayList<StudentContext> studentContext =new ArrayList<StudentContext>();
    public ArrayList<StudentContext> getInsertContext() {
        return studentContext;
    }
    public void setInsertcontext(ArrayList<StudentContext> list) {
        this.insertcontext = insertcontext;
    }
}





