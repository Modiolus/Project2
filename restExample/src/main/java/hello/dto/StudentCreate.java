package hello.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class StudentCreate {
    private String firstName;
    private String lastName;
}
