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

    public boolean setPaymentOfAmount(int paymentOfAmount) {
        if(paymentOfAmount >= 0) {
            this.paymentOfAmount = paymentOfAmount;
            return true;
        }
        else
            return false;
    }

    public int getUseTime() {
        return useTime;
    }

    public boolean setUseTime(int useTime) {
        if(useTime >= 0) {
            this.useTime = useTime;
            return true;
        }
        else
            return false;
    }
}
