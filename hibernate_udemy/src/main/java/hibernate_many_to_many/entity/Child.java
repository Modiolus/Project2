package hibernate_many_to_many.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
@Setter
@Getter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    //    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.PERSIST
            , CascadeType.MERGE
            , CascadeType.REFRESH
            , CascadeType.DETACH
    })
//    ниже мы описываем как связующая таблица child_section связана с таблицей children и таблицей section
    @JoinTable(name = "child_section"   // указываем с какой таблицей связана таблица children
            , joinColumns = @JoinColumn(name = "child_id") // таблица child_section связывается через столбец child_id с таблицей children
            , inverseJoinColumns = @JoinColumn(name = "section_id")//таблица child_section сявзана через столбец section_id с таблицей section
    )
    private List<Section> sections;

    public Child() {
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);

    }


    //    @JoinColumn


}
