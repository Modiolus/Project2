package hibernate_one_to_one.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Setter
@Getter
@ToString
//@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

//    ===============================================================================
//    ниже для обратного маппинга С Detail в Employee. При этом в Main все равно приходится использовать сеттер для Employee
    @OneToOne(mappedBy = "empDetail",  // показывает, что связь между Employee и Detail уже есть описана в поле empDetail
    cascade = CascadeType.ALL)
    private Employee employee;
//===============================================================================
//    ниже вариант, если мы хотим удалить данные только из таблицы details. Для этого нужно переписать каскад
//    @OneToOne(mappedBy = "empDetail",  // показывает, что связь между Employee и Detail уже есть описана в поле empDetail
//            cascade = {CascadeType.PERSIST, CascadeType.DETACH})
//    private Employee employee;
//==============================================================================
    public Detail(String city, String phoneNumber, String email) {

        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
