package org.apache.patterns.template02;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:23 下午 2020/4/26
 */
public class Test_Template_JDBC {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriver(new Driver());
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cas?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true");
        MemberDao dao = new MemberDao(dataSource);
        List<?> result = dao.selectAll();
        System.out.println(result);
    }
}
