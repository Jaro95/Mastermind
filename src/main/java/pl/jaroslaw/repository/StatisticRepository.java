package pl.jaroslaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaroslaw.model.Statistics;

@Repository
public interface StatisticRepository extends JpaRepository<Statistics, Long> {
}
