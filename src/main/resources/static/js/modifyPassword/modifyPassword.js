// **********************************************//
// modifyPassword.html 客户端脚本
// 
//
// @author lenovo
// @date 2020-08-13
// **********************************************//
var vm = new Vue({
    el: '#app',
    mixins: [atyTplMixin],
    data: function () {
        return {
            formData: {
                oldPwd: '',
                newPwd: '',
                newPwdAgain: ''
            }
        }
    },
    methods: {

        dataCancel: function () {
            this.formData.oldPwd = '';
            this.formData.newPwd = '';
            this.formData.newPwdAgain = '';
        },
        dataSubmit:function (tab) {
            if(this.formData.newPwd != this.formData.newPwdAgain){
                Artery.message.error('两次密码输入不一致');
                return;
            }
            this.$refs[tab].submit('modifyPassword/modifyPassword/changePwd').then(function (value) {
                if(value.status==201){
                    parent.Artery.message.info('修改密码成功');
                    parent.Artery.close();
                }else if(value.status==422){
                    Artery.message.error('原密码错误');
                }
            });
        }
    }
});