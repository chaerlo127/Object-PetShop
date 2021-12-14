<template>
 <v-data-table
    :headers="headers"
    :items="cartItems"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
</template>


<script>

const axios = require('axios').default; // axios 라이브러리 사용

export default {
  name: 'Cart', //public class Cart()
  components: {
  },

 data: () => ({
   headers: [
      { text: '이름', value: 'petDetail.name' }, // text: table의 column 이름 value: backend의 pet name
      { text: '활동성', value: 'petDetail.energy' }, // text: table의 column 이름 value: backend의 pet energy
      { text: '외모', value: 'petDetail.appearance' }, // text: table의 column 이름 value: backend의 pet appearance
      { text: '결제방법', value: 'payment.method' }, // text: table의 column 이름 value: backend의 payment method
      { text: '결제상태', value: 'payment.status' }, // text: table의 column 이름 value: backend의 payment status
   ],

   cartItems: [],
   showCart: false //showCart method 기본 값 false
     
    }),
    created(){//생성자의 역할
    this.init();
    },

    methods:{

      showCart(){
        this.showCart = true; //showCart button click하면 true
      },
      async init(){
        const response = await axios.get("/cartItems"); //backend 에서 cartItems 도메인 값 불러오기
        this.cartItems = response.data._embedded.cartItems; 
        this.cartItems.forEach(async cartItem => {
          const response = await axios.get(new URL(cartItem._links.pet.href).pathname); //backend에서 cartItem에 있는 pet의 pathname 불러오기
          cartItem.petDetail = response.data;
        })
      },
    }

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
