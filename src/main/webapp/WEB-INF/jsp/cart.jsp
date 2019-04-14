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

        <div id="app">

		<header-menu :count="itemInCart"></header-menu>
		<div class="leftcontent">
                <div class="container">
                    <h2 >Your Cart</h2>
                </div>
               <div class="container">
            
                    <section id="cart"> 
                        <article v-for="cartItem in cartItems" :key="cartItem.id" class="cart-product">
                            <header>
                                <a class="remove">
                                    <img :src="cartItem.item.imageUrl" :alt="cartItem.item.name">
                                </a>
                            </header>
            
                            <div class="cart-content">
                                <h1>{{ cartItem.item.name }}</h1>
                                Some description
                                <span @click="removeFromCart(cartItem.id)" class="remove-span">X</span>
                            </div>
            
                            <footer class="cart-content">
                                <span @click="decQuantity(cartItem.id)" :class="{'qt-minus': true, 'disabled' : cartItem.quantity <= 1}">-</span>
                                <span class="qt" >{{ cartItem.quantity }}</span>
                                <span @click="incQuantity(cartItem.id)" class="qt-plus">+</span>
            
                                <h2 class="full-price">{{ '$' + getMultiple(cartItem.item.price, cartItem.quantity) }}</h2>
                                <h2 class="price">{{ '$' + cartItem.item.price }}</h2>
                            </footer>
                        </article>
                    </section>
                </div>

            <footer id="site-footer">
                    <div class="container clearfix">

                        <div class="left">
                            <h2 class="subtotal">Subtotal: <span>163.96</span>$</h2>
                            <h3 class="tax">Taxes (5%): <span>8.2</span>$</h3>
                            <h3 class="shipping">Shipping: <span>5.00</span>$</h3>
                        </div>

                        <div class="right">
                            <h1 class="total">Total: <span>177.16</span>$</h1>
                            <a class="btn">Checkout</a>
                        </div>

                    </div>
            </footer>
        </div>
        </div>

		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="/js/cart.js"></script>

    </body>
</html>