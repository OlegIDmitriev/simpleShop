<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Fresh fruits</title>
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>

	    <div id="app">

		    <header-menu :count="itemInCart"></header-menu>

			<div class="sidenav">
			    <a href="#" v-on:click="getAllItems">All fruits</a>
				<a v-for="type in types" href="#" v-on:click="getItemsByCategory(type.id)">{{ type.name }}</a>
			</div>
			
			<div class="content">
				<div class="product-list">
					<div v-for="product in products" class="product">
					    <a :href="'/item?id=' + product.id">
						    <img :src="product.imageUrl" :alt="product.name">
						</a>
						<h1 class="product-name">{{ product.name }}</h1>
						<p class="price">{{ '$' + product.price }}</p>
						<p><button @click="addItemInCart(product.id)">Add to Cart</button></p>
					</div>
				</div>
			</div>
			
	    </div>

		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="/js/main.js"></script>

	</body>
</html>	