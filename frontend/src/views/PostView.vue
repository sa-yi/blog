<template>
  <div class="post-detail">
    <h1>{{ post.title }}</h1>
    <div class="meta">
      <span>作者：{{ post.author }}</span>
      <span>发布时间：{{ formatTime(post.createTime) }}</span>
    </div>
    <div class="content">
      {{ post.content }}
    </div>
    <button @click="$router.back()">返回</button>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute } from 'vue-router'

interface BlogPost {
  id: number;
  title: string;
  content: string;
  author: string;
  createTime: string;
  tags: string[];
}

const post = ref<BlogPost>({} as BlogPost)
const route = useRoute()

onMounted(async () => {
  try {
    const response = await axios.get(`/api/posts/${route.params.id}`)
    post.value = response.data
  } catch (error) {
    console.error('获取文章详情失败:', error)
  }
})

const formatTime = (timeString: string) => {
  return new Date(timeString).toLocaleDateString()
}
</script>

<style scoped>
.post-detail {
  max-width: 800px;
  margin: 2rem auto;
  padding: 2rem;
}
</style>