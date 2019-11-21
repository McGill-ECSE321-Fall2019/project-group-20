import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

  function SchoolDto (name) {
    this.name = name
  }

  export default {
    name: 'school',
    data () {
      return {
        schools:[],
        response: []
      }
    },
    created: function () {
      // Initializing people from backend
        
        AXIOS.get(`/schools`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.schools = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
       
    },
      methods: {
        createSchool: function (date) {
          AXIOS.post(`createSchool?schoolName=`+ date)
          .then(response => {
            // JSON responses are automatically parsed.
            this.schools.push(response.data)
            this.newPerson = ''
            this.errorPerson = ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorPerson = errorMsg
          });
        },
      }
      
  }

