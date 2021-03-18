package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Client")
public class ShopClients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userShopId")
    private Long userShopId;

    @Column(name = "userLogin", length = 30)
    private  String userLogin;

    @Column(name = "userPassword", length = 200,unique = true)
    private String userPassword;

    @Column(name = "userEmail", length = 70)
    private String userEmail;

    @Column(name = "phoneNumber", length = 8, unique = true)
    private Integer phoneNumber;

    @Column(name = "clientAdress")
    @Embedded
    private Address clientAdress;





    @ManyToOne(cascade = CascadeType.ALL)
    private RolesAuth rolesAuth;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopClients",orphanRemoval = true)
    private Set<BuyersOrders> buyersOrdersSet;
}
