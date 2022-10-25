package hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "priority", schema = "todolist", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Priority {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id
    private Long id;

    private String title;

    private String color;

   /* @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserData userData;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return id.equals(priority.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                //", userData=" + userData +
                '}';
    }
}