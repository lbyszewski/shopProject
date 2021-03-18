package pl.heaven_steel_and_dark_iron.lbyszewski.www.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.ProductWarehouseRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.GoodService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ProductWarehouse;

import java.util.List;

@RestController
@RequestMapping(value = "/shopGood")
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    private  final ProductWarehouseRepository productWarehouseRepository;


    @GetMapping(value = "/findProductWarehouse")
    public List<ProductWarehouse> findAllByProductWareHouse(){
        List<ProductWarehouse> productWarehouses = productWarehouseRepository.findAll();
        return  productWarehouses;
    }

    @GetMapping("/{productWarehouseId}")
    public ProductWarehouse findByIdProductWareHouse(@PathVariable("productWarehouseId") Long id ){
        ProductWarehouse productWarehouse = productWarehouseRepository.findById(id).orElse(null);

        return productWarehouse;
    }

    @PostMapping(value = "/saveProductWareHouse")
    public ProductWarehouse saveEntityProductWareHouse(@RequestBody ProductWarehouse productWarehouse){
        return goodService.saveEntityGoods(productWarehouse);
    }

    @PutMapping(value = "/updateProductWareHouse")
    public ProductWarehouse updateEntityProductWareHouse(@RequestBody ProductWarehouse productWarehouse){
        return goodService.updateEntityGoods(productWarehouse);

    }

    @DeleteMapping(value = "/deleteEntityRow/{productWarehouseId}")
    public void deleteEntityRow(@PathVariable("productWarehouseId") Long productWarehouseId){
        goodService.deleteProductWareHouse(productWarehouseId);
    }

}
