<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="d-flex justify-content-center">
      <h1 class="underline-steelblue py-4 my-4"><i class="bi bi-door-open-fill"></i>로그인</h1>
      <b-col cols="4" class="">
        <b-card class="text-center" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError">아이디 또는 비밀번호를 확인하세요.</b-alert>
            <b-form-group label="아이디" label-for="userid">
              <b-form-input
                id="userid"
                v-model="user.userid"
                required
                placeholder="ID"
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="PW"
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
          </b-form>
        </b-card>
      </b-col>
      <b-col cols="1">
        <b-row>
          <b-button type="button" variant="primary" class="m-1" @click="confirm" style="height: 200px">로그인</b-button>
        </b-row>
      </b-col>
      <b-row class="pt-3 mt-1 justify-content-center">
        아직 회원이 아니신가요?<b-button type="button" variant="success" class="joinBtn mx-1" @click="movePage"
          >회원가입</b-button
        >
      </b-row>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserLogin",
  data() {
    return {
      // isLoginError: false,
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "main" });
      }
    },
    movePage() {
      this.$router.push({ name: "join" });
    },
  },
};
</script>

<style>
.joinBtn {
  width: 80px;
  background-color: white;
  color: #6b799e;
  padding: 0px;
  margin: 0px;
  border: none;
}
.joinBtn :hover {
  color: green;
  background-color: white;
}
</style>
