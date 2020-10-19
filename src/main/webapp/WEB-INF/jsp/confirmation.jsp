<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
	<head>
		<style>
		body {
		
			font-family: Tahoma, Helvetica, sans-serif;
			background-color:#f4f0f7;
		}
		
		.main {
			margin: auto;
		  width: 50%;
		  height: 100px;
		  border-radius: 5px;
		  text-align: left;
		  opacity: 0.7;
		  background-color:#fbfafc;
		  height: 300px;
		  position: relative;
		  font-family: Arial, Helvetica, sans-serif;
		  
		}
		
		.outer {
			background-color:#f4f0f7;
			height: 400px;
		}
		
		
		.imgdiv {
			width: 80px;
			border-radius: 0 0 0px 75px;
			background-color: orange;
			float: right;
			height: 80px;
		}
		.bottom {
			
			position: absolute;
			bottom: 0;
			text-align: center;
			width: 100%;
			font-size: 12px;
			height: 50px;
			
			
		}
		
		a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  color: #fff;
  font-size: 15px;
}

a:hover, a:active {
  background-color: red;
}
		</style>
	</head>
	<body style="text-align: center; border-radius: 5px;">
		<div class="main">
			<div class="imgdiv">
			</div>
			<div style="margin-top:30px; font-size: 15px; padding: 40px; padding-top: 70px;">
				
				We have received your message. An associate will get back you soon!
			</div>
			
			<div class="bottom">
				<a href="/home">Home</a>
			</div>
		<div>
	</body>
</html>