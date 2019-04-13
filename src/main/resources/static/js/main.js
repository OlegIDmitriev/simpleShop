var app = new Vue({
	el: '#app',
	data: {
		products: [],
		types: [],
		errors: [],
		itemInCart: 0
	},

	methods: {
        getAllItems: function() {
            axios.get('http://localhost:8080/items')
            .then(response => (this.products = response.data))
            .catch(e => (this.errors.push(e)))

            console.log('getAllItems() was called!');
        },
        getItemsByCategory: function(category) {
            axios.get('http://localhost:8080/itemscat?category=' + category)
            .then(response => (this.products = response.data))
            .catch(e => (this.errors.push(e)))

            console.log('getItemsByCategory() was called!');
        },

        addItemInCart: function(itemId){
            axios.put('http://localhost:8080/additem?id=' + itemId)
            .then(this.getItemCountInCart())
            .catch(e => (this.errors.push(e)))
        },

        getItemCountInCart: function(){
            axios.get('http://localhost:8080/cartcount')
            .then(response => (this.itemInCart = response.data))
            .catch(e => (this.errors.push(e)))
        }
	},

	mounted() {
        this.getAllItems();
        this.getItemCountInCart();

          axios.get('http://localhost:8080/categories')
            .then(response => (this.types = response.data))
          .catch(e => (this.errors.push(e)))

      }
})



