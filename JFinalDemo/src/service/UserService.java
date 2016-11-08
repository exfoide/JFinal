package service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * Created by Jasper on 2016/11/4.
 */
public class UserService {
    public boolean add(String username, String password){
        String sql = "select userid from user where username = ?";
        Integer result = Db.queryFirst(sql, username);
        if (result == null) {
            Record record = new Record().set("username", username).set("password", password);
            Db.save("user", record);
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) {
        String sql = "select userid from user where username = ? and password = ?";
        Integer result = Db.queryFirst(sql, username, password);
        if (result == null) {
            return false;
        }
        return true;
    }
}
