package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.ShopClientsRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ShopClients;

@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final ShopClientsRepository shopClientsRepository;

}
