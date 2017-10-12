package ke.co.mchama.www.m_chama;

/**
 * Created by ReinhardBonnke on 10/11/2017.
 */

public class LoanHandler {

    private String paymentId;
    private String Amount;
    private String Duration;

    public LoanHandler(){
        //this constructor is required
    }

    public LoanHandler(String paymentId, String amount, String duration) {
        this.paymentId = paymentId;
        Amount = amount;
        Duration = duration;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAmount() {
        return Amount;
    }

    public String getDuration() {
        return Duration;
    }


}
