package com.bengtik.smarterhome.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhilipsLightVo {

    @JsonProperty("id")
    Integer lightId;

    @JsonProperty("on")
    Boolean isOn;

    @JsonProperty("bri")
    Integer brightness;

    @JsonProperty("ct")
    Integer colorTemperature;

    @JsonProperty("transitiontime")
    Integer transitionLength;

}
