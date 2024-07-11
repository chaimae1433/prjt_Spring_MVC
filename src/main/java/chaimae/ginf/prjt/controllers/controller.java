package chaimae.ginf.prjt.controllers;

import chaimae.ginf.prjt.model.Eleve;
import chaimae.ginf.prjt.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller {
@Autowired
    EleveService studentService;
    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.listAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Eleve student = new Eleve();
        model.addAttribute("student", student);
        return "ajouteeleve";

    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Eleve student,String fl) {
        studentService.registerStudent(student,fl);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable String id, Model model) {
        model.addAttribute("student", studentService.listByCne(id));
        return "editstudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable String id,
                                @ModelAttribute("student") Eleve student,
                                Model model) {

        // get student from database by id
        Eleve existingStudent = studentService.listByCne(id);
        existingStudent.setCne(id);
        existingStudent.setPrenom(student.getPrenom());
        existingStudent.setNom(student.getNom());
        //existingStudent.(student.getEmail());

        // save updated student object
        studentService.update(existingStudent);
        return "redirect:/students";
    }

    // handler method to handle delete student request

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
