<template>
  <div class="container">
    <div class="row g-4">
      <div class="col-lg-12 portfolio-item first">
        <div class="border portfolio-img rounded overflow-hidden">
          <div class="col-lg-12 text-center">
            <h1 class="display-7 my-4 mb-10">삼성화재 유성연수원 ↔ 대전역</h1>
          </div>
          <br />
          <div class="row g-5">
            <div class="col-lg-6">
              <div class="d-flex align-items-center mb-3">
                <img
                  v-if="$store.getters.getAvgState == '교통 정보 없음'"
                  class="img-fluid"
                  src="@/assets/img/bg-header2.png"
                  id="traffic_img"
                />
                <img
                  v-if="$store.getters.getAvgState == '정체'"
                  class="img-fluid"
                  src="@/assets/img/traffic_jam_danger.gif"
                  id="traffic_img"
                />
                <img
                  v-if="$store.getters.getAvgState == '지체'"
                  class="img-fluid"
                  src="@/assets/img/traffic_jam.gif"
                  id="traffic_img"
                />
                <img
                  v-if="$store.getters.getAvgState == '서행'"
                  class="img-fluid"
                  src="@/assets/img/traffic_jam_warning.gif"
                  id="traffic_img"
                />
                <img
                  v-if="$store.getters.getAvgState == '원활'"
                  class="img-fluid"
                  src="@/assets/img/traffic_jam_good.gif"
                  id="traffic_img"
                />
              </div>
            </div>
            <div class="col-lg-5">
              <div class="d-flex align-items-center mb-3">
                <h3 class="border-end pe-3 me-3 mb-0">현재 교통 상황</h3>
                <h2
                  :class="{
                    'text-dark fw-bold mb-0': $store.getters.getAvgState === '교통 정보 없음',
                    'text-danger fw-bold mb-0': $store.getters.getAvgState === '정체',
                    'text-warning fw-bold mb-0': $store.getters.getAvgState === '지체',
                    'text-info fw-bold mb-0': $store.getters.getAvgState === '서행',
                    'text-success fw-bold mb-0': $store.getters.getAvgState === '원활',
                  }"
                  data-toggle="counter-up"
                >
                  {{ $store.getters.getAvgState }}
                </h2>
              </div>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <th>도로 길이</th>
                    <td>{{ $store.state.trafficinfo.summary.distance }}m</td>
                  </tr>
                  <tr>
                    <th>소요 시간</th>
                    <td>{{ $store.getters.getTimeTaken }}</td>
                  </tr>
                  <tr>
                    <th>평균 교통 속도</th>
                    <td>{{ $store.getters.getAvgSpeed }}km/h</td>
                  </tr>
                  <tr>
                    <th>택시 요금</th>
                    <td>{{ $store.state.trafficinfo.summary.fare.taxi }}원</td>
                  </tr>
                </tbody>
              </table>
              <p class="mb-4">
                교통 상황 서비스 !<br />
                대전역에서 SSAFY 대전캠퍼스까지의 경로에 대한 상세 정보를 제공합니다.
              </p>
              <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO MOBILITY</p>
            </div>
          </div>
          <div class="portfolio-btn">
            <b-button v-b-toggle.sidebar-right><i class="bi bi-chat-right-dots-fill"></i></b-button>
          </div>
        </div>
      </div>
    </div>
    <b-sidebar id="sidebar-right" title="실시간 한마디" right shadow backdrop backdrop-variant="dark" width="620px">
      <template>
        <div>
          <b-collapse id="collapse-4" v-model="visible" class="mt-2">
            <b-form @submit="onSubmit" @reset="onReset">
              <b-button type="reset" variant="danger" class="m-1"
                ><i class="bi bi-eraser-fill white fs-4"></i
              ></b-button>
              <b-button
                :class="visible ? null : 'collapsed'"
                :aria-expanded="visible ? 'true' : 'false'"
                aria-controls="collapse-4"
                @click:="visible = !visible"
                type="submit"
                variant="primary"
                class="m-1"
                v-if="this.type === 'register'"
                ><i class="bi bi-send-fill white fs-4"></i
              ></b-button>
              <b-button type="submit" variant="primary" class="m-1" v-else
                ><i class="bi bi-send-fill white fs-4"></i
              ></b-button>
              <b-form-group id="userid-group" label="작성자:" label-for="userid" description="작성자를 입력하세요.">
                <b-form-input
                  id="userid"
                  :disabled="isUserid"
                  v-model="article.userid"
                  type="text"
                  required
                  placeholder="작성자 입력..."
                ></b-form-input>
              </b-form-group>

              <b-form-group id="subject-group" label="제목:" label-for="subject" description="제목을 입력하세요.">
                <b-form-input
                  id="subject"
                  v-model="article.subject"
                  type="text"
                  required
                  placeholder="제목 입력..."
                ></b-form-input>
              </b-form-group>

              <b-form-group id="content-group" label="내용:" label-for="content">
                <b-form-textarea
                  id="content"
                  v-model="article.content"
                  placeholder="내용 입력..."
                  rows="10"
                  max-rows="15"
                ></b-form-textarea>
              </b-form-group>
            </b-form>
          </b-collapse>
        </div>
        <div class="float-right p-2 m-2">
          <b-button
            :class="visible ? null : 'collapsed'"
            :aria-expanded="visible ? 'true' : 'false'"
            aria-controls="collapse-4"
            @click="visible = !visible"
            pill
          >
            <i v-if="!visible" class="bi bi-pencil-fill white fs-4"></i>
            <i v-else class="bi bi-x white fs-4"></i>
          </b-button>
        </div>
      </template>

      <div id="boardList" class="px-3 py-2 bg-white">
        <!-- button start -->
        <div
          class="panel-group"
          id="accordion"
          role="tablist"
          aria-multiselectable="true"
          v-on:scroll.prevent="onScroll"
        >
          <div
            v-for="(item, i) in articles"
            :key="i"
            type="button"
            :id="'article' + i"
            class=""
            v-on:click="viewArticle(item.articleno)"
            data-toggle="collapse"
            :href="'#toggle' + i"
            role="button"
            aria-expanded="false"
            :aria-controls="'toggle' + i"
          >
            <div class="row my-3" v-if="item.articletype == 0">
              <div class="col-2 p-2 text-right">
                <img class="rounded border user" src="@/assets/img/favorite.png" alt="" />
              </div>
              <div class="col-auto">
                <div class="row">{{ item.userid }}</div>
                <div class="row">
                  <div class="col-auto align-self-center rounded p-3 mb-3 mt-1 bubble">
                    <div class="">
                      <span class="pe-3" style="color: gray">{{ item.articleno }}</span>
                      <span class="fs-6 font-weight-bold">{{ item.subject }}</span>
                    </div>

                    <div class="collapse border-top pt-2 mt-2" :id="'toggle' + i" data-parent="#accordion">
                      <div class="row mb-3 justify-content-between">
                        <div class="col-auto">
                          <div style="color: #6b799e">조회수 {{ item.hit }}</div>
                        </div>
                        <div class="col-auto">
                          <a class="float-right" variant="primary" @click="editBtn"
                            ><i class="bi bi-pencil-square"></i
                          ></a>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          {{ item.content }}
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-auto align-self-center">
                    <div class="small" style="color: #e9b06b">{{ item.regtime.substr(0, 10) }}</div>
                    <div class="small" style="color: #e9b06b">{{ item.regtime.slice(10) }}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- button end -->
      </div>

      <div></div>
    </b-sidebar>
  </div>
</template>

<script>
import { mapActions, mapMutations } from "vuex";
import http from "@/util/http"; // 게시판 테스트용
export default {
  name: "DaejeonStationView",
  data() {
    return {
      // 게시판 테스트용
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
      // 게시판 글작성 테스트용
      article: {
        articleno: 0,
        articletype: "0",
        userid: "",
        subject: "",
        content: "",
      },
      isUserid: false,
      type: "register",
      visible: false,
    };
  },

  created() {
    // 대전역 위도,경도
    this.setOrigin("127.43297197155229,36.331350382608505");
    // 게시판 테스트용
    http.get(`/board`).then(({ data }) => {
      this.articles = data;
    });
    if (this.type === "modify") {
      http.get(`/board/${this.article.articleno}`).then(({ data }) => {
        // this.article.articleno = data.article.articleno;
        // this.article.userid = data.article.userid;
        // this.article.subject = data.article.subject;
        // this.article.content = data.article.content;
        this.article = data;
      });
      this.isUserid = true;
    }
  },

  methods: {
    ...mapActions(["getTrafficState"]),
    ...mapMutations(["SET_ORIGIN"]),

    setOrigin(val) {
      this.SET_ORIGIN(val);
      this.getTrafficState();
    },
    chatClick() {
      console.log("chat btn click");
    },
    // 게시판 테스트용
    moveWrite() {
      //this.$router.push({ name: "boardwrite" });
      console.log("move write");
    },
    viewArticle(articleno) {
      // this.$router.push({
      //   name: "boardview",
      //   params: { articleno: article.articleno },
      // });
      http.get(`/board/${articleno}`).then(({ data }) => {
        console.log(data);
      });
      console.log("view article");
      this.article.articleno = articleno;
      console.log(this.article.articleno + "test");
    },
    // 게시판 글작성 테스트용
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.userid && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userid.focus());
      err && !this.article.subject && ((msg = "제목 입력해주세요"), (err = false), this.$refs.subject.focus());
      err && !this.article.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else {
        this.type === "register" ? this.registArticle() : this.modifyArticle();
        this.visible = false;
        this.onReset();
        this.moveList();
      }
    },
    onReset() {
      //event.preventDefault();
      this.article.articleno = 0;
      this.article.subject = "";
      this.article.content = "";
      this.moveList();
    },
    registArticle() {
      console.log(this.article.articletype);
      http
        .post(`/board`, {
          userid: this.article.userid,
          articletype: this.article.articletype,
          subject: this.article.subject,
          content: this.article.content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.visible = !this.visible;
          this.onReset();
          this.type = "register";
        });
    },
    modifyArticle() {
      http
        .put(`/board`, {
          articleno: this.article.articleno,
          userid: this.article.userid,
          subject: this.article.subject,
          content: this.article.content,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.moveList();
        });
    },
    moveList() {
      //this.$router.push({ name: "boardlist" });
      console.log("move list");
      this.type = "register";
      http.get(`/board`).then(({ data }) => {
        this.articles = data;
      });
      this.visible = false;
      this.type = "register";
      //this.article.articletype = "3";
    },
    editBtn() {
      this.type = "edit";
      this.visible = true;
    },
  },
};
</script>

<style>
.user {
  width: 40px;
}

#sidebar-right {
  width: 1000px;
  overflow: auto;
}

.bubble {
  background-color: #ffda8b75;
}

.portfolio-item :hover {
  background-color: #c5c5c542;
}
</style>
