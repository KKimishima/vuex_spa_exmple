<template>
  <div>
    <header class="sticky-top">
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <router-link to="/" class="navbar-brand d-flex align-items-center">
            <strong>TodoListデモアプリ!!!SPAモード</strong>
          </router-link>
        </div>
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">クラシックモード <span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>

    </header>
  </div>

</template>

<script>
  export default {
    name: "my-header"
  }
</script>

<style scoped>

</style>