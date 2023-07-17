package com.app.boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.boot_app.model.Order;
import com.app.boot_app.repository.projection.UserProjection;

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

	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

	@Query(nativeQuery = true, value = """
	SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
	tb_game.short_description AS shortDescription, tb_belonging.position
	FROM tb_game
	INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
	WHERE tb_belonging.list_id = :listId
	ORDER BY tb_belonging.position
				""")
	List<UserProjection> searchByList(Long listId);

}