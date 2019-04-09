var app = new Vue({
	el: '#app',
	data: {
		cartItems: [],
		types: []
	},

	methods: {
        getAllItems: function() {

        }
    },

	mounted() {
        axios.get('http://localhost:8080/cartitems')
                    .then(response => (this.cartItems = response.data));
    }
})