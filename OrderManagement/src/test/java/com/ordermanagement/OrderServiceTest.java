package com.ordermanagement;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ordermanagement.controller.OrderController;
import com.ordermanagement.model.Address;
import com.ordermanagement.model.Order;
import com.ordermanagement.model.OrderItem;
import com.ordermanagement.model.OrderLine;
import com.ordermanagement.model.OrderLineStatus;
import com.ordermanagement.model.Status;
import com.ordermanagement.reponse.MessageResponse;
import com.ordermanagement.reponse.OrderListResult;
import com.ordermanagement.reponse.OrderResult;
import com.ordermanagement.reponse.ResultResponse;
import com.ordermanagement.service.OrderRepository;
import com.ordermanagement.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceTest {

	@Mock
	OrderService orderService;

	@Mock
	List<Order> order;

	@Autowired
	OrderRepository orderRepository;

	@InjectMocks
	OrderController controller;
	@Mock
	ResultResponse response;

	@Mock
	OrderResult orderResult;

	@Mock
	OrderListResult listResult;

	@Test
	public void createOrderTestForNotNullCheck() {
		Order order = createOrder();
		Mockito.when(orderService.saveOrder(order))
				.thenReturn(new ResultResponse(200, MessageResponse.SAVE_SUCCESFULL));
		ResultResponse result = controller.postOrderDetails(order);
		Mockito.verify(orderService).saveOrder(order);
		assertNotNull(result);
	}

	@Test
	public void createOrderTestforNullCheck() {
		Order order = createOrder();
		ResultResponse result = controller.postOrderDetails(order);
		assertNull(result);
	}

	@Test
	public void getOrdersByPincodeTestForNotNullCheck() {
		int pincode = 515110;
		Mockito.when(orderService.getOrderByPincode(pincode)).thenReturn(listResult);
		OrderListResult result = controller.getListOfOrderDetailsByPincode(515110);
		Mockito.verify(orderService).getOrderByPincode(pincode);
		assertNotNull(result);
	}

	@Test
	public void getOrdersByIdTestNotNullCheck() {
		String id = "629f4a70b16b474bee7c8066";
		Mockito.when(orderService.getOrderById(id)).thenReturn(new OrderResult());
		OrderResult result = controller.getOrder(id);
		Mockito.verify(orderService).getOrderById(id);
		assertNotNull(result);
	}

	@Test
	public void getOrdersByPincodeTestNullCheck() {
		OrderListResult result = controller.getListOfOrderDetailsByPincode(515110);
		assertNull(result);
	}

	@Test
	public void getOrdersByIdTestNullCheck() {
		OrderResult result = controller.getOrder("629f4a70b16b474bee7c8066");
		assertNull(result);
	}

	private Order createOrder() {
		Order order = new Order();
		order.setOrderLines(getListOfOrderLines());
		order.setOrderDate(getDate());
		order.setStatus(Status.OPEN);
		order.setTotalAmount(1200.0f);
		return order;
	}

	private List<OrderLine> getListOfOrderLines() {
		List<OrderLine> listOfOrderLines = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setEta(getDate());
		orderLine.setAddresses(getListOfAddress());
		orderLine.setListOfItems(getListOfItems());
		orderLine.setStatusLine(OrderLineStatus.OPEN);
		listOfOrderLines.add(orderLine);
		return listOfOrderLines;
	}

	private List<OrderItem> getListOfItems() {
		List<OrderItem> listOfItems = new ArrayList<>();
		OrderItem item = new OrderItem();
		item.setItemName("item1");
		item.setPrice(5000.0f);
		item.setQuantity(1);
		listOfItems.add(item);
		return listOfItems;

	}

	private List<Address> getListOfAddress() {
		List<Address> listOfAddress = new ArrayList<>();
		Address address = new Address();
		address.setState("ap");
		address.setCountry("India");
		address.setPinCode(515110);
		listOfAddress.add(address);
		return listOfAddress;
	}

	@Test
	public void saveOrderTestForNotNullCheck() {
		assertFalse(false);
		Order order = createOrder();
		Mockito.when(orderService.saveOrder(order))
				.thenReturn(new ResultResponse(200, MessageResponse.SAVE_SUCCESFULL));
		ResultResponse result = orderService.saveOrder(order);
		Mockito.verify(orderService).saveOrder(order);
		assertNotNull(result);

	}

	private Date getDate() {
		Date date = null;
		String sDate1 = "2022/06/10";
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		} catch (ParseException e) {
			// LOGGER
		}
		return date;
	}
}
