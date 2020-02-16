package com.bengtik.smarterhome.lights;

import com.bengtik.smarterhome.LightEnvironmentVo;
import com.bengtik.smarterhome.hue.HueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LightEnvironmentService {

    private LightsRepository lightsRepository;
    private HueService hueService;

    @Autowired
    public LightEnvironmentService(LightsRepository lightsRepository, HueService hueService) {
        this.lightsRepository = lightsRepository;
        this.hueService = hueService;
    }

    public void storeLightEnvironment(LightEnvironmentVo environment) {
        lightsRepository.save(environment);
    }

    public void pushLightEnvironment(String name){
        hueService.pushToHub(getEnvironmentByName(name).getLightVos());
    }


    LightEnvironmentVo getEnvironmentById(long id) {
        return lightsRepository.findById(id);
    }

    LightEnvironmentVo getEnvironmentByName(String name) {
        return lightsRepository.findByName(name);
    }

}
