package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.RolesRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.ShopClientsRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.RolesAuth;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ShopClients;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopLogicService {

    private final ShopClientsRepository shopClientsRepository;

    private final AuthorizerService authorizerService;

    public ShopClients saveEntityShopClient(ShopClients shopClients){


       return shopClientsRepository.save(shopClients);
    }
    @Transactional
    public ShopClients updateEntityShopClient(ShopClients shopClients) {

        ShopClients shopClientsUpdater = shopClientsRepository.findById(shopClients.getUserShopId()).orElseThrow();
        shopClientsUpdater.setUserLogin(shopClients.getUserLogin());
        shopClientsUpdater.setPhoneNumber(shopClients.getPhoneNumber());
        shopClientsRepository.save(shopClientsUpdater);
        return shopClientsUpdater;
    }

    public void deleteShopClient(Long id) {
        shopClientsRepository.deleteById(id);
    }


}
