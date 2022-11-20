<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container>
      <div class="row g-4">
        <div class="col-lg-12 portfolio-item first">
          <div class="border portfolio-img rounded overflow-hidden">
            <div class="col-lg-12 text-center">
              <h1 class="display-7 my-4 mb-10">{{ this.hours }}시 현재 기온</h1>
            </div>
            <br />
            <table class="table table-bordered" style="table-layout: fixed">
              <thead>
                <tr>
                  <th>시각</th>
                  <th v-for="(item, i) in hourslist()" :key="i">{{ item }} 시</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>기온</td>
                  <td v-for="i in 10" :key="i">
                    <span class="text-danger fw-bold">{{ i }} °C</span>
                  </td>
                </tr>
                <tr>
                  <td>풍향</td>
                  <td v-for="i in 10" :key="i">{{ i }} deg</td>
                </tr>
                <tr>
                  <td>풍속</td>
                  <td v-for="i in 10" :key="i">{{ i }} m/s</td>
                </tr>
                <tr>
                  <td>하늘상태</td>
                  <td v-for="i in 10" :key="i">
                    <span v-if="$store.getters.getAvgState == '1'">{{ i }} </span>
                    {{ i }}
                  </td>
                </tr>
                <tr>
                  <td>강수형태</td>
                  <td v-for="i in 10" :key="i">{{ i }}</td>
                </tr>
                <tr>
                  <td>강수확률</td>
                  <td v-for="i in 10" :key="i">{{ i }} %</td>
                </tr>
                <tr>
                  <td>1시간 강수량</td>
                  <td v-for="i in 10" :key="i">{{ i }} mm</td>
                </tr>
                <tr>
                  <td>습도</td>
                  <td v-for="i in 10" :key="i">{{ i }} %</td>
                </tr>
                <tr>
                  <td>1시간 적설량</td>
                  <td v-for="i in 10" :key="i">{{ i }} mm</td>
                </tr>
              </tbody>
            </table>
            <div class="portfolio-btn">
              <b-button v-b-toggle.sidebar-right
                ><i class="bi bi-chat-right-dots-fill"></i
              ></b-button>
            </div>
          </div>
        </div>
      </div>
    </b-container>
  </div>
  <!-- 관광 끝 -->
</template>

<script>
import http from "@/util/http"; // 버스 정류소 불러오기용
export default {
  name: "FavWeather",

  created() {
    let today = new Date();
    let year = today.getFullYear(); // 년도
    let month = today.getMonth() + 1; // 월
    let date = today.getDate(); // 날짜
    let basedate = year + month + date;
    let hours = today.getHours() + "00";
    let basetime = "";
    let list = [];

    // if(hours)
    //   let temp = this.hours;
    //   if (
    //     temp == "0200" ||
    //     temp == "0500" ||
    //     temp == "0800" ||
    //     temp == "1100" ||
    //     temp == "1400" ||
    //     temp == "1700" ||
    //     temp == "2000" ||
    //     temp == "2300"
    //   ) {
    //     basetime = temp;
    //     break;
    //   } else {
    //     if (parseInt(temp) == 0) {
    //       temp = 2400;
    //     }
    //     temp = parseInt(temp) - 100;

    //     console.log(temp);
    //   }

    for (var i = this.hours; i >= this.hours - 4; i--) {
      if (i >= 24) {
        list.push("0" + i - 24);
      } else {
        list.push(i);
      }
    }
    console.log(hours);

    //단기예보
    // - Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)
    //- API 제공 시간(~이후) : 02:10, 05:10, 08:10, 11:10, 14:10, 17:10, 20:10, 23:10

    //spring에서 비동기로 날씨 불러오기
    http
      .get(`/traffic/getweather/${hours}/${basedate}/${basetime}/${55}/${127}`)
      .then(({ data }) => {
        //this.td_info_list = data.msgBody;
        console.log(data);
      });
  },

  data() {
    return {
      hours: new Date().getHours(),
      hourlist: [],
      daytable: [],
    };
  },

  methods: {
    hourslist() {
      var list = [];
      for (var i = this.hours; i < this.hours + 10; i++) {
        if (i >= 24) {
          list.push("0" + i - 24);
        } else {
          list.push(i);
        }
      }
      return list;
    },
  },
};
</script>

<style></style>
