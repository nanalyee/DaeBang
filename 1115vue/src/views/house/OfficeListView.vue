<template>
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <h3>오피스텔 컴포넌트</h3>
    <!-- button start -->
    <div
      v-for="(item, i) in houses"
      :key="i"
      type="button"
      id="storeinfo"
      class="p-2 my-3 border rounded row"
      v-on:click="tableClick(item.단지)"
      data-toggle="collapse"
      :href="'#toggle' + i"
      role="button"
      aria-expanded="false"
      :aria-controls="'toggle' + i"
    >
      <div class="col align-self-center">
        <div class="">
          <span class="fs-4 pe-3">{{ item.단지 }}단지</span>
          <span style="color: gray">오피스텔</span>
        </div>
        <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
          <div class="row">
            <div class="col">
              <span class="pe-3" style="color: gray">면적</span>
              <span>{{ item.전용면적 }}</span>
            </div>
            <div class="col">
              <span class="pe-3" style="color: gray">층수</span>
              <span>{{ item.층 }}층</span>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <span class="pe-3" style="color: gray">법정동</span>
              <span>{{ item.법정동 }}</span>
            </div>
            <div class="col">
              <span class="pe-3" style="color: gray">건축년도</span>
              <span>{{ item.건축년도 }}</span>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <span class="pe-3" style="color: gray">월세</span>
              <span>{{ item.월세 }}</span>
            </div>
            <div class="col">
              <span class="pe-3" style="color: gray">보증금</span>
              <span>{{ item.보증금 }}</span>
            </div>
          </div>
          <!-- <div class="row collapse multi-collapse" :id="'toggle' + i">
          <div class="col-auto">
            <span class="pe-3" style="color: gray">지번주소</span>
            <span>대전시 유성구 학하서로</span>
          </div>
          <div class="col">
            <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
          </div>
        </div> -->
        </div>
      </div>

      <div class="col-3 collapse" :id="'toggle' + i" data-parent="#accordion">
        <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
      </div>
      <div class="col-1 text-right align-self-center collapse" :id="'toggle' + i" data-parent="#accordion">
        <a href="#" class="golink" v-on:click="goDetail">
          <i class="bi bi-chevron-compact-right fs-1"></i>
        </a>
      </div>
    </div>
    <!-- button end -->
    <!-- <table>
      <tr>
        <th>단지</th>
        <th>법정동</th>
        <th>지번</th>
        <th>층</th>
      </tr>
      <tr v-for="(item, i) in houses" :key="i">
        <td v-html="item.단지"></td>
        <td v-html="item.법정동"></td>
        <td v-html="item.지번"></td>
        <td v-html="item.층"></td>
      </tr>
    </table> -->
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "AppSearch",
  data() {
    return {};
  },
  computed: {
    ...mapState(["houses"]),
  },
  methods: {
    ...mapActions(["getTitleImg"]),
    ...mapMutations([]),

    tableClick(title) {
      console.log("table click");
      this.getTitleImg(title + "단지");
    },
    goDetail() {
      console.log("go detail view");
    },
  },
};
</script>

<style></style>
