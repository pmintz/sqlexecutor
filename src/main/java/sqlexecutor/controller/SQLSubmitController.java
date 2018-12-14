package sqlexecutor.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import sqlexecutor.model.TextArea;
import sqlexecutor.model.TextAreaDAO;
import static sqlexecutor.service.SQLService.submitToDatabase;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@Controller
@ControllerAdvice
public class SQLSubmitController /*extends SimpleFormController*/ {
	
/*	public SQLSubmitController(){
		setCommandClass(TextArea.class);
		setCommandName("textAreaForm");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {

		TextArea ta = (TextArea)command;
		return new ModelAndView("Success","ta",ta);
	
	}*/
	
	
	@RequestMapping(value="/submit", method = RequestMethod.POST)
	ModelAndView SQLSubmitMethod(@ModelAttribute("TextArea") TextArea textArea, 
			BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
        	System.out.println(result.toString());
        }
        
        String name = textArea.getTextArea();
        ModelAndView modelAndView = new ModelAndView("result.jsp");
        modelAndView.addObject("name_in_welcome_page", name);
        
        String databaseResult = submitToDatabase(textArea.getTextArea());
        
        
        return modelAndView;
				
	}
	
	@RequestMapping("/")
	RedirectView Login() {
		return new RedirectView("view");
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView View(HttpServletRequest request) throws IOException {

	   ModelAndView modelAndView = new ModelAndView("submit.jsp");
	   TextArea textArea = new TextArea();
	   modelAndView.addObject("TextArea", textArea);
	   return modelAndView;
	}

	
}
	



