import Vue from 'vue'
import Router from 'vue-router'
import VueSession from 'vue-session'
import Home from '@/components/Home'
import Students from '@/components/Students'
import Tutors from '@/components/Tutors'
import TutorApplications from '@/components/TutorRequestForm'
import Contact from '@/components/Contact'
import About from '@/components/About'
import Profile from '@/components/portal/Profile'
import Schedule from '@/components/portal/Schedule'

Vue.use(Router)
Vue.use(VueSession)

export default new Router({
  routes: [{
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
      path: '/tutorportal/',
      name: 'Tutor - Profile',
      component: Profile
    },
    {
      path: '/tutorportal/schedule',
      name: 'Tutor - Schedule',
      component: Schedule
    }
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
