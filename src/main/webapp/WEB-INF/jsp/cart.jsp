<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Fresh fruits</title>
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="stylesheet" type="text/css" href="/css/cart.css">
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
        <div id="app" class="leftcontent">
            <h2>Your Cart</h2>
            <div class="table">
            	<div class="layout-inline row th">
            		<div class="col col-pro">Product</div>
                    <div class="col col-price align-center ">Price</div>
                    <div class="col col-qty align-center">QTY</div>
            	</div>

            	<div v-for="cartItem in cartItems" class="layout-inline row">
            		<div class="col col-pro layout-inline">
            			<img :src="cartItem.item.imageUrl" :alt="cartItem.item.name" />
            				<p>{{ cartItem.item.name }}</p>
                    </div>
            		<div class="col col-price col-numeric align-center ">
                      <p>{{ '$' + cartItem.item.price }}</p>
                    </div>
            		<div class="col col-qty layout-inline">
            			<a href="#" class="qty qty-minus">-</a>
            				<input type="numeric" value="3" />
            			<a href="#" class="qty qty-plus">+</a>
                    </div>
            	</div>
            </div>
        </div>

		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="/js/cart.js"></script>

    </body>
</html>