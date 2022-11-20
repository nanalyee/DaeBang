import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http";

// module import
import createPersistedState from "vuex-persistedstate";
import memberStore from "@/store/modules/memberStore";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    // commercial district : 상권
    cd: {
      market: "",
      convenience: "",
      subway: "",
      bank: "",
      food: "",
      hospital: "",
      cafe: "",
      pharmacy: "",
    },
    guguns: [{ value: null, text: "선택하세요" }],
    houses: [],
    house: null,
    date: null,
    type: null,
    count: 0,
    houseimg: "",
    origin: null,
    destination: "127.29841486828657,36.35533690583481",
    trafficinfo: [],
    avgspeed: null,
    avgstate: null,
    timetaken: null,
    businfo: null,
  },
  getters: {
    // 평균 속도와 교통상태를 가공해보자,,,,,,,,,,,,,,,
    getAvgSpeed(state) {
      var road = state.trafficinfo.sections[0].roads;
      //console.log(road);
      var sum_speed = 0;
      var sum_dis = 0;
      for (var i = 0; i < road.length; i++) {
        sum_speed += road[i].traffic_speed * road[i].distance;
        sum_dis += road[i].distance;
      }
      var avg_speed = sum_speed / sum_dis;
      //console.log(avg_speed);
      //state.avgspeed = avg_speed;
      return avg_speed.toFixed(2);
    },
    getAvgState(state) {
      var road = state.trafficinfo.sections[0].roads;
      var default_state = 4;
      for (var i = 0; i < road.length; i++) {
        if (parseInt(road[i].traffic_state) == 0) {
          continue;
        }
        default_state = Math.min(default_state, road[i].traffic_state);
      }
      var res_state;
      if (default_state == 0) {
        res_state = "교통 정보 없음";
      } else if (default_state == 1) {
        res_state = "정체";
      } else if (default_state == 2) {
        res_state = "지체";
      } else if (default_state == 3) {
        res_state = "서행";
      } else if (default_state == 4) {
        res_state = "원활";
      }
      //state.avgstate = default_state;
      return res_state;
    },
    getTimeTaken(state) {
      var hour = parseInt(state.timetaken / 3600);
      var min = parseInt((state.timetaken % 3600) / 60);
      var sec = state.timetaken % 60;
      var res = 0;
      if (hour >= 1) {
        res = hour + "시간 " + min + "분 " + sec + "초";
      } else {
        res = min + "분 " + sec + "초";
      }
      //state.avgstate = default_state;
      return res;
    },
  },
  mutations: {
    ///////////// get House Type ///////////////
    SET_HOUSE_TYPE(state, payload) {
      state.type = payload;
      //console.log("타입 지정해줄거야");
      //console.log(state.type);
    },

    SET_DATE_TYPE(state, payload) {
      state.date = payload;
      //console.log("거래연월 지정해줄거야");
      //console.log(state.type);
    },

    SET_COUNT(state, count) {
      state.count = count;
    },

    CLEAR_HOUSE_TYPE(state) {
      state.type = null;
    },

    ////////////////// kakao img setting ///////////////////
    SET_TITLE_IMAGE(state, img) {
      state.houseimg = img;
    },
    ////////////////// 교통 상황 출발지 목적지 변수 ///////////////////
    SET_ORIGIN(state, origin) {
      state.origin = origin;
    },
    SET_DESTINATION(state, destination) {
      state.destination = destination;
    },
    SET_TRAFFIC_INFO(state, info) {
      state.trafficinfo = info;
    },
    SET_TIME_TAKEN(state, timetaken) {
      state.timetaken = timetaken;
    },
    /////////////////////////////// House start /////////////////////////////////////
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },

    CLEAR_APT_LIST(state) {
      state.houses = [];
      state.house = null;
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE(state, house) {
      // console.log("Mutations", house);
      state.house = house;
    },
    /////////////////////////////// House end /////////////////////////////////////
  },
  actions: {
    /////////////////////////////// House start /////////////////////////////////////
    getHouseList({ state, commit }, gugunCode) {
      //commit("SET_GUGUN_LIST", gugunCode);
      //console.log("구군코드랑 타입 출력");
      //console.log(gugunCode);
      console.log("거래연월 출력");
      console.log(state.date);

      const params = {
        //ex)aptlist, studio, one ,two
        HOUSE_TYPE: state.type,
        LAWD_CD: gugunCode,
        DEAL_YMD: state.date,
      };
      http
        .get(`/map/${params.HOUSE_TYPE}/${params.LAWD_CD}/${params.DEAL_YMD}`)
        .then(({ data }) => {
          //console.log(commit, data);
          //console.log(data);
          commit("SET_COUNT", data.response.body.totalCount);
          console.log(state.count);
          commit("SET_HOUSE_LIST", data.response.body.items.item);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    //////////// kakao img api //////////////////////
    getTitleImg({ commit }, title) {
      console.log(title);
      http
        .get(`/map/searchimg/${title}`)
        .then(({ data }) => {
          //console.log(commit, response);
          console.log(data.documents[0].thumbnail_url);
          commit("SET_TITLE_IMAGE", data.documents[0].thumbnail_url);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    ///////////////////// 교통 상황 api /////////////////////////
    getTrafficState({ state, commit }) {
      const params = {
        ORIGIN: state.origin,
        DESTINATION: state.destination,
      };
      console.log(params.ORIGIN);
      console.log(params.DESTINATION);
      http
        .get(`/traffic/searchroad/${params.ORIGIN}/${params.DESTINATION}`)
        .then(({ data }) => {
          //console.log(commit, data);
          //console.log(data.routes[0].summary.distance);
          commit("SET_TRAFFIC_INFO", data.routes[0]);
          commit("SET_TIME_TAKEN", data.routes[0].summary.duration);
        })
        .catch((error) => {
          console.log(error);
        });

      //this.getAvgSpeed;
      //this.getAvgState;
      //console.log(state.avgspeed);
      //console.log(state.avgstate);
    },

    ///////////////////집상세?/////////////////////
    detailHouse({ commit }, house) {
      // 나중에 house.일련번호를 이용하여 API 호출
      // console.log(commit, house);
      commit("SET_DETAIL_HOUSE", house);
    },
    /////////////////////////////// House end /////////////////////////////////////
  },
  modules: {
    memberStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});
