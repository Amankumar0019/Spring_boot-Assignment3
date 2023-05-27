package com.springproject.springproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.springproject.springproject.Entity.SalesCommission;
import org.springframework.stereotype.Service;
@Service
public class productjdbc {
    public List<SalesCommission> getData2(String productName) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesman", "root", "root");
        PreparedStatement pre_stm = null;
        ResultSet result = null;

        String query = "select salesman_area,sum(product_quantity)'total_quantity',sum(sale_amount)'total_sales'\n" +
                "from sales_commission where product_name=?\n" +
                "group by salesman_area;";

        pre_stm = connection.prepareStatement(query);
        pre_stm.setString(1, productName);
        result = pre_stm.executeQuery();

        List<SalesCommission> list = new ArrayList<>();

        while (result.next()) {
            String area = result.getString("salesman_area");
            int quantity = result.getInt("total_quantity");
            double salesAmount = result.getDouble("total_sales");

            SalesCommission salesCommission = new SalesCommission();
            salesCommission.setSalesman_area(area);
            salesCommission.setProduct_quantity(quantity);
            salesCommission.setSale_amount(salesAmount);

            list.add(salesCommission);
        }

        return list;
    }


}
