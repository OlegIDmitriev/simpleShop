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

		    <div class="leftcontent">
                <h2 class="hello-title">${item.name}!</h2>

                <h3>${item.price}</h3>
                <h3>${item.price}</h3>

            </div>

        </div>

        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
        <script src="/js/main.js"></script>
</body>
</html>