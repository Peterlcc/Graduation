<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Short Codes</title>
<link href="../../resource/user/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
<link href="../../resource/user/css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
<link href="../../resource/user/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->  
<!-- meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //meta tags -->
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<!--//fonts-->	
<script type="text/javascript" src="../../resource/user/js/jquery-2.1.4.min.js"></script><!-- Required-js -->
<script src="../../resource/user/js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="../../resource/user/js/numscroller-1.0.js"></script>
<!-- here stars scrolling icon -->
			<script type="text/javascript">
				$(document).ready(function() {
					$().UItoTop({ easingType: 'easeOutQuart' });
										
					});
			</script>
			<!-- start-smoth-scrolling -->
			<script type="text/javascript" src="../../resource/user/js/move-top.js"></script>
			<script type="text/javascript" src="../../resource/user/js/easing.js"></script>
			<script type="text/javascript">
				jQuery(document).ready(function($) {
					$(".scroll").click(function(event){		
						event.preventDefault();
						$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
					});
				});
			</script>
			<!-- start-smoth-scrolling -->
		<!-- //here ends scrolling icon -->
</head>
<body>
	<!-- header -->
	<header>
		<div class="container">
			<!-- nav -->
			<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">

				<div class="logo">
					<h1><a  style="color: #00c5b5">iLive</a></h1>
				</div>	
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li id="userId" style="display: none" value="${user.id}">${user.id}</li>
					<li ><a href="/house/ilive">Home</a></li>
					<li class="active"><a href="/house/home">租房</a></li>
					<li class="dropdown">
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.name} <b class="caret"></b></a>
					  <ul class="dropdown-menu">
						<li><a href="/user/detail">个人信息</a></li>
						<li><a href="/user/logout">退出</a></li>
					  </ul>
					</li>
				  </ul>
				</div>
				<!-- /.navbar-collapse -->
			  </div>
			  <!-- /.container-fluid -->
			</nav> 
			<script src="../../resource/user/js/nav.js"></script><!-- nav-js --> 
			<!-- //nav -->
		</div>
	</header>
	<!-- //header -->
	<!-- breadcrumbs -->
	<div class="w3ls-inner-banner">
		<div class="container">
			<h2>Short Codes</h2>
			<label></label>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //breadcrumbs -->
	
	<!-- main-content -->
	<div class="main-content">
		<!-- Typography -->
	<div class="typography">
		<div class="container">
				<div class="typo-grid">
 	  
        <div class="typo-1">
			  <div class="grid_3 grid_4">
			  <h3 class="head-top">Headings</h3>
			  <div class="bs-example">
				<table class="table">
				  <tbody>
					<tr>
					  <td><h1 id="h1.-bootstrap-heading">h1. Bootstrap heading<a class="anchorjs-link" href="#h1.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h1></td>
					  <td class="type-info">Semibold 36px</td>
					</tr>
					<tr>
					  <td><h2 id="h2.-bootstrap-heading">h2. Bootstrap heading<a class="anchorjs-link" href="#h2.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h2></td>
					  <td class="type-info">Semibold 30px</td>
					</tr>
					<tr>
					  <td><h3 id="h3.-bootstrap-heading">h3. Bootstrap heading<a class="anchorjs-link" href="#h3.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h3></td>
					  <td class="type-info">Semibold 24px</td>
					</tr>
					<tr>
					  <td><h4 id="h4.-bootstrap-heading">h4. Bootstrap heading<a class="anchorjs-link" href="#h4.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h4></td>
					  <td class="type-info">Semibold 18px</td>
					</tr>
					<tr>
					  <td><h5 id="h5.-bootstrap-heading">h5. Bootstrap heading<a class="anchorjs-link" href="#h5.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h5></td>
					  <td class="type-info">Semibold 14px</td>
					</tr>
					<tr>
					  <td><h6>h6. Bootstrap heading</h6></td>
					  <td class="type-info">Semibold 12px</td>
					</tr>
				  </tbody>
				</table>
				</div>
			  </div>
			  <div class="grid_3 grid_5">
				<h3 class="head-top">Labels</h3>
				 <div class="but_list">
				  <h1>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h1>
				  <h2>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h2>
				  <h3>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h3>
				  <h4>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h4>
				  <h5>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h5>
				  <h6>
					<span class="label label-default">Default</span>
					<span class="label label-primary">Primary</span>
					<span class="label label-success">Success</span>
					<span class="label label-info">Info</span>
					<span class="label label-warning">Warning</span>
					<span class="label label-danger">Danger</span>
				  </h6>
				 </div>
			   </div>
			   <div class="grid_3 grid_5">
				 <h3 class="head-top">Progress Bars</h3>
					 <div class="tab-content">
						  <div class="tab-pane active" id="domprogress">
							  <div class="progress">    
								<div class="progress-bar progress-bar-primary" style="width: 20%"></div>
							  </div>
							  <p>Info with <code>progress-bar-info</code> class.</p>
							  <div class="progress">    
								<div class="progress-bar progress-bar-info" style="width: 60%"></div>
							  </div>
							  <p>Success with <code>progress-bar-success</code> class.</p>
							  <div class="progress">
								<div class="progress-bar progress-bar-success" style="width: 30%"></div>
							  </div>
							  <p>Warning with <code>progress-bar-warning</code> class.</p>
							  <div class="progress">
								<div class="progress-bar progress-bar-warning" style="width: 70%"></div>
							  </div>
							  <p>Danger with <code>progress-bar-danger</code> class.</p>
							  <div class="progress">
								<div class="progress-bar progress-bar-danger" style="width: 50%"></div>
							  </div>
							  <p>Inverse with <code>progress-bar-inverse</code> class.</p>
							  <div class="progress">
								<div class="progress-bar progress-bar-inverse" style="width: 40%"></div>
							  </div>
							   <p>Inverse with <code>progress-bar-inverse</code> class.</p>
							  <div class="progress">
								<div class="progress-bar progress-bar-success" style="width: 35%"><span class="sr-only">35% Complete (success)</span></div>
								<div class="progress-bar progress-bar-warning" style="width: 20%"><span class="sr-only">20% Complete (warning)</span></div>
								<div class="progress-bar progress-bar-danger" style="width: 10%"><span class="sr-only">10% Complete (danger)</span></div>
							  </div>
						</div>
				   </div>
			   </div>
			   <div class="grid_3 grid_5">
				 <h3 class="head-top">Alerts</h3>
				 <div class="but_list">
				   <div class="alert alert-success" role="alert">
					<strong>Well done!</strong> You successfully read this important alert message.
				   </div>
				   <div class="alert alert-info" role="alert">
					<strong>Heads up!</strong> This alert needs your attention, but it's not super important.
				   </div>
				   <div class="alert alert-warning" role="alert">
					<strong>Warning!</strong> Best check yo self, you're not looking too good.
				   </div>
				   <div class="alert alert-danger" role="alert">
					<strong>Oh snap!</strong> Change a few things up and try submitting again.
				   </div>
				 </div>
			   </div>
			   <div class="grid_3 grid_5">
				 <h3 class="head-top">Pagination</h3>
				 <div class="col-md-6 page_1">
				  <nav>
				  <ul class="pagination pagination-lg">
					<li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
				  </ul>
				  </nav>
				  <nav>
				  <ul class="pagination">
					<li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
				  </ul>
				</nav>
				<nav>
				  <ul class="pagination pagination-sm">
					<li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
				  </ul>
				</nav>
				</div>
				<div class="col-md-6 page_1">
					<ul class="pagination pagination-lg">
						<li class="disabled"><a href="#"><span aria-hidden="true">«</span></a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#"><span aria-hidden="true">»</span></a></li>
				   </ul>
				<nav>
				  <ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
				 </ul>
			   </nav>
				 <ul class="pagination pagination-sm">
					<li class="disabled"><a href="#"><span aria-hidden="true">«</span></a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#"><span aria-hidden="true">»</span></a></li>
				</ul>
				</div>
			   <div class="clearfix"> </div>
			   </div>
			   <div class="grid_3 grid_5">
				 <h3 class="head-top">Breadcrumbs</h3>
				 <div class="but_list">
					<ol class="breadcrumb">
					  <li class="active">Home</li>
					</ol>
					<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li class="active">Library</li>
					</ol>
					<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li><a href="#">Library</a></li>
					  <li class="active">Data</li>
					</ol>
				  </div>
			   </div>
			   <div class="grid_3 grid_5">
				 <h3 class="head-top">Badges</h3>
				   <div class="but_list">
					<div class="col-md-6 page_1">
						<p>Add modifier classes to change the appearance of a badge.</p>
						  <table class="table table-bordered">
							<thead>
								<tr>
									<th>Classes</th>
									<th>Badges</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>No modifiers</td>
									<td><span class="badge">42</span></td>
								</tr>
								<tr>
									<td><code>.badge-primary</code></td>
									<td><span class="badge badge-primary">1</span></td>
								</tr>
								<tr>
									<td><code>.badge-success</code></td>
									<td><span class="badge badge-success">22</span></td>
								</tr>
								<tr>
									<td><code>.badge-info</code></td>
									<td><span class="badge badge-info">30</span></td>
								</tr>
								<tr>
									<td><code>.badge-warning</code></td>
									<td><span class="badge badge-warning">412</span></td>
								</tr>
								<tr>
									<td><code>.badge-danger</code></td>
									<td><span class="badge badge-danger">999</span></td>
								</tr>
							</tbody>
						  </table>                    
					</div>
					<div class="col-md-6 page_1">
					  <p>Easily highlight new or unread items with the <code>.badge</code> class</p>
						<div class="list-group list-group-alternate"> 
							<a href="#" class="list-group-item"><span class="badge">201</span> <i class="ti ti-email"></i> Inbox </a> 
							<a href="#" class="list-group-item"><span class="badge badge-primary">5021</span> <i class="ti ti-eye"></i> Profile visits </a> 
							<a href="#" class="list-group-item"><span class="badge">14</span> <i class="ti ti-headphone-alt"></i> Call </a> 
							<a href="#" class="list-group-item"><span class="badge">20</span> <i class="ti ti-comments"></i> Messages </a> 
							<a href="#" class="list-group-item"><span class="badge badge-warning">14</span> <i class="ti ti-bookmark"></i> Bookmarks </a> 
							<a href="#" class="list-group-item"><span class="badge badge-danger">30</span> <i class="ti ti-bell"></i> Notifications </a> 
						</div>
				   </div>
				   <div class="clearfix"> </div>
				   </div>
				 </div>
				 <div class="grid_3 grid_5">
					 <h3 class="head-top">Tabs</h3>
					 <div class="but_list">
					   <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
						<ul id="myTab" class="nav nav-tabs" role="tablist">
						  <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a></li>
						  <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">Profile</a></li>
						  <li role="presentation" class="dropdown">
							<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
							  <li><a href="#dropdown1" tabindex="-1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1">@fat</a></li>
							  <li><a href="#dropdown2" tabindex="-1" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2">@mdo</a></li>
							</ul>
						  </li>
						</ul>
					<div id="myTabContent" class="tab-content">
					  <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
						<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					  </div>
					  <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
						<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
					  </div>
					  <div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
						<p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
					  </div>
					  <div role="tabpanel" class="tab-pane fade" id="dropdown2" aria-labelledby="dropdown2-tab">
						<p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
					  </div>
					</div>
			   </div>
			   </div>
			  </div>
			  <div class="grid_3 grid_5">
				 <h3 class="head-top">Wells</h3>
				 <div class="but_list">
				   <div class="well">
					There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration
				   </div>
				   <div class="well">
					It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here
				   </div>
				   <div class="well">
					Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic
				   </div>
				 </div>
			  </div>  
 <div class="grid_3 grid_5">
				  <div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Focused Input</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" placeholder="Default Input">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block">Your help text!</p>
									</div>
								</div>
								<div class="form-group">
									<label for="disabledinput" class="col-sm-2 control-label">Disabled Input</label>
									<div class="col-sm-8">
										<input disabled="" type="text" class="form-control1" id="disabledinput" placeholder="Disabled Input">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-8">
										<input type="password" class="form-control1" id="inputPassword" placeholder="Password">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Checkbox</label>
									<div class="col-sm-8">
										<div class="checkbox-inline1"><label><input type="checkbox"> Unchecked</label></div>
										<div class="checkbox-inline1"><label><input type="checkbox" checked=""> Checked</label></div>
										<div class="checkbox-inline1"><label><input type="checkbox" disabled=""> Disabled Unchecked</label></div>
										<div class="checkbox-inline1"><label><input type="checkbox" disabled="" checked=""> Disabled Checked</label></div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Checkbox Inline</label>
									<div class="col-sm-8">
										<div class="checkbox-inline"><label><input type="checkbox"> Unchecked</label></div>
										<div class="checkbox-inline"><label><input type="checkbox" checked=""> Checked</label></div>
										<div class="checkbox-inline"><label><input type="checkbox" disabled=""> Disabled Unchecked</label></div>
										<div class="checkbox-inline"><label><input type="checkbox" disabled="" checked=""> Disabled Checked</label></div>
									</div>
								</div>
								<div class="form-group">
									<label for="selector1" class="col-sm-2 control-label">Dropdown Select</label>
									<div class="col-sm-8"><select name="selector1" id="selector1" class="form-control1">
										<option>Lorem ipsum dolor sit amet.</option>
										<option>Dolore, ab unde modi est!</option>
										<option>Illum, fuga minus sit eaque.</option>
										<option>Consequatur ducimus maiores voluptatum minima.</option>
									</select></div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Multiple Select</label>
									<div class="col-sm-8">
										<select multiple="" class="form-control1">
											<option>Option 1</option>
											<option>Option 2</option>
											<option>Option 3</option>
											<option>Option 4</option>
											<option>Option 5</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="txtarea1" class="col-sm-2 control-label">Textarea</label>
									<div class="col-sm-8"><textarea name="txtarea1" id="txtarea1" cols="50" rows="4" class="form-control1"></textarea></div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Radio</label>
									<div class="col-sm-8">
										<div class="radio block"><label><input type="radio"> Unchecked</label></div>
										<div class="radio block"><label><input type="radio" checked=""> Checked</label></div>
										<div class="radio block"><label><input type="radio" disabled=""> Disabled Unchecked</label></div>
										<div class="radio block"><label><input type="radio" disabled="" checked=""> Disabled Checked</label></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Radio Inline</label>
									<div class="col-sm-8">
										<div class="radio-inline"><label><input type="radio"> Unchecked</label></div>
										<div class="radio-inline"><label><input type="radio" checked=""> Checked</label></div>
										<div class="radio-inline"><label><input type="radio" disabled=""> Disabled Unchecked</label></div>
										<div class="radio-inline"><label><input type="radio" disabled="" checked=""> Disabled Checked</label></div>
									</div>
								</div>
								<div class="form-group">
									<label for="smallinput" class="col-sm-2 control-label label-input-sm">Small Input</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1 input-sm" id="smallinput" placeholder="Small Input">
									</div>
								</div>
								<div class="form-group">
									<label for="mediuminput" class="col-sm-2 control-label">Medium Input</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="mediuminput" placeholder="Medium Input">
									</div>
								</div>
								<div class="form-group mb-n">
									<label for="largeinput" class="col-sm-2 control-label label-input-lg">Large Input</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1 input-lg" id="largeinput" placeholder="Large Input">
									</div>
								</div>
							</form>
						</div>
					</div>			  
					</div>
				  </div>
		</div>	
		
	</div>
	</div>
	<!-- // Typography -->
	</div>
<!-- //main-content -->
	<!-- footer -->
    <footer>
        <!-- footer-top -->
        <div class="footer-top">
            <div class="container">
                <div class="col-md-4 footer-top-left">
                    <h3><a >iLive</a></h3>
                </div>
                <div class="col-md-4 footer-top-mid">
                    <h3>Our Program</h3>
                    <ul>
                        <li><a href="properties.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>主页</a></li>
                       
                        <li><a href="register.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>注册</a></li>
                        <li><a href="login.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>登录</a></li>

                    </ul>
                </div>
                <div class="col-md-4 footer-top-right">
                    <h3>Address</h3>
                    <address>
                        <ul>
                            <li>Hebut University</li>
                            <li>Telephone : 13820872310</li>
                            <li>Email : <a class="mail">1414499216@qq.com</a></li>
                        </ul>
                    </address>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //footer-top -->
        <div class="w3layouts-copyright">
            <p class="footer">Copyright &copy; 2018.iLive All rights reserved. </p>
        </div>
    </footer>
    <!-- //footer -->
</body>
</html>