var app = new Vue({
	el: '#app',
	data: {
		products: [],
		types: ['Apple', 'Orange', 'Watermelon', 'Lemon', 'Lime', 'Banana', 'Pineapple']
	},
	mounted() {
        axios.get('http://localhost:8080/items')
          .then(response => (this.products = response.data));
      }
})



