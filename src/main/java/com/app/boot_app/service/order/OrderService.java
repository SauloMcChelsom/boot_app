package com.app.boot_app.service.order;

import java.util.List;

import com.app.boot_app.model.Order;

public interface OrderService {

	Order save(Order user);
	
	List<Order> findAll();
	
	Order findById(Long value);
	
	List<Order> getOrderByUserId(int user_id);
	
	List<Order> getUserByOderGuest();
	
	List<Order> getUserByOderGuestNotCheckIn();
	
	List<Order> getUserByOderGuestHaveAlreadyCheckIn();
	
	Order checkOut(Long user_id);
	
	Order checkIn(Long user_id);
}
