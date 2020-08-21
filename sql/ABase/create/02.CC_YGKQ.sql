-- auto create by SMD

set client_encoding = UTF8;
set search_path to ;
commit;

comment on table  T_RYZH                                  is '人员帐号信息表';
comment on column T_RYZH.C_BH                             is '主键';
comment on column T_RYZH.N_YX                             is '有效';
comment on column T_RYZH.C_BM                             is '部门';
comment on column T_RYZH.N_XSSX                             is '显示顺序';
comment on column T_RYZH.C_XM                             is '姓名';
comment on column T_RYZH.C_BS                             is '标识';
comment on column T_RYZH.C_MM                             is '密码';

set client_encoding = UTF8;
set search_path to ;
commit;

comment on table  T_KQXX                                  is '人员考勤信息表';
comment on column T_KQXX.C_BH                             is '编号';
comment on column T_KQXX.C_BH_RYZH                             is '人员编号';
comment on column T_KQXX.DT_SBSJ                             is '上班时间';
comment on column T_KQXX.DT_XBSJ                             is '下班时间';
comment on column T_KQXX.N_KQZT                             is '考勤状态';
comment on column T_KQXX.C_BZ                             is '备注';

