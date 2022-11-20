<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container>
      <div class="row g-4">
        <div class="col-lg-12 portfolio-item first">
          <div class="border portfolio-img rounded overflow-hidden">
            <div class="col-lg-12 text-center">
              <h1 class="display-7 my-4 mb-10">날씨 !</h1>
            </div>
            <br />
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours + 1 }}시</th>
                  <th>{{ this.hours + 2 }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                  <th>{{ this.hours }}시</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>ㅇㅇ</td>
                  <td>ㅇ</td>
                </tr>
              </tbody>
              <tbody>
                <tr>
                  <td>ㅇㅇ</td>
                  <td>ㅇㅇ</td>
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
// import http from "@/util/http"; // 버스 정류소 불러오기용
export default {
  name: "FavWeather",

  created() {
    let hours = new Date().getHours() + "00";
    console.log(hours);
    // spring에서 비동기로 날씨 불러오기
    // http.get(`/traffic/gettd`).then(({ data }) => {
    //   this.td_info_list = data.msgBody;
    //   //console.log(data.msgBody);
    // });
  },
  data() {
    return {
      hours: new Date().getHours(),
      daytable: [],
    };
  },

  methods: {},
};
</script>

<style></style>
