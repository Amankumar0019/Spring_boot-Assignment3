package com.springproject.springproject.Comtroller;

import java.sql.SQLException;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.springproject.springproject.Entity.Sales;
import com.springproject.springproject.Entity.SalesCommission;
import com.springproject.springproject.Service.ServiceSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ControllerSales {

    @Autowired
    ServiceSale servicesale;

    @GetMapping("/hello")
    @CrossOrigin("http://localhost:3000")
    public String hello(){
        return "HELLO";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sales")
    @CrossOrigin("http://localhost:3000")
    public String addsales(@RequestBody Sales sales) {
//        System.out.println("Controller");
        servicesale.calculate(sales);
        return "Success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sales/commission")
    @CrossOrigin("http://localhost:3000")
    public List<SalesCommission> getSalesByDate(@RequestParam String date) throws SQLException {
        List<SalesCommission> data = servicesale.getData(date);
        return data;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sales/ByProductName/{productName}")
    @CrossOrigin("http://localhost:3000")
    public List<SalesCommission> getSalesByProductName(@PathVariable String productName) throws SQLException {
        List<SalesCommission> data2 = servicesale.getData2(productName);
        return data2;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sales/BySalesmanName/{salesmanName}")
    @CrossOrigin("http://localhost:3000")
    public List<SalesCommission> getSalesBysalesmanName(@PathVariable String salesmanName) throws SQLException {
        List<SalesCommission> data3 = servicesale.getData3(salesmanName);
        return data3;
    }
}
