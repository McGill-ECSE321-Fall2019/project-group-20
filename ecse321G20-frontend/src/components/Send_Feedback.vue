<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/studentInfo">Looking for a tutor</router-link>
      <router-link to="/tutorInfo">Become a Tutor</router-link>
      <router-link to="/contact"  class="right active">Contact us</router-link>
      <router-link to="/about" class="right">About</router-link>
    </div>
    
    <!-- Main page content. -->
    <div class="row">
      <div class="side">
        <center>
          <h1>Your request was sent to the Company Manager to 
              check for inappropriate or hurtful comments before
              being sent.  
          </h1>
          <button onclick="window.location.href='/#/tutorInfo';">
              Go Back
          </button>
        </center>
      </div>
    </div>
  </div>
</template>

<script>
</script>

<style>
</style>