package edu.poly.shop.model;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailModel {
	Long id;
	Double price;
	Integer quantity;
}
