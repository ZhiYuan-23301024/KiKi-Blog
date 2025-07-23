<template>
    <nav>
        <div class="avatar-wrapper">
            <img src="@/assets/avatar.jpg" alt="个人头像" class="avatar">
            <span class="name">ZhiYuan的博客天地</span>
        </div>
        <div class="icon-wrapper">
            <i class="el-icon-menu">系列</i> <!-- 目录图标 -->
        </div>
    </nav>
</template>
<script>
export default {
    name: 'NavMenu'
}
</script>
<style scoped>
nav {
    display: flex;
    flex-direction: row;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    background-color: #e2e6f1;
    color: #fff;
    padding: 10px;
    text-align: center;
    height: 30px;
    justify-content: space-between; /* 使头像区域和图标区域分开 */
}

.avatar-wrapper {
    display: flex;
    margin-top: 0;
    width: 180px; /* 调整宽度以适应新的布局 */
    height: 30px;
}

.avatar {
    width: 30px;
    height: 100%;
    border-radius: 50%;
    object-fit: cover;
    border: 0px solid #4c8dcd;
}

.name {
    display: flex;
    margin-left: 10px;
    font-size: 14px;
    font-weight: bold;
    color: #3a72b5;
    align-items: center;
    justify-content: center;
    height: 20px;
    line-height: 20px;
    text-align: center;
    width: auto;
    white-space: nowrap;
    align-self: center;
}

.icon-wrapper {
    display: flex;
    align-items: center;
}

.icon-wrapper i {
    margin-right: 10px; /* 图标之间的间距 */
    color: #3a72b5; /* 图标颜色 */
    font-size: 18px; /* 图标大小 */
}
</style>
