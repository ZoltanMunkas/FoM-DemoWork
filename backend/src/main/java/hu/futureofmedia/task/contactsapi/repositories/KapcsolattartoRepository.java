package hu.futureofmedia.task.contactsapi.repositories;

import hu.futureofmedia.task.contactsapi.entities.Kapcsolattarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface KapcsolattartoRepository extends JpaRepository<Kapcsolattarto, Long> {
}
