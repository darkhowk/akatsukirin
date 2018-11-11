<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">
<link rel="icon" type="image/png" href="./assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Memorandum Main</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<!-- CSS Files -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/now-ui-kit.css?v=1.2.0" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand" href="http://memornadum.tk" rel="tooltip" title="DarkHowk's Site" data-placement="bottom" target="_blank">
					Memorandum 
				</a>
				<button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-bar top-bar"></span> 
					<span class="navbar-toggler-bar middle-bar"></span> 
					<span class="navbar-toggler-bar bottom-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse justify-content-end backimg" id="navigation" data-nav-image=${pageContext.request.contextPath}/resources/img/main_visual.png">
				<ul class="navbar-nav">
					<!-- 컨텐츠들.. -->
					<li class="nav-item">
						<a class="nav-link" rel="tooltip" title="Follow on Twitter" data-placement="bottom" href="https://twitter.com/tsukirin0329" target="_blank"> 
							<i class="fab fa-twitter"></i>
							<p class="d-lg-none d-xl-none">Twitter</p>
						</a>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="wrapper">
		<div class="page-header clear-filter" filter-color="white">
			<div class="page-header-image" data-parallax="true"
				style="background-image:url('${pageContext.request.contextPath}/resources/img/main_visual.png');">
			</div>
		</div>
		<div class="main">
		</div>
		
		<!--  End Modal -->
		<footer class="footer" data-background-color="black">
			<div class="container">
				<nav>
					<ul>
						<!-- 현재 선택 컨텐츠 공식 홈페이지 등등.. 일단 아카츠키린 공식 홈페이지등으로.. -->
						<li>
							<a href="http://www.akatsukirin.com/"> 
								아카츠키린 공식 홈페이지
							</a>
						</li>
						<li>
							<a href="https://twitter.com/tsukirin0329"> 
								아카츠키린 공식 트위터
							</a>
						</li>
						<li>
							<a href="https://www.youtube.com/channel/UCXcJVQlczdNJX5LAwvOvENA"> 
								아카츠키린 공식 유튜브
							</a>
						</li>
					</ul>
				</nav>
				<div class="copyright" id="copyright">
					&copy;
					<script>
						document.getElementById('copyright').appendChild(document.createTextNode(new Date().getFullYear()))
					</script>
					, Develop by DEV JK
				</div>
			</div>
		</footer>
	</div>
	<!--   Core JS Files   -->
	<script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js" type="text/javascript"></script>
	<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-switch.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/nouislider.min.js" type="text/javascript"></script>
	<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
	<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
	<script src="${pageContext.request.contextPath}/resources/js/now-ui-kit.js?v=1.2.0" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			// the body of this function is in assets/js/now-ui-kit.js
			nowuiKit.initSliders();
		});

		function scrollToDownload() {

			if ($('.section-download').length != 0) {
				$("html, body").animate({
					scrollTop : $('.section-download').offset().top
				}, 1000);
			}
		}
	</script>
	<script type="text/javascript">
		$( document ).ready(function() {
		  var randomnum = 0;
		  var interval = setInterval(function(){ // 일정시간마다 반복 실행    

              randomnum = Math.random() * 0xffffff; // 랜덤하게 16진수 뽑기
              randomnum = parseInt(randomnum); // 정수로 변환
              randomnum = randomnum.toString(16);
              $("#navigation").css({"background":"'${pageContext.request.contextPath}/resources/img/main_visual.png'");

          },5000); // 5초마다 실행 (100 = 0.1초, 1000 = 1초)
		});
	</script>
	
</body>
</html>