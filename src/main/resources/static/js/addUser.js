// **********************************************//
// userManage 客户端脚本
// 
//
// @author lenovo
// @date 2020-08-18
// **********************************************//
var vm = new Vue({
	el: '#app',
	mixins: [atyTplMixin],
	data: function() {
		return {
			formData:{
				name: '',
				bh: '',
				corp: '',
				bs: '',
				password: '123',
			},
		}
	},
	methods: {
		addUser:function (form) {
			//this.formData.bh = Artery.uuid().replace(/-/g,'');
			if(this.formData.name == '' ||this.formData.bh == ''){
				Artery.message.error("请输入员工信息");
				return;
			}

			this.$refs[form].submit("userManage/addUser").then(function (value) {
				Artery.message.success("添加成功")
				parent.Artery.close();
			})
		},
	}
});