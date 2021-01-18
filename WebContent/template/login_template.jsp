<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<!-- App Favicon -->
<link rel="shortcut icon" href="<c:url value='/images/favicon.ico'/>">

<!-- App title -->
<title><tiles:insertAttribute name="title" /></title>

<!-- App CSS -->
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />

<!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

<script src="<c:url value='/js/modernizr.min.js'/>"></script>
</head>
<body>
  <div class="account-pages"></div>
  <div class="clearfix"></div>
  <div class="wrapper-page">
    <tiles:insertAttribute name="content" />
  </div>
  <!-- end wrapper page -->

  <script>
    var resizefunc = [];
  </script>

  <!-- jQuery  -->
  <script src="<c:url value='/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/js/tether.min.js'/>"></script>
  <!-- Tether for Bootstrap -->
  <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/js/waves.js'/>"></script>
  <script src="<c:url value='/js/jquery.nicescroll.js'/>"></script>
  <script src="<c:url value='/plugins/switchery/switchery.min.js'/>"></script>

  <!-- App js -->
  <script src="<c:url value='/js/jquery.core.js'/>"></script>
  <script src="<c:url value='/js/jquery.app.js'/>"></script>

</body>
</html>