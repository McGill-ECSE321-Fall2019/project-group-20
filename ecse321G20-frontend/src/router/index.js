import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Students from '@/components/Students'
import Tutors from '@/components/Tutors'
import TutorApplications from '@/components/TutorRequestForm'
import Contact from '@/components/Contact'
import About from '@/components/About'
import Profile from '@/components/portal/Profile'
import Schedule from '@/components/portal/Schedule'

Vue.use(Router)

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
