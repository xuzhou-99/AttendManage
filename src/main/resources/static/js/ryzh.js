// **********************************************//
// ryzh 客户端脚本
// 
//
// @author lenovo
// @date 2020-08-17
// **********************************************//
var vm = new Vue({
	el: '#app',
	mixins: [atyTplMixin],
	data: function() {
		return {
			userInfo:{
				name: '',
				corp: '',
				team: '',
				bh: '',
				job: '',
				workTime: '',
			}
		}
	},
	created:function(){
		// var _this = this;
		// Artery.ajax.post("ryzh/getUserInfo").then(function (result){
		// 	_this.userInfo.name = result.name;
		// 	_this.userInfo.corp = result.corp;
		// 	_this.userInfo.id = result.bh;
		//
		// })
	},
	methods: {
	},
});