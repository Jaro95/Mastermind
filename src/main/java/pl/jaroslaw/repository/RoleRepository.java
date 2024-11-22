package pl.jaroslaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaroslaw.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
