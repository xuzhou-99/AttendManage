// **********************************************//
// ygkq 客户端脚本
// 员工考勤
//
// @author lenovo
// @date 2020-08-17
// **********************************************//
var vm = new Vue({
	el: '#app',
	mixins: [atyTplMixin],
	data: function() {
		return {
			userInfo: {
				name: '',
			},
			formData: {
				code: '',
			},
			src: '',
			code: '',
		}
	},
	created:function(){
		// var _this = this;
		// Artery.ajax.post("ryzh/getUserInfo").then(function (value) {
		// 	_this.userInfo.name = value;
		// }).catch(function (reason) {
		//
		// });


	},
	methods: {
		changePwd:function () {
			Artery.open({
				url: 'modifyPassword/modifyPassword',
				targetType: '_window',
				width: 500,
				height: 220,
				title: '修改密码',
				footerHide: true
			})
		},
		logout:function () {
			var url =  window.location.href;
			var logoutUrl =  url.split("ygkq")[0]+ "/logout";
			console.log(logoutUrl);
			window.open(logoutUrl,'_self');
		},
		select: function (code) {
			this.code = code;
		},

	},

});