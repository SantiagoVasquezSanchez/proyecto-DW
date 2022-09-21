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
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    @Column (name="name")
    private String Name;
    @Column(name="description")
    private String Description;
    @Column(name="image_url")
    private String image_url;
    @Column(name="editorial_id")
    private int editorial_id;
}
