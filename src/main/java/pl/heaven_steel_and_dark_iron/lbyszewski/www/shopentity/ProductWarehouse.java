package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductWarehouse")
public class ProductWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productWarehouseId")
    private Long productWarehouseId;

    @Column(name = "productWarehouseName", length = 150, unique = true)
    private String productWarehouseName;

    @Column(name = "productWarehouseCategory", length = 150, unique = true)
    private String productWarehouseCategory;

    @Column(name = "productWarehouseInfo")
    private Boolean productWarehouseInfo;









    @ManyToOne
    private Merchandise merchandise;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "warehouseSet")

    private Set<BuyersOrders> ordersSet = new HashSet<>();

}
