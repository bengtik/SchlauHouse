package com.bengtik.smarterhome.hue;

import com.bengtik.smarterhome.PhilipsLightVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class HueService {

    private HueConnector hueConnector;

    @Autowired
    public HueService(HueConnector hueConnector) {
        this.hueConnector = hueConnector;
    }

    public void pushToHub(PhilipsLightVo lightVo) {
        hueConnector.putStateToLight(lightVo);
    }

    public void pushToHub(List<PhilipsLightVo> lightVos) {
        lightVos.forEach(hueConnector::putStateToLight);
    }

    public void pushContinuousToHub(int count, List<PhilipsLightVo> philipsLightVoList) {
        for (int i = 0; i < count; i++) {
            philipsLightVoList.forEach(lightVo -> {
                pushToHub(lightVo);
                try {
                    Thread.sleep(lightVo.getTransitionLength() * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("sent to hub {}", lightVo);
            });

        }
    }
}
