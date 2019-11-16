<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/" class="active">Home</router-link>
      <router-link to="/studentInfo">Looking for a tutor</router-link>
      <router-link to="/tutorInfo">Become a Tutor</router-link>
      <router-link to="/contact" class="right">Contact us</router-link>
      <router-link to="/about" class="right">About</router-link>
    </div>

    <!-- Main page content. -->
    <div class="row">
      <div class="side">
        <div><img src="../assets/learn.jpg" height=100% width=100% style="object-fit: contain;"></div>
        <router-view></router-view>
        <center>
          <p> Join the community of tutors and students. </p>
          <router-link to="/tutorInfo">
            <button class="button" style="width:300px">Join EDvantage as a tutor!</button>
          </router-link>
          <br>
          <br>
          <router-link to="/studentInfo">
            <button class="button" style="width:300px"> Join EDvantage as a student!</button>
          </router-link>
          <br>
        </center>
      </div>
    </div>
  </div>
</template>

<script>
</script>