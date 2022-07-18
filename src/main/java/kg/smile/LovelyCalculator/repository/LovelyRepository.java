package kg.smile.LovelyCalculator.repository;

import kg.smile.LovelyCalculator.entity.Lovely;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LovelyRepository extends JpaRepository<Lovely, Long> {
}
