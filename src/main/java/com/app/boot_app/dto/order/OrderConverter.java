package com.app.boot_app.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.app.boot_app.model.Order;

public class OrderConverter {

    public static OrderResponseDTO converter(Order originalOrdere) {
        return new OrderResponseDTO(
            originalOrdere.getId(),
            originalOrdere.getUser_id(),
            originalOrdere.getStatus(),
            originalOrdere.getHorary_check_in(),
            originalOrdere.getHorary_check_out(),
            originalOrdere.getDaily_price_monday_to_friday(),
            originalOrdere.getDaily_price_weekends(),
            originalOrdere.getPrice_of_car_spaces_monday_to_friday(),
            originalOrdere.getPrice_of_car_spaces_weekend(),
            originalOrdere.getAdditional_fee_percentage_of_later_check_in(),
            originalOrdere.getList_days_monday_to_friday(),
            originalOrdere.getList_days_weekend()
        );
    }

    public static List<OrderResponseDTO> converter(List<Order> Order) {
        List<OrderResponseDTO> ordereResponseDTO = new ArrayList<OrderResponseDTO>();

        for (Order order : Order) {
            ordereResponseDTO.add(
                new OrderResponseDTO(
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
                )
            );
        }

        return ordereResponseDTO;
    }

}
