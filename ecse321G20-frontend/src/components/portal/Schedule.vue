<template>
  <div id="page">
    <!-- Navigation bar -->
    <div class="navbar">
        <router-link to="/tutorportal/">My Profile</router-link>
        <router-link to="/tutorportal/schedule" class="active">Schedule</router-link>
        <router-link to='/tutorportal/feedback'>Feedback</router-link>
        <router-link to="/" class="right">Logout</router-link>
    </div>

    <!-- Header -->
    <div class="month">
        <ul>
            <li class="prev">&#10094;</li>
            <li class="next">&#10095;</li>
            <li>
                <h1> Tutor Schedule</h1>
                <p>We care for your <b>success</b>.</p>
                November<br>
                <span style="font-size:18px">2019</span>
            </li>
        </ul>
    </div>
    
    <!-- Main page content. -->
    <button class="button" onclick="document.getElementById('id03').style.display='block'"
                style="width:100%;">Add availability</button>


            <!--Pop-up window to create a session-->
            <div id="id03" class="modal">

                <form class="modal-content animate">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('id03').style.display='none'" class="close"
                            title="Close Create Session">&times;</span>
                    </div>

                    
                    <div class="container">
                        <label for="student"><b>Availablility : Date and time</b></label>
                        <input type="text" placeholder="Enter Date and time" name="student"  v-model="date" required>

                        <center><button class = 'button' @click="createSchool(date)">Add availability</button></center>
                        <br>
                    </div>

                    <div class="container" style="background-color:whitesmoke">
                        <button type="button" onclick="document.getElementById('id03').style.display='none'"
                            class="cancelbtn">Cancel</button>
                    </div>
                </form>
            </div>

<tr v-for="school in schools" :key='school' >

       
            <table>
                <tr>
                    <th>Availability</th>
                </tr>
                <tr>
                    <td>{{school.name}}</td>
                </tr>
            </table>
             </tr>


    <ul class="weekdays">
        <li>Mo</li>
        <li>Tu</li>
        <li>We</li>
        <li>Th</li>
        <li>Fr</li>
        <li>Sa</li>
        <li>Su</li>
    </ul>

    <ul class="days">
        <li>1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
        <li>5</li>
        <li>6</li>
        <li>7</li>
        <li>8</li>
        <li>9</li>
        <li><span class="active">10</span></li>
        <li>11</li>
        <li>12</li>
        <li>13</li>
        <li>14</li>
        <li>15</li>
        <li>16</li>
        <li>17</li>
        <li>18</li>
        <li>19</li>
        <li>20</li>
        <li>21</li>
        <li>22</li>
        <li>23</li>
        <li>24</li>
        <li>25</li>
        <li>26</li>
        <li>27</li>
        <li>28</li>
        <li>29</li>
        <li>30</li>
        <li>31</li>
    </ul>
    
  </div>
  
</template>

<script>
  //export default isLoggedMixin;
</script>

<style>
  /*Avatar*/
        img.avatar {
            width: 50%;
            border-radius: 50%;
        }
        .month {
            padding: 70px 25px;
            width: 100%;
            background: #1abc9c;
            text-align: center;
        }
        .month ul {
            margin: 0;
            padding: 0;
        }
        .month ul li {
            color: white;
            font-size: 20px;
            letter-spacing: 3px;
        }
        .month .prev {
            float: left;
            padding-top: 10px;
        }
        .month .next {
            float: right;
            padding-top: 10px;
        }
        .weekdays {
            margin: 0;
            padding: 10px 0;
            background-color: #ddd;
        }
        .weekdays li {
            display: inline-block;
            width: 13.6%;
            color: #666;
            text-align: center;
        }
        .days {
            padding: 10px 0;
            background: #eee;
            margin: 0;
        }
        .days li {
            list-style-type: none;
            display: inline-block;
            width: 13.6%;
            text-align: center;
            margin-bottom: 5px;
            font-size: 12px;
            color: #777;
        }
        .days li .active {
            padding: 5px;
            background: #1abc9c;
            color: white !important
        }
        /* Add media queries for smaller screens */
        @media screen and (max-width:720px) {
            .weekdays li,
            .days li {
                width: 13.1%;
            }
        }
        @media screen and (max-width: 420px) {
            .weekdays li,
            .days li {
                width: 12.5%;
            }
            .days li .active {
                padding: 2px;
            }
        }
        @media screen and (max-width: 290px) {
            .weekdays li,
            .days li {
                width: 12.2%;
            }
        }
</style>
<script src="../trial.js">
</script>