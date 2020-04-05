package Practice.Java.Reflect;

public class Person {
    public String country;
    public String city;
    private String name;
    private String province;
    private Integer height;
    private Integer age;


    public Person() {
        System.out.println("调用Person的无参构造方法");
    }

    private Person(String country, String city, String name) {
        this.country = country;
        this.city = city;
        this.name = name;
    }

    public Person(String country, Integer age) {
        this.country = country;
        this.age = age;
    }

    private String getMobile(String number) {
        return "010-110" + "-" + number;
    }


    private void setCountry(String country) {
        this.country = country;

    }

    @Override
    public String toString() {
        return "Person{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", height=" + height +
                '}';
    }
}

