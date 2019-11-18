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
          <h1>EDvantage Headquarters</h1>
          <p> Lorne M. Trottier Building <br>
            Room 5105<br>
            3630 University St<br>
            Montreal, Quebec<br>
            H3A 0C6<br>
            <br>
            <b>Email</b>: edvantage@marwan.com<br>
            <b>Tel</b>: 514-321-5105<br>
            <b>Fax</b> 514-123-5015
            <br>
          </p>
          <h3>Opening Hours</h3>
          <p> Mon-Fri: 9 AM - 7 PM <br>
            Sat: 10 AM - 5 PM<br>
            Sun: Closed<br>
          </p>

          <!-- Include google maps image of Trottier building -->
          <h3>Google Maps</h3>
          <div><img src="../assets/headquarters.png" height=100% width=100% style="object-fit: contain;"></div>

        </center>
      </div>
    </div>
  </div>
</template>

<script>
</script>

<style>
</style>