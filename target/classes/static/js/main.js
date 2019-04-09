var app = new Vue({
	el: '#app',
	data: {
		products: [],
		types: []
	},

	methods: {
        getAllItems: function() {
            axios.get('http://localhost:8080/items')
                .then(response => (this.products = response.data));

            console.log('getAllItems() was called!');
        },
        getItemsByCategory: function(category) {
            axios.get('http://localhost:8080/itemscat?category=' + category)
                .then(response => (this.products = response.data));

            console.log('getItemsByCategory() was called!');
        }
	},

	mounted() {
        this.getAllItems();

          axios.get('http://localhost:8080/categories')
                    .then(response => (this.types = response.data));
      }
})



