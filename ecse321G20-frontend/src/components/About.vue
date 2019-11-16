<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/studentInfo">Looking for a tutor</router-link>
      <router-link to="/tutorInfo">Become a Tutor</router-link>
      <router-link to="/contact"  class="right">Contact us</router-link>
      <router-link to="/about" class="right active">About</router-link>
    </div>
    
    <!-- About page content. -->
    <center>
      <h2>EDvantage Team</h2>
    </center>
    <div class="row">
      
      <!-- Include pictures with description of all team members -->
      <div class="column3">
        <center><img src="../assets/profiles/imane.jpg" height=80% width=80% style="object-fit: contain;"></center>
        <center>
          <h3>Imane Chafi</h3>
        </center>
        <center>
          <p>I am amazing</p>
        </center>
      </div>

      <div class="column3">
        <center><img src="../assets/profiles/sofia.jpg" height=80% width=80% style="object-fit: contain;"></center>
        <center>
          <h3>Sofia Dieguez</h3>
        </center>
        <center>
          <p>I am funny</p>
        </center>
      </div>

      <div class="column3">
        <center><img src="../assets/profiles/mahroo.jpg" height=80% width=80% style="object-fit: contain;"></center>
        <center>
          <h3>Mahroo Rahman</h3>
        </center>
        <center>
          <p>I am kind</p>
        </center>
      </div>

      <div class="column2Helper">
      </div>
      <div class="column2">
        <center><img src="../assets/profiles/georges.jpg" height=80% width=80% style="object-fit: contain;"></center>
        <center>
          <h3>Georges Mourant</h3>
        </center>
        <center>
          <p>I am a genius</p>
        </center>
      </div>

      <div class="column2">
        <center><img src="../assets/profiles/adam.jpg" height=80% width=80% style="object-fit: contain;"></center>
        <center>
          <h3>Adam Babs</h3>
        </center>
        <center>
          <p>I am cool</p>
        </center>
      </div>

      <div class="column2Helper">
      </div>
    </div>
  </div>
</template>

<script>
</script>

<style>
  .column3 {
      float: left;
      width: 33.33%;
      padding: 5px;
    }

    .column2 {
      float: left;
      width: 33.33%;
      padding: 5px;
    }

    .column2Helper {
      float: left;
      width: 16.65%;
      padding: 5px;
    }


    /* Clearfix (clear floats) */
    .row::after {
      content: "";
      clear: both;
      display: table;
    }
</style>