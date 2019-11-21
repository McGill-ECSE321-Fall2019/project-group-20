<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/studentInfo">Looking for a tutor</router-link>
      <router-link to="/tutorInfo" class="active">Become a Tutor</router-link>
      <router-link to="/contact" class="right">Contact us</router-link>
      <router-link to="/about" class="right">About</router-link>
    </div> 
    <!-- TutorInfo page content. -->
    <div class="row">
      <div class="side">
        <center>
          <p>Do you want to <b>help students succeed</b> in their classes? <br>EDvantage has <b>over 1000
              tutors </b>with expertise in various fields that are continuously helping students learn.
            <br>Sign up to <b>become a tutor</b> today!
          </p>
          <br>
        </center>

        <!-- Go to page to find info on applying to become a tutor -->
        <center>
          <router-link to="/tutorInfo/application">
            <button class="button" style="width:300px">New to EDvantage?<br> Apply to become a tutor!</button>
          </router-link>
          <br>
          <br>
        </center>

        <!-- Button to log into tutor account -->
        <center><button class="button" onclick="document.getElementById('id01').style.display='block'"
            style="width:300px;">Already a
            verified
            tutor? <br>Log in here!</button>
        </center>

        <!-- Pop-up login window -->
        <div id="id01" class="modal">

          <form class="modal-content animate">
            <div class="imgcontainer">
              <span onclick="document.getElementById('id01').style.display='none'" class="close"
                title="Close Login">&times;</span>
            </div>

            <div class="container">
              <label for="uname"><b>Username</b></label>
              <input id = "name" type="text" placeholder="Enter Username" name="uname" required>

              <label for="psw"><b>Password</b></label>
              <input id = "pass" type="password" placeholder="Enter Password" name="psw" required>

              <center><button  onclick="window.location.href='/#/tutorportal';" class="button" type="button">Login</button></center>
              <br>
              <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
              </label>
            </div>

            <div class="container" style="background-color:whitesmoke">
              <button type="button" onclick="document.getElementById('id01').style.display='none'"
                class="cancelbtn">Cancel</button>
              <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
          </form>
        </div>
      </div>  
    </div>
<div id="eventregistration">
    <table>
  <tr v-for="person in tutors" :key='person' >
      <td id = 'personName'>{{ person.name }}</td>
      <td id = 'personPassword'> {{ person.password}}</td>
      <td>{{ person.email }}</td>
      <td>{{ person.id }}</td>
      <td>{{ person.availability }}</td>
      <td>
        <ul>
          <li v-for="event in person.events" :key='event'>
            {{event.name}}
          </li>
        </ul>
        
      </td>
  </tr>
</table>
    <p>
    </p>
  </div>
    <!-- Footer image. -->
    <div class="footer">
      <div><img src="../assets/tutor.png" height=550px width=100%></div>
    </div>
  </div>
  
</template>

<script>
  // Get the modal
  var modal = document.getElementById('id01');

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
  
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
<style>
  #eventregistration {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: hsl(24, 28%, 93%);
  }
  
</style>

<script>
            function login() {
                if(document.getElementById('name') != "" && document.getElementById('pass') != "") {
                    if(document.getElementById('name') == document.getElementById('personName') && document.getElementById('pass') == document.getElementById('personPassword')) {
                        window.location.href = "/#/tutorportal/";
                    } else {
                        alert("The username and / or password is incorrect");
                    }
                } else {
                    console.log("A username and password must be present");
                }
            }
            
</script>

