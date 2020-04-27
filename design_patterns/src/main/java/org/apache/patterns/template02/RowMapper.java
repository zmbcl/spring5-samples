package org.apache.patterns.template02;

import java.sql.ResultSet;

/**
 * @Auther: bcl
 * @Description: 约束ORM逻辑的接口
 * @Date: Create in 8:57 下午 2020/4/26
 */
public interface RowMapper<T> {
    T mapRow(ResultSet resultSet, int rowNum) throws Exception;
}
