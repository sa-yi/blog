<template>
  <div class="home">
    <h1>欢迎来到我的技术博客！</h1>

    <!-- 分类区域移出网格容器 -->
    <div class="categories">
      <h2>文章分类</h2>
      <div class="tag-list">
        <span v-for="(count, name) in categories" :key="name" class="tag">
          {{ name }} ({{ count }})
        </span>
      </div>
    </div>


    <h2>最新文章</h2>
    <div class="grid-container">
      <div class="post-list">
        <div v-for="post in posts" :key="post.id" class="post-card"
          @click="router.push({ name: 'post', params: { id: post.id } })">

          <h3>{{ post.title }}</h3>
          <p>{{ post.content.substring(0, 100) }}...</p>
          <div class="meta">
            <span class="author">作者：{{ post.author }}</span>
            <span class="time">发布时间：{{ formatTime(post.createTime) }}</span>
          </div>
        </div>
      </div>
    </div>

    <!-- 测试按钮保持在最底部 -->
    <button @click="fetchData">测试接口连通性</button>
    <div v-if="message">
      <p>测试结果：{{ message }}</p>
    </div>
  </div>
</template>


<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router'
import axios from 'axios';

// 响应式数据
const message = ref<string>('');
const posts = ref<BlogPost[]>([]);
const categories = ref<Record<string, number>>({});
const router = useRouter()

// 类型定义
interface BlogPost {
  id: number;
  title: string;
  content: string;
  author: string;
  createTime: string;
}

// 初始化加载
onMounted(async () => {
  await fetchPosts();
  await fetchCategories();
});

// 获取文章列表
const fetchPosts = async () => {
  try {
    const response = await axios.get<BlogPost[]>('/api/posts');
    posts.value = response.data;
  } catch (error) {
    console.error('获取文章失败:', error);
  }
};

// 获取分类统计
const fetchCategories = async () => {
  try {
    const response = await axios.get<Record<string, number>>('/api/categories');
    categories.value = response.data;
  } catch (error) {
    console.error('获取分类失败:', error);
  }
};

// 保留原有测试方法
const fetchData = async (): Promise<void> => {
  try {
    const response = await axios.get<string>('/api/hello');
    message.value = response.data;
  } catch (error) {
    console.error('获取数据失败:', error);
    message.value = '请求失败，请检查后端服务是否运行。';
  }
};

// 时间格式化方法
const formatTime = (timeString: string) => {
  return new Date(timeString).toLocaleDateString();
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* 调整网格容器只包含文章列表 */
.grid-container {
  display: grid;
  gap: 2rem;
  margin-top: 2rem;
  /* 增加与分类区域的间距 */
}


.home {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
}
.home h1,
.home h2 {
  text-align: center;
}

/* 修改网格容器 */
.grid-container {
  width: 100%;
  display: flex;
  /* 改为弹性布局 */
  justify-content: center;
  /* 居中内容 */
}

/* 调整文章列表容器 */
.post-list {
  display: grid;
  gap: 1.5rem;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  /* 自动适配列数 */
  max-width: 1200px;
  /* 限制最大宽度 */
  width: 100%;
  padding: 0 20px;
  /* 增加左右留白 */
}

.post-card {
  padding: 1.5rem;
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(0, 0, 0, 0.1);
  height: 100%;
  display: flex;
  flex-direction: column;
  text-align: center;
}

.meta {
  display: flex;
  justify-content: space-between;
  margin-top: auto; /* 推动到底部 */
  padding: 0 0.5rem;
}

.author {
  margin-right: auto; /* 左对齐 */
}

.time {
  margin-left: auto; /* 右对齐 */
}

/* 桌面端优化 */
@media (min-width: 768px) {
  .post-list {
    gap: 2rem;
    padding: 0 40px;
    /* 增大桌面端留白 */
  }

  .post-card {
    margin: 0;
    min-height: 250px;
    transition: transform 0.2s;
    /* 添加悬停效果 */
  }

  .post-card:hover {
    transform: translateY(-5px);
  }
}

/* 移动端优化 */
@media (max-width: 767px) {
  .post-list {
    grid-template-columns: 1fr;
    padding: 0 15px;
  }
}
</style>