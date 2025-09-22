package nimingneibulei;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        //目标：完成数组排序
        Student[] student = new Student[6];
        student[0] = new Student("小王", 18, 190,'男');
        student[1] = new Student("小张", 19, 180,'男');
        student[2] = new Student("小李", 17, 170,'男');
        student[3] = new Student("小赵", 16, 160,'男');
        student[4] = new Student("小孙", 15, 150,'男');
        student[5] = new Student("小周", 14, 140,'男');
        //调用api直接对数组排序
//        public static void sort(T[] a, Comparator<T> c);
        //参数一：选择排序的数组
        //参数二：需要给sort声明一个Comparator比较器对象（指定排序的规则）
        Arrays.sort(student, new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               //按照年龄升序排序
               return o1.getAge() - o2.getAge();
           }
        });
        for (int i = 0; i < student.length; i++) {
            Student s = student[i];
            System.out.println(s.getName() + " " + s.getAge() + " " + s.getHeight() + " " + s.getSex());
        }
    }
}
