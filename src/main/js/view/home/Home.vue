<template>
  <div>
    <div class="card">
      <div class="card-header">
        <h3>todolist一覧</h3>
      </div>

      <div class="card-body">
        <h5 class="card-title">一覧テーブル</h5>
        <router-link to="/New" class="btn-outline-primary btn" role="button">
          新規作成
        </router-link>
        <button type="button" class="btn-outline-primary btn" data-toggle="collapse" data-target="#todo-list-search"
                aria-expanded="false" aria-controls="todo-list-search">
          検索条件
        </button>

        <div class="collapse" id="todo-list-search">
          <SearchForm/>
        </div>

        <DataTable/>

        <Pagination/>

      </div>
    </div>
  </div>
</template>

<script>
  import SearchForm from "./SearchForm";
  import DataTable from "./DataTable";
  import Pagination from "./Pagination";


  export default {
    components: {Pagination, DataTable, SearchForm}
  }
</script>