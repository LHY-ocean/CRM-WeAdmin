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
<form class="layui-form" lay-filter="myform" action="position/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="position/update.action">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">职位名称</label>
    <div class="layui-input-block">
      <input type="text" name="posname"  autocomplete="off" placeholder="请输入编号" class="layui-input">
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



var id="${param.id}";
function init(){
	$.post("position/select.action",{id:id}, function(json) {
		render('myform', json);
	},"json");
}
if(id.length>0){
	init();
}

</script>
</body>
</html>