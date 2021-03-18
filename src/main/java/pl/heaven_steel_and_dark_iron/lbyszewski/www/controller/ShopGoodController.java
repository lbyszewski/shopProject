package pl.heaven_steel_and_dark_iron.lbyszewski.www.controller;

;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.MerchandiseRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.ShopGoodService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.Merchandise;


import java.util.List;

@RestController
@RequestMapping(value = "/good")
@RequiredArgsConstructor
public class ShopGoodController {

    private final ShopGoodService shopGoodService;

    private final MerchandiseRepository merchandiseRepository;

    @GetMapping(value = "/findMerchandise")
    public List<Merchandise> findAllByMerchandise(){
        List<Merchandise> merchandiseList = merchandiseRepository.findAll();
        return  merchandiseList;
    }

    @GetMapping("/{merchandiseId}")
    public Merchandise findByIdMerachandise(@PathVariable("merchandiseId") Long id ){
        Merchandise merchandise = merchandiseRepository.findById(id).orElse(null);

        return merchandise;
    }

    @PostMapping(value = "/saveMerchandise")
    public Merchandise saveEntityMerachandise(@RequestBody Merchandise merchandise){
        return shopGoodService.saveEntityShopGoods(merchandise);
    }

    @PutMapping(value = "/updateMerchandise")
    public Merchandise updateEntityMerachandise(@RequestBody Merchandise merchandise){
        return shopGoodService.updateEntityShopGoods(merchandise);

    }
    @DeleteMapping(value = "/deleteEntityRow/{merchandiseId}")
    public void deleteEntityRow(@PathVariable("merchandiseId") Long merchandiseId){
        shopGoodService.deleteMerchandise(merchandiseId);
    }

}
