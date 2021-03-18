package pl.heaven_steel_and_dark_iron.lbyszewski.www.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.BuyersOrdersRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.service.BuyersService;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.BuyersOrders;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class BuyersOrdersController {

    private final BuyersOrdersRepository buyersOrdersRepository;

    private final BuyersService buyersService;

    @GetMapping(value = "/findBuyersOrder")
    public List<BuyersOrders> findAllByBuyerOrders(){
        List<BuyersOrders> buyersOrders = buyersOrdersRepository.findAll();
        return  buyersOrders;
    }

    @GetMapping("/{buyersOrderId}")
    public BuyersOrders findByIdBuyerOrders(@PathVariable("buyersOrderId") Long id ){
        BuyersOrders buyersOrders = buyersOrdersRepository.findById(id).orElse(null);
        return buyersOrders;
    }

    @PostMapping(value = "/saveBuyersOrders")
    public BuyersOrders saveEntityBuyersOrders(@RequestBody BuyersOrders buyersOrders){
        return buyersService.saveEntityBuyersOrders(buyersOrders);
    }

    @PutMapping(value = "/updateBuyersOrders")
    public BuyersOrders updateEntityBuyerOrders(@RequestBody BuyersOrders buyersOrders){
        return buyersService.updateEntityBuyersOrders(buyersOrders);

    }

    @DeleteMapping(value = "/deleteEntityRow/{buyersOrderId}")
    public void deleteEntityRow(@PathVariable("buyersOrderId") Long buyersOrderId){
        buyersService.deleteBuyersOrders(buyersOrderId);
    }


}
