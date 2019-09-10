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
<form class="layui-form" lay-filter="myform" action="user/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="user/update.action">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="username"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="text" name="userpwd"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="usersex" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">电话号码</label>
    <div class="layui-input-block">
      <input type="text" name="userphone"  autocomplete="off" placeholder="请输入电话号码" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">职位</label>
    <div class="layui-input-block">
      <select name="posid" >
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
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].posname+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

var id="${param.id}";
function init(){
	$.post("user/select.action",{id:id}, function(json) {
		render('myform', json);
		getarray("user/getUsersex.action",{},"[name=usersex]",json.usersex);
		getlist("user/getPosition.action",{},"[name=posid]",json.posid);
	},"json");
}
if(id.length>0){
	init();
}else{
	getarray("user/getUsersex.action",{},"[name=usersex]",-1);
	getlist("user/getPosition.action",{},"[name=posid]",0);
}

</script>
</body>
</html>