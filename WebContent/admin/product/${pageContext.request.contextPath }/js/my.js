//使用ajax加载类别下拉选
	//参数1：将下拉选放入的标签id
	//生成下拉选时候，select标签的name属性
	//参数3：需要回显时候,选中哪个option
	function loadSelect(positionId,selectname,selectedId){
		//1 创建select对象,将name属性指定
		var $select =  $("<select name="+selectname+" ></select>");
		//2 添加提示选项
		$select.append($("<option value='' >---请选择---</option>"));
		//3 使用jquery 的ajax 方法,访问后台Action
		$.post("${pageContext.request.contextPath}/CategoryAction_list",
		  function(data){
		   		//遍历
		//4 返回json数组对象,对其遍历
		   		$.each( data, function(i, json){
			// 每次遍历创建一个option对象
		   			var $option = $("<option value='"+json['cid']+"' >"+json["cname"]+"</option>"); 
		   			
				if(json['cid'] == selectedId){
				//判断是否需要回显 ,如果需要使其被选中
					$option.attr("selected","selected");
				}
			//并添加到select对象
					$select.append($option);
		   		});
		  },"json");
			
		//5 将组装好的select对象放入页面指定位置
		$("#"+positionId).append($select);
	}