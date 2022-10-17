package Group;

public class GroupParameter {
    private long paymentOfAmount;
    private int useTime;

    public GroupParameter() {}

    public GroupParameter(int paymentOfAmount, int useTime) {
        this.paymentOfAmount = paymentOfAmount;
        this.useTime = useTime;
    }

    public long getPaymentOfAmount() {
        return paymentOfAmount;
    }

    public boolean setPaymentOfAmount(long paymentOfAmount) {
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

    @Override
    public String toString() {
        return " Parameter = {" +
                "UseTime = " + this.useTime +
                ", PaymentOfAmount = " + this.paymentOfAmount +
                " } ";
    }
}
