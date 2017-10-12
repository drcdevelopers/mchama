package ke.co.mchama.www.m_chama;

/**
 * Created by ReinhardBonnke on 10/11/2017.
 */

public class ReportHandler {

    private String paymentId;
    private String projectProjets;
    private String projectReports;

    public ReportHandler(){
        //this constructor is required
    }

    public ReportHandler(String paymentId, String projectProjets, String projectReports) {
        this.paymentId = paymentId;
        this.projectProjets = projectProjets;
        this.projectReports = projectReports;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getProjectProjets() {
        return projectProjets;
    }

    public String getProjectReports() {
        return projectReports;
    }
}


