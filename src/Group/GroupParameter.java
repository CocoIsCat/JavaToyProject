package Group;

public class GroupParameter {
    private int paymentOfAmount;
    private int useTime;

    public GroupParameter() {}

    public GroupParameter(int paymentOfAmount, int useTime) {
        this.paymentOfAmount = paymentOfAmount;
        this.useTime = useTime;
    }

    public int getPaymentOfAmount() {
        return paymentOfAmount;
    }

    public void setPaymentofAmount(int paymentOfAmount) {
        this.paymentOfAmount = paymentOfAmount;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }
}
