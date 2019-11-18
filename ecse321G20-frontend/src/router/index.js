import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Students from '@/components/Students'
import Tutors from '@/components/Tutors'
import TutorApplications from '@/components/TutorRequestForm'
import Contact from '@/components/Contact'
import About from '@/components/About'
// add import after all existing imports
import EventRegistration from '@/components/Tutors'
import Profile from '@/components/portal/Profile'
import Schedule from '@/components/portal/Schedule'
import Sent from '@/components/Sent'
import Feedback from '@/components/portal/Feedback'
import Sent_Feedback from '@/components/Send_Feedback'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Sent',
      name: 'Sent',
      component: Sent
    },{
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/studentInfo',
      name: 'Students',
      component: Students
    },
    {
      path: '/tutorInfo',
      name: 'Tutors',
      component: Tutors
    },
    {
      path: '/tutorInfo/application',
      name: 'Tutor - Request Form',
      component: TutorApplications
    },
    {
      path: '/contact',
      name: 'Contact',
      component: Contact
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/app',
      name: 'EventRegistration',
      component: EventRegistration
    },
    {
      path: '/tutorportal/',
      name: 'Tutor - Profile',
      component: Profile
    },
    {
      path: '/tutorportal/schedule',
      name: 'Tutor - Schedule',
      component: Schedule
    },
    {
      path: '/tutorportal/feedback',
      name: 'Feedback',
      component: Feedback
    },
    {
      path: '/Sent_Feedback',
      name: 'Sent_Feedback',
      component: Sent_Feedback
    },
  ]
})

var isLoggedMixin = {
  methods: {
    checkIfLogged(){
        var vm = this;
        return new Promise((resolve, reject) => {
          axios.get('/sessionStatus')
             .then(response => {
                resolve(response.data.user);
             })
             .catch(error => {
                reject(error.response.data);
             });
        })
        
    }
  }
}

