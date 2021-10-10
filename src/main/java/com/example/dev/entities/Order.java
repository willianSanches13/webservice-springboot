package com.example.dev.entities;
import java.io.Serializable;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment; 
	
	private Integer orderStatus; 
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client; 
	
	

	
	public enum OrderStatus{
		WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(4);
		private int i; 

		private OrderStatus(int i) {
			this.i = i; 
		}
		public int getI() {
			return this.i; 
		}
		public static OrderStatus valueOf(int i) {
			for(OrderStatus value: OrderStatus.values()) {
				if (value.getI() == i) {
					return value; 
				}
			}
			throw new IllegalArgumentException("Invalid Status Code"); 	
		}

};

	public Order() {
	}
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.setOrderStatus(orderStatus); 
		this.client = client;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(this.orderStatus); 
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getI();  
		}
	}


	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	

}
