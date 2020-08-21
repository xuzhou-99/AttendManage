// **********************************************//
// kqxx 客户端脚本
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
			formData:{
				name: '',
				bh: '',
				status: '',
				startTime: '',
				endTime: '',
			},
		}
	},
	methods: {
		cancel:function () {
			this.formData.name = '';
			this.formData.bh = '';
			this.formData.status = '';
			this.formData.startTime = '';
			this.formData.endTime = '';
		}
	}
});