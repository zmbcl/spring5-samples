package org.apache.patterns.delegate01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: bcl
 * @Description: 项目经理类
 * @Date: Create in 3:44 下午 2020/4/21
 */
public class Leader implements IEmployee {

    private Map<String, IEmployee> targets = new HashMap<String, IEmployee>();

    public Leader() {
        targets.put("加密", new EmployeeA());
        targets.put("登录", new EmployeeB());
    }

    //项目经理自己不干活
    public void doing(String command) {
        targets.get(command).doing(command);
    }

}
