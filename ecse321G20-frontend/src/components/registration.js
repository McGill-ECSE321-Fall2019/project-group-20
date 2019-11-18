import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function TutorDto (name, id, email, availability, password, subject, hourlyRate) {
    this.name = name
    this.id = id
    this.email = email
    this.availability = availability
    this.password = password
    this.subject = subject
    this.hourlyRate = hourlyRate
    this.events = []
  }

  function PersonDto (name, id, email, is_removed, password) {
    this.name = name
    this.email = email
    this.is_removed = is_removed
    this.password = password
  }
  function TutorReviewDto (id, isRejected, date, startTime, endTime) {
    this.id = id
    this.isRejected = isRejected
    this.date = date
    this.startTime = startTime
    this.endTime = endTime
  }

  function SchoolDto (name) {
    this.name = name
  }
  function SubjectDto (name, id) {
    this.name = name
    this.id = id
  }

  function CourseDto (number) {
    this.number = number
  }

  function FeedBackDto (session, id) {
    this.session = session
    this.id = id
  }
  function RoomDto (number, sessionType, isAvailable) {
    this.number = number
    this.sessionType = sessionType
    this.isAvailable = isAvailable
  }
  function RoomBookingDto (requestNb) {
    this.requestNb = requestNb
  }

  export default {
    name: 'eventregistration',
    data () {
      return {
        tutors: [],
        persons:[],
        schools:[],
        sessions:[],
        feedbacks:[],
        tutorReviews:[],
        rooms:[],
        roomBookings:[],
        newPerson: '',
        errorPerson: '',
        response: []
      }
    },
    created: function () {
      // Initializing people from backend
        AXIOS.get(`/tutors`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.tutors = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
        AXIOS.get(`/persons`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.persons = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
        AXIOS.get(`/schools`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.schools = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
        AXIOS.get(`/subjectMatter`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.sessions = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
    },
      methods: {
        createPerson: function (personName, id, email, is_removed, password ) {
          AXIOS.post(`/persons/`+ personName + '?subjectMatter=' + email + '&Date=' + password + '&sessionType=' + id + '&feedback=' + is_removed)
          .then(response => {
            // JSON responses are automatically parsed.
            this.persons.push(response.data)
            this.newPerson = ''
            this.errorPerson = ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorPerson = errorMsg
          });
        },
        deleteSession:function (name) {
          AXIOS.delete(`/deleteCourse?courseId=`+ name)
          .then(response => {
            // JSON responses are automatically parsed.
            console.log("worked!")
            window.location.reload();
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorPerson = errorMsg
          });
        },
        log() {
          if(document.getElementById('name') != "" && document.getElementById('pass') != "") {
            console.log(document.getElementById('name').value);
            console.log(document.getElementById('personName').value);
              //if(document.getElementById('name').value == document.getElementById('personName').value && document.getElementById('pass').value == document.getElementById('personPassword').value) {
                  window.location.href = "/#/tutorportal/";
              //} else {
                //  alert("The username and / or password is incorrect");
              //}
          } else {
              console.log("A username and password must be present");
          }
      }
      }
      
  }

