package org.apache.patterns.template02;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:03 下午 2020/4/26
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 获取连接
            Connection connection = this.getConnection();
            // 创建语句集
            PreparedStatement statement = this.createPrepareStatement(connection, sql);
            // 执行语句集
            ResultSet set = this.executeQuery(statement, values);
            // 处理结果集
            List<?> result = this.paresResultSet(set, rowMapper);
            // 关闭结果集
            this.closeResultSet(set);
            // 关闭语句集
            this.closeStatement(statement);
            // 关闭连接
            this.closeConnection(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    protected PreparedStatement createPrepareStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    protected ResultSet executeQuery(PreparedStatement statement, Object[] values) throws SQLException {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i, values[i]);
            }
        }
        return statement.executeQuery();
    }

    protected List<?> paresResultSet(ResultSet set, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (set.next()) {
            result.add(rowMapper.mapRow(set, rowNum++));
        }
        return result;
    }

    protected void closeResultSet(ResultSet set) throws SQLException {
        set.close();
    }

    protected void closeStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    protected void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
