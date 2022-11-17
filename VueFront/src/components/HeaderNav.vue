<template>
  <div class="header">
    <!--
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow py-lg-0 justify-content-center">
      <a href="index.jsp" class="navbar-brand d-block d-lg-none">
        <h1 class="text-primary fw-bold m-0">대방</h1>
      </a>
      <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse py-4 py-lg-0 justify-content-between" id="navbarCollapse">
        <div class="navbar-nav py-0 justify-content-center">
          <router-link to="/" class="navbar-brand bg-light py-3 px-4 mx-3 d-none d-lg-block">
            <h1 class="text-primary fw-bold m-0">대방</h1>
          </router-link>
          <router-link to="/search" class="nav-item nav-link px-4">매매검색</router-link>
          <router-link to="/traffic" class="nav-item nav-link px-4">교통정보</router-link>
          <router-link to="/about" class="nav-item nav-link px-4">서비스</router-link>
        </div>

        <div class="navbar-nav py-0" v-if="userInfo">
          <router-link :to="{ name: 'mypage' }" class="nav-item nav-link px-4">마이페이지</router-link>
          <a class="nav-item nav-link px-4" @click.prevent="onClickLogout">로그아웃</a>
        </div>

        <div class="navbar-nav me-auto py-0" v-else>
          <router-link :to="{ name: 'join' }" class="nav-item nav-link px-4">회원가입</router-link>
          <router-link :to="{ name: 'login' }" class="nav-item nav-link px-4">로그인</router-link>
        </div>
      </div>
    </nav>
    <nav>{{ userInfo.username }}({{ userInfo.userid }})님 환영합니다.</nav> -->

    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow py-lg-0 px-4 px-lg-5 justify-content-center">
      <a href="index.jsp" class="navbar-brand d-block d-lg-none">
        <h1 class="text-primary fw-bold m-0">구해줘홈즈</h1>
      </a>
      <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-between py-4 py-lg-0" id="navbarCollapse">
        <div class="navbar-nav ms-auto py-0">
          <router-link to="/search" class="nav-item nav-link px-4">매매검색</router-link>
          <router-link to="/traffic" class="nav-item nav-link px-4">교통정보</router-link>
          <router-link to="/about" class="nav-item nav-link px-4">서비스</router-link>
        </div>
        <router-link to="/" class="navbar-brand bg-light py-3 px-4 mx-3 d-none d-lg-block">
          <h1 class="text-primary fw-bold m-0">H<i class="bi bi-house-heart-fill fs-3"></i>mes</h1>
        </router-link>

        <div class="navbar-nav me-auto py-0" v-if="userInfo">
          <!-- <router-link to="/about" class="nav-item nav-link px-4">회원가입/로그인</router-link> -->
          <router-link :to="{ name: 'mypage' }" class="nav-item nav-link px-4">마이페이지</router-link>
          <a class="nav-item nav-link px-4" @click.prevent="onClickLogout">로그아웃</a>
          <nav>{{ userInfo.username }}({{ userInfo.userid }})님 환영합니다.</nav>
        </div>

        <div class="navbar-nav me-auto py-0" v-else>
          <router-link :to="{ name: 'join' }" class="nav-item nav-link px-4">회원가입</router-link>
          <router-link :to="{ name: 'login' }" class="nav-item nav-link px-4">로그인</router-link>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";
const memberStore = "memberStore";

export default {
  name: "TheHeaderNavbar",
  data() {
    return {};
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    // ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // this.SET_IS_LOGIN(false);
      // this.SET_USER_INFO(null);
      // sessionStorage.removeItem("access-token");
      // if (this.$route.path != "/") this.$router.push({ name: "main" });
      console.log(this.userInfo.userid);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userid);
      this.userLogout(this.userInfo.userid);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "main" });
    },
  },
};
</script>

<style></style>
