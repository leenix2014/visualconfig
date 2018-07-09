package com.dszy.visualconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dszy.visualconfig.entity.SadDatabasesConfEntity;
import com.dszy.visualconfig.entity.SadGameEntity;
import com.dszy.visualconfig.repo.php.SadDatabasesConfRepo;
import com.dszy.visualconfig.repo.php.SadGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PHPController {

    @Autowired
    private SadDatabasesConfRepo sadDatabasesConfRepo;

    @Autowired
    private SadGameRepo sadGameRepo;

    @GetMapping("php")
    public String getConfig(Integer productId){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("dbType", "isMaster", "gameStatus");
        SadDatabasesConfEntity sadDatabasesConfEntity = new SadDatabasesConfEntity();
        sadDatabasesConfEntity.setGameId(productId);
        List<SadDatabasesConfEntity> sadDatabasesConfEntities = sadDatabasesConfRepo.findAll(Example.of(sadDatabasesConfEntity, matcher));

        SadGameEntity sadGameEntity = new SadGameEntity();
        sadGameEntity.setGameId(productId);
        List<SadGameEntity> sadGameEntities = sadGameRepo.findAll(Example.of(sadGameEntity, matcher));

        JSONObject result = new JSONObject();
        result.put("sadDatabases", JSON.toJSON(sadDatabasesConfEntities));
        result.put("sadGames", JSON.toJSON(sadGameEntities));
        return result.toString();
    }
}
