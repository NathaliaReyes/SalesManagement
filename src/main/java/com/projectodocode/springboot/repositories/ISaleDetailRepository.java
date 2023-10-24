package com.projectodocode.springboot.repositories;

import com.projectodocode.springboot.entities.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDetailRepository extends JpaRepository<SaleDetail,Long> {
}
