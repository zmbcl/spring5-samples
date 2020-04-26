package org.apache.patterns.delegate01;

/**
 * @Auther: bcl
 * @Description: 员工类A
 * @Date: Create in 3:44 下午 2020/4/21
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我现在开始干" + command + "工作");
    }
}
