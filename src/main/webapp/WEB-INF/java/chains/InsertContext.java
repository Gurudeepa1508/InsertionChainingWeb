package chains;
import org.apache.commons.chain.impl.ContextBase;
import java.io.Serializable;
import java.sql.Connection;
public class InsertContext extends ContextBase implements Serializable {
    private String name;
    private String rollnum;
    private String branch;
    private String password;
    private String error="";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    private Connection connection;


    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
        System.out.println(error);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name);
    }

    public String getRollnum() {
        return rollnum;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
        System.out.println(rollnum);

    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
