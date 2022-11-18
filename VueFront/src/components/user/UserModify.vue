<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>정보 수정</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isModifyError">모든 항목을 입력해주세요.</b-alert>

            <b-form-group label="이름:" label-for="username">
              <b-form-input id="username" v-model="user.username" required></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호확인:" label-for="userpwdCK">
              <b-form-input
                type="password"
                id="userpwdCK"
                v-model="user.userpwdCK"
                required
                placeholder="password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="email">
              <b-form-input id="email" v-model="user.email" required> </b-form-input>
            </b-form-group>

            <b-button type="button" variant="success" class="m-1" @click="modifyMember"
              >수정</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http"; // 게시판 테스트용
const memberStore = "memberStore";

export default {
  name: "UserModify",
  data() {
    return {
      isModifyError: false,
      user: {
        username: null,
        userpwd: null,
        userpwdCK: null,
        email: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    modifyMember() {
      const username = this.user.username;
      const userpwd = this.user.userpwd;
      const userpwdCK = this.user.userpwdCK;
      const email = this.user.email;
      if (!username || !userpwd || !userpwdCK || !email) {
        this.isModifyError = true;
        console.log(username + " " + userpwd + " " + email);
        return false;
      }

      const userid = this.userInfo.userid;
      console.log(username + " " + userpwd + " " + email);
      http
        .put(`/user`, {
          userid: userid,
          username: username,
          userpwd: userpwd,
          email: email,
        })
        .then(({ data }) => {
          let msg = "정보 수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "정보 수정이 완료되었습니다.";
          }
          alert(msg);
          this.movePage();
        });
    },
    movePage() {
      this.userInfo.username = this.user.username;
      this.userInfo.userpwd = this.user.userpwd;
      this.userInfo.email = this.user.email;
      console.log(this.userInfo);
      this.$router.push({ name: "mypage" });
    },
  },
};
</script>

<style></style>
