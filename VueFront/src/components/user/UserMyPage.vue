<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="d-flex justify-content-center">
      <h1 class="underline-steelblue py-4 my-4"><i class="bi bi-door-open-fill"></i>마이페이지</h1>

      <b-container class="mt-4 border m-2 p-2 bg-light rounded" style="max-width: 40rem">
        <h3 class="pt-3 m-3">{{ userInfo.userid }}님의 정보</h3>
        <b-row class="d-flex justify-content-center py-2">
          <b-col cols="2" class="text-center p-2 t-2 px-4">아이디</b-col
          ><b-col cols="6" class="text-start p-2 t-2 border rounded bg-white">{{ userInfo.userid }}</b-col>
        </b-row>
        <b-row class="d-flex justify-content-center py-2">
          <b-col cols="2" class="text-center p-2 t-2 px-4">이름</b-col
          ><b-col cols="6" class="text-start p-2 t-2 border rounded bg-white">{{ userInfo.username }}</b-col>
        </b-row>
        <b-row class="d-flex justify-content-center py-2">
          <b-col cols="2" class="text-center p-2 t-2 px-4">이메일</b-col
          ><b-col cols="6" class="text-start p-2 t-2 border rounded bg-white">{{ userInfo.email }}</b-col>
        </b-row>
        <b-row class="d-flex justify-content-center py-2">
          <b-col cols="2" class="text-center p-2 t-2 px-4">가입일</b-col
          ><b-col cols="6" class="text-start p-2 t-2 border rounded bg-white">{{ userInfo.joindate }}</b-col>
        </b-row>

        <b-row class="d-flex justify-content-center py-2">
          <b-col cols="4" class="text-center pr-0"
            ><router-link :to="{ name: 'modify' }" class="btn btn-primary mr-1" style="width: 100%"
              >정보수정</router-link
            ></b-col
          ><b-col cols="4" class="text-start pr-0"
            ><b-button variant="danger" href="#" @click="deleteMember" style="width: 100%">회원탈퇴</b-button></b-col
          >
        </b-row>

        <b-container class="mt-4" v-show="showWishModify">
          <hr />
          <h3 class="pt-4 m-3">{{ userInfo.userid }}님의 주변 상권 선호도</h3>

          <b-row class="d-flex justify-content-center py-2 align-items-center">
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #6dc0ff8c; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-shop"></i> 대형마트
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["market"] }}
            </b-col>
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #3fce9e8a; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-shop-window"></i> 편의점
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["convenience"] }}
            </b-col>
          </b-row>

          <b-row class="d-flex justify-content-center py-2 align-items-center">
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #ffc95da1; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-train-lightrail-front"></i> 지하철역
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["subway"] }}
            </b-col>
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #ed82928c; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-egg-fried"></i> 음식점
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["food"] }}
            </b-col>
          </b-row>

          <b-row class="d-flex justify-content-center py-2 align-items-center">
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #9584d09c; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-cup-hot"></i> 카페
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["cafe"] }}
            </b-col>
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #6dc0ff8c; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-cash-coin"></i> 은행
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["bank"] }}
            </b-col>
          </b-row>

          <b-row class="d-flex justify-content-center py-2 align-items-center">
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #6dc0ff8c; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-bandaid"></i> 약국
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["pharmacy"] }}
            </b-col>
            <b-col cols="2" class="text-end p-0">
              <div
                class="btn btn-primary m-0 disabled"
                style="background-color: #ffc95da1; border: none; color: black; padding: 5px 5px 5px 5px"
              >
                <i class="bi bi-hospital"></i> 병원
              </div>
            </b-col>
            <b-col cols="2" class="text-start p-2 border rounded bg-white mx-2">
              {{ $store.state.cd_score["hospital"] }}
            </b-col>
          </b-row>

          <b-row class="d-flex justify-content-center py-2">
            <b-col cols="6" class="text-end p-2">
              <b-button type="reset" variant="primary" class="m-1" @click="isWishModify" style="width: 100%">
                관심지수 재설정
              </b-button>
            </b-col>
          </b-row>
        </b-container>

        <b-container class="mt-4" v-show="!showWishModify">
          <hr />
          <h3 class="pt-4 m-3">주변 상권 선호도 점수 재설정</h3>
          <p>1~5점 사이의 점수로 입력해주세요. 관심지역 랭킹 시스템에 반영됩니다.</p>
          <b-form @submit="onSubmit">
            <b-row class="d-flex justify-content-center">
              <b-col cols="2" class="text-end p-2"><i class="bi bi-shop"></i> 대형마트</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="market-group" label-for="market">
                  <b-form-input
                    id="market"
                    v-model="score.market"
                    type="number"
                    min="1"
                    max="5"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
              <b-col cols="2" class="text-end p-2"><i class="bi bi-shop-window"></i> 편의점</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="convenience-group" label-for="convenience">
                  <b-form-input
                    id="convenience"
                    v-model="score.convenience"
                    type="number"
                    min="1"
                    max="5"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
            </b-row>

            <b-row class="d-flex justify-content-center">
              <b-col cols="2" class="text-end p-2"><i class="bi bi-train-lightrail-front"></i> 지하철역</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="subway-group" label-for="subway">
                  <b-form-input
                    id="subway"
                    v-model="score.subway"
                    type="number"
                    min="1"
                    max="5"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
              <b-col cols="2" class="text-end p-2"><i class="bi bi-egg-fried"></i> 음식점</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="food-group" label-for="food">
                  <b-form-input id="food" v-model="score.food" type="number" min="1" max="5" required></b-form-input>
                </b-form-group>
              </b-col>
            </b-row>

            <b-row class="d-flex justify-content-center py-2">
              <b-col cols="2" class="text-end p-2"><i class="bi bi-cup-hot"></i> 카페</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="cafe-group" label-for="cafe">
                  <b-form-input id="cafe" v-model="score.cafe" type="number" min="1" max="5" required></b-form-input>
                </b-form-group>
              </b-col>
              <b-col cols="2" class="text-end p-2"><i class="bi bi-hospital"></i> 병원</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="hospital-group" label-for="hospital">
                  <b-form-input
                    id="hospital"
                    v-model="score.hospital"
                    type="number"
                    min="1"
                    max="5"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
            </b-row>

            <b-row class="d-flex justify-content-center py-2">
              <b-col cols="2" class="text-end p-2"><i class="bi bi-bandaid"></i> 약국</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="pharmacy-group" label-for="pharmacy">
                  <b-form-input
                    id="pharmacy"
                    v-model="score.pharmacy"
                    type="number"
                    min="1"
                    max="5"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
              <b-col cols="2" class="text-end p-2"><i class="bi bi-cash-coin"></i> 은행</b-col>
              <b-col cols="2" class="text-start mx-2">
                <b-form-group id="bank-group" label-for="bank">
                  <b-form-input
                    id="bank"
                    v-model="score.bank"
                    type="number"
                    min="1"
                    max="5"
                    step="1"
                    required
                  ></b-form-input>
                </b-form-group>
              </b-col>
            </b-row>

            <b-row class="d-flex justify-content-center py-2">
              <b-col cols="8" class="text-end p-2">
                <b-button type="submit" variant="primary" class="p-1" style="width: 100%"> 변경내용 저장 </b-button>
              </b-col>
            </b-row>
          </b-form>
        </b-container>
      </b-container>
      <hr class="my-4" />
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
import http from "@/util/http"; // 게시판 테스트용

const memberStore = "memberStore";

export default {
  name: "UserMyPage",
  components: {},
  data() {
    return {
      showWishModify: true, // 관심 지수 수정 창 끄고 켜기
      score: {
        market: this.$store.state.cd_score["market"],
        convenience: this.$store.state.cd_score["convenience"],
        subway: this.$store.state.cd_score["subway"],
        food: this.$store.state.cd_score["food"],
        cafe: this.$store.state.cd_score["cafe"],
        hospital: this.$store.state.cd_score["hospital"],
        pharmacy: this.$store.state.cd_score["pharmacy"],
        bank: this.$store.state.cd_score["bank"],
      },
    };
  },
  created() {
    // http.get(`/wish/` + this.userInfo.userid).then(({ data }) => {
    //   this.score = data;
    // });
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    ...mapMutations(["SET_CD_SCORE"]),
    ...mapActions(memberStore, ["userLogout"]),
    deleteMember() {
      var _this = this;
      const userid = this.userInfo.userid;
      http.delete(`user/delete/${userid}`).then(({ data }) => {
        let msg = "탈퇴 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "탈퇴가 완료되었습니다.";
        }
        alert(msg);

        // 로그아웃
        console.log(_this.userInfo.userid);
        _this.userLogout(_this.userInfo.userid);
        sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
        sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
        if (_this.$route.path != "/") _this.$router.push({ name: "main" });

        //this.movePage();
      });
    },
    movePage() {
      this.$router.push({ name: "main" });
    },

    isWishModify() {
      this.showWishModify = !this.showWishModify;
    },

    onSubmit(event) {
      console.log("입력버튼");
      event.preventDefault();
      console.log(event);
      this.SET_CD_SCORE(this.score);

      alert("변경되었습니다");
      let err = true;
      let msg = "";
      if (!err) alert(msg);
      // else {
      //   this.modifyScore();
      // }
      this.isWishModify();
    },
    modifyScore() {
      // http
      //   .put(`/board`, {
      //     market: this.score.market,
      //     convenience: this.score.market,
      //     subway: this.score.subway,
      //     food: this.score.food,
      //     cafe: this.score.cafe,
      //     hospital: this.score.hospital,
      //     pharmarcy: this.score.pharmarcy,
      //     bank: this.score.bank,
      //   })
      //   .then(({ data }) => {
      //     let msg = "관심 지수 처리시 문제가 발생했습니다.";
      //     if (data === "success") {
      //       msg = "관심 지수 수정이 완료되었습니다.";
      //     }
      //     alert(msg);
      //     // 현재 route를 /list로 변경.
      //     this.moveList();
      //   });
      this.moveList();
    },
    moveList() {
      // http.get(`/wish/` + this.userInfo.userid).then(({ data }) => {
      //   this.score = data;
      // });
      console.log("창을 닫습니다.");
      this.isWishModify();
    },
  },
};
</script>

<style></style>
