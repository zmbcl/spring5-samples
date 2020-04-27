package org.apache.patterns.adapter03;

import org.apache.patterns.adapter02.ResultMsg;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:30 上午 2020/4/27
 */
public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
