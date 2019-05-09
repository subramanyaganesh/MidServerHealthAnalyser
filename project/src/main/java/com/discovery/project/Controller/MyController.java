package com.discovery.project.Controller;

import com.discovery.project.Model.MongoModel;
import com.discovery.project.Repository.MongoRepo;
import com.discovery.project.Service.HttpsService;
import com.discovery.project.Service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*")//so that this program can be accessed by other apis and not only browser
@RestController

public class MyController {
    @Autowired
    MongoService mongoService;
    @Autowired
    HttpsService httpsService;

    @RequestMapping(value = "/config", method = GET)
    public Object getdetails() {
        return mongoService.getAll();
    }

    @RequestMapping(value = "/config", method = POST)
    public Object createdata(@RequestBody MongoModel model) {
        return mongoService.create(model);
    }

    @RequestMapping(value = "/config/{key}", method = PUT)
    public Object alteringdata(@RequestBody MongoModel mongoModel, @PathVariable String key) {
        return mongoService.Alter(key, mongoModel);
    }

    @RequestMapping(value = "/config/{key}", method = DELETE)
    public void Deletingdata(@PathVariable(name = "key") String id) {
        mongoService.delete(id);
    }

    @RequestMapping(value = "/check", method = GET, produces = "application/json")
    public ResponseEntity HealthCheck() {
        return new ResponseEntity(httpsService.Healthcheck(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/instance-health", method = GET, produces = "application/json")
    public ResponseEntity getInstanceHealth() {
        return new ResponseEntity(httpsService.getInstanceHealth(), HttpStatus.ACCEPTED);
    }

//    @RequestMapping(value = "/instance/plugin", method = GET, produces = "application/json")
//    public ResponseEntity getInstancePlugin() {
//        return new ResponseEntity(httpsService.getInstancePlugin(), HttpStatus.ACCEPTED);
//    }
}

