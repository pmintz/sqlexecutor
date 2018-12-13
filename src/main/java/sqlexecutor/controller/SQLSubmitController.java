package sqlexecutor.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import sqlexecutor.model.TextArea;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	String SQLSubmitMethod(@ModelAttribute("TextArea") TextArea textArea, 
			BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("textArea", textArea.getTextArea());
        
		System.out.println(textArea);
		return "result.jsp";		
	}
	
	@RequestMapping("/")
	String Login() {
		return "submit.jsp";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView View(HttpServletRequest request) throws IOException {

	   ModelAndView modelAndView = new ModelAndView("submit");
	   TextArea textArea = new TextArea();
	   modelAndView.addObject("TextArea", textArea);
	   return modelAndView;
	}

	
}
	



