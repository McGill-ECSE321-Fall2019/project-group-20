<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/studentInfo">Looking for a tutor</router-link>
      <router-link to="/tutorInfo">Become a Tutor</router-link>
      <router-link to="/contact" class="right">Contact us</router-link>
      <router-link to="/about" class="right">About</router-link>
    </div>
    
    <!-- TutorRequestForm page content. -->
    <div class="row">
        <div class="side">
            <center>
                <p> To become a tutor, you must <b>complete an application form</b>. <br>Only once the EDvantage company
                    manager <b>verifies</b> your application form will you be allowed to create a tutor account.
                    <br><br>This form is <b>available at our
                        headquarters</b>.
                </p>
            </center>

            <center>
                <h3>EDvantage Headquarters</h3>
                <p> Lorne M. Trottier Building <br>
                    Room 5105<br>
                    3630 University St<br>
                    Montreal, Quebec<br>
                    H3A 0C6<br>
                </p>
                <h4>Opening Hours</h4>
                <p> Mon-Fri: 9 AM - 7 PM <br>
                    Sat: 10 AM - 5 PM<br>
                    Sun: Closed
                </p>
            </center>
        </div>
    </div>

    <!-- Footer image -->
    <div class="footer">
        <div><img src="../assets/tutor.png" height=550px width=100%></div>
    </div>
  </div>
</template>

<script>
</script>

<style>
      /* Extra styles for the cancel button */
    .cancelbtn {
      background-color: #f74a3e;
      border: none;
      color: white;
      text-align: center;
      font-size: 16px;
      cursor: pointer;
      width: auto;
      padding: 10px 18px;

    }

    .cancelbtn:hover {
      background-color: #c00f03;
    }

    /* Center the image and position the close button */
    .imgcontainer {
      text-align: center;
      margin: 24px 0 12px 0;
      position: relative;
    }

    img.avatar {
      width: 15%;
      border-radius: 50%;
    }

    .container {
      padding: 16px;
    }

    span.psw {
      float: right;
      padding-top: 16px;
    }

    /* The Modal (background) */
    .modal {
      display: none;
      /* Hidden by default */
      position: fixed;
      /* Stay in place */
      z-index: 1;
      /* Sit on top */
      left: 0;
      top: 0;
      width: 100%;
      /* Full width */
      height: 100%;
      /* Full height */
      overflow: auto;
      /* Enable scroll if needed */
      background-color: rgb(0, 0, 0);
      /* Fallback color */
      background-color: rgba(0, 0, 0, 0.4);
      /* Black w/ opacity */
      padding-top: 60px;
    }

    /* Modal Content/Box */
    .modal-content {
      background-color: #fefefe;
      margin: 5% auto 15% auto;
      /* 5% from the top, 15% from the bottom and centered */
      border: 1px solid #888;
      width: 80%;
      /* Could be more or less, depending on screen size */
    }

    /* The Close Button (x) */
    .close {
      position: absolute;
      right: 25px;
      top: 0;
      color: #000;
      font-size: 35px;
      font-weight: bold;
    }

    .close:hover,
    .close:focus {
      color: red;
      cursor: pointer;
    }

    /* Add Zoom Animation */
    .animate {
      -webkit-animation: animatezoom 0.6s;
      animation: animatezoom 0.6s
    }

    @-webkit-keyframes animatezoom {
      from {
        -webkit-transform: scale(0)
      }

      to {
        -webkit-transform: scale(1)
      }
    }

    @keyframes animatezoom {
      from {
        transform: scale(0)
      }

      to {
        transform: scale(1)
      }
    }

    /* Full-width input fields */
    input[type=text],
    input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
      span.psw {
        display: block;
        float: none;
      }

      .cancelbtn {
        width: 100%;
      }
    }
</style>