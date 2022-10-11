package Management;

import Database.DB;


public class DeleteUser {
    public static void deleteUser(int delIdx) {
        for(int i = delIdx - 1; i < DB.index; i++) {
            DB.customers[i] = DB.customers[i+1];
        }
        DB.index--;
    }
}
