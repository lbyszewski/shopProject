package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Role")
public class RolesAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "roleAuthorization")
    private Long roleAuthorization;

    @Column(name = "roleName")
    private String roleName;

    public RolesAuth(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rolesAuth")
    private Set<ShopClients> shopClients;

}
