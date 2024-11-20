package com.example.spring_web.repository;

import com.example.spring_web.model.Task_Model;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface Task_Repository extends JpaRepository<Task_Model,Long>
{

}