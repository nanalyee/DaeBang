<template>
  <b-container class="mt-4" v-if="userInfo">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>내정보</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <template #header>My Page</template>

          <template #lead> 내 정보 확인페이지입니다. </template>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.userid }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.username }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.email }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">가입일</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.joindate }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>

            <router-link :to="{ name: 'modify' }" class="btn btn-primary mr-1"
              >정보수정</router-link
            >
            <!-- <b-button variant="primary" href="#" class="mr-1">정보수정</b-button> -->
            <b-button variant="danger" href="#" @click="deleteMember">회원탈퇴</b-button>
            <b-row>
              대형마트: {{ $store.state.cd_score["market"] }}, 편의점:
              {{ $store.state.cd_score["convenience"] }}, 지하철역:
              {{ $store.state.cd_score["subway"] }}, 음식점: {{ $store.state.cd_score["food"] }},
              카페: {{ $store.state.cd_score["cafe"] }}, 병원:
              {{ $store.state.cd_score["hospital"] }}, 약국:
              {{ $store.state.cd_score["pharmacy"] }}, 은행:
              {{ $store.state.cd_score["bank"] }}
              <b-button type="reset" variant="danger" class="m-1" @click="isWishModify"
                >관심지수 재설정</b-button
              >
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-container class="mt-4" v-show="!showWishModify">
            <h3>관심 지수</h3>
            <p>1~5점 사이의 점수로 입력해주세요. 관심지역 랭킹 시스템에 반영됩니다.</p>
            <b-form @submit="onSubmit">
              <b-button type="submit" variant="primary" class="m-1"
                ><i class="bi bi-send-fill white fs-4"></i
              ></b-button>

              <b-form-group id="market-group" label="대형마트:" label-for="market">
                <b-form-input
                  id="market"
                  v-model="score.market"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="convenience-group" label="편의점:" label-for="convenience">
                <b-form-input
                  id="convenience"
                  v-model="score.convenience"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="subway-group" label="지하철:" label-for="subway">
                <b-form-input
                  id="subway"
                  v-model="score.subway"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="food-group" label="음식점:" label-for="food">
                <b-form-input
                  id="food"
                  v-model="score.food"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="cafe-group" label="카페:" label-for="cafe">
                <b-form-input
                  id="cafe"
                  v-model="score.cafe"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="hospital-group" label="병원:" label-for="hospital">
                <b-form-input
                  id="hospital"
                  v-model="score.hospital"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="pharmacy-group" label="약국:" label-for="pharmacy">
                <b-form-input
                  id="pharmacy"
                  v-model="score.pharmacy"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>

              <b-form-group id="bank-group" label="은행:" label-for="bank">
                <b-form-input
                  id="bank"
                  v-model="score.bank"
                  type="number"
                  min="1"
                  max="5"
                  required
                ></b-form-input>
              </b-form-group>
            </b-form>
          </b-container>
          <hr class="my-4" />
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";
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

    deleteMember() {
      const userid = this.userInfo.userid;
      http.delete(`user/delete/${userid}`).then(({ data }) => {
        let msg = "탈퇴 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "탈퇴가 완료되었습니다.";
        }
        alert(msg);
        this.movePage();
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
