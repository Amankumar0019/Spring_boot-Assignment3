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
public class Salesjdbc {

    public List<SalesCommission> getData(String date) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesman", "root", "root");
        PreparedStatement pre_stm = null;
        ResultSet result = null;

        String query = "SELECT * FROM sales_commission where created_date=? ";

        pre_stm = connection.prepareStatement(query);
        pre_stm.setString(1, date);
        result = pre_stm.executeQuery();

        List<SalesCommission> list = new ArrayList<SalesCommission>();

        while (result.next()) {
            Long id = Long.parseLong(result.getString(1));
            String date1 = result.getString(2);
            String product_name = result.getString(3);
            int quantity = Integer.parseInt(result.getString(4));
            double total_sales_amt = Double.parseDouble(result.getString(5));
            String area = result.getString(6);
            int commission_amt = Integer.parseInt(result.getString(7));
            String name = result.getString(8);

            System.out.println(name);

            SalesCommission scm = new SalesCommission();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate created_date = LocalDate.parse(date1, formatter);

            scm.setId(id);
            scm.setSalesman_name(name);
            scm.setSalesman_area(area);
            scm.setProduct_name(product_name);
            scm.setProduct_quantity(quantity);
            scm.setSale_amount(total_sales_amt);
            scm.setSalesman_commission(commission_amt);
            scm.setCreated_date(created_date);
            list.add(scm);
            id++;
        }

        return list;
    }
}
