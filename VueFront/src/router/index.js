import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "@/views/MainView.vue";
import SearchView from "@/views/SearchView.vue";
import DetailView from "@/views/DetailView.vue";
import TrafficView from "@/views/TrafficView.vue";

import LiveView from "@/views/traffic/LiveView.vue";
import DaejeonStationView from "@/views/traffic/live/DaejeonStationView.vue";
import YuseongStationView from "@/views/traffic/live/YuseongStationView.vue";
import NoeunStationView from "@/views/traffic/live/NoeunStationView.vue";
import HanbatUnivView from "@/views/traffic/live/HanbatUnivView.vue";
import BusView from "@/views/traffic/BusView.vue";
import TrainView from "@/views/traffic/TrainView.vue";
import BicycleView from "@/views/traffic/BicycleView.vue";
// import HomeView from "@/views/LoiginView.vue";
// import HomeView from "@/views/RegistView.vue";

import AptListView from "@/views/house/AptListView.vue";
import RoomListView from "@/views/house/RoomListView.vue";
import OfficeListView from "@/views/house/OfficeListView.vue";
import MansionListView from "@/views/house/MansionListView.vue";

import KakaoMapView from "@/components/detail/KakaoMapView.vue";
import NearListView from "@/components/detail/NearListView.vue";

import store from "@/store";

Vue.use(VueRouter);

// jwt 로그인
// https://v3.router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const checkToken = store.getters["memberStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("memberStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "login" });
    router.push({ name: "login" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "main",
    component: MainView,
  },
  {
    path: "/search",
    name: "search",
    component: SearchView,
    children: [
      {
        path: "apt",
        name: "searchApt",
        component: AptListView,
      },
      {
        path: "room",
        name: "searchRoom",
        component: RoomListView,
      },
      {
        path: "office",
        name: "searchOffice",
        component: OfficeListView,
      },
      {
        path: "mansion",
        name: "searchMansion",
        component: MansionListView,
      },
    ],
  },
  {
    path: "/detail",
    name: "detail",
    component: DetailView,
    children: [
      {
        path: "kakaoMap",
        name: "kakaoMap",
        component: KakaoMapView,
      },
      {
        path: "nearList",
        name: "nearList",
        component: NearListView,
      },
    ],
  },
  {
    path: "/traffic",
    name: "traffic",
    component: TrafficView,
    redirect: "/traffic/live/daejeonStation",
    children: [
      {
        path: "live",
        name: "trafficLive",
        component: LiveView,
        children: [
          {
            path: "daejeonStation",
            name: "daejeonStation",
            component: DaejeonStationView,
          },
          {
            path: "yuseongStation",
            name: "yuseongStation",
            component: YuseongStationView,
          },
          {
            path: "noeunStation",
            name: "noeunStation",
            component: NoeunStationView,
          },
          {
            path: "hanbatUniv",
            name: "hanbatUniv",
            component: HanbatUnivView,
          },
        ],
      },
      {
        path: "bus",
        name: "trafficBus",
        component: BusView,
      },
      {
        path: "train",
        name: "trafficTrain",
        component: TrainView,
      },
      {
        path: "bicycle",
        name: "trafficBicycle",
        component: BicycleView,
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser"),
    children: [
      {
        path: "join",
        name: "join",
        component: () => import("@/components/user/UserRegister"),
      },
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/UserLogin"),
      },
      {
        path: "mypage",
        name: "mypage",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/UserMyPage"),
      },
      {
        path: "modify",
        name: "modify",
        component: () => import("@/components/user/UserModify"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
