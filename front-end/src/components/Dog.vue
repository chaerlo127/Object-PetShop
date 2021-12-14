<template>
  <Pet v-model="value"></Pet>
</template>

<script>

import Pet from './Pet' //Pet.vue import

  export default {
    name: 'Dog',

    components:{
      Pet
    },

    mixins: [Pet],



    methods:{//backend에서 method를 호출하여 사용 -> pet method 그대로 사용하여 energy 증가하고 , appearance 추가 안됨
    //즉, appearance 추가하려면 core backend에서 pet.java method 내부 attribute 변경
      // eat(){
      //   this.$super(Pet).eat();//pet에 있는 eat 그대로 추가
      // },

      // sleep(){
        
      //   this.$super(Pet).sleep();//pet에 있는 sleep 값 모두 추가
      //   this.value.appearance ++;//외모지수 추가
      //   this.$emit("change", this.value);//변경 값 저장
        
      // },

    },


  }
</script>
