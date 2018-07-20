package intPackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import intPackage.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}