<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tml" uri="/tml-tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="google" content="notranslate">
<title>Foody</title>

<link rel="icon" type="image/ico" href="<s:url value="/assets/favicon.ico"/>">

<link rel='stylesheet'
	href="http://fonts.googleapis.com/css?family=Roboto:400,300,500,700" />

<s:url value="/assets" var="style" htmlEscape="true"/>
<tml:stylesheet_link ltr="${style}/stylesheets/bootstrap.min.css" 
	rtl="${style}/stylesheets/bootstrap.min.css" />

<tml:stylesheet_link ltr="${style}/stylesheets/style.css"
	rtl="${style}/stylesheets/style.css" />

<script src="<s:url value="/assets/javascripts/jquery.min.js"/>" type="text/javascript"></script>
<script src="<s:url value="/assets/javascripts/bootstrap.min.js"/>"></script>

<tml:scripts />	