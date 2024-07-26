package com.cloth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Money_Repository extends JpaRepository<com.cloth.model.Money_b,Long> {

}
