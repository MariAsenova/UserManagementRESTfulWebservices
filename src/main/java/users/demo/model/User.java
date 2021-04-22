package users.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//is a JPA annotation used to indicate that
// the annotated class is a JPA entity class!
// to make a table out of this class --> create an entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    // marks a field in a model class as a primary key
    // primary key should be serial
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private String email;
    private String password;
}
