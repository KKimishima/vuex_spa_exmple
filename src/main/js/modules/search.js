import Axios from "axios";

export default {
  namespaced: true,
  state: {
    todolist: {},
    progressList: {},
    searchTitle: "",
    searchDescribe: "",
    searchProgressId: "",
    searchMinDate: "",
    searchMaxDate: "",
  },
  getters: {
    todolist(state) {
      return state.todolist.content
    },
    todoTotalPages(state) {
      return state.todolist.totalPages
    },
    todoTotalElements(state) {
      return state.todolist.totalElements
    },
    todoPageSize(state) {
      return state.todolist.size
    },
    todoCurrentPageNumber(state) {
      return state.todolist.number
    },
    progressList(state) {
      return state.progressList
    },
    searchTitle(state) {
      return state.searchTitle
    },
    searchDescribe(state) {
      return state.searchDescribe
    },
    searchProgressId(state) {
      return state.searchProgressId
    },
    searchMinDate(state) {
      return state.searchMinDate
    },
    searchMaxDate(state) {
      return state.searchMaxDate
    },
  },
  mutations: {
    mutationTodoList(state, data) {
      state.todolist = data
    },
    mutationTodoListMove(state, data) {
      state.todolist = data
    },
    mutationProgressList(state, data) {
      state.progressList = data
    },
    mutationSearchTitle(state, data) {
      state.searchTitle = data
    },
    mutationSearchDescribe(state, data) {
      state.searchDescribe = data
    },
    mutationSearchProgressId(state, data) {
      state.searchProgressId = data
    },
    mutationSearchMinDate(state, data) {
      state.searchMinDate = data
    },
    mutationSearchMaxDate(state, data) {
      state.searchMaxDate = data
    },
    mutationSearchClear(state) {
      state.searchTitle = ""
      state.searchDescribe = ""
      state.searchProgressId = ""
      state.searchMinDate = ""
      state.searchMaxDate = ""
    },
  },
  actions: {
    initList({commit}) {
      Axios.get("/api/todolist").then(function (res) {
        commit("mutationTodoList", res.data)
      })
    },
    initProgressList({commit}) {
      Axios.get("/api/todolist/ProgressList").then(function (res) {
        commit("mutationProgressList", res.data)
      })
    },
    moveList({commit, state}, data) {
      Axios.get(`/api/todolist`, {
        params: {
          title: state.searchTitle,
          describe: state.searchDescribe,
          progressId: state.searchProgressId,
          minDate: state.searchMinDate,
          maxDate: state.searchMaxDate,
          page: data
        }
      }).then(function (res) {
        commit("mutationTodoList", res.data)
      })
    },
    searchList({commit, state}) {
      Axios.get(`/api/todolist`, {
        params: {
          title: state.searchTitle,
          describe: state.searchDescribe,
          progressId: state.searchProgressId,
          minDate: state.searchMinDate,
          maxDate: state.searchMaxDate,
        }
      }).then(function (res) {
        commit("mutationTodoList", res.data)
      })
    },
    setSearchTitle({commit}, data) {
      commit("mutationSearchTitle", data)
    },
    setSearchDescribe({commit}, data) {
      commit("mutationSearchDescribe", data)
    },
    setSearchProgressId({commit}, data) {
      commit("mutationSearchProgressId", data)
    },
    setSearchMinDate({commit}, data) {
      commit("mutationSearchMinDate", data)
    },
    setSearchMaxDate({commit}, data) {
      commit("mutationSearchMaxDate", data)
    },
  }
}

