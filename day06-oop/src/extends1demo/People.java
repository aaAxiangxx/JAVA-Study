package extends1demo;

public class People {
    //父类
    //继承的好处，减少代码冗余，提高代码复用性
    private String name;
    private char sex;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
