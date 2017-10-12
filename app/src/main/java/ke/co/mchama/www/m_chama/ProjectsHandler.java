package ke.co.mchama.www.m_chama;


public class ProjectsHandler {


    private String paymentId;
    private String projectProjets;

    public ProjectsHandler(){
        //this constructor is required
    }


    public ProjectsHandler(String paymentId, String projectProjets) {
        this.paymentId = paymentId;
        this.projectProjets = projectProjets;

    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getProjectProjets() {
        return projectProjets;
    }

}
