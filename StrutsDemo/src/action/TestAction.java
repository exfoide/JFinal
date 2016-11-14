package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Jasper on 2016/10/28.
 */
public class TestAction extends ActionSupport{
    public String test(){
        System.out.println();
        return SUCCESS;
    }
}
