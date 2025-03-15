<template>
  <div id="app">
    <nav>
      <router-link to="/">主页</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script setup lang="ts">
// 不需要额外的逻辑时，可以留空
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 20px;
  background-color: #42b983;
}

nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  margin: 0 10px;
}

nav a.router-link-exact-active {
  color: #ffdd57;
}
</style>