package demo;

public class SmartHomeControl {
    private static final SmartHomeControl smartHomeControl = new SmartHomeControl();
    private SmartHomeControl(){}
    public static SmartHomeControl getInstance(){
        return smartHomeControl;
    }

    public void control(JD jd){
        System.out.println(jd.getName() + "状态目前是：" + (jd.isStatus()?"开":"关"));
        System.out.println("开始您的操作");
        jd.press();
        System.out.println(jd.getName() + "状态已经是：" + (jd.isStatus()?"开":"关"));

    }

    public void printAllStatus(JD[] jds) {
        for (int i = 0; i < jds.length; i++) {
            JD jd = jds[i];
            System.out.println((i + 1) + "," + jd.getName() + "状态目前是：" + (jd.isStatus()?"开":"关"));
        }
    }
}
