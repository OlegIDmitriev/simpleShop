var app = new Vue({
	el: '#app',
	data: {
		cartItems: [],
		types: []
	},

	methods: {
        removeFromCart: function() {

        },

        incQuantity: function(itemId) {

        },

        decQuantity: function(itemId) {

        },
    },

	mounted() {
        axios.get('http://localhost:8080/cartitems')
                    .then(response => (this.cartItems = response.data));
    }
})