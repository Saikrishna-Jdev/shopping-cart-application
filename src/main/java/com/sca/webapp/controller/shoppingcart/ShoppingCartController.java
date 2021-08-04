package com.sca.webapp.controller.shoppingcart;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.User;
import com.sca.webapp.service.shoppingcart.ShoppingCartService;
import com.sca.webapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserService service;


    @GetMapping("/all/{userId}")
    public List<CartItem> displayCartItems(@PathVariable("userId") int userId){
        System.out.println("User Id is : "+userId);
        User user= service.getUserById(userId);
//        System.out.println(user.getName()+" with Id"+user.getUserId());
        return  shoppingCartService.cartItemList(user);
    }

    @PostMapping("/add/{productId}/{quantity}/{userId}")
    public String addProductToCart(@PathVariable("productId") int productId, @PathVariable("quantity") int quantity,
                                   @PathVariable("userId") int userId){
        System.out.println("ADD Products To the Cart");
        System.out.println("Product with Id  "+productId+" is added with "+quantity+" to shopping cart");

        User user=service.getUserById(userId);
        int addedQuantity=shoppingCartService.addProduct(productId,quantity,user);
        return addedQuantity+" item(s) of this products added to your shopping cart";
    }


    @PostMapping("/update")
    public String updateQuantity(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity,
                                 @RequestParam("userId") int userId) {
        System.out.println("ADD Products To the Cart");
        System.out.println("Product with Id  " + productId + " is added with " + quantity + " to shopping cart");

        User user = service.getUserById(userId);



        float subtotal=shoppingCartService.updateQuantity(productId,quantity,userId);
        return "Updated quantity in your Cart is : "+quantity+"<Br>Total Cart Amount is  "+String.valueOf(subtotal);


    }




    @PostMapping("/remove")
    public String deleteProductFromCart(@RequestParam("productId") int productId, @RequestParam("userId") int userId) {


        User user = service.getUserById(userId);

        shoppingCartService.removeProduct(productId,userId);
        return "The Product With Id : "+productId+" is Removed From your Cart";


    }


}
