import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function PersonDto (name, id, email, is_removed, password) {
    this.name = name
    this.id = id
    this.email = email
    this.is_removed = is_removed
    this.password = password
    this.events = []
  }
  
  function EventDto (name, date, start, end) {
    this.name = name
    this.eventDate = date
    this.startTime = start
    this.endTime = end
  }

  export default {
    name: 'eventregistration',
    data () {
      return {
        people: [],
        newPerson: '',
        errorPerson: '',
        response: []
      }
    },
    created: function () {
      // Initializing people from backend
        AXIOS.get(`/persons`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.people = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
    },
      methods: {
        createPerson: function (personName) {
          AXIOS.post(`/persons/`+personName, {}, {})
          .then(response => {
            // JSON responses are automatically parsed.
            this.people.push(response.data)
            this.newPerson = ''
            this.errorPerson = ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorPerson = errorMsg
          });
        }
      }
  }

