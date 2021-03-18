package pl.heaven_steel_and_dark_iron.lbyszewski.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ShopClients;

import java.util.List;


@Repository
public interface ShopClientsRepository extends JpaRepository<ShopClients,Long> {

}
