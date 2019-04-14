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
		products: [],
		types: [],
		errors: [],
		itemInCart: 0
	},

	methods: {
        getAllItems: function() {
            axios.get('http://localhost:8080/items/all')
            .then(response => (this.products = response.data))
            .catch(e => (this.errors.push(e)))

            console.log('getAllItems() was called!');
        },
        getItemsByCategory: function(category) {
            axios.get('http://localhost:8080/items/category?id=' + category)
            .then(response => (this.products = response.data))
            .catch(e => (this.errors.push(e)))

            console.log('getItemsByCategory() was called!');
        },

        addItemInCart: function(itemId){
            axios.put('http://localhost:8080/cart/add?id=' + itemId)
            .then(response => (this.getItemCountInCart()))
            .catch(e => (this.errors.push(e)))
        },

        getItemCountInCart: function(){
            axios.get('http://localhost:8080/cart/count')
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



