package com.thunisoft.ygkq.ygkq.common;

public interface ModifyPasswordConsts {
    /**加密密钥*/
    String SECURITY_CODE = "";

    /**旧密码标识*/
    String OLD_PASSWORD = "oldPwd";

    /**新密码标识*/
    String NEW_PASSWORD = "newPwd";

    /**用户ID标识*/
    String USER_ID = "userId";

    /**TAP接口部分地址*/
    String URL_PART = "users/changepassword/";

    /**新增账号接口地址*/
    String ADD_USER = "users/";

    /**账户有效*/
    int nValid=1;

    /**新增账号用户名标志*/
    String USER_NAME = "name";

    /**新增账号登录ID*/
    String LOGIN_ID = "loginId";

    /**是否有效/
    String NVALID = "nValid";

    /**新增账号单位ID*/
    String CORP_ID = "corpId";

    /**新增账号部门ID*/
    String DEPT_ID = "deptId";

}
