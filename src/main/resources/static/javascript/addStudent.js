


    var get = document.getElementById("gpa") ;
    get.oninput= (()=>{
        value = get.value ; 
        document.getElementById("currGPA").textContent = value  ;
    });

    window.addEventListener('DOMContentLoaded', function() {
        document.getElementById("addStudentForm").addEventListener("submit", function(event) {
            event.preventDefault(); 

            
            alert("User added successfully!");

            // Submit the form
            document.getElementById("addStudentForm").submit();
        });
    });

