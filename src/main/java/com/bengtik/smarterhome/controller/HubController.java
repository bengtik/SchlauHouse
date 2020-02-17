package com.bengtik.smarterhome.controller;

import com.bengtik.smarterhome.vo.LightEnvironmentVo;
import com.bengtik.smarterhome.vo.PhilipsLightVo;
import com.bengtik.smarterhome.hue.HueService;
import com.bengtik.smarterhome.lights.LightEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HubController {

    private HueService hueService;
    private LightEnvironmentService environmentService;

    @Autowired
    public HubController(HueService hueService, LightEnvironmentService environmentService) {
        this.hueService = hueService;
        this.environmentService = environmentService;
    }

    @PutMapping("/light")
    public void pushToHub(@RequestBody PhilipsLightVo lightVo) {
        hueService.pushToHub(lightVo);
    }

    @PutMapping("/lights")
    public void pushToHub(@RequestBody List<PhilipsLightVo> lightVos){
        hueService.pushToHub(lightVos);
    }

    @PutMapping("/continuous")
    public void pushContinuously(@RequestParam("count")int count, @RequestBody List<PhilipsLightVo> lightVos){
        hueService.pushContinuouslyToHub(count, lightVos);
    }

    @PutMapping("/environment/{name}")
    public void pushEnvironment(@PathVariable("name") String name){
        environmentService.pushLightEnvironment(name);
    }

    @PostMapping("/environment")
    public void saveNewEnvironment(@RequestBody LightEnvironmentVo environmentVo){
        environmentService.storeLightEnvironment(environmentVo);
    }
}
