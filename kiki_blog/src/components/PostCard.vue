<!-- PostCard.vue -->
<template>
    <div class="post-card" @click="handleClick">
      <div class="post-header">
        <span class="post-date">{{ formattedDate }}</span>
        <h2 class="post-title">{{ post.title }}</h2>
      </div>
      <div id="tags">
        <div id="tag1">标签1</div>
        <div id="tag2">标签2</div>
        <div id="tag3">标签3</div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'PostCard',
    props: {
      post: {
        type: Object,
        required: true,
        validator: (value) => ['id', 'title', 'updateTime'].every(key => key in value)
      }
    },
    computed: {
      formattedDate() {
        const options = { year: 'numeric', month: 'long', day: 'numeric' }
        return new Date(this.post.updateTime).toLocaleDateString('zh-CN', options)
      }
    },
    methods: {
      handleClick() {
        this.$emit('view-detail', this.post.id)
      }
    }
  }
  </script>
  
  <style scoped>
  /* 原post-card样式完整迁移至此 */
  .post-card {
  background: white;
  padding: 1.5rem;
  margin-bottom: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  transition: transform 0.2s;
}
.read-more{
  background: linear-gradient(135deg, #4c9e7a, #58a24b); /* 渐变色背景 */
  border: none;
  padding: 12px 24px;
  border-radius: 8px;
  color: white;
  box-shadow: 0 4px 6px rgba(0,0,0,0.1); /* 投影效果 */
  transition: transform 0.2s; /* 交互动画 */
}
.read-more:hover{
  transform: translateY(-2px);
}
.post-header {
  margin-bottom: 1rem;
}
#tags{
  margin: auto;
  margin-top: 1rem;
  display: flex;
  width: 30%;
  justify-content: space-between;
}
#tag1{
  background: #FFD700;
  color: white;
  padding: 8px 16px;
  border-radius: 8px;
  margin-right: 1rem;
}
#tag2{
  background: #58a24b;
  color: white;
  padding: 8px 16px;
  border-radius: 8px;
  margin-right: 1rem;
}
#tag3{
  background: #f7b731;
  color: white;
  padding: 8px 16px;
  border-radius: 8px;
  margin-right: 1rem;
}

</style>