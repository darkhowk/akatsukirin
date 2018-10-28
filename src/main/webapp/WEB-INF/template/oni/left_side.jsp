<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> --%>
<aside class="main-sidebar">
<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".menu").click(function(){
		$("#admin > #selMenu").val(this.getAttribute("no"));
		$('#admin').attr("method","POST").attr("action", this.getAttribute("link")).submit();
	});
});
</script>
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- search form (Optional) -->
      <!-- <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form> -->
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <%-- <li class="header">${id }</li> --%>
        <!-- Optionally, you can add icons to the links -->
        <form id="admin" >
        	<input type="hidden" id="selMenu" name="selMenu">
        </form>
      <%--   <c:forEach items="${mainMenu }" var="L1">
        		<li class="treeview">
		          <a href="#"><i class="fa fa-link"></i> <span>${L1.MENUNAME }</span>
		            <span class="pull-right-container">
		                <i class="fa fa-angle-left pull-right"></i>
		              </span>
		          </a>
		          <ul class="treeview-menu">
		          	<c:forEach items="${subMenu }" var="L2">
			          	<c:if test="${L1.MENUCATEGORY eq L2.MENUCATEGORY }">
			           		<li><a href="#" class="menu" link="${L2.MENULINK }" no="${L2.SEQ }">${L2.MENUNAME }</a></li>
			            </c:if>
		            </c:forEach>
		          </ul>
		        </li>
        </c:forEach> --%>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>