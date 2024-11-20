package com.example.spring_web.controller;
import com.example.spring_web.domain.Task_Status;
import com.example.spring_web.model.Task_Model;
import com.example.spring_web.repository.Task_Repository;
import com.sun.source.util.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")

public class Task_Controller {
    @Autowired
    Task_Repository taskRepository;
    //RETRIEVING ALL TASKS IN THE DB
    @GetMapping("tasks")
    public ResponseEntity<List<Task_Model>>getAllTasks()
    {
        try
        {
            List<Task_Model> Task_List = new ArrayList<>();
            taskRepository.findAll().forEach(Task_List::add);

            if(Task_List.isEmpty())
            {
                //IF NO TASKS RETURN THEN HTTPSTATUS-> NO_CONTENT
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //IF TASKS ARE PRESENT,RETURN TASKS,HTTPSTATUS-> OK
            return new ResponseEntity<>(Task_List,HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //RETRIEVING A SPECIFIC BY ITS ID
    @GetMapping("tasks/{id}")
    public ResponseEntity<Task_Model>getTaskById(@PathVariable Long id)
    {
        try
        {
            Optional<Task_Model> TaskObj = taskRepository.findById(id);
            if(TaskObj.isPresent())
            {
                //IF TASK IS FOUND WITH ID,THEN RETURN TASK ,HTTPSTATUS-> OK
                return new ResponseEntity<>(TaskObj.get(), HttpStatus.OK);
            }
            else
            {
                //IF TASK IS NOT FOUND THEN HTTPSTATUS->NOT FOUND
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ADDIND A NEW TASK
    @PostMapping("tasks")
    public ResponseEntity<Task_Model>addTask(@RequestBody Task_Model task_model)
    {
        try
        {

            Task_Model taskObj = taskRepository.save(task_model);
            //AFTER SUCCESFUL ADDING , RETURN ADDED HTTPSTATUS -> CREATED
            return new ResponseEntity<>(taskObj,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<HttpStatus>deleteTaskById(@PathVariable Long id)
    {
        try
        {
            Optional<Task_Model> taskObj = taskRepository.findById(id);
            if(taskObj.isPresent())
            {
                //IF TASK IS FOUND WITH ID,THEN RETURN TASK ,HTTPSTATUS-> MOVED PERMANENTLY
                taskRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
            }
            else
            {
                //IF TASK IS NOT FOUND, THEN HTTPSTATUS -> NOTFOUND
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //UPDATING THE TASK
    @PutMapping("tasks/{id}")
    public ResponseEntity<Task_Model>updateTaskById(@PathVariable Long id,@RequestBody Task_Model task_model)
    {
        try
        {
            Optional<Task_Model>TaskObj = taskRepository.findById(id);
            if(TaskObj.isPresent())
            {
                //IF A TASK IS FOUND WITH THE ID, THEN->
                // UPDATING THE TASK,
                //UPDATING THE DESCRIPTION
                //UPDATING THE STATUS TO 'PENDING' OR 'IN_PROGRESS'
                //UPDATING THE SETUPDATED TO THE  CURRENT TIMESTAMP
                //IF THE DATA SENT WITH NO ERRORS->
                //IT WILL SAVE AND UPDATED THE DB WITH HTTPSTATUS OF ACCEPTED
                Task_Model updated_Task = TaskObj.get();
                updated_Task.setTitle(task_model.getTitle());
                updated_Task.setDescription(task_model.getDescription());
                updated_Task.setStatus(task_model.getStatus());
                updated_Task.setUpdated_at(LocalDateTime.now());
                taskRepository.save(updated_Task);
                return new ResponseEntity<>(updated_Task,HttpStatus.ACCEPTED);

            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //MARKING THE TASK AS COMPLETE BY ITS ID
    @PatchMapping("tasks/{id}/complete")
    public ResponseEntity<Task_Model>MarkCompleted(@PathVariable Long id)
    {
        try
        {
            Optional<Task_Model>TaskObj = taskRepository.findById(id);
            if (TaskObj.isPresent())
            {
                //IF THE ID IS FOUND,THEN UPDATE ONLY THE STATUS 0F TASK AS -> COMPLETE
                //AND ALSO UPDATE THE UPDATED_AT TO THE CURRENT TIMESTAMP

                Task_Model updated_task = TaskObj.get();
                updated_task.setStatus(Task_Status.valueOf("COMPLETED"));
                updated_task.setUpdated_at(LocalDateTime.now());
                taskRepository.save(updated_task);
                return new ResponseEntity<>(updated_task,HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
