<template>
  <div class="home">
    <h1>欢迎来到我的主页！</h1>
    <p>这是一个使用 Vue 3 和 Spring Boot 构建的示例项目。</p>
    <button @click="fetchData">获取数据</button>
    <div v-if="message">
      <p>后端返回的数据：{{ message }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';

// 定义响应式数据
const message = ref<string>('');

// 定义方法：获取后端数据
const fetchData = async (): Promise<void> => {
  try {
    const response = await axios.get<string>('/api/hello'); // 调用 Spring Boot 后端 API
    message.value = response.data;
  } catch (error) {
    console.error('获取数据失败:', error);
    message.value = '请求失败，请检查后端服务是否运行。';
  }
};
</script>

<style scoped>
.home {
  text-align: center;
  margin-top: 50px;
}

h1 {
  color: #2c3e50;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #3aa876;
}
</style>