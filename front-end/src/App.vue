<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="grey darken-1"
          size="32"
        ></v-avatar>

        <v-btn

          href="/shop"
        >
         쇼핑몰
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addPet(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >

            <Pet @change="updatePet(pet)" 
            :is="pets[index].type" v-model="pets[index]" v-for="(pet, index) in pets" :key="index"></Pet>

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>
import Cat from './components/Cat'//Cat.vue import
import Dog from './components/Dog'//Dog.vue import
import Pet from './components/Pet.vue'//Pet.vue import
const axios = require('axios').default; //axios 문법 사용

export default {
  name: 'App', //public class App()
  components: {
    Cat,//import file : Cat.vue, Dog.vue, Pet.vue
    Dog,
    Pet
  },

 data: () => ({
      items: [
        '강아지', //강아지나 고양이 버튼을 누르면 자신이 원하는 반려동물이 생성
        '고양이'
      ],
      pets:[

      ]
     
    }),
    created(){//생성자의 역할
    this.init(); //method 호출
    },

    methods:{
      async init(){
        const response = await axios.get("/cats"); 
        
        this.pets = response.data._embedded.cats;
      },
      addPet(item){
        if(item=="강아지"){ //강아지 버튼을 누르면 type은 Dog, 이름은 멍멍이, energy는 1, appearance는 1로 기본 값 세팅
          this.pets.push(
            {
              type: 'Dog',
              name: '멍멍이',
              energy: 1,
              appearance: 1
            }
          );
        }else if (item=="고양이"){ //고양이 버튼을 누르면 type은 Cat, 이름은 야용이, energy는 1, appearance는 1로 기본 값 세팅
          this.pets.push(
            {
              type: 'Cat',
              name: '양용이',
              energy: 1,
              appearance: 1
            }
          );
        }

        axios.request({
          method: 'POST', //api : post
          url: '/cats', //localhost:8080/cats
          headers: {'Content-Type': 'application/json'}, 
          data: this.pets[this.pets.length -1]
        });
      },

      updatePet(pet){
          axios.request({
          method: 'PATCH', //api : patch
          url: new URL(pet._links.self.href).pathname, //localhost:8080/cats/__
          headers: {'Content-Type': 'application/json'},
          data: pet
        });
      }


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
