package org.apache.patterns.template02;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:19 下午 2020/4/26
 */
public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from user_info";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                return member;
            }
        }, null);
    }
}
