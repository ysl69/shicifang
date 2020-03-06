//对象简写
//es5
function people(name,age){
    return {
        name:name,
        age:age
    }
}
//es6
function people2(name,age){
    return {
        name,
        age
    }
}
console.log(people2('laowang',18));
