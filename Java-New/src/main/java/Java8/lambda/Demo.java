package Java8.lambda;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-14 13:41
 */
public class Demo {
    String name;
    int age;
    int sex;

    public Demo() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
