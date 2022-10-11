package Customer;

public class Customer {
    private String customerNum; //고객 번호
    private String customerName;    //고객 이름
    private String customerID;  //고객ID
    private int useTime;    //사용 시간
    private int paymentAmount;  //소비 금액

    Customer() {}

    Customer(String customerNum, String customerName, String customerID, int useTime, int paymentAmount) {
        this.customerNum = customerNum;
        this.customerName = customerName;
        this.customerID = customerID;
        this.useTime = useTime;
        this.paymentAmount = paymentAmount;
    }
    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return customerNum.equals(customer.customerNum) & customerName.equals(customer.customerName) & customerID.equals(customer.customerID) & useTime == customer.useTime & paymentAmount == customer.paymentAmount;
    }

    /*public String toString()
    * - 고객 정보 출력
    */
    @Override
    public String toString() {
        return "Customer{" +
                "customerNum = " + customerNum +
                " customerName = " + customerName +
                " customerID = " + customerID +
                " useTime = " + useTime +
                " paymentAmount = " + paymentAmount +
                "}";
    }
}
