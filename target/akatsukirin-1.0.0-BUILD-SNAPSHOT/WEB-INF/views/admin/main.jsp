<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Memorandum Admin
        <small>비망록 관리자 페이지</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>admin > main</a></li>
      </ol>
    </section>

    <!-- Main content -->
  <!--   <section class="content container-fluid"> -->
    	<div class="iframe_wrap row" style="min-height: 839px;">
    	 	<section class="col-lg-3 connectedSortable ui-sortable">
				<h2><small>memorandum</small> </h2>		    	
		    	<iframe class="iframe" src="http://www.memorandum.tk"></iframe>
		    	
		    </section>
    		<section class="col-lg-3 connectedSortable ui-sortable">
				<h2> <small>akatsukirin</small> </h2>
		    	<iframe class="iframe" src="http://www.akatsukirin.com"></iframe>
		    </section>
		   
		</div>
   <!--  </section> -->
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
   
 <style type="text/css">
 .content-wrapper {
	width: 100%; height: 100%;
}
  .iframe_wrap {
    width: 180%;
    min-height: 839px;
    padding: 0;
    overflow: hidden;
}
.iframe {
    width: 180%;
    min-height: 839px;
    border: 0;
    -ms-transform: scale(0.5);
    -moz-transform: scale(0.5);
    -o-transform: scale(0.5);
    -webkit-transform: scale(0.5);
    transform: scale(0.5);
    -ms-transform-origin: 0 0;
    -moz-transform-origin: 0 0;
    -o-transform-origin: 0 0;
    -webkit-transform-origin: 0 0;
    transform-origin: 0 0;
}
</style>