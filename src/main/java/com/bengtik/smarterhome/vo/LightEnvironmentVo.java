package com.bengtik.smarterhome.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class LightEnvironmentVo {

    @Id
    private String name;

    private List<PhilipsLightVo> lightVos;
}
