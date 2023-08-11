package com.app.boot_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.boot_app.dto.order.OrderConverter;
import com.app.boot_app.dto.order.OrderRequestDTO;
import com.app.boot_app.dto.order.OrderResponseDTO;
import com.app.boot_app.model.Order;
import com.app.boot_app.service.order.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public OrderResponseDTO create(@Validated @RequestBody final  OrderRequestDTO order) {
		Order savedOrder = orderService.save(new Order(
			order.getId(),
			order.getUser_id(),
			order.getStatus(),
			order.getHorary_check_in(),
			order.getHorary_check_out(),
			order.getDaily_price_monday_to_friday(),
			order.getDaily_price_weekends(),
			order.getPrice_of_car_spaces_monday_to_friday(),
			order.getPrice_of_car_spaces_weekend(),
			order.getAdditional_fee_percentage_of_later_check_in(),
			order.getList_days_monday_to_friday(),
			order.getList_days_weekend()
		));
	    return OrderConverter.converter(savedOrder);
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
