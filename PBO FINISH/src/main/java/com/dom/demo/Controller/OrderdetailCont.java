package com.dom.demo.Controller;

import com.dom.demo.ErorrHandler.NotFound;
import com.dom.demo.model.Orderdetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.demo.repository.OrderdetailRepo;

@RestController
@RequestMapping("/api")
public class OrderdetailCont{
    
    @Autowired
    OrderdetailRepo orderdetailRepository;

    @GetMapping("/OrderDetail")
    public List<Orderdetail> getAll(){
        return orderdetailRepository.findAll();
    }

    @PostMapping("/OrderDetail")
    public Orderdetail insertOrderdetail(@Validated @RequestBody Orderdetail orderdetail){
        return orderdetailRepository.save(orderdetail);
    }

    @GetMapping("/OrderDetail/{t_order}")
    public Orderdetail getOrderdetail(@PathVariable(value="t_order") int id){
        return orderdetailRepository.findById(id).orElseThrow(()-> new NotFound("Orderdetail", "t_order", id));
    }

    @PutMapping("/OrderDetail/{t_order}")
    public Orderdetail updateOrderdetail(@PathVariable(value="t_order") int id, @Validated @RequestBody Orderdetail detail){
        Orderdetail orderdetail = orderdetailRepository.findById(id).orElseThrow(()-> new NotFound("Orderdetail", "t_order", id));
        orderdetail.setOrder(detail.getOrder());
        orderdetail.setProduct(detail.getProduct());
        orderdetail.setQuantity(detail.getQuantity());
        orderdetail.setPrice(detail.getPrice());
        Orderdetail updateOrderdetail = orderdetailRepository.save(orderdetail);
        return updateOrderdetail;
    }

    @DeleteMapping("/OrderDetail/{t_order}")
    public ResponseEntity<?> deleteOrderdetail(@PathVariable(value="t_order") int id){
        Orderdetail orderdeOrderdetail = orderdetailRepository.findById(id).orElseThrow(()-> new NotFound("Orderdetail", "t_order", id));
        orderdetailRepository.delete(orderdeOrderdetail);
        return ResponseEntity.ok().build();
    }
}
