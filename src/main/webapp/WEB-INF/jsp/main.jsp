<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Fresh fruits</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
	
		<header>
			<span class="header-phone">8 800 777 00 00</span>
			<a href="/" class="main-page">Start page</a>
			<div class="header-menu">
				<button class="header-search">
					<span class="hidden-mob">Search</span>
				</button>
				<a href="/personal/" title="Personal cabinet" class="header-personal">
					<span class="hidden-mob">Personal cabinet</span>
				</a>
				<a href="/cart/" title="Basket" class="header-basket">
					<span class="hidden-mob">Basket</span>&nbsp;<span class="basketNum" id="basketNum">- 0</span>
				</a>
			</div>
		</header>
		
		<p></p>
		
		<div id="app">
			<div class="left-column">
				<div class="left-navigation">
					<ul>
						<li v-for="type in types">{{ type }}</li>
					</ul>
				</div>
			</div>
			
			<div class="right-column">
				<div class="product-list">
					<div v-for="product in products" class="product">
						<div class="product-image">
							<img :src="product.imageUrl">
						</div>
						<div class="product-name">{{ product.name }}</div>
						<div class="product-price">{{ product.price }}</div>
					</div>
				</div>
			</div>
			
		</div>

		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="/js/main.js"></script>

	</body>
</html>	