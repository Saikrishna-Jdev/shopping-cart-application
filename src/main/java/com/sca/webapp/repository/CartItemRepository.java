package com.sca.webapp.repository;

import com.sca.webapp.entity.CartItem;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

    public List<CartItem> findByUser(User user);
    public CartItem findByUserAndProduct(User user, Product product);

    @Query("UPDATE CartItem c SET c.quantity=?1 WHERE c.product.productId= ?2 AND c.user.userId= ?3")
    @Modifying
    public void updateQuantity(int quantity,int productId,int userId);


    @Query("DELETE  from CartItem  c where c.user.userId=?1 and c.product.productId=?2")
    @Modifying
    public void deleteByUserAndProduct(int userId,int productId);

}
