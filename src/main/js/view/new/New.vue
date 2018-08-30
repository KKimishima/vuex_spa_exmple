<template>
  <div class="card">
    <div class="card-header">
      <h3>todo新規作成</h3>
    </div>
    <div class="card-body">
      <edit-form/>
    </div>
    <transition name="fade">
      <router-link to="/" class="btn-primary btn" role="button">
        戻る
      </router-link>
    </transition>
  </div>
</template>

<script>
  import EditForm from "../layouts/EditForm";

  export default {
    name: "New",
    components: {EditForm}
  }
</script>

<style scoped>

</style>