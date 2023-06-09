
//display current gpa for gpa slider 
console.log("javascript file linked")
    var get = document.getElementById("gpa") ;
    get.oninput= (()=>{
        value = get.value ; 
        document.getElementById("currGPA").textContent = value  ;
    });


