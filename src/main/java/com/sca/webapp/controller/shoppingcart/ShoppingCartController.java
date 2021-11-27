package com.sca.webapp.controller.shoppingcart;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.User;
import com.sca.webapp.service.shoppingcart.ShoppingCartService;
import com.sca.webapp.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@Slf4j
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserService service;


    @GetMapping("/all/{userId}")
    public List<CartItem> displayCartItems(@PathVariable("userId") int userId){
        //System.out.println("User Id is : "+userId);
        log.debug("Logged in User wit an ID : {}",userId);
        User user= service.getUserById(userId);
        log.debug("User with an ID : {} is Requesting For Displaying the cart Items",user.getUserId());
        log.debug("Getting The CartItems for the User : {}",shoppingCartService.cartItemList(user));
        return  shoppingCartService.cartItemList(user);
    }

    @PostMapping("/add/{productId}/{quantity}/{userId}")
    public String addProductToCart(@PathVariable("productId") int productId, @PathVariable("quantity") int quantity,
                                   @PathVariable("userId") int userId){
        log.debug("In addProductToCart()");
        log.debug("Product with Id:  {} is added with Quantity: {} to shopping cart",userId,quantity);

        User user=service.getUserById(userId);
        int addedQuantity=shoppingCartService.addProduct(productId,quantity,user);
        log.debug("{} Item(s) of this Products Added to your Shopping Cart",addedQuantity);
        return addedQuantity+" item(s) of this products added to your shopping cart";
    }


    @PostMapping("/update")
    public String updateQuantity(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity,
                                 @RequestParam("userId") int userId) {
        log.info("ADD Products To the Cart");
        log.debug("Product with Id: {}  is added with Quantity : {} to shopping cart",userId,quantity);

        User user = service.getUserById(userId);
        log.debug("Logged In User with User ID: {}",userId);



        float subtotal=shoppingCartService.updateQuantity(productId,quantity,userId);
        log.info("Updated quantity in your Cart is : {} ",quantity);
        log.info("Total Cart Amount is : {}",String.valueOf(subtotal));
        return "Updated quantity in your Cart is : "+quantity+"<Br>Total Cart Amount is  "+String.valueOf(subtotal);


    }




    @PostMapping("/remove")
    public String deleteProductFromCart(@RequestParam("productId") int productId, @RequestParam("userId") int userId) {


        User user = service.getUserById(userId);
        log.debug("Trying to fetch the user : {} ",user);
        shoppingCartService.removeProduct(productId,userId);
        log.error("The Product With an Id : {} is removed from your Cart");
        return "The Product With Id : "+productId+" is Removed From your Cart";


    }
    // error: failed to push some refs to 'https://github.com/Saikrishna-Jdev/shopping-cart-application.git'


}
