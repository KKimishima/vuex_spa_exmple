import Axios from "axios";

export default {
  namespaced: true,
  state: {
    title: "",
    describe: "",
    progressId: "",
    limitDate: "",
    limitTime: "",
    userId: "",
    progressList: {}

  },
  getters: {
    getTitle(state) {
      return state.title
    },
    getDescribe(state) {
      return state.describe
    },
    getProgressId(state) {
      return state.progressId
    },
    getLimitDate(state) {
      return state.limitDate
    },
    getLimitTime(state) {
      return state.limitTime
    },
    getUserId(state) {
      return state.userId
    },
    getProgressList(state) {
      return state.progressList
    }
  },
  mutations: {
    setTitle(state, data) {
      state.title = data
    },
    setDescribe(state, data) {
      state.describe = data
    },
    setProgressId(state, data) {
      state.progressId = data
    },
    setLimitDate(state, data) {
      state.limitDate = data
    },
    setLimitTime(state, data) {
      state.limitTime = data
    },
    setUserId(state, data) {
      state.userId = data
    },
    setProgressList(state, data) {
      state.progressList = data
    }
  },
  actions: {
    initProgressList({commit}) {
      Axios.get("/api/todolist/ProgressList").then(function (res) {
        commit("setProgressList", res.data)
      })
    },
    actionGetUserId({commit}){
      Axios.get("/api/todolist/userid").then(()=>{
        commit("setUserId",res.data)
      })
    }
  }
}