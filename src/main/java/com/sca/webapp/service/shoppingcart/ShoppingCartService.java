package com.sca.webapp.service.shoppingcart;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.User;
import com.sca.webapp.repository.CartItemRepository;
import com.sca.webapp.repository.ProductRepository;
import com.sca.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class  ShoppingCartService {

    @Autowired
    private CartItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;



    public List<CartItem> cartItemList(User user){

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
        itemRepository.save(cartItem);
        return addedQuantity;
    }

    public float updateQuantity(int productId,int quantity,int userId){
        itemRepository.updateQuantity(quantity,productId,userId);
        Product product=productRepository.findById(productId).get();



        float subtotal=product.getPrice()*quantity;
        return subtotal;
    }



    public void removeProduct(int productId,int userId){
        itemRepository.deleteByUserAndProduct(productId,userId);

    }
}
