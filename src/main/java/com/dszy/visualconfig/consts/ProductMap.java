package com.dszy.visualconfig.consts;

import java.util.*;

public class ProductMap {

    //Map<productId, actRewardIds>
    private static Map<Integer, List<Long>> actRewardMap = new HashMap<>();

    //Map<productId, activityId>
    private static Map<Integer, Integer> activityMap = new HashMap<>();

    static {
        actRewardMap.put(5538, Arrays.asList(20101L, 20102L, 20103L));
        actRewardMap.put(5539, Arrays.asList(20104L, 20105L, 20106L));
        actRewardMap.put(5537, Arrays.asList(20107L, 20108L, 20109L));
        actRewardMap.put(4444, Arrays.asList(20110L, 20111L, 20112L));
        actRewardMap.put(4514, Arrays.asList(20113L, 20114L, 20115L));
        actRewardMap.put(4156, Arrays.asList(20116L, 20117L, 20118L));
        actRewardMap.put(3422, Arrays.asList(20119L, 20120L, 20121L));
        actRewardMap.put(5113, Arrays.asList(20122L, 20123L, 20124L));
        actRewardMap.put(3425, Arrays.asList(20125L, 20126L, 20127L));
        actRewardMap.put(5541, Arrays.asList(20128L, 20129L, 20130L));

        activityMap.put(5538, 101);
        activityMap.put(5539, 102);
        activityMap.put(5537, 103);
        activityMap.put(4444, 104);
        activityMap.put(4514, 105);
        activityMap.put(4156, 106);
        activityMap.put(3422, 107);
        activityMap.put(5113, 108);
        activityMap.put(3425, 109);
        activityMap.put(5541, 110);

    }

    public static List<Long> getActRewardIds(Integer productId){
        List<Long> actRewardIds = actRewardMap.get(productId);
        if(actRewardIds == null){
            return Collections.EMPTY_LIST;
        }
        return actRewardIds;
    }

    public static Integer getActivityId(Integer productId){
        Integer activityId = activityMap.get(productId);
        if(activityId == null){
            return 0;
        }
        return activityId;
    }
}
