package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Merchandise")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchandiseShopId")
    private Long merchandiseShopId;

    @Column(name = "merchandiseFullName", length = 150, unique = true)
    private String merchandiseFullName;

    @Column(name = "merchandiseCategory", length = 150)
    private String merchandiseCategory;

    @Column(name = "merchandisePrice" ,updatable = true, length = 8 )
    private Double merchandisePrice;










    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Set<ProductWarehouse> productWarehouseSet = new HashSet<>();


}
