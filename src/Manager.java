
public class Manager extends User {

    private Report report;
    public Manager(String user_type, String username, String password){
        super(user_type, username, password);
        createReport();
    }

    public Manager(int user_id, String user_type, String username, String password){
        super(user_id, user_type, username, password);
        createReport();
    }

    public void createAccount(String accountType) {
        
    }

    public void createReport(){
        this.report = Bank.db.getAllAccountsReport();
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
