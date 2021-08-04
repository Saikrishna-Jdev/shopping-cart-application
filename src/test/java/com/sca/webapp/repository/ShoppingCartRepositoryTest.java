package com.sca.webapp.repository;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ShoppingCartRepositoryTest {

    @Autowired
    private CartItemRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testAddItemToCart(){
        Product product = testEntityManager.find(Product.class,3);
        User user=testEntityManager.find(User.class,1);
        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setUser(user);
        cartItem.setQuantity(5);
        CartItem savedCartItem=repository.save(cartItem);
        assertTrue(savedCartItem.getId()>0);
    }

    @Test
    public void testCartItemsByUser(){
        User user=new User();
        user.setUserId(1);
        List<CartItem> cartItemList=repository.findByUser(user);
        assertEquals(4,cartItemList.size());

    }
}
