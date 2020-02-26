package com.stonks.SpringComp.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeEnum {
    CLIENT(0),
    VENDOR(1);

    private UserTypeEnum selectedUserType;
    private Integer selectedInt;
    private static Map list = new HashMap();
    static{
        for (UserTypeEnum userType : UserTypeEnum.values()){
            list.put(userType.selectedInt,userType);
        }
    }
    UserTypeEnum(int i) {
        this.selectedInt=i;
    }
    public Integer getSelectedInt() {
        return selectedInt;
    }
    public UserTypeEnum getSelectedUserType(Integer i) {
        return (UserTypeEnum) list.get(i);
    }
}