//解构

const people = {
    name:'老王',
    age:18
};

//es5
//console.log(people.name+"==="+people.age);
//es6
const { name, age } = people
console.log(`${name}===${age}`);
