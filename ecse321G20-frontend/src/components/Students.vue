<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/studentInfo" class="active">Looking for a tutor</router-link>
      <router-link to="/tutorInfo">Become a Tutor</router-link>
      <router-link to="/contact" class="right">Contact us</router-link>
      <router-link to="/about" class="right">About</router-link>
    </div>
    
    <!-- StudentInfo page content. -->
    <div class="row">
      <div class="side">

        <center>
          <p>Are you finding one or more of your classes difficult? <br>EDvantage has <b>over 1000
              tutors </b>with expertise in various fields that are ready to help you learn.<br>
            Sign up now to request a <b>private tutoring session</b> or a <b>group review session</b> with friends!
          </p>
          <br>
        </center>

        <!-- Make a student account button -->
        <!-- No path because we do not have to implement the student viewpoint -->
        <center><button class="button" style="width:300px">New to EDvantage? <br>Sign up now!</button>
          <br>
          <br>
          <!-- Log into student account button -->
          <!-- No path because we do not have to implement the student viewpoint -->
          <button class="button" style="width:300px"> Already have a student account? <br>Log in here!</button>
          <br>
        </center>
        <br>

      </div>
    </div>

    <!-- Footer image -->
    <div class="footer">
      <div><img src="../assets/student.jpg" height=350px width=100%></div>
    </div>
  </div>
</template>

<script>
</script>

<style>
</style>