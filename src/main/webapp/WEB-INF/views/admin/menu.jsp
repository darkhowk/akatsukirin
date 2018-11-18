<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/tui-grid.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.3.3/backbone.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.4.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tui-grid.js"></script>

<div class="content-wrapper">
	<section class="content-header">
		<h1>
			${path.MenuName }
		</h1>
		<ol class="breadcrumb">
			<li>
				<a href="#">
					<i class="fa fa-dashboard"></i> 
					${path.path }
				</a>
			</li>
		</ol>
	</section>
	
	<section class="content container-fluid">
		<div class="box">
			<div class="box-header">
				<button class="btn btn-primary pull-right add">추가</button>
				<button class="btn btn-primary pull-right save">저장</button>
			</div>
			
			<div class="box-body">
				<div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
					<div class="t_grd" id="grid"></div>
				</div>
			</div>
		</div>
	</section>
</div>

<style type="text/css"> 
input{     
	border: none; 
	background: transparent;
} 
</style>
<script type="text/javascript" class="code-js">
	$(document).ready(function (){
		var data = ${data.list};
		var col = ${data.column};
		var grid = new tui.Grid({
		    el: $('#grid'),
		    columns:  col,
		    editingEvent: 'click',
		});
		grid.setData(data);
		
		$(".add").click(function(){
			grid.appendRow();
		});
		
		$(".save").click(function(){
			var data =  grid.getModifiedRows(); 
			console.log(data);
			$.post('/admin/menu/ajax', data ,function(result){
					console.log(result);
					location.reload();
			});
		});
		  
	});
 </script>