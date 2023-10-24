package com.projectodocode.springboot.repositories;

import com.projectodocode.springboot.entities.Sale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {

    @Transactional
    @Query("SELECT COALESCE(SUM(s.amount), 0.0) FROM Sale s WHERE s.date=?1")
    double dailySaleAmount(String date);

    @Transactional
    @Query("SELECT COALESCE(COUNT(s), 0.0) FROM Sale s WHERE s.date=?1")
    int quantitySalesPerDay(String date);


}


