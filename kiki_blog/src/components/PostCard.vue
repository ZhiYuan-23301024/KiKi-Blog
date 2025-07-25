<template>
  <div class="post-card" @click="handleClick">
    <div class="post-header">
      <span class="post-date">{{ formattedDate }}</span>
      <h2 class="post-title">{{ post.title }}</h2>
    </div>
    <div id="tags">
      <div v-if="post.id1!=null" class="tag" :style="{ background: post.color1 }">{{ post.id1 }}</div>
      <div v-if="post.id2!=null" class="tag" :style="{ background: post.color2 }">{{ post.id2 }}</div>
      <div v-if="post.id3!=null" class="tag" :style="{ background: post.color3 }">{{ post.id3 }}</div>
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
      validator: (value) => ['id', 'title', 'updateTime','id1', 'id2', 'id3','color1', 'color2', 'color3'].every(key => key in value)
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
.post-card {
  background: white;
  padding: 1.5rem;
  margin-bottom: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  transition: transform 0.2s;
}

.post-header {
  margin-bottom: 1rem;
}

#tags {
  margin: auto;
  margin-top: 1rem;
  display: flex;
  width: 30%;
  justify-content: space-between;
}

.tag {
  color: white;
  padding: 8px 16px;
  border-radius: 8px;
  margin-right: 1rem;
  display: flex;
  margin: auto;
  font-size: small;
}
</style>
