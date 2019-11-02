package jbr.springmvc.controller;

import jbr.springmvc.model.Room;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DoeController {


    @Autowired
    UserService userService;


    @RequestMapping(value = "/doe", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("doe");
        mav.addObject("user", new User());

        return mav;
    }

    @RequestMapping(value = "/doeProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("user") User user) {


        String roomno = user.getRoomno();
        List<User> list = userService.getList(roomno);
        //User user = userService.validateUser(login);
        ModelAndView mav = new ModelAndView("display");
        mav.addObject("lists", list);
        return mav;
    }

    @RequestMapping(value = "/doe1")
    public ModelAndView loginProcess1() {


        List<Room> list1 = userService.getList1();

        ModelAndView mav = new ModelAndView("roomdisplay");
        mav.addObject("lists", list1);
        return mav;
    }
    @RequestMapping(value = "/studentinfo")
    public ModelAndView studentinf() {


        List<User> list2 = userService.getStudinfo();

        ModelAndView mav = new ModelAndView("display");
        mav.addObject("lists", list2);
        return mav;
    }

}
