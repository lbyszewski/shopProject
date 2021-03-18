package pl.heaven_steel_and_dark_iron.lbyszewski.www.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.RolesRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.AuthorizerService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.RolesAuth;

import java.util.List;

@RequestMapping(value = "/roles")
@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RolesRepository rolesRepository;

    private final AuthorizerService authorizerService;


    @GetMapping(value = "/findRoles")
    public List<RolesAuth> findAllByRolesAuth(){
        List<RolesAuth> rolesAuths = rolesRepository.findAll();
        return  rolesAuths;
    }

    @GetMapping("/{rolesId}")
    public RolesAuth findByIdRoleAuth(@PathVariable("rolesId") Long id ){
        RolesAuth rolesAuth = rolesRepository.findById(id).orElse(null);

        return rolesAuth;
    }

    @PostMapping(value = "/saveRolesAuth")
    public RolesAuth saveEntityRolesAuth(@RequestBody RolesAuth rolesAuth){
        return authorizerService.saveEntityRolesAuth(rolesAuth);
    }

    @PutMapping(value = "/updateRolesAuth")
    public RolesAuth updateEntityRolesAuth(@RequestBody RolesAuth rolesAuth){
        return authorizerService.updateEntityRolesAuth(rolesAuth);

    }
    @DeleteMapping(value = "/deleteEntityRow/{rolesId}")
    public void deleteEntityRow(@PathVariable("rolesId") Long Id){
        authorizerService.deleteRolesAuth(Id);
    }
//

}
