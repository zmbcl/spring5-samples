package org.apache.patterns.delegate01;

/**
 * @Auther: bcl
 * @Description: 员工类B
 * @Date: Create in 3:44 下午 2020/4/21
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干" + command + "工作");
    }
}
