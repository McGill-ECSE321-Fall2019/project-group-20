<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
        <router-link to="/tutorportal/" class="active">My Profile</router-link>
        <router-link to="/tutorportal/schedule">Schedule</router-link>
        <router-link to='/tutorportal/feedback'>Feedback</router-link>
        <router-link to="/" class="right">Logout</router-link>
    </div>
    

    <!-- Main page content. -->
    <div class="row">

        
        
      <div class="side">
    <div id="eventregistration">
    <h2>Tutor Profile</h2>
    <table>
  <tr v-for="person in tutors" :key='person' >
      
          <h2>{{person.name}}</h2>

          <!-- Star rating -->
          <span class="fa fa-star checked"></span>
          <span class="fa fa-star checked"></span>
          <span class="fa fa-star checked"></span>
          <span class="fa fa-star checked"></span>
          <span class="fa fa-star"></span>
          <br>
          <br>
          

          <h4>About:</h4>
          <p align="justify">I have a B.Eng in Chemical Engineering.
              I was a TA at Waterloo University for 3 years
              for CHEM204 and CHEM551. I graduated with a 3.9 CGPA.
              I am now doing my master's in Stem Cell Bioprocessing at McGill University.
          </p>
          <p><b>Email:</b> {{person.email}} </p>
          <h3>Teaching subjects:</h3>
          <table>
              <tr>
                  <th>Subject Matter</th>
                  <th>Hourly Rate ($)</th>
              </tr>
              <tr>
                  <td>{{person.subject}}</td>
                  <td>{{person.hourlyRate}}</td>
              </tr>
            <h3>
                Availability
            </h3>
            <button class="button" type="button" onclick="window.location.href='/#/tutorportal/schedule';">Availability</button>
          </table>
          <br>
      
  </tr>
</table>
    <p>
    </p>
  </div>
          <button class="button" onclick="document.getElementById('id02').style.display='block'"
              style="width:auto;">Add another subject matter</button>

          <div id="id02" class="modal">

            <form class="modal-content animate">
              <div class="imgcontainer">
                <span onclick="document.getElementById('id02').style.display='none'" class="close"
                    title="Close Request Subject Matter">&times;</span>
              </div>

              <div class="container">
                <label for="requestsubjectmatter"><b>Subject Matter</b></label>
                <input type="text" placeholder="Enter Subject Matter" name="requestsubjectmatter" required>

                <label for="experience"><b>Experience</b></label>
                <input type="text" placeholder="Enter Experience with Subject Matter" name="experience" required>

                <label for="availability"><b>Availability (optional)</b></label>
                <input type="text" placeholder="Enter Availability (optional)" name="availability" optional>

                <label for="hourlyrate"><b>Hourly Rate (optional)</b></label>
                <input type="text" placeholder="Enter Hourly Rate (optional)" name="hourlyrate" optional>

                <center><button class="button" type="button" onclick="window.location.href='/../#/Sent';">Request to teach new subject matter</button></center>
                <br>
              </div>

              <div class="container" style="background-color:whitesmoke">
                <button type="button" onclick="document.getElementById('id02').style.display='none'"
                    class="cancelbtn">Cancel</button>
              </div>
            </form>
          </div>
        </div>
        <div class="main">
                 <h2>Tutoring Sessions</h2>
          <tr v-for="person in persons" :key='person' >

       
            <table>
                <tr>
                    <th>Student Name</th>
                    <th>Subject Matter</th>
                    <th>Date</th>
                    <th>Session Type</th>
                    <th>Feedback</th>
                    <th>Delete?</th>
                </tr>
                <tr>
                    <td >{{person.name}}</td>
                    <td>{{person.email}}</td>
                    <td>{{person.password}}</td>
                    <td>{{person.id}}</td>
                    <td>{{person.isRemoved}}</td>
                    <td><button class = 'button' @click="deleteSession(person.name)">Delete Session</button></td>
                </tr>
            </table>
             </tr>
            <br>
            <button class="button" onclick="document.getElementById('id03').style.display='block'"
                style="width:100%;">Create session</button>


            <!--Pop-up window to create a session-->
            <div id="id03" class="modal">

                <form class="modal-content animate">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('id03').style.display='none'" class="close"
                            title="Close Create Session">&times;</span>
                    </div>

                    
                    <div class="container">
                        <label for="student"><b>Student Name</b></label>
                        <input type="text" placeholder="Enter Student name" name="student"  v-model="newPerson" required>

                        <label for="subjectmatter"><b>Subject Matter</b></label>
                        <input type="text" placeholder="Enter Subject Matter"  v-model="subjectmatter" name="subjectmatter" required>

                        <label for="date"><b>Date</b></label>
                        <input type="text" placeholder="Enter Date of session" v-model="date" name="date" required>

                        <label for="sessiontype"><b>Session Type</b></label>
                        <input type="text" placeholder="Enter Session Type" v-model="session" name="sessiontype" required>

                        <center><button class = 'button' @click="createPerson(newPerson, session, subjectmatter, false, date)">Create Session</button></center>
                        <br>
                    </div>

                    <div class="container" style="background-color:whitesmoke">
                        <button type="button" onclick="document.getElementById('id03').style.display='none'"
                            class="cancelbtn">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
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

<script src="../registration.js">
</script>