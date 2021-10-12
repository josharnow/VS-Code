package com.codingdojo.omikujiform.controllers;
//import java.util.ArrayList;

import javax.servlet.http.HttpSession;

//import com.codingdojo.omikujiform.models.Form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class FormController {

  @GetMapping("/")
  public String index() {
    return "redirect:/omikuji";
  }

  @GetMapping("/omikuji")
  public String omikuji() {
    return "omikujiForm.jsp";
  }

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

      return "redirect:/omikuji/show";
  }

  @GetMapping("/omikuji/show")
  public String render(HttpSession session, Model model) {
    // Integer number = (Integer) session.getAttribute("number");
    // String city = (String) session.getAttribute("city");
    // String person = (String) session.getAttribute("person");
    // String endeavor = (String) session.getAttribute("endeavor");
    // String livingThing = (String) session.getAttribute("livingThing");
    // String textBox = (String) session.getAttribute("textBox");

    // Form form = new Form(number, city, person, endeavor, livingThing, textBox); // Form refers to Form.java in models folder

    // Get any info needed out of session and add to the view model to render on the page.

    model.addAttribute("number", session.getAttribute("number"));
    model.addAttribute("city", session.getAttribute("city"));
    model.addAttribute("person", session.getAttribute("person"));
    model.addAttribute("endeavor", session.getAttribute("endeavor"));
    model.addAttribute("livingThing", session.getAttribute("livingThing"));
    model.addAttribute("textBox", session.getAttribute("textBox"));

    // ArrayList<Form> form = new ArrayList<Form>();
    // form.add()


    // model.addAttribute("formFromMyController", form);

    // model.addAttribute("number", form.getNumber());
    // model.addAttribute("city", form.getCity());
    // model.addAttribute("person", form.getPerson());
    // model.addAttribute("endeavor", form.getEndeavor());
    // model.addAttribute("livingThing", form.getLivingThing());
    // model.addAttribute("textBox", form.getTextBox());


    return "show.jsp";
  }
  
	@GetMapping("/createError") // the only time that an error would be printed out is immediately following visiting /createError. This allows us to pass temporary data through our application to notify users across new request/response cycles.
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "A test error!");
		return "redirect:/";
	}
  
}
