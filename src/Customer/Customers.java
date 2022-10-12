package Customer;

import Database.DB;

import java.util.Arrays;
import java.util.Comparator;

public class Customers {

    private Customer[] customers;

    public Customers() {}

    public Customers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }


    /*Customoers 안의 요소들을 이름 순으로 오름차순 또는 내림차순으로 정렬
    *
    * @param    isAscending 오름차순으로 할 것인지 내림차순으로 할 것인지 결정
    */
    public void sortByName(boolean isAscending) {
        Customer[] temp = Arrays.copyOf(this.customers, this.elementNum());
        if(isAscending) {   //오름차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName());
                }
            });
        }
        else {  //내림차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName()) * -1;
                }
            });
        }
        this.setCustomers(Arrays.copyOf(temp, this.customers.length));
    }

    /*Customoers 안의 요소들을 소요 시간 순으로 오름차순 또는 내림차순으로 정렬
     *
     * @param   isAscending 오름차순으로 할 것인지 내림차순으로 할 것인지 결정
     */
    public void sortByTime(boolean isAscending) {
        Customer[] temp = Arrays.copyOf(this.customers, this.elementNum());
        if(isAscending) {   //오름차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getUseTime() - o2.getUseTime();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getUseTime() - o1.getUseTime();
                }
            });
        }
        this.setCustomers(Arrays.copyOf(temp, this.customers.length));
    }

    /*Customoers 안의 요소들을 소비 금액 순으로 오름차순 또는 내림차순으로 정렬
     *
     * @param   isAscending 오름차순으로 할 것인지 내림차순으로 할 것인지 결정
     */
    public void sortBySpend(boolean isAscending) {
        Customer[] temp = Arrays.copyOf(this.customers, this.elementNum());
        if(isAscending) {   //오름차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getPaymentAmount() - o2.getPaymentAmount();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(temp, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getPaymentAmount() - o1.getPaymentAmount();
                }
            });
        }
        this.setCustomers(Arrays.copyOf(temp, this.customers.length));
    }

    /* 새로운 Customer 요소를 Customers에 추가
    *
    * @param    temp 추가하려는 Customer 요소
    * @return   추가가 완료된 Customers
    * @except   ArrayIndexOutOfBoundsException 용량이 부족할 경우
    * */
     public Customers add (Customer temp) {
         int size = this.elementNum();
        try {
            this.customers[size] = temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            if(upsize()) {
                this.customers[size] = temp;
            }
            else {
                /*오류 메시지 출력*/
            }
        }
        return this;
     }

     /*원하는 위치의 요소를 삭제함
     *
     * @param   index 삭제를 원하는 위치
     * @return  삭제가 이루어졌는지 여부 반환
     * @except  ArrayIndexOutOfBoundsException  배열의 크기를 넘어서는 입력이 들어왔을 경우
     * */
     public boolean del (int delIndex) {
         int size = this.elementNum();
         try {
             for (int i = delIndex - 1; i < size; i++) {
                 this.customers[i] = this.customers[i + 1];
             }
             return true;
         } catch (ArrayIndexOutOfBoundsException e) {
             /*오류 메시지 출력*/
             return false;
         }
     }

     /*배열의 사이즈를 두 배로 늘려서 반환
     *
     * @return  더블링이 성공적으로 수행됐는지 여부 반환
     * @except  OutOfMemory 메모리가 부족할 경우*/
     public boolean upsize() {
         try {
             int size = this.customers.length * 2;
             Customer[] newCustomers = new Customer[size];
             newCustomers = Arrays.copyOf(this.customers, size);
             this.setCustomers(newCustomers);
             return true;
         } catch (OutOfMemoryError e) {
             /*오류 메시지 출력*/
             return false;
         }
     }
    /*배열에서 null이 아닌 요소의 값을 반환함
    *
    * @return   num null이 아닌 요소의 수*/
    public int elementNum() {
        int num = 0;
        int size = this.customers.length;
        while(num < this.customers.length) {
            if(this.customers[num] != null)
                num++;
            else
                break;
        }
        return num;
    }

     @Override
    public String toString() {
         int size = this.elementNum();
         String result = "Customers{\n";
         for(int i = 0; i < size; i++) {
             result += (this.customers[i].toString() + "\n");
         }
         return result + "}";
     }
}