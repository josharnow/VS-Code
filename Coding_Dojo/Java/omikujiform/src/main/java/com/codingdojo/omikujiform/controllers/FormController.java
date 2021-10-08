package com.codingdojo.omikujiform.controllers;
import javax.servlet.http.HttpSession;

import com.codingdojo.omikujiform.models.Form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {

  @GetMapping("/omikuji")
  public String index(HttpSession session, Model model) {
  // public String index(HttpSession session) {
    // session.setAttribute("count");
  


      return "omikujiForm.jsp";
  }

  // @PostMapping("/omikuji/submit")
  // public String submitForm(HttpSession session, Model model) {
  //   // Integer currentCount = (Integer) session.getAttribute("count");
  //   // session.setAttribute("number", currentCount + 1);
  //   // session.setAttribute("number", 2);

  //   // session.setAttribute("number", value);
  //   // session.setAttribute("person", value);
  //   // session.setAttribute("endeavor", value);
  //   // session.setAttribute("livingThing", value);
  //   // session.setAttribute("textBox", value);



  //   return "redirect:/omikuji/show";
  // }

  @PostMapping("/omikuji/submit")
  public String submitForm(
    HttpSession session,
    @RequestParam(value="number") int number, // *value* argument must match the *name* attribute used in HTML form field
    @RequestParam(value="city") String city, // *value* argument must match the *name* attribute used in HTML form field
    @RequestParam(value="person") String person, // *value* argument must match the *name* attribute used in HTML form field
    @RequestParam(value="endeavor") String endeavor, // *value* argument must match the *name* attribute used in HTML form field
    @RequestParam(value="livingThing") String livingThing, // *value* argument must match the *name* attribute used in HTML form field
    @RequestParam(value="textBox") String textBox) { // *value* argument must match the *name* attribute used in HTML form field


      // CODE TO PROCESS FORM i.e. check number, person, etc
      // ** Put any necessary information in session for later **
      session.setAttribute("number", number);
      session.setAttribute("city", city);
      session.setAttribute("person", person);
      session.setAttribute("endeavor", endeavor);
      session.setAttribute("livingThing", livingThing);
      session.setAttribute("textBox", textBox);

      // model.addAttribute("number", number);
      // model.addAttribute("city", city);
      // model.addAttribute("person", person);
      // model.addAttribute("endeavor", endeavor);
      // model.addAttribute("livingThing", livingThing);
      // model.addAttribute("textBox", textBox);



      return "redirect:/omikuji/show";
  }

  @GetMapping("/omikuji/show")
  public String render(HttpSession session, Model model) {
    // model.addAttribute("number", session.getAttribute("number"));
    // model.addAttribute("city", session.getAttribute("city"));
    // model.addAttribute("person", session.getAttribute("person"));
    // model.addAttribute("endeavor", session.getAttribute("endeavor"));
    // model.addAttribute("livingThing", session.getAttribute("livingThing"));
    // model.addAttribute("textBox", session.getAttribute("textBox"));


    // model.getAttribute("number");
    // model.getAttribute("city");
    // model.getAttribute("person");
    // model.getAttribute("endeavor");
    // model.getAttribute("livingThing");
    // model.getAttribute("textBox");

    // get any info needed out of session and add to the
    // view model to render on the page.

    model.addAttribute("number", session.getAttribute("number"));
    model.addAttribute("city", session.getAttribute("city"));
    model.addAttribute("person", session.getAttribute("person"));
    model.addAttribute("endeavor", session.getAttribute("endeavor"));
    model.addAttribute("livingThing", session.getAttribute("livingThing"));
    model.addAttribute("textBox", session.getAttribute("textBox"));


    // System.out.println(session.getAttribute("number"));
    // System.out.println(session.getAttribute("person"));
    // System.out.println(session.getAttribute("city"));
    // System.out.println(session.getAttribute("endeavor"));
    // System.out.println(session.getAttribute("livingThing"));
    // System.out.println(session.getAttribute("textBox"));

    return "show.jsp";
  }
  
}
