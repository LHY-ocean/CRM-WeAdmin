<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<base href="../../">
<link href="lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="lib/layui/layui.all.js"></script>
<script type="text/javascript" src="static/js/my.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/tableSelect.js"></script>
<title></title>
</head>
<body>
<style>
.layui-input, .layui-form-select{width:200px;}
</style>




<form class="layui-form" lay-filter="myform" action="client/updateOpids.action">
<input type="hidden" name="id" >

<input type="hidden" name="str" value="${param.str }">

  <div class="layui-form-item">
    <label class="layui-form-label">负责人ID</label>
    <div class="layui-input-block">
      <input type="text" name="operatornames" id="opids" readonly="readonly" autocomplete="off" placeholder="请选择负责人" class="layui-input">
      <input type="hidden" name="operatorids">
    </div>
  </div>
  
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">

//开始使用
var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#opids',	//定义输入框input对象 必填
	checkedKey: 'name', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
	offset:'auto',
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'operator/index.action',
		cols: [[ 
			{type: 'checkbox'},
			{
			field : 'id',
			title : 'ID',
			width : 100,
		},{
			field : 'name',
			title : '用户名',
			width : 100
		} 
		]],
parseData : function(res) {
	return {
		"code" : res.code, //解析接口状态
		"msg" : res.msg,//解析提示文本
		"count" : res.count,//解析数据长度
		"data" : res.list//解析数据列表
	}
}
	},
	done: function (elem, data) {
	//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
	//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
		var NEWJSON = []
		var NEWJSON1 = []
		layui.each(data.data, function (index, item) {
			NEWJSON.push(item.name);
			NEWJSON1.push(item.id);
		})
		elem.val(NEWJSON.join(","))
		$('[name=operatorids]').val(NEWJSON1.join(","))
	}
})

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('mytab');
			}, "json");
		    
		    return false;
		  });
});

function getList(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].name+"</option>"))
		}
		layui.form.render('select');
	},"json");
}


var id="${param.id}";
function init(){
	$.post("client/select.action",{id:id}, function(json) {
		render('myform', json);
		$('[id=opids]').attr('ts-selected',json.operatornames);
		getList("client/getClientType.action",{},"[name=clienttypeid]",json.clienttypeid);
		getList("client/getOperator.action",{},"[name=createoperatorid]",json.createoperatorid);
		getList("client/getSrc.action",{},"[name=srcid]",json.srcid);
		
		getarray("client/getLink.action",{},"[name=linkstatus]",json.linkstatus);
		getarray("client/getClient.action",{},"[name=clientstatus]",json.clientstatus);
		getarray("client/getPurpose.action",{},"[name=purposestatus]",json.purposestatus);
		getarray("client/getAssess.action",{},"[name=assessstatus]",json.assessstatus);
		getarray("client/getExec.action",{},"[name=execstatus]",json.execstatus);
		getarray("client/getStatus.action",{},"[name=status]",json.status);
		getarray("client/getSex.action",{},"[name=sex]",json.sex);
	},"json");
}
if(id.length>0){
	init();
}else{
	getList("client/getClientType.action",{},"[name=clienttypeid]",0);
	getList("client/getOperator.action",{},"[name=createoperatorid]",0);
	getList("client/getSrc.action",{},"[name=srcid]",0);
	
	getarray("client/getLink.action",{},"[name=linkstatus]",-1);
	getarray("client/getClient.action",{},"[name=clientstatus]",-1);
	getarray("client/getPurpose.action",{},"[name=purposestatus]",-1);
	getarray("client/getAssess.action",{},"[name=assessstatus]",-1);
	getarray("client/getExec.action",{},"[name=execstatus]",-1);
	getarray("client/getStatus.action",{},"[name=status]",-1);
	getarray("client/getSex.action",{},"[name=sex]",-1);
}




</script>
</body>
</html>