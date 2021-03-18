package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BuyerOrder")
public class BuyersOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordersShopId")
    private Long ordersShopId;

    @Column(name = "orderName", length = 150)
    private String orderName;

    @Column(name = "orderPaymentMethod")
    private String orderPaymentMethod;











    @ManyToOne
    @JoinColumn(name = "fk_shopClients")
    private ShopClients shopClients;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Orders_ProductWarehouse",
            joinColumns = { @JoinColumn(name = "ordersShopId") },
            inverseJoinColumns = { @JoinColumn(name = "productWarehouseId") }
    )
    Set<ProductWarehouse> warehouseSet = new HashSet<>();

}
