package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class DeleteController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("user", new User());

        return mav;
    }

    @RequestMapping(value = "/deleteProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("user") User user) {
        ModelAndView mav = null;

        userService.delete(user);
        mav = new ModelAndView("delete");
        mav.addObject("message2", "vacated");
        return mav;
    }

}
