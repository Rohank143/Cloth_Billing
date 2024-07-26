package com.cloth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloth.model.Stock_info;

public interface Stock_Repo extends JpaRepository<Stock_info, Long>
{

}
