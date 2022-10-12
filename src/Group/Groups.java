package Group;

import Customer.Customer;
import Customer.Customers;

public class Groups {
    private Group[] groups;

    public Groups() {}

    public Groups(Group[] groups) {
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    /*기준에 따라 customers를 GENERAL, VIP, VVIP 등급으로 나눔
    *
    * @param    customers 정렬을 당할 고객들
    * @return   각 그룹별로 분류가 완료된 Groups*/
    public Groups groupClassify(Customers customers) {
        GroupParameter VVIPparam = this.getGroups()[0].getGroupParameter();
        GroupParameter VIPparam = this.getGroups()[1].getGroupParameter();
        GroupParameter GENERALparam = this.getGroups()[2].getGroupParameter();

        Customers VVIPMem = new Customers(new Customer[10]);
        Customers VIPMem = new Customers(new Customer[10]);
        Customers GENERALMem = new Customers(new Customer[10]);
        Customers Mem = new Customers(new Customer[10]);

        for(int i = 0; i < customers.elementNum(); i++) {
            if(customers.getCustomers()[i].getUseTime() >= VVIPparam.getUseTime() & customers.getCustomers()[i].getPaymentAmount() >= VVIPparam.getPaymentOfAmount())
                VVIPMem.add(customers.getCustomers()[i]);
            else if(customers.getCustomers()[i].getUseTime() >= VIPparam.getUseTime() & customers.getCustomers()[i].getPaymentAmount() >= VIPparam.getPaymentOfAmount())
                VIPMem.add(customers.getCustomers()[i]);
            else if(customers.getCustomers()[i].getUseTime() >= GENERALparam.getUseTime() & customers.getCustomers()[i].getPaymentAmount() >= GENERALparam.getPaymentOfAmount())
                GENERALMem.add(customers.getCustomers()[i]);
            else
                Mem.add(customers.getCustomers()[i]);
        }

        this.getGroups()[0].setGroupMember(VVIPMem);
        this.getGroups()[1].setGroupMember(VIPMem);
        this.getGroups()[2].setGroupMember(GENERALMem);
        this.getGroups()[3].setGroupMember(Mem);
        return this;
    }
}
