package com.app.boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.boot_app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "select * from orders where user_id = :user_id", nativeQuery = true)
	List<Order> getOrderByUserId(@Param("user_id") int user_id);
	
	@Query(value = "select * from orders where status = 'GUESTS_WHO_ARE_STILL_AT_THE_HOTEL'", nativeQuery = true)
	List<Order> getUserByOderGuest();
	
	@Query(value = "select * from orders where status = 'GUESTS_WHO_HAVE_RESERVATIONS_BUT_HAVENT_CHECKED_IN'", nativeQuery = true)
	List<Order> getUserByOderGuestNotCheckIn();
	
	@Query(value = "select * from orders where status = 'GUESTS_WHO_HAVE_ALREADY_CHECKED_IN'", nativeQuery = true)
	List<Order> getUserByOderGuestHaveAlreadyCheckIn();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update orders set status = 'GUESTS_WHO_ARE_STILL_AT_THE_HOTEL' where id=:order_id", nativeQuery = true)
	void CheckIn(@Param("order_id") Long id);
	
	@Query(value = "update orders SET status = 'GUESTS_WHO_HAVE_ALREADY_CHECKED_IN' WHERE id = :id", nativeQuery = true)
	void checkOut(@Param("id") Long id);
	
}