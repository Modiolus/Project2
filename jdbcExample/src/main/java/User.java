import lombok.*;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private int age;
    private String first_name;
    private String last_name;
    private String pasport_number;
    private String phone;
    private String sex;
// конструктор закомментирован потому что вместо него работает @AllArgsConstructor
//    public User(int id, int age, String first_name, String last_name, String pasport_number, String phone, String sex) {
//        this.id = id;
//        this.age = age;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.pasport_number = pasport_number;
//        this.phone = phone;
//        this.sex = sex;
//    }
}
