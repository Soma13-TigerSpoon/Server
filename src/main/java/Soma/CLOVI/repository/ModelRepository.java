package Soma.CLOVI.repository;

import Soma.CLOVI.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
