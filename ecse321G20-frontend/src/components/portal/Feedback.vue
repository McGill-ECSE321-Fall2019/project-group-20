<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
        <router-link to="/tutorportal/" class="active">My Profile</router-link>
        <router-link to="/tutorportal/schedule">Schedule</router-link>
        <router-link to='#'>Feedback</router-link>
        <router-link to="/" class="right">Logout</router-link>
    </div>
    

    <!-- Main page content. -->
    <div class="row">

        
        
      <div class="side">
    <div id="feedback">
    <h2>Create Feedback</h2>
    
    <p>
    </p>
  </div>

            <form class="modal-content animate">
              <div class="imgcontainer">
                <span onclick="document.getElementById('id02').style.display='none'" class="close"
                    title="Close Request Subject Matter">&times;</span>
              </div>

              <div class="container">
                <label for="requestsubjectmatter"><b>Student Name</b></label>
                <input type="text" placeholder="Enter Subject Matter" v-model="name" name="requestsubjectmatter" required>

                <label for="availability"><b>Rating (1-5)</b></label>
                <input type="text" placeholder="Enter Availability (optional)" v-model="amount" name="availability" optional>

                <label for="hourlyrate"><b>Comment? (Optional)</b></label>
                <input type="text" placeholder="Enter Hourly Rate (optional)" v-model="session" name="hourlyrate" optional>

                <center><button class = 'button' @click="createFeedback(name, amount, session)">Create Session</button></center>
                <br>
              </div>

              <div class="container" style="background-color:whitesmoke">
                <button type="button" onclick="document.getElementById('id02').style.display='none'"
                    class="cancelbtn">Cancel</button>
              </div>
            </form>
          </div>
    </div>
    <div>
     <h2>My Feedbacks</h2>
     <table>
  <tr v-for="final in feedbacks" :key='final' >
    <table>
                <tr>
                    <th>Student Name</th>
                    <th>Rating</th>
                    <th>Comment</th>
                </tr>
                <tr>
                    <td >{{final.id}}</td>
                    <td>{{final.amount}}</td>
                    <td>{{final.session_id}}</td>  
                </tr>
            </table>
  </tr>
</table>
    </div>
    <!-- Footer image. -->
    <div class="footer">
        
    </div>
  </div>
</template>

<script>
  //export default isLoggedMixin;
  
  // Get the modal
  var modal = document.getElementById('id03');
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
      if (event.target == modal) {
          modal.style.display = "none";
      }
  }
</script>

<style>
          .button {
            background-color: #1fd6b2;
            border: #05221c;
            border-style: solid;
            border-width: thin;
            color: white;
            padding: 15px 25px;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #117460;
        }
        /*Properties for pop-up screen*/
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
        /*Avatar*/
        img.avatar {
            width: 50%;
            border-radius: 50%;
        }
        .checked {
            color: orange;
        }
</style>
<script src="../feedback.js">
</script>