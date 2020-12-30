package com.ankit.covidtracker.controller;

import com.ankit.covidtracker.CovidDataServices;
import com.ankit.covidtracker.models.InputStats;
import com.ankit.covidtracker.models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller //access when load home controller url -- To render in html UI
public class HomeController {
    private String searchBox;
    @Autowired
    CovidDataServices covidDataServices;

    @GetMapping("/")// back slash which is root url
    public String home(Model model)
    {
        List<LocationStats> ls=covidDataServices.getAllstats();
        int totalCases=ls.stream().mapToInt(stat->stat.getLatestDateCase()).sum();

        int totalNewCases=ls.stream().mapToInt(stat->stat.getDiffOfCase()).sum();



        System.out.println(totalNewCases);

        model.addAttribute("locationStats",ls);
        model.addAttribute("totalReportedCase",totalCases);
        model.addAttribute("totalNewReportedCase",totalNewCases);
        model.addAttribute("searchboxcountry", searchBox);

        System.out.println("ls Value "+ls.get(145));

        // SEARCH BOX RESULT

        for(int i=0;i<ls.size();i++)
        {
            if((ls.get(i)).equals(searchBox))
            {

                model.addAttribute("countrybox",ls.get(i));
                model.addAttribute("countrybox",ls.get(i));

                model.addAttribute("countrybox",ls.get(i));


            }
        }

        //  key        Value
        return "home.html"; // return UI page eg. index.html, here its home.html
    }

    @RequestMapping(value = "/page2")
    public ModelAndView save(@ModelAttribute InputStats user)
    {
        System.out.println("User from UI = " + user);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("searchBox");
        modelAndView.addObject("searchCountrybox", user);

        List<LocationStats> ls=covidDataServices.getAllstats();
        int totalCases=ls.stream().mapToInt(stat->stat.getLatestDateCase()).sum();
        int totalNewCases=ls.stream().mapToInt(stat->stat.getDiffOfCase()).sum();

        searchBox=user.getSearchCountry();
        modelAndView.addObject("locationStats", ls);

        modelAndView.addObject("totalReportedCase",totalCases);
        modelAndView.addObject("totalNewReportedCase",totalNewCases);
        modelAndView.addObject("searchboxcountry", searchBox);

        return modelAndView;
    }



}
