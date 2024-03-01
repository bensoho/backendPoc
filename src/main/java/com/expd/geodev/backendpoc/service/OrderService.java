package com.expd.geodev.backendpoc.service;

import com.expd.geodev.backendpoc.model.Order;

public interface OrderService {
    String bookTicket(String userId, String ticketId);
    String rebook(Order order);
    String cancelOrder(Order order);
}
