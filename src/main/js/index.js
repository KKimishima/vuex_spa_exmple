import './css/common.css'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import Vue from "vue"
import VueRouter from 'vue-router';
import routes from "./router"
import store from "./store"
import App from "./App"

import Axios from "axios"



Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  base: '/spa/',
  routes: routes
});

// if (window.location.pathname === "/spa") {
document.addEventListener("DOMContentLoaded", function () {
  new Vue({
    el: "#app",
    router,
    store,
    render: h => h(App)
  })
})

