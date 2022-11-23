<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container>
      <div class="row g-4 mt-5">
        <div class="p-3">
          <h4 class="text-start">
            {{ gugun }} 관광지 <br />
            {{ gugun_td_list.length }}곳을 소개합니다.
          </h4>
        </div>
        <div class="col-lg-6 text-center">
          <div class="border portfolio-img rounded" style="padding: 20px">
            <!-- <h1 class="display-7 my-4 mb-10">{{ gugun }} 관광지{{ gugun_td_list.length }} 곳 발견!</h1> -->
            <div id="tdlist" class="px-3 py-2 box" style="height: 500px; overflow: auto">
              <!-- button start -->
              <div
                class="panel-group"
                id="accordion"
                role="tablist"
                aria-multiselectable="true"
                v-on:scroll.prevent="onScroll"
              >
                <div
                  v-for="(item, i) in gugun_td_list"
                  :key="i"
                  type="button"
                  :id="'article' + i"
                  class=""
                  @click="log(td_info_list[item].tourSeq, td_info_list[item].name)"
                >
                  <div class="row my-3">
                    <div class="col-2 p-2 text-right">
                      <img
                        v-if="td_info_list[item].dCode == 'C0101'"
                        id="bus_icon"
                        class="rounded user"
                        src="@/assets/img/td/research.png"
                        alt=""
                      />
                      <img
                        v-if="td_info_list[item].dCode == 'C0102'"
                        id="bus_icon"
                        class="rounded user"
                        src="@/assets/img/td/laboratory-assistant.png"
                        alt=""
                      />
                      <img
                        v-if="td_info_list[item].dCode == 'C0103'"
                        id="bus_icon"
                        class="rounded user"
                        src="@/assets/img/td/holy-gate.png"
                        alt=""
                      />
                      <img
                        v-if="td_info_list[item].dCode == 'C0104'"
                        id="bus_icon"
                        class="rounded user"
                        src="@/assets/img/td/stupa.png"
                        alt=""
                      />
                    </div>
                    <div class="col-auto">
                      <div class="row">
                        <div class="col-auto align-self-center rounded p-3 mb-3 mt-1 bubble">
                          <div class="">
                            <span class="fs-5 me-2 font-weight-bold">{{ td_info_list[item].name }} </span>
                            <span
                              v-if="td_info_list[item].dCode == 'C0101'"
                              class="pe-3 text-success"
                              style="color: gray"
                              >자연생태</span
                            >
                            <span
                              v-if="td_info_list[item].dCode == 'C0102'"
                              class="pe-3 text-primary"
                              style="color: gray"
                              >첨단과학</span
                            >
                            <span
                              v-if="td_info_list[item].dCode == 'C0103'"
                              class="pe-3 text-danger"
                              style="color: gray"
                              >문화시설</span
                            >
                            <span v-if="td_info_list[item].dCode == 'C0104'" class="pe-3 text-info" style="color: gray"
                              >문화유산</span
                            >
                            <br />
                            <span class="fs-6 font-weight-bold">{{ td_info_list[item].addr1 }} </span>
                            <br />
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- button end -->
          </div>
        </div>
        <div class="col-lg-6">
          <div class="border portfolio-img rounded overflow-hidden" style="padding: 20px">
            <div class="text-center">
              <img v-show="!isTDshow" src="@/assets/img/empty.gif" alt="" class="" style="width: 400px; layout: " />
            </div>
            <table class="table table-bordered" style="table-layout: fixed" v-show="isTDshow">
              <tbody>
                <tr>
                  <th>번호</th>
                  <td colspan="3">{{ this.td_info_detail.telCode }}</td>
                </tr>
                <tr>
                  <th>우편번호</th>
                  <td colspan="3">{{ this.td_info_detail.zipcode }}</td>
                </tr>
                <tr>
                  <th>홈페이지</th>
                  <td colspan="3">{{ this.td_info_detail.homepage }}</td>
                </tr>
                <tr>
                  <th>운영시간</th>
                  <td colspan="3">{{ this.td_info_detail.Time }}</td>
                </tr>
                <tr>
                  <th>이용요금</th>
                  <td colspan="3">{{ this.td_info_detail.priceDesc }}</td>
                </tr>
                <tr>
                  <th>편의시설</th>
                  <td colspan="3">{{ this.td_info_detail.subsidiaryDesc }}</td>
                </tr>
                <tr>
                  <th>등산로</th>
                  <td colspan="3">{{ this.td_info_detail.climbingRoadDesc }}</td>
                </tr>
                <tr>
                  <th>길 안내</th>
                  <td colspan="3">{{ this.td_info_detail.ownerDriver }}</td>
                </tr>
                <tr>
                  <th>주차시설</th>
                  <td colspan="3">{{ this.td_info_detail.parkDesc }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </b-container>
  </div>
  <!-- 관광 끝 -->
</template>

<script>
import http from "@/util/http"; // 버스 정류소 불러오기용
import { mapActions } from "vuex";
export default {
  name: "WishTour",

  created() {
    // spring에서 비동기로 랜덤 관광지 불러오기
    http.get(`/wish/gettd`).then(({ data }) => {
      this.td_info_list = data.msgBody;
      console.log("관광지 가져와");
      console.log(data.msgBody);

      for (let i = 0; i < this.td_info_list.length; i++) {
        var str = this.td_info_list[i].addr1;
        if (str.includes(this.gugun)) {
          this.gugun_td_list.push(i);
        }
      }

      console.log(this.gugun_td_list);
    });
  },
  props: {
    gugun: { type: String, required: true },
  },
  data() {
    return {
      //tourist destination
      td_info_list: [],
      td_info: {
        tourSeq: "",
        name: "뽑기 버튼 클릭",
        addr1: "",
        tel: "",
        zipcode: "",
        tdimg: "",
      },
      td_info_detail: {
        dCodeNm: "",
        homepage: "",
        Time: "",
        priceDesc: "",
        subsidiaryDesc: "",
        climbingRoadDesc: "",
        ownerDriver: "",
        parkDesc: "",
      },
      gugun_td_list: [],
      isTDshow: false,
      startTD: true,
      restartTD: false,
    };
  },

  methods: {
    ...mapActions(["getTitleImg"]),

    log(id, title) {
      //this.TDInfoShow();
      // 0부터 126사이의 숫자 중 랜덤 뽑기
      // spring에서 비동기로 관광지 정보 불러오기
      this.td_info.tourSeq = id;
      this.isTDshow = false;
      //다음 이미지 api
      this.getTitleImg(title);

      // spring에서 비동기로 관광지 상세 정보 불러오기
      http.get(`/wish/gettddetail/${this.td_info.tourSeq}`).then(({ data }) => {
        if (data.msgBody.zipcode == null) this.td_info_detail.zipcode = "정보 없음";
        else this.td_info_detail.zipcode = data.msgBody.zipcode;
        if (data.msgBody.dCodeNm == null) this.td_info_detail.dCodeNm = "정보 없음";
        else this.td_info_detail.dCodeNm = data.msgBody.dCodeNm;
        if (data.msgBody.homepage == null) this.td_info_detail.homepage = "정보 없음";
        else this.td_info_detail.homepage = data.msgBody.homepage;
        if (data.msgBody.Time == null) this.td_info_detail.Time = "정보 없음";
        else this.td_info_detail.Time = data.msgBody.Time;
        if (data.msgBody.priceDesc == null) this.td_info_detail.priceDesc = "정보 없음";
        else this.td_info_detail.priceDesc = data.msgBody.priceDesc;
        if (data.msgBody.subsidiaryDesc == null) this.td_info_detail.subsidiaryDesc = "정보 없음";
        else this.td_info_detail.subsidiaryDesc = data.msgBody.subsidiaryDesc;
        if (data.msgBody.climbingRoadDesc == null) this.td_info_detail.climbingRoadDesc = "정보 없음";
        else this.td_info_detail.climbingRoadDesc = data.msgBody.climbingRoadDesc;
        if (data.msgBody.ownerDriver == null) this.td_info_detail.ownerDriver = "정보 없음";
        else this.td_info_detail.ownerDriver = data.msgBody.ownerDriver;
        if (data.msgBody.parkDesc == null) this.td_info_detail.parkDesc = "정보 없음";
        else this.td_info_detail.parkDesc = data.msgBody.parkDesc;
        if (data.msgBody.telCode == null) this.td_info_detail.telCode = "정보 없음";
        else this.td_info_detail.telCode = data.msgBody.telCode + "-" + data.msgBody.telKuk + "-" + data.msgBody.telNo;
        this.isTDshow = true;
        // console.log();
        console.log(data.msgBody);
      });
    },
    TDInfoShow() {
      this.randomSearchTD();
      this.isTDshow = !this.isTDshow;
      this.startTD = !this.startTD;
      this.restartTD = !this.restartTD;
    },
  },
};
</script>

<style>
.box::-webkit-scrollbar {
  padding-left: 8px;
  width: 8px; /* 스크롤바의 너비 */
}

.box::-webkit-scrollbar-thumb {
  height: 30%; /* 스크롤바의 길이 */
  background: #17bcc262; /* 스크롤바의 색상 */

  border-radius: 10px;
}

.box::-webkit-scrollbar-track {
  background: #6b799e0c; /*스크롤바 뒷 배경 색상*/
}
</style>
