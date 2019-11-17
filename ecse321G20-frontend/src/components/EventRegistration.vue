<template>
  <div id="eventregistration">
    <h2>People</h2>
    <table>
      <tr>
          <td>John</td>
          <td>Event to attend</td>
      </tr>
      <tr>
          <td>
              <input type="text" placeholder="Person Name">
          </td>
          <td>
              <button>Create</button>
          </td>
      </tr>
    </table>
    <table>
  <tr v-for="person in people" :key='person' >
      <td>{{ person.name }}</td>
      <td>
        <ul>
          <li v-for="event in person.events" :key='event'>
            {{event.name}}
          </li>
        </ul>
      </td>
  </tr>
</table>
<table>
  <!-- ... -->
  <tr>
    <td>
        <input type="text" v-model="newPerson" placeholder="Person Name">
    </td>
    <td>
        <button @click="createPerson(newPerson)">Create Person</button>
    </td>
  </tr>
</table>
<span v-if="errorPerson" style="color:red">Error: {{errorPerson}} </span>
    <p>
      <span style="color:red">Error: Message text comes here</span>
    </p>
  </div>
</template>
<style>
  #eventregistration {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #f2ece8;
  }
</style>
<script src="./registration.js">
</script>