package Customer;

import java.util.regex.Pattern;

public class Customer {
    private String customerNum; //고객 번호
    private String customerName;    //고객 이름
    private String customerID;  //고객ID
    private int useTime;    //사용 시간
    private int paymentAmount;  //소비 금액

    public Customer() {}

    public Customer(int total, String customerName, String customerID, int useTime, int paymentAmount) {
        this.customerNum = "UID-" + total;
        this.customerName = customerName;
        this.customerID = customerID;
        this.useTime = useTime;
        this.paymentAmount = paymentAmount;
    }
    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int total) {
        this.customerNum = "UID-" + total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean setCustomerName(String customerName) {
        String reg = "^[a-zA-Z\\s]{3,20}$";
        if(Pattern.matches(reg, customerName)) {
            this.customerName = customerName;
            return true;
        }
        else
            return false;
    }

    public String getCustomerID() {
        return customerID;
    }

    public boolean setCustomerID(String customerID) {
        String reg = "^[a-zA-Z0-9]{5,12}$";
        if (Pattern.matches(reg, customerID)) {
            this.customerID = customerID;
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

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public boolean setPaymentAmount(int paymentAmount) {
        if(paymentAmount >= 0) {
            this.paymentAmount = paymentAmount;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return customerNum.equals(customer.customerNum) & customerName.equals(customer.customerName) & customerID.equals(customer.customerID) & useTime == customer.useTime & paymentAmount == customer.paymentAmount;
    }

    public void resetCustomer() {
        this.customerNum = null;
        this.customerName = null;
        this.customerID = null;
        this.paymentAmount = 0;
        this.useTime = 0;
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
