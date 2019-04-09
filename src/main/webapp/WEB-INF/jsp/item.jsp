<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Fresh fruits</title>
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>

		<div class="header sticky navbar">
		    <div class="float-left">
		        <a href="/"><i class="fa fa-fw fa-home"></i> Home</a>
                <a href="#"><i class="fa fa-fw fa-search"></i> Search</a>
                <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a>
            </div>
            <div class="float-right" >
                <a href="#"><i class="fa fa-fw fa-user"></i> Login</a>
                <a href="/cart" class="cart-font"><i class="fa fa-fw fa-shopping-cart"></i> | 9+</a>
            </div>

		</div>
		<div class="leftcontent">
            <h2 class="hello-title">${item.name}!</h2>

            <h3>${item.price}</h3>
            <h3>${item.price}</h3>

        </div>

        <script src="/js/item.js"></script>
</body>
</html>