<template>
  <div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">タイトル</span>
      </div>
      <input type="text"
             class="form-control"
             v-model="searchTitle"
             placeholder="タイトル">
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">説明</span>
      </div>
      <input type="text"
             class="form-control"
             v-model="searchDescribe"
             placeholder="説明">
    </div>

    <div class="input-group ">
      <div class="input-group-prepend">
        <span class="input-group-text">期限日時</span>
      </div>
      <input class="form-control"
             type="date"
             v-model="searchMinDate">

      <div class="input-group-prepend">
        <span class="input-group-text">~</span>
      </div>
      <input class="form-control"
             type="date"
             v-model="searchMaxDate">
    </div>

    <div class="form-row">
      <div class="form-group col-md-4">
        <label for="todo-progress-search">進行状態</label>
        <select class="form-control"
                id="todo-progress-search"
                v-model="searchProgressId">
          <option value="" selected="selected">-</option>
          <option v-for="list in progress"
                  v-bind:key="list.id"
                  v-bind:value="list.id">
            {{list.progressName}}
          </option>
        </select>
      </div>

    </div>

    <button v-on:click="onSearch" type="submit" class="btn btn-primary">検索</button>
    <button v-on:click="onSearchClear" type="submit" class="btn btn-secondary">条件削除</button>
  </div>
</template>

<script>
  export default {
    name: "SearchForm",
    created() {
      this.$store.dispatch("search/initProgressList")
    },
    computed: {
      progress() {
        return this.$store.getters['search/progressList']
      },
      searchTitle: {
        get() {
          return this.$store.getters['search/searchTitle']
        },
        set(value) {
          this.$store.dispatch("search/setSearchTitle", value)
        }
      },
      searchDescribe: {
        get() {
          return this.$store.getters['search/searchDescribe']
        },
        set(value) {
          this.$store.dispatch("search/setSearchDescribe", value)
        }
      },
      searchProgressId: {
        get() {
          return this.$store.getters['search/searchProgressId']
        },
        set(value) {
          this.$store.dispatch("search/setSearchProgressId", value)
        }
      },
      searchMinDate: {
        get() {
          return this.$store.getters['search/searchMinDate']
        },
        set(value) {
          this.$store.dispatch("search/setSearchMinDate", value)
        }
      },
      searchMaxDate: {
        get() {
          return this.$store.getters['search/searchMaxDate']
        },
        set(value) {
          this.$store.dispatch("search/setSearchMaxDate", value)
        }
      }

    },
    methods: {
      onSearch() {
        this.$store.dispatch("search/searchList")
      },
      onSearchClear() {
        this.$store.commit("search/mutationSearchClear")
      }
    }
  }
</script>

<style scoped>

</style>