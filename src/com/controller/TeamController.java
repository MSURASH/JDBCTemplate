package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Team;
import com.dao.JdbcDaoImpl;

@RequestMapping("team")
@RestController
public class TeamController {

	@Autowired
	JdbcDaoImpl jdbcDaoImpl;
	
	@GetMapping("/all")
	public List<Team> getAllTeam() {

		System.out.println("select all method");

		return jdbcDaoImpl.getTeamList();

		
	}
}
