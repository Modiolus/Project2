package hibernate_many_to_many.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Setter
@Getter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;


    //    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.PERSIST
            , CascadeType.MERGE
            , CascadeType.REFRESH
            , CascadeType.DETACH
    })
//    ниже мы описываем как связующая таблица child_section связана с таблицей section и таблицей children
    @JoinTable(name = "child_section"
            , joinColumns = @JoinColumn(name = "section_id") // таблица child_section связывается через столбец section_id с таблицей section
            , inverseJoinColumns = @JoinColumn(name = "child_id")//таблица child_section связана через столбец child_id с таблицей children
    )
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;    }

    public void addChildToSection(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);

    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
