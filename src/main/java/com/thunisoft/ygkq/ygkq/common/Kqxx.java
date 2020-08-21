package com.thunisoft.ygkq.ygkq.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Kqxx {

    /**
     * 编号
     */
    @Column(name = "C_BH")
    private String bh;

    /**
     * 人员编号，对应于人员表中的人员的主键（C_BH）
     */
    @Column(name = "C_BH_RYZH")
    private String bhRyzh;

    /**
     * 上班时间
     */
    @Column(name = "DT_SBSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sbsj;

    /**
     * 下班时间
     */
    @Column(name = "DT_XBSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime xbsj;

    /**
     * 考勤状态，代码：正常、迟到、早退
     */
    @Column(name = "N_KQZT")
    private BigDecimal kqzt;

    /**
     * 备注
     */
    @Column(name = "C_BZ")
    private String bz;
}
