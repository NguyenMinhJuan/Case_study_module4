package com.codegym.casestudymodule4.service.order;

import com.codegym.casestudymodule4.model.DTO.OrderDTO;
import com.codegym.casestudymodule4.model.DTO.OrderItemDTO;
import com.codegym.casestudymodule4.model.ENUM.OrderStatus;
import com.codegym.casestudymodule4.model.Order;
import com.codegym.casestudymodule4.model.OrderItem;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.repository.OrderRepository;
import com.codegym.casestudymodule4.repository.ProductRepository;
import com.codegym.casestudymodule4.repository.UserRepository;
import com.codegym.casestudymodule4.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
      orderRepository.deleteById(id);
    }
    @Override
    public Order createOrder(OrderDTO orderDTO) {
        // Tìm sản phẩm
        Product product = productRepository.findById(orderDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Tìm người dùng
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Tạo đơn hàng mới
        Order order = new Order();
        order.setUser(user); // Liên kết với người dùng
        order.setMerchant(product.getMerchant()); // Lấy merchant từ sản phẩm
        order.setOrderDate(LocalDateTime.now()); // Thiết lập thời gian đặt hàng
        order.setStatus(OrderStatus.PENDING); // Trạng thái đơn hàng là PENDING

        // Tạo OrderItem mới từ DTO
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product); // Gán sản phẩm cho OrderItem
        orderItem.setQuantity(orderDTO.getQuantity()); // Gán số lượng
        orderItem.setPrice(product.getPrice()); // Gán giá sản phẩm

        // Thiết lập Order cho OrderItem
        orderItem.setOrder(order); // Gán order cho OrderItem

        // Thêm OrderItem vào Order
        order.getOrderItems().add(orderItem);

        // Tính tổng giá cho đơn hàng
        double totalPrice = product.getPrice() * orderDTO.getQuantity();
        order.setTotalPrice(totalPrice); // Thiết lập tổng giá cho đơn hàng

        // Lưu đơn hàng
        return orderRepository.save(order);
    }


    @Override
    public List<OrderItem> getOrderItemsByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserUserId(userId);
        List<OrderItem> orderItems = new ArrayList<>();

        for (Order order : orders) {
            orderItems.addAll(order.getOrderItems());
        }

        return orderItems;
    }

}
