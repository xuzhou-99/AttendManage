package com.thunisoft.ygkq.ygkq.common;


import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ryzh {
    /**
     * id主键
     */
    @Column(name = "C_ID")
    public String id;
    /**
     * 工号
     */
    @Column(name = "C_BH")
    private String bh;

    /**
     * 有效，代码：0无效、1有效
     */
    @Column(name = "N_YX")
    private String yx;

    /**
     * 部门，代码：corp
     */
    @Column(name = "C_BM")
    private String corp;

    /**
     * 显示顺序，用于排序展示
     */
    @Column(name = "N_XSSX")
    private String xssx;

    /**
     * 姓名
     */
    @Column(name = "C_XM")
    private String name;

    /**
     * 标识
     */
    @Column(name = "C_BS")
    private String bs;

    /**
     * 密码
     */
    @Column(name = "C_MM")
    private String password;

}
