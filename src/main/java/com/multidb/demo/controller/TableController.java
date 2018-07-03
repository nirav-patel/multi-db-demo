package com.multidb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.multidb.demo.dto.TableDto;
import com.multidb.demo.service.TableService;

@Controller
public class TableController {

	@Autowired
	private TableService tableService;

	@RequestMapping(value = "/newtable", method = RequestMethod.GET)
	public ModelAndView newTableForm(String dbName) {
		ModelAndView model = new ModelAndView("TableForm");
		TableDto table = new TableDto();
		table.setDbName(dbName);
		model.addObject("tableDto", table);
		return model;
	}

	@RequestMapping(value = "/savetable", method = RequestMethod.POST)
	public ModelAndView createDatabase(@ModelAttribute TableDto tableDto) {
		tableService.createTable(tableDto);
		return new ModelAndView("redirect:/");
	}

}