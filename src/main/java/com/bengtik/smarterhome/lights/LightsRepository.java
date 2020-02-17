package com.bengtik.smarterhome.lights;

import com.bengtik.smarterhome.vo.LightEnvironmentVo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LightsRepository extends MongoRepository<LightEnvironmentVo, Long> {

    public Optional<LightEnvironmentVo> findByName(String name);
}
