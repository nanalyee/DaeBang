<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view />
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import HeaderNav from "./components/HeaderNav.vue";
import FooterNav from "./components/FooterNav.vue";
export default {
  components: { HeaderNav, FooterNav },
};
</script>

<style></style>
