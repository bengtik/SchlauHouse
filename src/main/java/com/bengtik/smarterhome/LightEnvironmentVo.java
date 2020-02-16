package com.bengtik.smarterhome;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class LightEnvironmentVo {

    @Id
    private long id;
    private String name;
    private List<PhilipsLightVo> lightVos;
}
