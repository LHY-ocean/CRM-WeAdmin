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
<a class="layui-btn layui-btn-xs" lay-event="edit">选择分配</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    <button class="layui-btn layui-btn-sm" lay-event="add">批量导入</button>
    <button class="layui-btn layui-btn-sm" lay-event="peach">批量分配</button>

  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 575,
				id:'mytab',
				url : 'client/no_index.action' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{type:'checkbox'},
				{
					field : 'id',
					title : 'ID',
					width : 80,
					hide:true,
					sort : true,
				}, {
					field : 'name',
					title : '姓名',
					width : 100
				}, {
					field : 'sexname',
					title : '性别',
					width : 80
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
				},{
					field : 'infos',
					title : '额外信息',
					width : 100,
					hide:true
				},{
					field : 'linkstatusname',
					title : '联通状态',
					width : 100,
					hide:true
				},{
					field : 'clientstatusname',
					title : '客户状态',
					width : 100,
					hide:true
				},{
					field : 'purposestatusname',
					title : '意向状态',
					width : 100,
					hide:true
				},{
					field : 'assessstatusname',
					title : '评估状态',
					width : 100,
					hide:true
				},{
					field : 'execstatusname',
					title : '处理状态',
					width : 100,
					hide:true
				},{
					field : 'statusname',
					title : '状态',
					width : 100
				},{
					field : 'clienttypename',
					title : '客户类型',
					width : 100
				},{
					field : 'operatorids',
					title : '负责人ID',
					width : 100,
					hide:true
				},{
					field : 'operatorname',
					title : '创建人',
					width : 100
				},{
					field : 'createdate',
					title : '创建时间',
					width : 120
				},{
					field : 'srcname',
					title : '机会来源',
					width : 100
				},{
					field : 'count',
					title : '回访次数',
					width : 100,
					hide:true
				},{
					field : 'comments',
					title : '备注',
					width : 180,
					hide:true
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性
					
					myconfirm("刪除？",function(){
						$.post("client/delete.action", {id : data.id}, 
								function(json) {
							reload('demo');
							layer.close(layer.index);
								}, "json");
					});
				}else{
					WeAdminShow('分配用户','pages/clientpool/edit.jsp?str=,'+data.id+',',600,400)
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('mytab',{txt : txt});
				} else if(obj.event === 'add') {
					WeAdminShow('导入用户','pages/clientpool/upload.jsp',600,400);
				} else if(obj.event == 'peach'){
					var data = obj.data;
						var checkStatus = table.checkStatus("mytab");
						var str="";
						for(var i=0;i<checkStatus.data.length;i++){
							str+=checkStatus.data[i].id+","	
						}
						if(checkStatus.data.length>0){
							str=","+str;
						}
					WeAdminShow('批量分配用户','pages/clientpool/edit.jsp?str='+str,600,400);
				}
			});

		});
	</script>
</body>
</html>