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



<c:if test="${param.clientid!=null}">
<form class="layui-form" lay-filter="myform" action="revisit/insert.action">
<input type="hidden" name="clientid" value="${param.clientid }" >
</c:if>
<c:if test="${param.clientid==null}">
<form class="layui-form" lay-filter="myform" action="revisit/update.action">
<input type="hidden" name="id" >
<input type="hidden" name="clientid" >

</c:if>
  <div class="layui-form-item">
			<label class="layui-form-label">连通状态</label>
			<div class="layui-input-block">
				<select name="linkstatus">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户状态</label>
			<div class="layui-input-block">
				<select name="clientstatus">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">意向状态</label>
			<div class="layui-input-block">
				<select name="purposestatus">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">评估状态</label>
			<div class="layui-input-block">
				<select name="assessstatus">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">处理状态</label>
			<div class="layui-input-block">
				<select name="execstatus">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">询问状况</label>
			<div class="layui-input-block">
				<input type="text" name="askinfo" autocomplete="off"
					placeholder="请输入询问状况" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">跟进措施</label>
			<div class="layui-input-block">
				<input type="text" name="followinfo" autocomplete="off"
					placeholder="请输入跟进措施" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户顾虑</label>
			<div class="layui-input-block">
				<input type="text" name="probleminfo" autocomplete="off"
					placeholder="请输入客户顾虑" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<select name="status">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">回访人</label>
			<div class="layui-input-block">
				<select name="operatorid">
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" name="comments" autocomplete="off"
					placeholder="请输入备注" class="layui-input">
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
	$.post("revisit/select.action",{id:id}, function(json) {
		render('myform', json);
		getList("client/getOperator.action",{},"[name=operatorid]",json.operatorid);

		
		getarray("client/getLink.action",{},"[name=linkstatus]",json.linkstatus);
		getarray("client/getClient.action",{},"[name=clientstatus]",json.clientstatus);
		getarray("client/getPurpose.action",{},"[name=purposestatus]",json.purposestatus);
		getarray("client/getAssess.action",{},"[name=assessstatus]",json.assessstatus);
		getarray("client/getExec.action",{},"[name=execstatus]",json.execstatus);
		getarray("client/getStatus.action",{},"[name=status]",json.status);
	},"json");
}
if(id.length>0){
	init();
}else{
	getList("client/getOperator.action",{},"[name=operatorid]",0);

	
	getarray("client/getLink.action",{},"[name=linkstatus]",-1);
	getarray("client/getClient.action",{},"[name=clientstatus]",-1);
	getarray("client/getPurpose.action",{},"[name=purposestatus]",-1);
	getarray("client/getAssess.action",{},"[name=assessstatus]",-1);
	getarray("client/getExec.action",{},"[name=execstatus]",-1);
	getarray("client/getStatus.action",{},"[name=status]",-1);
}

</script>
</body>
</html>