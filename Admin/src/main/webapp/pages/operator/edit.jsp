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
<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>



<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="operator/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="operator/update.action">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">电话号码</label>
    <div class="layui-input-block">
      <input type="text" name="tel" disabled="disabled" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="text" name="pass"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  disabled="disabled" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">工作组</label>
    <div class="layui-input-block">
      <select name="groupid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">角色</label>
    <div class="layui-input-block">
      <select name="power" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});

function getlist(url,data,selector,def_id){
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
	$.post("operator/select.action",{id:id}, function(json) {
		render('myform', json);
		getlist("operator/getGroup.action",{},"[name=groupid]",json.groupid);
		getarray("operator/getPower.action",{},"[name=power]",json.power);
		getarray("operator/getStatus.action",{},"[name=status]",json.status);
	},"json");
}
if(id.length>0){
	init();
}else{
	getlist("operator/getGroup.action",{},"[name=groupid]",0);
	getarray("operator/getPower.action",{},"[name=power]",-1);
	getarray("operator/getStatus.action",{},"[name=status]",-1);
}

</script>
</body>
</html>