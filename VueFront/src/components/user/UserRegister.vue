<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="d-flex justify-content-center">
      <h1 class="underline-steelblue py-4 my-4"><i class="bi bi-person-square"></i> 회원가입</h1>
      <b-col cols="8 d-flex justify-content-center">
        <b-card class="text-center mt-3" style="width: 30rem" align="left">
          <b-form class="text-left">
            <b-form-group label="아이디" label-for="userid">
              <b-form-input id="userid" v-model="user.userid" required placeholder="ID"></b-form-input>
            </b-form-group>
            <b-form-group label="이름" label-for="username">
              <b-form-input id="username" v-model="user.username" required placeholder="name"></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호 확인" label-for="userpwdCK">
              <b-form-input
                type="password"
                id="userpwdCK"
                v-model="user.userpwdCK"
                required
                placeholder="password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일" label-for="email">
              <b-form-input id="email" v-model="user.email" required placeholder="email"> </b-form-input>
            </b-form-group>
          </b-form>
          <b-alert show variant="danger" v-if="isLoginError" class="text-center">모든 항목을 입력해주세요.</b-alert>
          <b-button type="button" variant="success" class="m-1" @click="regist" style="width: 100%">회원가입</b-button>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/util/http"; // 게시판 테스트용

export default {
  name: "UserLogin",
  data() {
    return {
      isLoginError: false,
      user: {
        userid: null,
        username: null,
        userpwd: null,
        userpwdCK: null,
        email: null,
      },
    };
  },
  methods: {
    // ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    // async confirm() {
    //   await this.userConfirm(this.user);
    //   let token = sessionStorage.getItem("access-token");
    //   // console.log("1. confirm() token >> " + token);
    //   if (this.isLogin) {
    //     await this.getUserInfo(token);
    //     // console.log("4. confirm() userInfo :: ", this.userInfo);
    //     this.$router.push({ name: "main" });
    //   }
    // },
    regist() {
      const userid = this.user.userid;
      const username = this.user.username;
      const userpwd = this.user.userpwd;
      const userpwdCK = this.user.userpwdCK;
      const email = this.user.email;

      if (!userid || !username || !userpwd || !userpwdCK || !email) {
        this.isLoginError = true;
        console.log(userid + " " + username + " " + userpwd + " " + userpwdCK + " " + email);
        return false;
      }

      http
        .post(`/user/regist`, {
          userid: userid,
          username: username,
          userpwd: userpwd,
          email: email,
        })
        .then(({ data }) => {
          let msg = "회원가입 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "회원가입이 완료되었습니다.";
          }
          alert(msg);
          this.movePage();
        });
    },
    movePage() {
      this.$router.push({ name: "login" });
    },
  },
};
</script>

<style></style>
