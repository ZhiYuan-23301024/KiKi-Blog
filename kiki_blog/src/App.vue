<template>
  <div class="app-container">
    <NavMenu />
    <router-view :key="$route.fullPath" class="content"></router-view>
  </div>
</template>

<script>
import NavMenu from './components/NavMenu.vue'

export default {
  name: 'App',
  components: {
    NavMenu
  }
}
</script>

<style scoped>
.app-container {
  margin-top: 10px; /* 确保router-view与NavMenu之间有30px的间距 */
}

.content {
  padding: 30px; /* 可选：为内容区域添加内边距 */
}
</style>
