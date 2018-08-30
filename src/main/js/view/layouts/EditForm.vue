<template>
  <div>
    <div class="form-group">
      <label for="todo-title">タイトル</label>
      <input type="text"
             class="form-control"
             id="todo-title"
             placeholder="todoのタイトル"
             required name="title"
             v-model="title">
    </div>

    <div class="form-group">
      <label for="todo-describe">詳細説明</label>
      <textarea rows="5"
                class="form-control"
                id="todo-describe"
                placeholder="todoの説明"
                v-model="describe">
      </textarea>
    </div>

    <div class="form-group">
      <label for="todo-progress">進行状態</label>
      <select class="form-control"
              id="todo-progress"
              v-model="progressId">
        <option value="" selected="selected">-</option>
        <option v-for="list in progress"
                v-bind:key="list.id"
                v-bind:value="list.id">
          {{list.progressName}}
        </option>
      </select>
    </div>

    <div class="form-group">
      <label for="todo-limit-date">期限日程</label>
      <input class="form-control"
             id="todo-limit-date"
             type="date"
             v-model="limitDate">
    </div>

    <div class="form-group">
      <label for="todo-limit-time">期限日時</label>
      <input class="form-control"
             id="todo-limit-time"
             type="time"
             name="limitTime"
             v-model="limitTime">
    </div>


    <input type="hidden" v-model="">
    <input type="hidden" id="id" name="id" value="">

    <button id="on-click" type="submit" class="btn btn-primary">登録</button>
  </div>
</template>

<script>
  export default {
    name: "EditForm",
    created() {
      this.$store.dispatch("todo/initProgressList")
      this.$store.dispatch("todo/actionGetUserId")
    },
    computed: {
      progress() {
        return this.$store.getters['todo/getProgressList']
      },
      progressId: {
        get() {
          return this.$store.getters["todo/getProgressId"]
        },
        set(value) {
          this.$store.commit("todo/setProgressId", value)
        }
      },
      title: {
        get() {
          return this.$store.getters["todo/getTitle"]
        },
        set(value) {
          this.$store.commit("todo/setTitle", value)
        }
      },
      describe: {
        get() {
          return this.$store.getters["todo/getDescribe"]
        },
        set(value) {
          this.$store.commit("todo/setDescribe", value)
        },
      },
      limitDate: {
        get() {
          return this.$store.getters["todo/getLimitDate"]
        },
        set(value) {
          this.$store.commit("todo/setLimitDate", value)
        }
      },
      limitTime: {
        get() {
          return this.$store.getters["todo/getLimitTime"]
        },
        set(value) {
          this.$store.commit("todo/setLimitTime", value + ":00")
        }
      },
      userId: {
        get() {
          return this.$store.getters["todo/getUserId"]
        },
        set(value) {
          this.$store.commit("todo/setUserId", value)
        }
      }
    }
  }
</script>

<style scoped>

</style>