

layui.define(['jquery','element','laytpl','carousel','laypage'],function(exports){
	var $ = layui.$,laytpl = layui.laytpl,element = layui.element,laypage = layui.laypage,carousel = layui.carousel;
	var _mm = {
		request : function(param){
			var _this = this;
			$.ajax({
				type   		: param.method || 'get',
				url    		: param.url    || '',
				dataType 	: param.type || 'json',
				data 		: param.data || '',
				success 	: function(res){

	                if(0 === res.status){
	                    typeof param.success === 'function' && param.success(res, res.msg);
	                }

	                else if(1 === res.status){
	                    typeof param.error === 'function' && param.error(res.msg);
	                }
				},
				error       : function(err){
					 typeof param.error === 'function' && param.error(err.statusText);	
				}
			});
		},
		renderHtml : function(htmlTemplate, data){
	        var template    = laytpl(htmlTemplate),
	            result      = template.render(data);
	        return result;
	    }
	}
  exports('mm',_mm)
});