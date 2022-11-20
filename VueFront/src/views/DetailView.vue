<template>
  <div class="box p-0 m-0">
    <div class="container mt-5 mb-3">
      <div class="row justify-content-between">
        <div class="col">
          <a v-if="check() == false && userInfo" class="fs-4 pe-3 like" @click="like"
            ><i id="heart" class="bi bi-heart"></i
          ></a>
          <a v-else-if="userInfo" class="fs-4 pe-3 like" @click="like"
            ><i id="heart" class="bi bi-heart-fill"></i
          ></a>
          <h3 style="display: inline-block; color: #6b799e">{{ wishname }} {{ wishtype }}</h3>
          <h4 style="display: inline-block">&nbsp;&nbsp;주변 상권 정보</h4>
        </div>
        <div class="col text-lg-end text-center">
          <button type="button" class="btn bg-white mx-4" @click="goBack" style="color: #6b799e">
            매매검색으로 돌아가기
          </button>
        </div>
      </div>
      <div class="row">
        <kakao-map-view></kakao-map-view>
        <!-- <div class="col-6"><near-list-view></near-list-view></div> -->
      </div>
    </div>
  </div>
</template>

<script>
//import http from "@/util/http"; // 게시판 테스트용

import KakaoMapView from "../components/detail/KakaoMapView.vue";
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";

export default {
  name: "appDetail",
  components: { KakaoMapView },
  data() {
    return {
      wishname: this.$route.params.wishname,
      wishtype: this.$route.params.wishtype,
      gugunname: this.$route.params.gugunname,
      dongname: this.$route.params.dongname,
      lat: this.$route.params.lat,
      lng: this.$route.params.lng,
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    check() {
      console.log(this.wishname + "가 관심지역에 포함되어있는지 DB검사를 진행합니다.");
      console.log(this.wishname + "가 관심지역에 포함되어있으면 true를 반환합니다.");
      return false;
    },
    like() {
      let heart = document.getElementById("heart");
      let status = heart.getAttribute("class");
      if (status == "bi bi-heart") {
        document.getElementById("heart").setAttribute("class", "bi bi-heart-fill");
        console.log(
          "관심지역에 해당 " + this.wishname + " 정보로 " + this.userInfo.userid + "에 추가합니다."
        );
        // http
        //   .post(`/해당경로`, {
        //     wishname: this.wishname,
        //     wishtype: this.wishtype,
        //     gugunname: this.gugunname,
        //     dongname: this.dongname,
        //     lat: this.lat,
        //     lng: this.lng,
        //     userid: this.userInfo.userid,
        //     // 등록시간은 spring에서 써야함
        //   })
        //   .then(({ data }) => {
        //     let msg = "관심 지역 등록 처리시 문제가 발생했습니다.";
        //     if (data === "success") {
        //       msg = "관심 지역 등록이 완료되었습니다.";
        //     }
        //     alert(msg);
        //   });
      } else {
        document.getElementById("heart").setAttribute("class", "bi bi-heart");
        console.log(
          "관심지역에 해당 " +
            this.wishname +
            " 정보로 " +
            this.userInfo.userid +
            "에서 삭제합니다."
        );
        // http
        //   .delete(`/해당경로`, {
        //     wishname: this.wishname,
        //     userid: this.userInfo.userid,
        //     // 등록시간은 spring에서 써야함
        //   })
        //   .then(({ data }) => {
        //     let msg = "관심 지역 삭제 처리시 문제가 발생했습니다.";
        //     if (data === "success") {
        //       msg = "관심 지역 삭제가 완료되었습니다.";
        //     }
        //     alert(msg);
        //   });
      }
    },
  },
};
</script>

<style scoped>
.box {
  width: 100vw;
  height: 100vh;
}
#map {
  z-index: 1;
}
.like:hover {
  color: red;
}
</style>
