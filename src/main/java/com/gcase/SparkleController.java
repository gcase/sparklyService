package com.gcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class SparkleController {

    @Autowired
    SparkleService sparkleService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/sparkles/{user}", method = RequestMethod.POST)
    public SparkleSummary addSparkle(
      @PathVariable("user") String user,
      @RequestParam(value="reason", required=false) String reason) {
        Optional<String> reasonOpt = Optional.ofNullable(reason);
        return sparkleService.addSparkle(user, reasonOpt);
    }

    @RequestMapping(value = "/sparkles/{user}", method = RequestMethod.DELETE)
    public SparkleSummary removeSparkle(
      @PathVariable("user") String user,
      @RequestParam(value="reason", required=false) String reason) {
        Optional<String> reasonOpt = Optional.ofNullable(reason);
        return sparkleService.removeSparkle(user, reasonOpt);
    }

    @RequestMapping(value = "/sparkles/{user}", method = RequestMethod.GET)
    public SparkleSummary getSparkles(@PathVariable("user") String user) {
        return sparkleService.getSparkleSummary(user);
    }


}
