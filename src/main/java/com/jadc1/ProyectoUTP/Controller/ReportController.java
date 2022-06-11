package com.jadc1.ProyectoUTP.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jadc1.ProyectoUTP.Form.ReportForm;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


@Controller
@RequestMapping("/reporte")
public class ReportController {
	
	@ModelAttribute("/formatos")
	public ArrayList getFormatos() {
		ArrayList<String> formatos = new ArrayList<String>();
		formatos.add("Html");
		formatos.add("PDF");

		return formatos;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadSurveyPg(@ModelAttribute("reportForm") ReportForm reportForm, Model model){
		model.addAttribute("reportForm", reportForm);
		return "Report/report";
	}
	
	@RequestMapping(value = "/generarReporte", method = RequestMethod.POST)
	public String generarReporte(@RequestParam("prueba") String prueba, Map<String, Object> model) {
		
		System.out.print(prueba);
		return null;

	}

}
