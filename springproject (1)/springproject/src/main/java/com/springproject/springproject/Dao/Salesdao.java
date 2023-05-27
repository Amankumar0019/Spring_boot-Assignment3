package com.springproject.springproject.Dao;



import com.springproject.springproject.Entity.SalesCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Salesdao extends JpaRepository<SalesCommission,Integer> {

}