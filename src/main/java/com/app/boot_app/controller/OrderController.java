package com.app.boot_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.boot_app.model.Order;
import com.app.boot_app.service.order.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order user) {
		  Order savedOrder = orderService.save(user);
	      return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>>  getUserAll() {
		List<Order> order = orderService.findAll();
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<List<Order>> getOrderById(@PathVariable("id") Long id) {
		List<Order> orderlist = new ArrayList<Order>();
		Order order = orderService.findById(id);
		orderlist.add(order);
	    return new ResponseEntity<>(orderlist, HttpStatus.CREATED);
	}
	
	@GetMapping("user_id/{id}")
	public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable("id") int id) {
		List<Order> order = orderService.getOrderByUserId(id);
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("status/GUESTS_WHO_ARE_STILL_AT_THE_HOTEL")
	public ResponseEntity<List<Order>> getUserByOderGuest() {
		List<Order> order = orderService.getUserByOderGuest();
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("status/GUESTS_WHO_HAVE_RESERVATIONS_BUT_HAVENT_CHECKED_IN")
	public ResponseEntity<List<Order>> getUserByOderGuestNotCheckIn() {
		List<Order> order = orderService.getUserByOderGuestNotCheckIn();
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("status/GUESTS_WHO_HAVE_ALREADY_CHECKED_IN")
	public ResponseEntity<List<Order>> getUserByOderGuestHaveAlreadyCheckIn() {
		List<Order> order = orderService.getUserByOderGuestHaveAlreadyCheckIn();
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("check-in/order/{id}")
	public ResponseEntity<Order> checkIn(@PathVariable("id") Long id) {
		Order order = orderService.checkIn(id);
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("check-out/order/{id}")
	public ResponseEntity<Order> checkOut(@PathVariable("id") Long id) {
		Order order = orderService.checkOut(id);
	    return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
}
