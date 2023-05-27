package com.springproject.springproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String product_name;
    private int quantity;
    private int mrp_per_unit;
    private int salesman_id;
  }



