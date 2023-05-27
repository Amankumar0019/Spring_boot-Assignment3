package com.springproject.springproject.Service;

import com.springproject.springproject.Dao.*;
import com.springproject.springproject.Entity.Product;
import com.springproject.springproject.Entity.Sales;
import com.springproject.springproject.Entity.SalesCommission;
import com.springproject.springproject.Entity.Salesman;
import com.springproject.springproject.Dao.Salesdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceSale {

    @Autowired
    Salesdao dao;

    @Autowired
    Salesjdbc jdbc;

    @Autowired
    productjdbc jdbc2;
    @Autowired
    Salesmanjdbc jdbc3;

    public void calculate(Sales sales) {
        List<Product> product = sales.getProduct();
        List<Salesman> salesman = sales.getSalesman();

        for (Product prod : product) {

            String product_name = prod.getProduct_name();
            int mrp_per_unit = prod.getMrp_per_unit();
            int quantity = prod.getQuantity();
            final int salesman_id = prod.getSalesman_id();
            double total_sales_amt = mrp_per_unit * quantity;

            Optional<Salesman> strm = salesman.stream().filter(new Predicate<Salesman>() {
                public boolean test(Salesman sman) {
                    return sman.getSalesman_id() == salesman_id;
                }
            }).findFirst();

            Salesman sman = strm.get();

            int commission_rate = sman.getCommission_rate();
            String name = sman.getName();
            String area = sman.getArea();
            int commission_amt = (int) (commission_rate * total_sales_amt / 100);

            LocalDate created_date = LocalDate.now();

            SalesCommission sale_comm = new SalesCommission();

            sale_comm.setId(sale_comm.getId());
            sale_comm.setSalesman_name(name);
            sale_comm.setSalesman_area(area);
            sale_comm.setProduct_name(product_name);
            sale_comm.setProduct_quantity(quantity);
            sale_comm.setSale_amount(total_sales_amt);
            sale_comm.setSalesman_commission(commission_amt);
            sale_comm.setCreated_date(created_date);

            System.out.println(sale_comm);
            dao.save(sale_comm);
        }
    }

    public List<SalesCommission> getData(String data) throws SQLException
    {
        List<SalesCommission> salesdata = jdbc.getData(data);
        return salesdata;
    }

    public List<SalesCommission> getData2(String productName) throws SQLException
    {
        List<SalesCommission> salesdata2 = jdbc2.getData2(productName);
        return salesdata2;
    }

    public List<SalesCommission> getData3(String salesmanName) throws SQLException
    {
        List<SalesCommission> salesdata3 = jdbc3.getData3(salesmanName);
        return salesdata3;
    }

}



