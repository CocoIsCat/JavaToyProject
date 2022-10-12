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
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName());
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName()) * -1;
                }
            });
        }
    }

    /*Customoers 안의 요소들을 소요 시간 순으로 오름차순 또는 내림차순으로 정렬
     *
     * @param   isAscending 오름차순으로 할 것인지 내림차순으로 할 것인지 결정
     */
    public void sortByTime(boolean isAscending) {
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getUseTime() - o2.getUseTime();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getUseTime() - o1.getUseTime();
                }
            });
        }
    }

    /*Customoers 안의 요소들을 소비 금액 순으로 오름차순 또는 내림차순으로 정렬
     *
     * @param   isAscending 오름차순으로 할 것인지 내림차순으로 할 것인지 결정
     */
    public void sortBySpend(boolean isAscending) {
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getPaymentAmount() - o2.getPaymentAmount();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getPaymentAmount() - o1.getPaymentAmount();
                }
            });
        }
    }

    /* 새로운 Customer 요소를 Customers에 추가
    *
    * @param    temp 추가하려는 Customer 요소
    * @return   추가가 완료된 Customers
    * @except   ArrayIndexOutOfBoundsException 용량이 부족할 경우
    * */
     public Customers add (Customer temp) {
        try {
            this.customers[DB.index] = temp;
            DB.index++;
        } catch (ArrayIndexOutOfBoundsException e) {
            resize();
            this.customers[DB.index] = temp;
            DB.index++;
        }
        return this;
     }

     /*원하는 위치의 요소를 삭제함
     *
     * @param   index 삭제를 원하는 위치
     * @return  삭제가 이루어졌는지 여부 반환
     * @except  ArrayIndexOutOfBoundsException  배열의 크기를 넘어서는 입력이 들어왔을 경우
     * */
     public boolean del (int index) {
         try {
             for (int i = index - 1; i < DB.index; i++) {
                 this.customers[i] = this.customers[i + 1];
             }
             DB.index--;
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
     public boolean resize() {
         try {
             int size = this.customers.length * 2;
             Customer[] newCustomers = new Customer[size];
             for(int i = 0; i < DB.index; i++) {
                 newCustomers[i] = this.customers[i];
             }
             /*newCustomers = Arrays.copyOf(this.customers, this.customers.length);*/
             this.setCustomers(newCustomers);
             return true;
         } catch (OutOfMemoryError e) {
             /*오류 메시지 출력*/
             return false;
         }
     }

     @Override
    public String toString() {
         String result = "Customers{\n";
         for(int i = 0; i < DB.index; i++) {
             result += (this.customers[i].toString() + "\n");
         }
         return result + "}";
     }
}
