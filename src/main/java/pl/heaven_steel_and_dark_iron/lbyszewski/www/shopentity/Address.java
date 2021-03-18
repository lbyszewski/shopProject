package pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Data
public class Address {

    @Column(name = "addressStreet")
    private String addressSteet;

    @Column(name = "addressStructureNumber")
    private Integer addressStructureNumber;

    @Column(name = "addressHomeNumber")
    private Integer addressHomeNumber;

    @Column(name = "addressPostCode")
    private Integer addressPostCode;

    @Column(name = "addressState")
    private String addressState;

    @Column(name = "addressCityLocation")
    private String addressCityLocation;

    @Column(name = "addressSmallVillage")
    private String addressSmallVillage;

}
