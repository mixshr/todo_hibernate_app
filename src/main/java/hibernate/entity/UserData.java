package hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserData {

    public UserData(String email, String username) {
        this.email = email;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name = "userpassword")
    private String password;

    private String username;

    @ManyToMany // таблица role ссылается на user через промежуточную таблицу user_role
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", updatable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", updatable = false))
    private Set<Role> roles = new HashSet<>();

    /*@OneToMany(mappedBy = "userData", fetch = FetchType.LAZY)
    private List<Category> categories;

    @OneToMany(mappedBy = "userData",  fetch = FetchType.LAZY)
    private List<Priority> priorities;

    @OneToOne(mappedBy = "userData", fetch = FetchType.LAZY, optional = false)
    private Activity activity;

    @OneToOne(mappedBy = "userData", fetch = FetchType.LAZY, optional = false)
    private Stat stat;

    @OneToMany(mappedBy = "userData", fetch = FetchType.LAZY)
    private List<Task> tasks;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id.equals(userData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}