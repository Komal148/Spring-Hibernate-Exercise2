package com.stackroute.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.hibernate.dao.TrackDAO;
import com.stackroute.hibernate.model.Track;

@Controller
@RequestMapping("/")
public class TrackController {

	@Autowired
	private TrackDAO trackDao;

	private Track track = new Track();

	@GetMapping
	public String indexPage(ModelMap model) {
		return "index";
	}

	@GetMapping("populate")
	public String addTrack(@RequestParam("userName") String username,@RequestParam("password") String password, ModelMap model) {
			track.setName(username);
			track.setPassword(password);
			boolean status = trackDao.saveTrack(track);
			if (status) {
				model.addAttribute("greeting1", trackDao.getTrackById(track.getId()));
				return "update";
			} else {
				return "index";
			}

		}
}