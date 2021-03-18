package pl.heaven_steel_and_dark_iron.lbyszewski.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.RolesAuth;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<RolesAuth, Long> {
    Optional<RolesAuth> findByRoleName(String name);
}
