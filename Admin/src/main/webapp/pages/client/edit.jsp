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
<form class="layui-form" lay-filter="myform" action="client/insert.action">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="client/update.action">
<input type="hidden" name="id" >
</c:if>
<div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  disabled="disabled" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">电话号码</label>
    <div class="layui-input-block">
      <input type="text" name="tel" disabled="disabled" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="email" name="qq"  autocomplete="off" placeholder="请输入qq" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input type="email" name="email"  autocomplete="off" placeholder="请输入邮箱" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos" autocomplete="off" placeholder="请输入额外信息" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">联通状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
      <select name="execstatus" >
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
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">负责人ID</label>
    <div class="layui-input-block">
      <input type="email" name="operatorids"  autocomplete="off" placeholder="请输入邮箱" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="createoperatorid" >
      </select>
    </div>
  </div>
 <div class="layui-form-item">
      <label class="layui-form-label">创建时间</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test1" name="createdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户来源</label>
    <div class="layui-input-block">
      <select name="srcid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="number" name="count" autocomplete="off" placeholder="请输入回访次数" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="comments" autocomplete="off" placeholder="请输入备注" class="layui-input">
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