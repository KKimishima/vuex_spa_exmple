<template>
  <div id="app">
    <my-header/>

    <div class="container">
      <router-view/>
    </div>

    <my-footer/>
  </div>
</template>

<script>
  import MyHeader from "./view/layouts/MyHeader";
  import MyFooter from "./view/layouts/MyFooter";

  export default {
    name: "App",
    components: {MyFooter, MyHeader},
  }
</script>

<style scoped>

</style>