package pl.heaven_steel_and_dark_iron.lbyszewski.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.BuyersOrders;
@Repository
public interface BuyersOrdersRepository extends JpaRepository<BuyersOrders,Long> {
}
