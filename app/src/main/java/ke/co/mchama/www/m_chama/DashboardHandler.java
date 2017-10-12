package ke.co.mchama.www.m_chama;

/**
 * Created by ReinhardBonnke on 10/11/2017.
 */

public class DashboardHandler {

    private String id;
    private String name;
    private String phone;

    public DashboardHandler(){
        //this constructor is required
    }

    public DashboardHandler(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
