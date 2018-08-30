<template>
  <div>
    <ul class="pagination">

      <li class="active"
          style="display:inline"
          v-for="n in todolistSize"
          v-on:click="move(n - 1)">
        <span class="page-link">
          {{n}}
        </span>
      </li>

    </ul>
  </div>
</template>

<script>
  export default {
    name: "Pagination",
    computed: {
      todolistSize() {
        return this.$store.getters['search/todoTotalPages']
      },
    },
    methods: {
      move(n) {
        this.$store.dispatch("search/moveList",  n)
      }
    }
  }
</script>

<style scoped>

</style>