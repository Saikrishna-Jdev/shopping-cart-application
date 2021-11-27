package com.sca.webapp.service.shoppingcart;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.User;
import com.sca.webapp.repository.CartItemRepository;
import com.sca.webapp.repository.ProductRepository;
import com.sca.webapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class  ShoppingCartService {

    @Autowired
    private CartItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;



    public List<CartItem> cartItemList(User user){
        log.info("In ShoppingCartService.cartItemList() ");

        return  itemRepository.findByUser(user);
    }

    public int addProduct(int productId,int quantity,User user){

        int addedQuantity=quantity;
        Product product=productRepository.findById(productId).get();

        CartItem cartItem=itemRepository.findByUserAndProduct(user,product);
        if(cartItem!=null){
            addedQuantity=cartItem.getQuantity()+quantity;
            cartItem.setQuantity(addedQuantity);

        }else{
            cartItem=new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setUser(user);
            cartItem.setProduct(product);
        }
        log.info("Item(s) {} are added into the shopping Cart",cartItem.getQuantity());
        itemRepository.save(cartItem);
        log.info("Item(s) with Quantity {} is/are added into Cart Successfully",addedQuantity);
        return addedQuantity;
    }

    public float updateQuantity(int productId,int quantity,int userId){
        log.info("In ShoppingCartService.updateQuantity() for updating the Product Quantity");
        itemRepository.updateQuantity(quantity,productId,userId);
        Product product=productRepository.findById(productId).get();
        log.info("Update Details for the Product Id is: {},userId {}",productId,userId);



        float subtotal=product.getPrice()*quantity;
        log.info("The total Amount After updating the quantity is : {}",subtotal);
        return subtotal;
    }



    public void removeProduct(int productId,int userId){
        log.error("Removed Product From the Cart With Product Id: {} by the Logged in User with Id: ",productId,userId);
        itemRepository.deleteByUserAndProduct(productId,userId);

    }
}
