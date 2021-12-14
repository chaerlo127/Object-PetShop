<template>
  <Pet v-model="value">
    <template v-slot:buttons>
    <v-btn
      outlined
      rounded
      text


    @click="groom"
    >
      그루밍하기
    </v-btn>
    </template>
  </Pet>
  

  
</template>

<script>
const axios = require('axios').default;
import Pet from './Pet'

  export default {
    name: 'Cat',

    components:{
      Pet
    },
    mixins: [Pet],


    methods:{
      // eat(){
      //   this.energy ++;
      // },

      // sleep(){
      //   this.energy ++;
      // },

      async groom(){ //await를 사용하기 위해 pet의 vue 파일이 아닌 직접 method 추가

        await axios.request({
          method: 'PUT', //api : put
          url: new URL(this.value._links.groom.href).pathname,//localhost:8080/cats
          headers: {'Content-Type': 'application/json'},
        });
        
         this.refresh();

        // this.value.appearance+=2;//외모지수 추가
        // this.$emit("change", this.value);//변경 값 저장
      }
    },


  }
</script>
