// **********************************************//
// userManage 客户端脚本
// 
//
// @author lenovo
// @date 2020-08-17
// **********************************************//
var vm = new Vue({
    el: '#app',
    mixins: [atyTplMixin],
    data: function () {
        return {
            rs1: [],
            qp: {},
            queryData: [{
                name: '',
                bh: '',
                corp: '',
                bs: '',
            }],
            userList: [],
            formData:{
                name: '',
                bh: '',
            },
            searchData:{
                name:'',
                bh: '',
            },
            query: {
                pageNow: 1,
                pagesize: 10,
            }
        }
    },

    methods: {

        search: function () {
            console.log("search");
            if (this.formData.name == '' && this.formData.bh == '') {
                Artery.message.error("请输入查询条件！");
                return;
            }
            this.$refs.userlbTab.reloadData();
        },
        edit: function (bh) {
            // parent.Artery.open({
            // 	url: 'editUser/addUser?flag=edit&bh='+bh,
            // 	targetType: '_window',
            // 	width: 900,
            // 	height: 580,
            // 	title: '编辑',
            // 	footerHide: true
            // })
        },
        deleteUser: function (bh) {
            var _this = this;
            this.$Modal.confirm({
                title: '提示',
                content: '确认删除' + name + "?",
                onOk: function () {
                    Artery.ajax.post("userManage/deleteUser?bh=" + bh).then(function (value) {
                        if (value == "ok") {
                            Artery.message.info({
                                content: '删除成功',
                                duration: 10,
                                closable: true
                            });
                            _this.$refs.userlbTab.reloadData();
                        }
                    })
                }
            });
        },
        loadData: function (queryInfo) {
            console.log("loadData");
            var _this = this;
            Artery.ajax.post("userManage/getUserList?name="+_this.searchData.name+'&bh='+_this.searchData.bh ,queryInfo).then(function (result) {
                _this.queryData = result;
            })
        },

        add: function () {
            parent.Artery.open({
                url: 'addUser',
                targetType: '_window',
                width: 600,
                hight: 600,
                title: '新增',
                footerHdie: true,
            })

        }

    }
});