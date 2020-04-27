package org.apache.patterns.adapter01;

/**
 * @Auther: bcl
 * @Description: 电源适配器
 * @Date: Create in 11:07 上午 2020/4/27
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int adapterInput = ac220.outputAC220();
        // 变压器
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC：" + adapterInput + "V，输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}
