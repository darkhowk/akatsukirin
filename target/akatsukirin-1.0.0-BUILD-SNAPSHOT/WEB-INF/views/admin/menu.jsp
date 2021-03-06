<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			${selMenu } <small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>
					${selMenuCategory }</a></li>
			<li class="active">${selMenu }</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content container-fluid">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">${selMenu }</h3>
				<button type="button" class="btn btn-primary pull-right add">추가</button>
                <button type="button" class="btn btn-primary pull-right submit">저장</button>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div id="example2_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap">
					<div class="row">
						<div class="col-sm-6"></div>
						<div class="col-sm-6"></div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<form id="menu">
							<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
								<thead>
									<tr role="row">
										<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">Delete</th>
										<th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="SEQ">SEQ</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="MenuName">메뉴 이름</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="MenuLevel">메뉴 레벨</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="MenuCategory">메뉴 카테고리</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="MenuLink">메뉴 링크</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="MenuAuth">메뉴 권한</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="UseYn">메뉴 사용여부</th>
									</tr>
								</thead>
								<tbody>
										<c:forEach items="${data.list }" var="list">
										<tr role="row" class="odd">
											<td>
												<input type="checkbox" class="delete">
												<input type="hidden" id="CURD" name="CURD" value="R">
											</td>
											<td class="sorting_1">
												<input type="text" id="SEQ" name="SEQ" value="${list.SEQ }" tabindex="0">
											</td>
											<td>
												<input type="text" id="MENUNAME" name="MENUNAME" value="${list.MENUNAME }" tabindex="1">
											</td>
											<td>
												<input type="text" id="MENULEVEL" name="MENULEVEL" value="${list.MENULEVEL }" tabindex="2">
											</td>
											<td>
												<input type="text" id="MENUCATEGORY" name="MENUCATEGORY" value="${list.MENUCATEGORY }" tabindex="3">
											</td>
											<td>
												<input type="text" id="MENULINK" name="MENULINK" value="${list.MENULINK }"  tabindex="4">
											</td>
											<td>
												<input type="text" id="MENUAUTH" name="MENUAUTH" value="${list.MENUAUTH }"  tabindex="5">
											</td>
											<td>
												<input type="text" id="USEYN" name="USEYN" value="${list.USEYN }" tabindex="6">
											</td>
										</tr>
										
										</c:forEach>
								</tbody>
							</table>
							</form>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="example2_info" role="status"
								aria-live="polite">현재  ${data.param.page }페이지를 ${data.param.countPage }개씩  총 ${data.list[0].TOTCONT }개의 데이터가 있습니다.</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example2_paginate">
								<ul class="pagination">
									<c:if test="${data.list[0].TOTCONT <= data.param.countPage * data.param.page }">
										<li class="paginate_button previous disabled" id="example2_previous">
											<a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
										</li>
										<li class="paginate_button active">
											<a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">1</a>
										</li>
										<li class="paginate_button next disabled" id="example2_next">
											<a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a>
										</li>
									</c:if>
									<c:if test="${data.list[0].TOTCONT > data.param.countPage * data.param.page }">
										<li class="paginate_button previous disabled" id="example2_previous">
											<a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
										</li>
											<c:forEach var="i" begin="1" end="${data.list[0].TOTCONT / data.param.countPage }">
												<c:if test="${data.param.page eq i }">
													<li class="paginate_button active">
														<a href="#" aria-controls="example2" data-dt-idx="${i }" tabindex="0">${i }</a>
													</li>
												</c:if>
												<c:if test="${data.param.page ne i }">
													<li class="paginate_button ">
														<a href="#" aria-controls="example2" data-dt-idx="${i }" tabindex="0">${i }</a>
													</li>
												</c:if>
											</c:forEach>
										<li class="paginate_button next" id="example2_next">
											<a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box-body -->
		</div>

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<style type="text/css"> 
	input{     
 		border: none; 
 		background: transparent;
	} 
</style>
<script type="text/javascript">
	$(function(){
	    $('input[type="text"]').on('change', function() {
	    	var new_value = $(this).val();
	    	var old_value = $(this).prop("defaultValue")
	    	if (new_value != old_value){
	    		this.parentElement.parentElement.setAttribute("style", "background:pink");
	    		$(this).parent().find("input[id=CRUD]")[0].value = "U";
	    	}
	    });
	    $('.delete').click(function(){
	    	var _this = $(this);
	    		if (_this.prop("checked")){
	    			if (_this.parent().find("input[id=CURD]")[0].value == "N"){
	    				_this.parent().remove();
	    			}
	    			else{
	    				this.parentElement.parentElement.setAttribute("style", "background:gray");
	    				_this.parent().find("input[id=CRUD]")[0].value = "D";
	    			}
	    		}
	    		else{
	    			this.parentElement.parentElement.removeAttribute("style");
		    		this.parentElement.parentElement.removeAttribute("crud");
		    		_this.parent().find("input[id=CRUD]")[0].value = "R";
	    		}
	    });
	    $('.add').click(function(){
	    	var inner = '<tr role="row" class="odd">'
					  + '<td>'
					  + '<input type="checkbox" class="delete">'
					  + '<input type="hidden" id="CURD" name="CURD" >';
					  + '</td>'
					  + '<td class="sorting_1">'
					  + '<input type="text" id="SEQ" name="SEQ" tabindex="0">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="MENUNAME" name="MENUNAME" tabindex="1">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="MENULEVEL" name="MENULEVEL" tabindex="2">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="MENUCATEGORY" name="MENUCATEGORY" tabindex="3">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="MENULINK" name="MENULINK" tabindex="4">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="MENUAUTH" name="MENUAUTH" tabindex="5">'
					  + '</td>'
					  + '<td>'
					  + '<input type="text" id="USEYN" name="USEYN" tabindex="6">'
					  + '</td>'
					  + '</tr>';
					  
	    	 $('#example2 > tbody:last').append(inner);
   		});
	    $( document ).ready(function() {
		    $('.submit').click(function(){
		    	 var params = $("#menu").serialize(); // serialize() : 입력된 모든Element(을)를 문자열의 데이터에 serialize 한다.
		    	 $.ajax({   
				    	   type: "POST"  
				    	  ,url: "/admin/ajax/adminmenu"
				    	  ,data: params
				    	  ,success:function(data){
				    		  console.log(params);
				    		  console.log("succ" , data);
				    	  }
				    	  ,error:function(data){
				    		  console.log("err" , data);
				    	  }
		    	  });
	    	});
	    });
	});
</script>
