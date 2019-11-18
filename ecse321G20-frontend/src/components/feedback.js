import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

  function BillDto (id, amount, session_id) {
    this.id = id
    this.amount = amount
    this.session_id = session_id
  }

  export default {
    name: 'feedback',
    data () {
      return {
        feedbacks:[],
        response: [],
        bills:[],
      }
    },
    created: function () {
      // Initializing people from backend
        
        AXIOS.get(`/bills`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.feedbacks = response.data
        })
        .catch(e => {
          this.errorPerson = e;
        });
       
    },
      methods: {
        createFeedback: function (name, amount, session) {
          AXIOS.post(`createBill?courseName=`+ name + '&courseAmount='+amount+'&session_id='+session)
          .then(response => {
            // JSON responses are automatically parsed.
            this.bills.push(response.data)
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

