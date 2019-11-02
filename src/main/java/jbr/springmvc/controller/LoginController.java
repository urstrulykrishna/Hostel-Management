package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

import java.util.List;

@Controller
public class LoginController {

  @Autowired
  UserService userService;


  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    String roomNo = login.getRoomno();
    User user = userService.validateUser(roomNo);

    if (null != user) {
      mav = new ModelAndView("welcome");
      mav.addObject("firstname", user.getFirstname());
      mav.addObject("Lastname", user.getLastname());
      mav.addObject("emailid", user.getEmail());
      mav.addObject("phonenumber", user.getPhone());

    } else {

      mav = new ModelAndView("login");
      mav.addObject("message", "room is empty!!");
    }

    return mav;
  }

  /*
  @ResponseBody
  @RequestMapping(value = "/getroomdetails", method = RequestMethod.GET)
  public String getroomdetails(HttpServletRequest request) throws JsonProcessingException {
    String room = request.getParameter("roomId");
    String name = request.getParameter("name");
    Login login = new Login();
    login.setUsername(name);
    login.setRoomno(room);
//
    ObjectMapper mapper = new ObjectMapper();

    User user = userService.validateUser(login);
    String jsonInString = mapper.writeValueAsString(user);

    return jsonInString;
  }
*/

}
