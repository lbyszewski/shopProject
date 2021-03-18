package pl.heaven_steel_and_dark_iron.lbyszewski.www.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.ShopClientsRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.AuthorizerService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.ShopLogicService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ShopClients;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/shop")
@RequiredArgsConstructor
@RestController
public class ShopLogicController {
    private final ShopLogicService shopLogicService;

    private final ShopClientsRepository shopClientsRepository;
    private final AuthorizerService authorizerService;
    @GetMapping(value = "/findShopClient")
    public List<ShopClients> findAllByShopClients(){
        List<ShopClients> shopClients = shopClientsRepository.findAll();
        return shopClients;
    }


    @GetMapping(value = "/shopClient/{shopClientId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ShopClients findByIdShopClients(@PathVariable("shopClientId") Long shopClientId){
        ShopClients shopClients = shopClientsRepository.findById(shopClientId).orElse(null);
        return  shopClients;
    }

    @PostMapping(value = "/saveShopClient")
    @CrossOrigin(origins = "http://localhost:4200")
    public ShopClients saveEntityShopClients(@RequestBody ShopClients shopClients){
           /* //authorizerService.saveEntityRolesAuth(rolesAuth);
            Set<RolesAuth> defaultRiles = new HashSet<>();
            RolesAuth rolesAuth = new RolesAuth("USER");
            //rolesAuth.setShopClientsAuth(shopClients);
            defaultRiles.add(rolesAuth);
            shopClients.setRolesAuths(defaultRiles);*/
           return shopLogicService.saveEntityShopClient(shopClients);
    }

    @PutMapping(value = "/updateShopClient/update/{shopClientId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ShopClients updateEntityShopClients(@RequestBody ShopClients shopClients, @PathVariable ("shopClientId")Long shopClientId){
        return shopLogicService.updateEntityShopClient(shopClients);

    }
    @DeleteMapping(value = "/deleteEntityRow/{shopClientId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ShopClients> deleteEntityRow(@PathVariable("shopClientId") Long shopClientsId){
        shopLogicService.deleteShopClient(shopClientsId);
        return shopClientsRepository.findAll();
    }
}
