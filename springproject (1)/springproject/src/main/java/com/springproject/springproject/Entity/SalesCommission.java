package com.springproject.springproject.Entity;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;



import javax.persistence.* ;
@Entity
@Getter
@Setter
@NoArgsConstructor

public class SalesCommission  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_name;
    private int product_quantity;
    private double sale_amount;
    private String salesman_name;
    private int salesman_commission;
    private String salesman_area;
    private LocalDate created_date;

    @Override
    public String toString() {
        return "SalesCommission [id=" + id + ", product_name=" + product_name + ", product_quantity=" + product_quantity
                + ", sale_amount=" + sale_amount + ", salesman_name=" + salesman_name + ", salesman_commission="
                + salesman_commission + ", salesman_area=" + salesman_area + ", created_date=" + created_date + "]";
    }
}

