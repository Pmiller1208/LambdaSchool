package com.lambdaschool.j52c2.controllers;


import com.lambdaschool.j52c2.models.Order;
import com.lambdaschool.j52c2.services.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

// ORDERS (ordnum, ordamount, advanceamount, custcode, orderdescription)
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // GET all orders
    // http://localhost:2019/orders/orders
    @GetMapping(value = "/orders/orders",
            produces = {"application/json"})
    public ResponseEntity<?> listAllOrders(){

        List<Order> myOrders = orderService.findAll();
        return new ResponseEntity<>(myOrders, HttpStatus.OK);
    }

    // GET one order by id
    // http://localhost:2019/orders/order/{orderid}
    @GetMapping(value = "/order/{orderId}",
            produces = {"application/json"})
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        Order r = orderService.findOrderById(orderId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // GET one order by name
    // http://localhost:2019/orders/order/{orderName}
    @GetMapping(value = "/order/name/{orderName}",
            produces = {"application/json"})
    public ResponseEntity<?> getOrderByName(@PathVariable String orderName) {
        Order r = orderService.findOrderByName(orderName);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // GET one order by telephone
    // http://localhost:2019/orders/order/{orderPhone}
    @GetMapping(value = "/order/phone/{orderPhone}",
            produces = {"application/json"})
    public ResponseEntity<?> getOrderByTelephone(@PathVariable String orderPhone) {
        Order r = orderService.findOrderByTelephone(orderPhone);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // GET /orders/order/{id} - Returns the order and its customer with the given order number

    // GET /orders/advanceamount - returns all orders with their customers that have an advanceamount greater than 0.
    // DELETE one order
    // http://localhost:2019/orders/order/{orderid}
    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long orderId) {
        orderService.delete(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT one order
    // http://localhost:2019/orders/order/{orderid}
    @PutMapping(value = "/order/{orderId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> updateOrder(@RequestBody Order updateOrder,
                                              @PathVariable Long orderId) {
        orderService.update(updateOrder, orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // POST one order
    @PostMapping(value = "/order",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> addNewOrder(@Valid
                                              @RequestBody Order newOrder) throws URISyntaxException{
        newOrder = orderService.save(newOrder);

        // set location header for newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderid}")
                .buildAndExpand(newOrder.getOrderid()).toUri();
        responseHeaders.setLocation(newOrderURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
