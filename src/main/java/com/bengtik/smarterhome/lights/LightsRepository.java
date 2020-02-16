package com.bengtik.smarterhome.lights;

import com.bengtik.smarterhome.LightEnvironmentVo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightsRepository extends MongoRepository<LightEnvironmentVo, Long> {

    public LightEnvironmentVo findById(long id);

    public LightEnvironmentVo findByName(String name);
}
