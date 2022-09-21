package proyecto1.ProyectoDW.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "editorial")
public class Editorial {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    @Column (name="name")
    private String Name;
    @Column(name="web_site")
    private String web_site;
}
