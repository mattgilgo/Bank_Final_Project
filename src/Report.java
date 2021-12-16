import java.util.ArrayList;

public class Report {
    private ArrayList<ReportTuple> reportTuples;
    public Report() {
        this.reportTuples = new ArrayList<>();
        generateReport();
    }

    public void generateReport(){
        //this.reportTuples = Bank.db.getAllAccounts();
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportTuples=" + reportTuples +
                '}';
    }

    //getters


    public ArrayList<ReportTuple> getReportTuples() {
        return reportTuples;
    }

    //setters

    public void setReportTuples(ArrayList<ReportTuple> reportTuples) {
        this.reportTuples = reportTuples;
    }
}
