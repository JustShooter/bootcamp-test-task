package by.justshooter.repository.entity;

import by.justshooter.repository.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "second_name", length = 40)
    private String secondName;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Column(name = "e_mail", length = 50)
    private String eMail;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "secondName = " + secondName + ", " +
                "firstName = " + firstName + ", " +
                "middleName = " + middleName + ", " +
                "eMail = " + eMail + ", " +
                "role = " + role.getName() + ")";
    }
}