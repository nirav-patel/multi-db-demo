package com.multidb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.multidb.demo.dto.DatabaseDto;
import com.multidb.demo.service.DatabaseService;

@Controller
public class DatabaseController {

	@Autowired
	private DatabaseService databaseService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		List<DatabaseDto> listDatabases = databaseService.fetchAllDatabases();
		ModelAndView model = new ModelAndView("index");
		model.addObject("databaseList", listDatabases);
		return model;
	}
	
	@RequestMapping(value = "/newdb", method = RequestMethod.GET)
	public ModelAndView newDatabaseForm() {
		ModelAndView model = new ModelAndView("DBCreateForm");
		model.addObject("databaseDto", new DatabaseDto());
		return model;
	}

	@RequestMapping(value = "/savedb", method = RequestMethod.POST)
	public ModelAndView createDatabase(@ModelAttribute DatabaseDto databaseDto) {
		databaseService.createDatabase(databaseDto);
		return new ModelAndView("redirect:/");
	}

}