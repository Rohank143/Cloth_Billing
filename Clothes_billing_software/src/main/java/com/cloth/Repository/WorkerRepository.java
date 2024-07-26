package com.cloth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloth.model.Worker;



public interface WorkerRepository extends JpaRepository<Worker, Long>
{

	Worker findByEmail(String email);

}
