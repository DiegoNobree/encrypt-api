package diegonobre.com.encryptapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import diegonobre.com.encryptapi.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
