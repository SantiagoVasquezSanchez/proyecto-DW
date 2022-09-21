package proyecto1.ProyectoDW.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto1.ProyectoDW.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
