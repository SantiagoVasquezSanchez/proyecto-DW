package proyecto1.ProyectoDW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto1.ProyectoDW.model.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,Integer> {
}
