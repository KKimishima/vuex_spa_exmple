<template>
  <div>
    <p>
      {{todoTotalElements}}件ヒット!!
    </p>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">タイトル</th>
        <th scope="col">進行状態</th>
        <th scope="col">担当者</th>
        <th scope="col">期限日時</th>
        <th scope="col">期限日時</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="list in todolist" v-bind:id="list.id">
        <th scope="row">{{list.id}}</th>
        <td>{{list.title}}</td>
        <td>{{list.todoProgress.progressName}}</td>
        <td>{{list.users.name}}</td>
        <td>{{list.limitDate}}</td>
        <td>{{list.limitTime}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  export default {
    name: "DataTable",
    computed: {
      todolist() {
        return this.$store.getters['search/todolist']
      },
      todoTotalElements() {
        return this.$store.getters['search/todoTotalElements']
      },
    },
    created() {
      this.$store.dispatch("search/initList")
    },
  }
</script>

<style scoped>

</style>