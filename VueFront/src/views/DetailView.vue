<template>
  <div class="box p-0 m-0">
    <div class="container mt-5 mb-3">
      <div class="row justify-content-between">
        <div class="col">
          <a v-if="!this.status && userInfo" class="fs-4 pe-3 like" @click="like"
            ><i id="heart" class="bi bi-heart"></i
          ></a>
          <a v-else-if="userInfo" class="fs-4 pe-3 like" @click="like"><i id="heart" class="bi bi-heart-fill"></i></a>
          <h3 style="display: inline-block; color: #6b799e">{{ wishname }} {{ wishtype }}</h3>
          <h4 style="display: inline-block">&nbsp;&nbsp;주변 상권 정보</h4>
        </div>
        <div class="col text-start row">
          <div class="col">
            <b-button
              v-b-toggle.my-collapse
              type="button"
              class="btn bg-white border-bottom p-0 m-0"
              style="border: none; border-radius: 0px 0px 0px 0px; color: #6b799e"
              ><i class="bi bi-cloud-sun-fill"></i>날씨</b-button
            >
          </div>
          <div class="col text-lg-end">
            <button
              type="button"
              class="btn bg-white border-bottom p-0 mr-4"
              @click="goBack"
              style="border-radius: 0px 0px 0px 0px; color: #6b799e"
            >
              <i class="bi bi-cloud-sun-fill"></i>매매검색으로 돌아가기
            </button>
          </div>
        </div>
      </div>
      <div class="row">
        <kakao-map-view></kakao-map-view>

        <template>
          <div>
            <div class="mb-3"></div>

            <b-collapse id="my-collapse">
              <!-- 테스트용 관광 -->
              <b-container v-if="this.weathertable.length > 0">
                <div class="row g-4">
                  <div
                    id="weather-container"
                    :style="{ backgroundImage: `url(${require('@/assets/img/weather/' + this.bgimage)})` }"
                    class="row"
                  >
                    <div class="col mt-5 justify-content-between">
                      <div class="display-7 mt-5 mb-5 px-5 text-start" style="color: black">
                        <div class="text fw-bold">대전시 {{ gugunname }} {{ dongname }}</div>
                        <i
                          v-if="weathertable[this.startdata + 5].fcstValue == '4'"
                          class="display-5 bi bi-cloud-haze-fill"
                        ></i>
                        <i
                          v-if="weathertable[this.startdata + 5].fcstValue == '3'"
                          class="display-5 bi bi-cloud-fill"
                        ></i>
                        <i
                          v-if="weathertable[this.startdata + 5].fcstValue == '1'"
                          class="display-5 bi bi-sun-fill"
                        ></i>
                        <span v-if="weathertable[this.startdata].fcstValue" class="fw-bold display-5">
                          {{ weathertable[this.startdata].fcstValue }}°
                        </span>
                        <span v-if="weathertable[this.startdata].fcstValue" class="fs-3"> 흐림 </span>
                        <!-- <img
                v-if="weathertable[this.startdata + 5].fcstValue == '4'"
                class="img-fluid"
                src="@/assets/img/weather/cloudfog.png"
                id="title_weather"
              />
              <img
                v-if="weathertable[this.startdata + 5].fcstValue == '3'"
                class="img-fluid"
                src="@/assets/img/weather/cloud.png"
                id="title_weather"
              />
              <img
                v-if="weathertable[this.startdata + 5].fcstValue == '1'"
                class="img-fluid"
                src="@/assets/img/weather/sun.png"
                id="title_weather"
              /> -->
                      </div>
                    </div>
                    <div class="col text-end align-self-end mb-5" style="color: black">
                      <div class="text fw-bold">{{ this.hours }}시 현재 기상 정보</div>
                      <span v-if="weathertable[this.startdata + 7].fcstValue" class="display-7 my-4 mb-10 pr-3">
                        <i class="bi bi-droplet-half"></i>
                        강수확률 {{ weathertable[this.startdata + 7].fcstValue }}%
                      </span>
                      <span v-if="weathertable[this.startdata + 10].fcstValue" class="display-7 my-4 mb-10">
                        <i class="bi bi-moisture"></i>
                        습도 {{ weathertable[this.startdata + 10].fcstValue }}%
                      </span>
                    </div>
                  </div>
                  <table class="table text-center table-borderless" style="table-layout: fixed">
                    <thead>
                      <tr>
                        <th scope="col border-right">시각</th>
                        <th scope="col" v-for="(item, i) in hourslist()" :key="i">{{ item + 1 }} 시</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">기온</th>
                        <td v-for="(item, i) in tempnum()" :key="i">
                          <span class="text-danger fw-bold"> {{ weathertable[item].fcstValue }} °C</span>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">풍향</th>
                        <td v-for="(item, i) in tempnum()" :key="i">
                          {{ weathertable[item + 3].fcstValue }}
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">풍속</th>
                        <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 4].fcstValue }} m/s</td>
                      </tr>
                      <tr>
                        <th class="align-middle" scope="row">하늘상태</th>
                        <td v-for="(item, i) in tempnum()" :key="i">
                          <img
                            v-if="weathertable[item + 5].fcstValue == '4'"
                            class="img-fluid"
                            src="@/assets/img/weather/cloudfog.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 5].fcstValue == '3'"
                            class="img-fluid"
                            src="@/assets/img/weather/cloud.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 5].fcstValue == '1'"
                            class="img-fluid"
                            src="@/assets/img/weather/sun.png"
                            id="weather_img"
                          />
                          <!-- {{ weathertable[item + 5].fcstValue }} -->
                        </td>
                      </tr>
                      <tr>
                        <th class="align-middle" scope="row">강수형태</th>
                        <td v-for="(item, i) in tempnum()" :key="i">
                          <img
                            v-if="weathertable[item + 6].fcstValue == '0'"
                            class="img-fluid"
                            src="@/assets/img/weather/cloudx.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 6].fcstValue == '1'"
                            class="img-fluid"
                            src="@/assets/img/weather/rain.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 6].fcstValue == '2'"
                            class="img-fluid"
                            src="@/assets/img/weather/snowing.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 6].fcstValue == '3'"
                            class="img-fluid"
                            src="@/assets/img/weather/snow.png"
                            id="weather_img"
                          />
                          <img
                            v-if="weathertable[item + 6].fcstValue == '4'"
                            class="img-fluid"
                            src="@/assets/img/weather/rainshower.png"
                            id="weather_img"
                          />
                          <!-- {{ weathertable[item + 6].fcstValue }} -->
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">강수확률</th>
                        <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 7].fcstValue }} %</td>
                      </tr>
                      <tr>
                        <th scope="row">1시간 강수량(mm)</th>
                        <td class="align-middle" v-for="(item, i) in tempnum()" :key="i">
                          {{ weathertable[item + 9].fcstValue }}
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">습도</th>
                        <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 10].fcstValue }} %</td>
                      </tr>
                      <tr>
                        <th scope="row">1시간 적설량(mm)</th>
                        <td class="align-middle" v-for="(item, i) in tempnum()" :key="i">
                          {{ weathertable[item + 11].fcstValue }}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </b-container>
              <!-- 관광 끝 -->
            </b-collapse>
          </div>
        </template>

        <!-- <div class="col-6"><near-list-view></near-list-view></div> -->
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http"; // 관심지역 추가, 삭제용

import KakaoMapView from "../components/detail/KakaoMapView.vue";
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";

export default {
  name: "appDetail",
  components: { KakaoMapView },
  data() {
    return {
      status: false,
      wishname: this.$route.params.wishname,
      wishtype: this.$route.params.wishtype,
      gugunname: this.$route.params.gugunname,
      dongname: this.$route.params.dongname,
      lat: this.$route.params.lat,
      lng: this.$route.params.lng,

      // 날씨
      hours: new Date().getHours(),
      hourlist: [],
      weathertable: [],
      temp: "",
      startdata: "",
      bgimage: "sunny.gif",
    };
  },
  created() {
    http.get(`/wish/chkexistwish/${this.wishname}/${this.userInfo.userid}`).then(({ data }) => {
      if (data === "success") {
        console.log("true");
        this.status = true;
      } else {
        console.log("false");
        this.status = false;
      }
    });

    // 날씨
    let today = new Date();
    let year = today.getFullYear(); // 년도
    let month = today.getMonth() + 1; // 월
    let date = today.getDate(); // 날짜
    let basedate = String(year) + String(month) + String(date);
    let hours = "";
    let basetime = "";
    // let nx = 55;
    // let ny = 127;
    let temp = 0;

    if (today.getHours() < 10) {
      hours = "0" + today.getHours() + "00";
    } else {
      hours = today.getHours() + "00";
    }
    if (hours == "2300" || hours == "0000" || hours == "0100") {
      if (hours == "0000") {
        temp = 12;
      } else if (hours == "0100") {
        temp = 24;
      }
      basedate -= 1;
      basetime = "2300";
    } else if (hours == "0200" || hours == "0300" || hours == "0400") {
      if (hours == "0300") {
        temp = 12;
      } else if (hours == "0400") {
        temp = 24;
      }
      basetime = "0200";
    } else if (hours == "0500" || hours == "0600" || hours == "0700") {
      if (hours == "0600") {
        temp = 12;
      } else if (hours == "0700") {
        temp = 24;
      }
      basetime = "0500";
    } else if (hours == "0800" || hours == "0900" || hours == "1000") {
      if (hours == "0900") {
        temp = 12;
      } else if (hours == "1000") {
        temp = 24;
      }
      basetime = "0800";
    } else if (hours == "1100" || hours == "1200" || hours == "1300") {
      if (hours == "1200") {
        temp = 12;
      } else if (hours == "1300") {
        temp = 24;
      }
      basetime = "1100";
    } else if (hours == "1400" || hours == "1500" || hours == "1600") {
      if (hours == "1500") {
        temp = 12;
      } else if (hours == "1600") {
        temp = 24;
      }
      basetime = "1400";
    } else if (hours == "1700" || hours == "1800" || hours == "1900") {
      if (hours == "1800") {
        temp = 12;
      } else if (hours == "1900") {
        temp = 24;
      }
      basetime = "1700";
    } else if (hours == "2000" || hours == "2100" || hours == "2200") {
      if (hours == "2100") {
        temp = 12;
      } else if (hours == "2200") {
        temp = 24;
      }
      basetime = "2000";
    }
    this.temp = temp;
    //console.log(hours);
    //console.log(basedate);
    //console.log(basetime);
    //단기예보
    // - Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)
    //- API 제공 시간(~이후) : 02:10, 05:10, 08:10, 11:10, 14:10, 17:10, 20:10, 23:10

    // 위도 경도 xy 좌표로 변환하기
    var RE = 6371.00877; // 지구 반경(km)
    var GRID = 5.0; // 격자 간격(km)
    var SLAT1 = 30.0; // 투영 위도1(degree)
    var SLAT2 = 60.0; // 투영 위도2(degree)
    var OLON = 126.0; // 기준점 경도(degree)
    var OLAT = 38.0; // 기준점 위도(degree)
    var XO = 43; // 기준점 X좌표(GRID)
    var YO = 136; // 기1준점 Y좌표(GRID)
    var DEGRAD = Math.PI / 180.0;
    // var RADDEG = 180.0 / Math.PI;

    var re = RE / GRID;
    var slat1 = SLAT1 * DEGRAD;
    var slat2 = SLAT2 * DEGRAD;
    var olon = OLON * DEGRAD;
    var olat = OLAT * DEGRAD;
    var v1 = this.lat;
    var v2 = this.lng;

    var sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
    sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
    var sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
    sf = (Math.pow(sf, sn) * Math.cos(slat1)) / sn;
    var ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
    ro = (re * sf) / Math.pow(ro, sn);
    var rs = {};
    rs["lat"] = v1;
    rs["lng"] = v2;
    var ra = Math.tan(Math.PI * 0.25 + v1 * DEGRAD * 0.5);
    ra = (re * sf) / Math.pow(ra, sn);
    var theta = v2 * DEGRAD - olon;
    if (theta > Math.PI) theta -= 2.0 * Math.PI;
    if (theta < -Math.PI) theta += 2.0 * Math.PI;
    theta *= sn;
    rs["x"] = Math.floor(ra * Math.sin(theta) + XO + 0.5);
    rs["y"] = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5);
    console.log(rs.x);
    console.log(rs.y);

    //spring에서 비동기로 날씨 불러오기
    http.get(`/wish/getweather/${basedate}/${basetime}/${rs.x}/${rs.y}`).then(({ data }) => {
      this.weathertable = data.response.body.items.item;
      //console.log(data.response.body.items.item[temp].fcstValue);
      //console.log(temp);
      //console.log(this.weathertable);
      if (this.weathertable[this.temp].category == "TMX" || this.weathertable[this.temp].category == "TMN") {
        this.startdata = temp + 1;
      } else {
        this.startdata = temp;
      }
      //console.log(this.weathertable[this.startdata + 6].fcstValue);

      if (this.weathertable[this.startdata + 6].fcstValue == "0") {
        if (this.weathertable[this.startdata + 5].fcstValue == "3") {
          this.bgimage = "sunny.gif";
        } else if (this.weathertable[this.startdata + 5].fcstValue == "4") {
          this.bgimage = "sunny.gif";
        } else if (this.weathertable[this.startdata + 5].fcstValue == "1") {
          if (this.hours <= 18 && this.hours >= 6) {
            this.bgimage = "sunny.gif";
          } else {
            this.bgimage = "night.gif";
          }
        }
      } else if (this.weathertable[this.startdata + 6].fcstValue == "1") {
        this.bgimage = "rain.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "2") {
        this.bgimage = "rain.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "3") {
        this.bgimage = "snow.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "4") {
        this.bgimage = "rain.gif";
      }
    });
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    showWeather() {
      this.isWeatherShow = !this.isWeatherShow;
    },
    check() {
      console.log(this.wishname + "가 관심지역에 포함되어있는지 DB검사를 진행합니다.");
      http.get(`/wish/chkexistwish/${this.wishname}/${this.userInfo.userid}`).then(({ data }) => {
        if (data === "success") {
          console.log("true");
          this.status = true;
        } else {
          console.log("false");
          this.status = false;
        }
      });
      console.log(this.wishname + "가 관심지역에 포함되어있으면 true를 반환합니다.");
      //return false;
    },
    like() {
      let heart = document.getElementById("heart");
      let status = heart.getAttribute("class");
      if (status == "bi bi-heart") {
        document.getElementById("heart").setAttribute("class", "bi bi-heart-fill");
        console.log("관심지역에 해당 " + this.wishname + " 정보로 " + this.userInfo.userid + "에 추가합니다.");
        http
          .post(`/wish`, {
            wishname: this.wishname,
            wishtype: this.wishtype,
            gugunname: this.gugunname,
            dongname: this.dongname,
            lat: this.lat,
            lng: this.lng,
            userid: this.userInfo.userid,
            // 등록시간은 spring에서 써야함
          })
          .then(({ data }) => {
            let msg = "관심 지역 등록 처리시 문제가 발생했습니다.";
            if (data === "success") {
              msg = "관심 지역 등록이 완료되었습니다.";
            }
            alert(msg);
          });
      } else {
        document.getElementById("heart").setAttribute("class", "bi bi-heart");
        console.log("관심지역에 해당 " + this.wishname + " 정보로 " + this.userInfo.userid + "에서 삭제합니다.");
        http.delete(`/wish/${this.wishname}/${this.userInfo.userid}`).then(({ data }) => {
          let msg = "관심 지역 삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "관심 지역 삭제가 완료되었습니다.";
          }
          alert(msg);
        });
      }
    },

    // 날씨
    hourslist() {
      var list = [];
      for (var i = this.hours; i < this.hours + 9; i++) {
        if (i >= 24) {
          list.push("0" + i - 24);
        } else {
          list.push(i);
        }
      }
      return list;
    },
    startnum() {
      var list = [];
      // console.log(this.temp);
      for (var i = this.temp; i < this.temp + 10; i = i + 12) {
        if (this.weathertable[i].category == "TMX" || this.weathertable[i].category == "TMN") {
          i++;
        }
        list.push(i);
      }
      //console.log(list);
      return list;
    },
    tempnum() {
      var list = [];
      //console.log(this.temp);
      for (var i = this.temp + 12; i < this.temp + 120; i = i + 12) {
        if (this.weathertable[i].category == "TMX" || this.weathertable[i].category == "TMN") {
          i++;
        } else if (this.weathertable[i].category == "SNO") {
          i = i + 2;
        }
        list.push(i);
      }
      //console.log(list);
      return list;
    },
  },
};
</script>

<style scoped>
#map {
  z-index: 1;
}
.like:hover {
  color: red;
}

#thermometer {
  width: 7%;
}
#title_weather {
  width: 10%;
}
#weather_img {
  width: 60%;
}

#weather-container {
  /* background-color: rgba(255, 255, 255, 0.3); */
  background-size: cover;
  width: 100%;
  height: 100%;
  text-align: center;
  position: relative;
}
#weather-container::before {
  content: "";
  opacity: 0.5;
  position: absolute;
  top: 0px;
  left: 0px;
  right: 0px;
  bottom: 0px;
  background-color: rgb(255, 255, 255);
}

#weatherhomepage {
  width: 30%;
}
</style>
