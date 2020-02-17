package com.bengtik.smarterhome.hue;


import com.bengtik.smarterhome.vo.PhilipsLightVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HueConnector {

    private HueConfiguration hueConfiguration;
    private RestTemplate restTemplate;

    @Autowired
    public HueConnector(HueConfiguration configuration) {
        this.hueConfiguration = configuration;
        this.restTemplate = new RestTemplate();
    }

    public void putStateToLight(PhilipsLightVo lightVo) {
        String url = hueConfiguration.getBaseUrl() + "/" + hueConfiguration.getUserName() + "/lights/" + lightVo.getLightId() + "/state";
        log.info("url: {}", url);
        log.debug("payload: {}", lightVo);

        restTemplate.put(url, lightVo);
    }
}
