package com.springproject.springproject.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class Sales {

    @Override
    public String toString() {
        return "Sales [salesman=" + salesman + ", product=" + product + "]";
    }

    private List<Salesman> salesman = new ArrayList<Salesman>();
    private List<Product> product = new ArrayList<Product>();



}
