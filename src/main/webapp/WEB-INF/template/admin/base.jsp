<!DOCTYPE html>
<html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<head>
<%@include file="comm_head.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
 	<tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="left-side"/>
    <tiles:insertAttribute name="content"/>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>


 