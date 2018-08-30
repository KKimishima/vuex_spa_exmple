import Vue from "vue"
import Vuex from "vuex"
import search from "./modules/search"
import todo from "./modules/todo"

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    search,
    todo
  }
})

export default store