package Management;

import javax.xml.crypto.Data;

public class DeleteUser {
    public static void deleteUser(int delIdx) {
        for(int i = delIdx - 1; i < DataBase.index; i++) {
            DataBase.customers[i] = DataBase.customers[i+1];
        }
        DataBase.index--;
    }
}
