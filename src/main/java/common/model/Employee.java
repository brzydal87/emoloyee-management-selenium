package common.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    String name;
    String surname;
    String position;
    String dayJoined;
    int salary;
    String dateOfBirth;
}
