package com.app.boot_app.service.order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.boot_app.model.Order;
import com.app.boot_app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order save(Order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> optionalOrder = this.orderRepository.findById(id);
		return optionalOrder.get();
	}

	@Override
	public List<Order> getOrderByUserId(int user_id) {
		List<Order> order = this.orderRepository.getOrderByUserId(user_id);
		return order;
	}

	@Override
	public List<Order> getUserByOderGuest() {
		List<Order> order = this.orderRepository.getUserByOderGuest();
		return order;
	}

	@Override
	public List<Order> getUserByOderGuestNotCheckIn() {
		List<Order> order = this.orderRepository.getUserByOderGuestNotCheckIn();
		return order;
	}

	@Override
	public List<Order> getUserByOderGuestHaveAlreadyCheckIn() {
		List<Order> order = this.orderRepository.getUserByOderGuestHaveAlreadyCheckIn();
		return order;
	}

	@Override
	public Order checkOut(Long id) {
		  Order order =  new Order();
		  Date d = new Date();  
	      if(d.getHours() <= 12 && d.getMinutes() == 0  && d.getSeconds() == 0) {
	    	  this.orderRepository.checkOut(id);
	    	  order.setStatus("CHECK_IN_SUCCESS");
	      }else {
	    	  order.setStatus("CHECK_OUT_SERA_PARTIR_DAS_12H00MIN");
	      }
		return order;
	}

	@Override
	public Order checkIn(Long id) {
		  Order order =  new Order();
		  Date d = new Date();  
	      if(d.getHours() == 14 && d.getMinutes() == 0  && d.getSeconds() == 0) {
	    	  this.orderRepository.CheckIn(id);
	    	  order.setStatus("CHECK_IN_SUCCESS");
	      }else {
	    	  order.setStatus("CHECK_IN_SERA_PARTIR_DAS_14H00MIN");
	      }
		return order;
	}
}
