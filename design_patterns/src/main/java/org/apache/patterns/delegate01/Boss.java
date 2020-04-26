package org.apache.patterns.delegate01;


public class Boss {

    public void command(String command, Leader leader) {
        leader.doing(command);
    }

}

