<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<base href="../../">
<link href="lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="lib/layui/layui.all.js"></script>
<script type="text/javascript" src="static/js/my.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px; width : 200px;
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select{width:200px;
}
</style>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="search">选择文件</button>
<button class="layui-btn layui-btn-sm" lay-event="add">上传提交</button>
  </div>
</script>

	<script>
	
		layui.use(['table','upload'], function() {
			var table = layui.table;
			var upload = layui.upload;
			//第一个实例
			table.render({
				elem : '#demo',
				height : 575,
				id:"mytab",
				url : 'upload/list.action' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{type:'checkbox'},
				{
					field : 'id',
					title : 'ID',
					width : 100
				}, {
					field : 'name',
					title : '姓名',
					width : 100
				}, {
					field : 'sexname',
					title : '性别',
					width : 80
				}, {
					field : 'uploadstatusname',
					title : '状态',
					width : 280
				}, {
					field : 'uploadstatus',
					title : '状态号',
					width : 280,
					hide:true
				}, {
					field : 'tel',
					title : '电话号码',
					width : 120
				}, {
					field : 'qq',
					title : 'QQ',
					width : 120
				},{
					field : 'email',
					title : '邮箱',
					width : 180
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				},  done: function (res, curr, count){
					if(res.count>0)
						for(var i=0;i<res.data.length;i++){
							if(res.data[i].uploadstatus==1){
								$($("[data-index]")[i]).css("background","#ee5577");
								$($("[data-index]")[i]).find("[type=checkbox]").prop("disabled","disabled")
							}
						}
					}
			});
			
			var uploadInst = upload.render({
	            elem: '[lay-event=search]' //绑定元素
	            ,url: 'upload/index.action' //上传接口
	            ,method: 'POST'
	            ,accept: 'file'
	            ,field:"file"
	            ,size: 50
	            ,done: function(res){//上传完毕回调
	            	fresh("mytab");
	            }
	            ,error: function(){//请求异常回调
	                layer.msg('网络异常，请稍后重试！');
	            }
	        });

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性

			table.on('toolbar(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'add') {
					var checkStatus = table.checkStatus("mytab");
					var str="";
					for(var i=0;i<checkStatus.data.length;i++){
						str+=checkStatus.data[i].id+","	
					}
					if(checkStatus.data.length>0){
						str=","+str;
					}
					$.post("upload/save.action",{ids:str},function(json){
						fresh("mytab");
					},"json");
				}
			});


		});
	</script>
</body>
</html>