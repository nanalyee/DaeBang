<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container>
      <div class="row g-4">
        <div class="col-lg-12 text-center">
          <h1 class="display-7 my-4 mb-10">랜덤 관광지 알아보기 ╰（‵□′）╯</h1>
          <button class="btn btn-dark" @click="TDInfoShow" v-show="startTD">클릭</button>
          <button class="btn btn-dark" @click="randomSearchTD" v-show="restartTD">다른 관광지 보기</button>
        </div>
        <div class="col-lg-12 text-center" v-show="startTD">
          <img class="img-fluid rounded" src="@/assets/img/daejeon_bridge.png" alt="" />
        </div>
        <div class="col-lg-6" v-show="isTDshow">
          <div class="border portfolio-img rounded overflow-hidden" style="padding: 20px">
            <div class="d-flex align-items-center mt-3 mb-3" style="text-align: center">
              <h3 class="border-end pe-3 ml-5 me-3 mb-0">{{ this.td_info.name }}</h3>
              <img class="img-fluid rounded-circle" :src="$store.state.houseimg" alt="" />
            </div>
            * 이미지 검색 API 를 사용하여 실제와 다를 수 있습니다
            <br />
            <table class="table table-bordered" style="table-layout: fixed">
              <tbody>
                <tr>
                  <th>주소</th>
                  <td colspan="2">{{ this.td_info.addr1 }}</td>
                </tr>
                <tr>
                  <th>전화번호</th>
                  <td colspan="2">{{ this.td_info.tel }}</td>
                </tr>
                <tr>
                  <th>우편번호</th>
                  <td colspan="2">{{ this.td_info.zipcode }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        <div class="col-lg-6" v-show="isTDshow">
          <div class="border portfolio-img rounded overflow-hidden" style="padding: 20px">
            <table class="table table-bordered" style="table-layout: fixed">
              <tbody>
                <tr>
                  <th>분류</th>
                  <td colspan="3">{{ this.td_info_detail.dCodeNm }}</td>
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
      console.log(data.msgBody);
    });
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
      isTDshow: false,
      startTD: true,
      restartTD: false,
    };
  },

  methods: {
    ...mapActions(["getTitleImg"]),
    randomSearchTD() {
      // 0부터 126사이의 숫자 중 랜덤 뽑기
      const rand_num = Math.floor(Math.random() * 127);
      // spring에서 비동기로 관광지 정보 불러오기
      this.td_info.tourSeq = this.td_info_list[rand_num].tourSeq;
      this.td_info.name = this.td_info_list[rand_num].name;
      this.td_info.addr1 = this.td_info_list[rand_num].addr1;
      this.td_info.zipcode = this.td_info_list[rand_num].zipcode;
      this.td_info.tel =
        this.td_info_list[rand_num].telCode +
        "-" +
        this.td_info_list[rand_num].telKuk +
        "-" +
        this.td_info_list[rand_num].telNo;

      //다음 이미지 api
      this.getTitleImg(this.td_info.name);

      // spring에서 비동기로 관광지 상세 정보 불러오기
      http.get(`/wish/gettddetail/${this.td_info.tourSeq}`).then(({ data }) => {
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

        // console.log();
        //console.log(data.msgBody);
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

<style></style>
