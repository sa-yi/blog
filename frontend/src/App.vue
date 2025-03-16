<template>
  <div id="app">
    <nav>
      <div class="nav-brand">
        <span class="logo">🍃</span>
        <span class="title">立风阁</span>
      </div>
      <router-link to="/">首页</router-link>
    </nav>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: 'Microsoft YaHei', Avenir, Helvetica, Arial, sans-serif;
}

nav {
  padding: 0 2rem;
  background: linear-gradient(135deg, #3c8d7d 0%, #42b983 100%);
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  display: flex;
  align-items: center;
  justify-content: center;
  height: 60px;
  position: relative;
}

.nav-brand {
  position: absolute;
  left: 2rem;
  display: flex;
  align-items: center;
  gap: 12px;
  margin-right: auto;
}

.logo {
  font-size: 1.8rem;
  animation: logoFloat 3s ease-in-out infinite;
}

.title {
  font-weight: 600;
  color: rgba(255,255,255,0.95);
  font-size: 1.3rem;
  letter-spacing: 2px;
}

nav a {
  color: rgba(255,255,255,0.9);
  padding: 0.8rem 1.2rem;
  border-radius: 6px;
  transition: all 0.3s ease;
  position: relative;
  font-size: 1.05rem;
}

nav a::after {
  content: '';
  position: absolute;
  bottom: -3px;
  left: 50%;
  transform: translateX(-50%);
  width: 0;
  height: 2px;
  background: #ffeb3b;
  transition: width 0.3s;
}

nav a:hover {
  background: rgba(255,255,255,0.15);
}

nav a.router-link-exact-active {
  color: #ffeb3b;
  font-weight: 500;
}

nav a.router-link-exact-active::after {
  width: 60%;
}

@keyframes logoFloat {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-3px); }
}

@media (max-width: 768px) {
  nav {
    padding: 0 1rem;
  }
  
  .title {
    font-size: 1.1rem;
  }
  
  nav a {
    padding: 0.6rem;
    font-size: 0.95rem;
  }
}
</style>