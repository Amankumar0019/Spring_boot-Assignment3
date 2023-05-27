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
public class Salesmanjdbc {

    public List<SalesCommission> getData3(String salesmanName) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesman", "root", "root");
        PreparedStatement pre_stm = null;
        ResultSet result = null;

        String query = "select salesman_area,sum(product_quantity)'total_quantity',sum(salesman_commission)'total_commission' \n"+
        "from sales_commission where salesman_name=?\n"+
        "group by salesman_area";

        pre_stm = connection.prepareStatement(query);
        pre_stm.setString(1, salesmanName);
        result = pre_stm.executeQuery();

        List<SalesCommission> list = new ArrayList<>();

        while (result.next()) {
            String area = result.getString("salesman_area");
            int quantity = result.getInt("total_quantity");
            double salesmancommission = result.getDouble("total_commission");

            SalesCommission salesCommission = new SalesCommission();
            salesCommission.setSalesman_area(area);
            salesCommission.setProduct_quantity(quantity);
            salesCommission.setSalesman_commission((int) salesmancommission);

            list.add(salesCommission);
        }

        return list;
    }
}
