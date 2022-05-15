package edu.miu.cs.badgeandmembershipcontrol.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseTypeMapper {

    static public Map ResponseType(List<?> t){
        Map map = new HashMap();
        map.put("count",t.size());
        map.put("data",t);
        return map;
    }
}
