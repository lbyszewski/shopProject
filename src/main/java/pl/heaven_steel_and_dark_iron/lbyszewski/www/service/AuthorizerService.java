package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.RolesRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.RolesAuth;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class AuthorizerService {

    private final RolesRepository rolesRepository;

    /*public RolesAuth findRoleByName(String name ){

        Optional<RolesAuth> byRoleName = rolesRepository.findByRoleName(name);
        if(byRoleName.isPresent()){
            return byRoleName.get();
        } else {
            throw new NoSuchElementException("roll dosent exist");
        }

    }*/

    public RolesAuth saveEntityRolesAuth(RolesAuth rolesAuth) {
       return rolesRepository.save(rolesAuth);
    }
    @Transactional
    public RolesAuth updateEntityRolesAuth(RolesAuth rolesAuth) {
        RolesAuth rolesAuthUpdater = rolesRepository.findById(rolesAuth.getRoleAuthorization()).orElseThrow();
        rolesAuthUpdater.setRoleName(rolesAuth.getRoleName());
        return rolesAuthUpdater;
    }

    public void deleteRolesAuth(Long id) {
        rolesRepository.deleteById(id);
    }
}
