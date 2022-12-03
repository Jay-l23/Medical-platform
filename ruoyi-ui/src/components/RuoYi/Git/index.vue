<template>
  <div>
    <svg-icon icon-class="github" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'RuoYiGit',
  data() {
    return {
      url: 'https://gitee.com/lijie2002211329/Medical-system.git'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
