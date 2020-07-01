package trung.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import trung.codegym.model.SmartPhone;
import trung.codegym.service.PhoneService;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class SmartPhoneController {

    @Autowired
    private PhoneService smartphoneService;

    @GetMapping("/smartphones")
    public ModelAndView getAllSmartphones() {
        ModelAndView mv = new ModelAndView("all-phone");
        List<SmartPhone> allphones = (List<SmartPhone>) smartphoneService.findAll();
        mv.addObject("allphones", allphones);
        mv.addObject("sPhone", new SmartPhone());

        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("new-phone");
        mav.addObject("sPhone", new SmartPhone());
        return mav;
    }

    @RequestMapping(value = "/createNewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartphone(@RequestBody SmartPhone smartphone) {
        return smartphoneService.save(smartphone);
    }

}
