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
<form class="layui-form" lay-filter="myform" action="customer/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="customer/update.action">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户名</label>
    <div class="layui-input-block">
      <input type="text" name="cusname"  autocomplete="off" placeholder="请输入客户名" class="layui-input">
    </div>
  </div>
   </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户等级</label>
    <div class="layui-input-block">
      <select name="cuslevelid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户信誉度</label>
    <div class="layui-input-block">
      <input type="text" name="cuscredit"  autocomplete="off" placeholder="请输入客户信誉度" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户满意度</label>
    <div class="layui-input-block">
      <input type="text" name="cuspleased"  autocomplete="off" placeholder="请输入客户满意度" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户所在地</label>
    <div class="layui-input-block">
      <input type="text" name="cusarea"  autocomplete="off" placeholder="请输入客户所在地" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户详细地址</label>
    <div class="layui-input-block">
      <input type="text" name="cusaddress"  autocomplete="off" placeholder="请输入客户详细地址" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户电话</label>
    <div class="layui-input-block">
      <input type="text" name="cusphone"  autocomplete="off" placeholder="请输入客户电话" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">负责人</label>
    <div class="layui-input-block">
      <select name="userid" >
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

function getlevel(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].levelname+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function getuser(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].username+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

var id="${param.id}";
function init(){
	$.post("customer/select.action",{id:id}, function(json) {
		render('myform', json);
		getlevel("customer/getLevel.action",{},"[name=cuslevelid]",json.cuslevelid);
		getuser("customer/getUser.action",{},"[name=userid]",json.userid);
	},"json");
}
if(id.length>0){
	init();
}else{
	getlevel("customer/getLevel.action",{},"[name=cuslevelid]",0);
	getuser("customer/getUser.action",{},"[name=userid]",0);
}

</script>
</body>
</html>