package extends6constructor;

public class Teacher extends People {
    //子类
    private String skill;//技能

    public Teacher(String name, String skill, char sex) {
        //可以把子类继承自父类这部分的数据也完成初始化赋值
        super(name, sex);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
