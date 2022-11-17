import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "http://localhost:9999/vue",
  headers: {
    "Content-Type": "application/json;charset=utf-8",
  },
});

// local vue api axios instance
function apiInstance() {
  const instance = axios.create({
    baseURL: "http://localhost:9999/vue",
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { apiInstance };
