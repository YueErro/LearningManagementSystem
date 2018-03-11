/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yue.lms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yue.lms.entity.Task;
import yue.lms.repository.TaskRepository;

/**
 *
 * @author Yue
 */
@Controller
public class AllController {
    
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Yue");
        return "hello";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tasks")
    public String taskList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Task> tasks = taskRepository.findByUsername(auth.getName());
        for( int t = 0; t < tasks.size(); t++ )
        {
            tasks.get(t).setDatefrom( tasks.get(t).getDatefrom().replace('-', '/') );
            tasks.get(t).setDateto( tasks.get(t).getDateto().replace('-', '/') );
        }
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
    
    @GetMapping("/add")
    public String add(Task task) {
        return "add";
    } 
    
    @PostMapping("/add")
    public String addTask( @Valid Task task, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws ParseException 
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();                
        task.setUusername(auth.getName());
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date df = format.parse(task.getDatefrom());
        Date dt = format.parse(task.getDateto());
        
        if (df.compareTo(dt) > 0) 
        {
            return "add";
        }
        
        taskRepository.save(task);
        return "redirect:/tasks";
    }
    
    long id;
    @GetMapping("/edit")
    public String edit(Task t, Model model) {
        id = t.getId();
        Task task = taskRepository.findTask(id);
        model.addAttribute("task",task);
        return "edit";
    } 
    
    @PostMapping("/edit")
    public String editTask( @Valid Task task, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws ParseException 
    {
        String name = task.getName();
        String desc = task.getDescription();
        String from = task.getDatefrom();
        String to = task.getDateto();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date df = format.parse(from);
        Date dt = format.parse(to);
        
        if (df.compareTo(dt) > 0) 
        {
            return "edit";
        }
        
        taskRepository.edit(name, desc, from, to, id);
        return "redirect:/tasks";
    }
    
    @PostMapping("/delete")
     public String deleteTask(Task t) 
    {   
        taskRepository.findById(t.getId());
        return "redirect:/tasks";
    }
}

