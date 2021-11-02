package pl.coderslab.springhibernatemodul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernatemodul6.entity.Person;
import pl.coderslab.springhibernatemodul6.entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Skill1", "Skill2", "Skill3", "Skill4", "Skill5");
    }


    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Polska", "Niemcy", "Anglia");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Sport", "Music", "Cooking", "Movies", "Wyscigi zolwi");
    }



    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "student/studentForm";
    }

    @PostMapping("/form")
    @ResponseBody
    public String saveForm(@ModelAttribute("student") Student testStudent){

        return testStudent.toString();
    }





}
