-- auto create by SMD

set client_encoding = UTF8;
set search_path to ;
commit;

-------------------------
-- 人员帐号信息表
-------------------------

drop table if exists T_RYZH;
create table T_RYZH
(
    C_BH                  varchar(32)                          NULL,        -- 主键
    N_YX                  numeric(, 0)                         NULL,        -- 有效
    C_BM                  varchar(300)                         NULL,        -- 部门
    N_XSSX                numeric(, 0)                         NULL,        -- 显示顺序
    C_XM                  varchar(300)                         NULL,        -- 姓名
    C_BS                  varchar(300)                         NULL,        -- 标识
    C_MM                  varchar(300)                         NULL         -- 密码
);

 commit; 

set client_encoding = UTF8;
set search_path to ;
commit;

-------------------------
-- 人员考勤信息表
-------------------------

drop table if exists T_KQXX;
create table T_KQXX
(
    C_BH                  varchar(32)                          NULL,        -- 编号
    C_BH_RYZH             varchar(32)                          NULL,        -- 人员编号
    DT_SBSJ               timestamp(3)                         NULL,        -- 上班时间
    DT_XBSJ               timestamp(3)                         NULL,        -- 下班时间
    N_KQZT                numeric(5, 0)                        NULL,        -- 考勤状态
    C_BZ                  varchar(300)                         NULL         -- 备注
);

 commit; 

