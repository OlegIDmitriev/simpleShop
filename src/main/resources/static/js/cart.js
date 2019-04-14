Vue.component('header-menu', {
  props: ['count'],
  template: `
    <div class="header sticky navbar">
    	<div class="float-left">
    		        <a href="/"><i class="fa fa-fw fa-home"></i> Home</a>
                    <a href="#"><i class="fa fa-fw fa-search"></i> Search</a>
                    <a href="/info"><i class="fa fa-fw fa-envelope"></i> Contact</a>
         </div>
         <div class="float-right" >
          <a href="#"><i class="fa fa-fw fa-user"></i> Login</a>
          <a href="/cart" :class="{'cart-font' : count}"><i class="fa fa-fw fa-shopping-cart"></i> | {{ count }}</a>
        </div>
    </div>
  `
})

var app = new Vue({
	el: '#app',
	data: {
		cartItems: [],
		errors: [],
		itemInCart: 0,
		totalPrice: 0
	},

	methods: {
        removeFromCart: function(cartItemId) {
            axios.delete('http://localhost:8080/cart/delete?cartItemId=' + cartItemId)
            .then(response => (
                this.getCartItems(),
                this.getItemCountInCart(),
                this.getTotalPrice()
            ))
            .catch(e => (this.errors.push(e)))
        },

        incQuantity: function(cartItemId) {
            axios.post('http://localhost:8080/cart/inc', {
                cartItemId: cartItemId
            })
            .then(response => (
                this.getCartItems(),
                this.getTotalPrice()
            ))
            .catch(e => (this.errors.push(e)))
        },

        decQuantity: function(cartItemId, currentQuantity) {
            if(currentQuantity <=1){
                return;
            }

            axios.post('http://localhost:8080/cart/dec', {
                cartItemId: cartItemId
            })
            .then(response => (
                this.getCartItems(),
                this.getTotalPrice()
            ))
            .catch(e => (this.errors.push(e)))
        },

        getItemCountInCart: function(){
           axios.get('http://localhost:8080/cart/count')
           .then(response => (this.itemInCart = response.data))
           .catch(e => (this.errors.push(e)))
        },


        getCartItems: function(){
           axios.get('http://localhost:8080/cart/items')
           .then(response => (this.cartItems = response.data))
           .catch(e => (this.errors.push(e)))
        },

        getTotalPrice: function(){
           axios.get('http://localhost:8080/cart/price')
           .then(response => (this.totalPrice = response.data))
           .catch(e => (this.errors.push(e)))
        },

        getMultiple: function(var1, var2) {
            var multiple = var1 * var2;

            return multiple.toFixed(2);
        }
    },

	mounted() {
	    this.getItemCountInCart();

        this.getCartItems();

        this.getTotalPrice();
    }
})