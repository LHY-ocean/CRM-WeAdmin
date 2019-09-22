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
<form class="layui-form" lay-filter="myform" action="order/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="order/update.action">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <input type="text" name="clientname" disabled="disabled" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
      <label class="layui-form-label">创建日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="create" name="createdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">业绩日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="comp" name="compdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">合同日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="order" name="orderdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">开始日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="start" name="startdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">结束日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="end" name="enddate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <input type="text" name="operatorname"  autocomplete="off" placeholder="请输入创建人" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">合同条款</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入合同条款"  class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">文件</label>
    <div class="layui-input-block">
      <input type="text" name="files"  autocomplete="off" placeholder="请输入合同条款"  class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
      <input type="text" name="compoeratorids"  autocomplete="off" placeholder="请输入业绩人员"  class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">业务权重</label>
    <div class="layui-input-block">
      <input type="text" name="compweight"  autocomplete="off" placeholder="请输入业务权重"  class="layui-input">
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
    <label class="layui-form-label">总金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入总金额"  class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入备注"  class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	    ,trigger: 'click'
	  });
});
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
	$.post("order/select.action",{id:id}, function(json) {
		render('myform', json);
		getarray("order/getStatus.action",{},"[name=status]",json.status);
	},"json");
}
if(id.length>0){
	init();
}else{
	getarray("order/getStatus.action",{},"[name=status]",-1);
}

</script>
</body>
</html>