package com.dszy.visualconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dszy.visualconfig.entity.*;
import com.dszy.visualconfig.repo.club.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private DictFormalRepo dictFormalRepo;

    @Autowired
    private DictGameDbRepo dictGameDbRepo;

    @Autowired
    private DictGameRepo dictGameRepo;

    @Autowired
    private DictGoodPriceRepo dictGoodPriceRepo;

    @Autowired
    private DictKeyCfgRepo dictKeyCfgRepo;

    @Autowired
    private DictLevelupRepo dictLevelupRepo;

    @Autowired
    private DictShareRepo dictShareRepo;

    @GetMapping("/club")
    public String getConfig(Integer productId){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("isEnable", "type");
        DictFormalEntity dictFormalEntity = new DictFormalEntity();
        dictFormalEntity.setGameId(productId);
        List<DictFormalEntity> dictFormalEntities = dictFormalRepo.findAll(Example.of(dictFormalEntity, matcher));

        DictGameDbEntity dictGameDbEntity = new DictGameDbEntity();
        dictGameDbEntity.setGameId(productId);
        List<DictGameDbEntity> dictGameDbEntities = dictGameDbRepo.findAll(Example.of(dictGameDbEntity, matcher));

        DictGameEntity dictGameEntity = new DictGameEntity();
        dictGameEntity.setGameId(productId);
        List<DictGameEntity> dictGameEntities = dictGameRepo.findAll(Example.of(dictGameEntity, matcher));

        DictGoodPriceEntity dictGoodPriceEntity = new DictGoodPriceEntity();
        dictGoodPriceEntity.setGameId(productId);
        List<DictGoodPriceEntity> dictGoodPriceEntities = dictGoodPriceRepo.findAll(Example.of(dictGoodPriceEntity, matcher));

        DictKeyCfgEntity dictKeyCfgEntity = new DictKeyCfgEntity();
        dictKeyCfgEntity.setGameId(productId);
        List<DictKeyCfgEntity> dictKeyCfgEntities = dictKeyCfgRepo.findAll(Example.of(dictKeyCfgEntity, matcher));

        DictLevelupEntity dictLevelupEntity = new DictLevelupEntity();
        dictLevelupEntity.setGameId(productId);
        List<DictLevelupEntity> dictLevelupEntities = dictLevelupRepo.findAll(Example.of(dictLevelupEntity, matcher));

        DictShareEntity dictShareEntity = new DictShareEntity();
        dictShareEntity.setGameId(productId);
        List<DictShareEntity> dictShareEntities = dictShareRepo.findAll(Example.of(dictShareEntity, matcher));

        JSONObject result = new JSONObject();
        result.put("dictFormals", JSON.toJSON(dictFormalEntities));
        result.put("dictGameDbs", JSON.toJSON(dictGameDbEntities));
        result.put("dictGames", JSON.toJSON(dictGameEntities));
        result.put("dictGoodPrices", JSON.toJSON(dictGoodPriceEntities));
        result.put("dictKeyCfgs", JSON.toJSON(dictKeyCfgEntities));
        result.put("dictLevelups", JSON.toJSON(dictLevelupEntities));
        result.put("dictShares", JSON.toJSON(dictShareEntities));
        return result.toString();
    }
}
